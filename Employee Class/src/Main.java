import java.io.FileNotFoundException;

import javax.swing.*; //�Access�JFrame
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.io.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static int empNum = 0;

	public static void main(String[] args) throws IOException {

		new paycheck();

		Payroll pemps = new Payroll();
		pemps.fill(); 

		JFrame theGUI = new JFrame("paycheck");
		theGUI.setTitle("paycheck");
		theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		paycheck check = new paycheck();
		Container pane = theGUI.getContentPane();
		pane.add(check);

		JLabel name = new JLabel(pemps.pra[empNum].getfname() + " " + pemps.pra[empNum].getlname(),
				SwingConstants.CENTER);
		name.setBounds(150, 100, 200, 40);
		name.setVisible(true);

		JLabel date = new JLabel("10/14/2019", SwingConstants.CENTER);
		date.setBounds(430, 72, 100, 20);
		date.setVisible(true);

		JLabel netpay = new JLabel(Double.toString(formatDouble(pemps.pra[empNum].findNP() / 52.0)),
				SwingConstants.CENTER);
		netpay.setBounds(450, 110, 100, 20);
		netpay.setVisible(true);

		JLabel company = new JLabel("Kummer Industries", SwingConstants.CENTER);
		company.setBounds(250, 200, 300, 20);
		company.setVisible(true);

		JLabel memo = new JLabel("Employee pay after taxes", SwingConstants.CENTER);
		memo.setBounds(0, 200, 280, 20);
		memo.setVisible(true);

		ImageIcon img = new ImageIcon("paycheck.jpg");
		JLabel background = new JLabel("", img, JLabel.CENTER);
		background.setBounds(0, 0, 578, 265);

		JButton previous = new JButton("Previous");
		previous.setBounds(200, 50, 100, 30);

		JButton next = new JButton("Next");
		next.setBounds(50, 50, 100, 30);
		
		theGUI.add(memo);
		theGUI.add(company);
		theGUI.add(netpay);
		
		theGUI.add(name);
		theGUI.add(date);
		theGUI.add(background);
		
		theGUI.setLayout(null);
		theGUI.setSize(590, 300);
		theGUI.setVisible(true);

		String[][] data = new String[19 * 100 + 1][3];
		String[] columns = { "Employee", "Pay", "Stub" };
		JFrame Stub = new JFrame();
		Double totalNetPay = 0.0;
		Double totalNetPayYTD = 0.0;
		Double totalFedTax = 0.0;
		Double totalStateTax = 0.0;
		Double totalLocalTax = 0.0;
		Double totalSSTax = 0.0;
		Double totalGrossPay = 0.0;
		for (int i = 0; i < 100; i++) {

			data[1 + i * 19][0] = new String("Name");
			data[1 + i * 19][1] = new String(pemps.pra[i].getfname());
			data[1 + i * 19][2] = new String(pemps.pra[i].getlname());

			data[2 + i * 19][1] = new String(new String("" + pemps.pra[i].getid()));
			data[2 + i * 19][0] = new String("Emp ID");

			data[3 + i * 19][1] = new String(new String("" + pemps.pra[i].getNdep()));
			data[3 + i * 19][0] = new String("Dependents");

			data[4 + i * 19][0] = new String("Payment");
			data[4 + i * 19][1] = new String("Information");

			data[5 + i * 19][0] = new String("Hours Worked");
			data[5 + i * 19][1] = new String(
					new String("" + Math.floor((pemps.pra[i].getHours()) / 52.0 * 100.0) / 100.0));

			data[6 + i * 19][0] = new String("Wage");
			data[6 + i * 19][1] = new String(new String("$" + (pemps.pra[i].getrate())));

			data[7 + i * 19][0] = new String("Gross Pay");
			data[7 + i * 19][1] = new String(new String("$" + formatDouble(toWeekly((pemps.pra[i].findGP())))));
			totalGrossPay += formatDouble(toWeekly((pemps.pra[i].findGP())));

			data[9 + i * 19][0] = new String("Deductions");
			data[9 + i * 19][2] = new String("YTD");

			data[10 + i * 19][0] = new String("Federal Tax");
			data[10 + i * 19][1] = String.format("$%,.2f", toWeekly((pemps.pra[i].findFed())));
			data[10 + i * 19][2] = String.format("$%,.2f", toWeekly((pemps.pra[i].calcYTD(pemps.pra[i].findFed()))));
			totalFedTax += toWeekly((pemps.pra[i].calcYTD(pemps.pra[i].findFed())));

			data[11 + i * 19][0] = new String("State Tax");
			data[11 + i * 19][1] = String.format("$%,.2f", toWeekly((pemps.pra[i].findState())));
			data[11 + i * 19][2] = String.format("$%,.2f", toWeekly((pemps.pra[i].calcYTD(pemps.pra[i].findState()))));
			totalStateTax += toWeekly((pemps.pra[i].calcYTD(pemps.pra[i].findState())));

			data[12 + i * 19][0] = new String("Local Tax");
			data[12 + i * 19][1] = String.format("$%,.2f", toWeekly((pemps.pra[i].findLoc())));
			data[12 + i * 19][2] = String.format("$%,.2f", toWeekly((pemps.pra[i].calcYTD(pemps.pra[i].findLoc()))));
			totalLocalTax += toWeekly((pemps.pra[i].calcYTD(pemps.pra[i].findLoc())));

			data[13 + i * 19][0] = new String("Social Security");
			data[13 + i * 19][1] = String.format("$%,.2f", toWeekly((pemps.pra[i].findSS())));
			data[13 + i * 19][2] = String.format("$%,.2f", toWeekly((pemps.pra[i].calcYTD(pemps.pra[i].findSS()))));
			totalSSTax += toWeekly((pemps.pra[i].calcYTD(pemps.pra[i].findSS())));

			double total = 0;
			total = toWeekly(
					pemps.pra[i].findSS() + pemps.pra[i].findLoc() + pemps.pra[i].findState() + pemps.pra[i].findFed());

			double total2 = 0;
			total2 = (pemps.pra[i].calcYTD(pemps.pra[i].findFed())) + (pemps.pra[i].calcYTD(pemps.pra[i].findState()))
					+ (pemps.pra[i].calcYTD(pemps.pra[i].findLoc()))
					+ (pemps.pra[empNum].calcYTD(pemps.pra[i].findSS()));
			total2 = toWeekly(total2);
			data[15 + i * 19][0] = new String("Deductions Total");

			data[15 + i * 19][1] = String.format("$%,.2f", total);
			data[15 + i * 19][2] = String.format("$%,.2f", total2);

			data[17 + i * 19][0] = new String("Net Pay");

			data[17 + i * 19][1] = String.format("$%,.2f", toWeekly(pemps.pra[i].findNP()));
			totalNetPay += toWeekly(pemps.pra[i].findNP());

			double np = 0;
			np = pemps.pra[i].calcYTD(pemps.pra[i].findNP()) - total2;
			np = toWeekly(np);
			data[17 + i * 19][2] = String.format("$%,.2f", np);
			totalNetPayYTD += np;

			data[18 + i * 19][0] = new String("Total Net Pay:");
			data[18 + i * 19][1] = String.format("$%,.2f", totalNetPay);

			np = pemps.pra[i].calcYTD(pemps.pra[i].findNP()) - total2;
			np = toWeekly(np);
			data[18 + i * 19][2] = String.format("$%,.2f", totalNetPayYTD);
			data[19 + i * 19][0] = "++++++++++++++++";
			data[19 + i * 19][1] = "++++++++++++++++";
			data[19 + i * 19][2] = "++++++++++++++++";
		}

		System.out.println("Total Net Pay: $" + formatDouble(totalNetPay));
		System.out.println("Total Net Pay YTD: $" + formatDouble(totalNetPayYTD));
		System.out.println("Total Federal Tax: $" + formatDouble(totalFedTax));
		System.out.println("Total State Tax: $" + formatDouble(totalStateTax));
		System.out.println("Total Local Tax: $" + formatDouble(totalLocalTax));
		System.out.println("Total SS Tax: $" + formatDouble(totalSSTax));
		System.out.println("Total Gross Pay: $" + formatDouble(totalGrossPay));

		JTable j;
		j = new JTable(data, columns);
		j.setBounds(30, 40, 200, 300);

		JScrollPane sp = new JScrollPane(j);
		Stub.add(sp);

		Stub.setSize(400, 400);
		Stub.setVisible(true);

		j.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = j.rowAtPoint(evt.getPoint());
				name.setText(pemps.pra[(int) Math.floor(row / 19)].getfname() + " "
						+ pemps.pra[(int) Math.floor(row / 19)].getlname());
				makeStub(pemps);
				netpay.setText(Double.toString(formatDouble(pemps.pra[(int) Math.floor(row / 19)].findNP() / 52.0)));
			}
		});

	}

	private static double toWeekly(double n) {
		return n / 52.0;
	}

	public double calcYTD(double temp) {
		Calendar calOne = Calendar.getInstance();
		int dayOfYear = calOne.get(Calendar.DAY_OF_YEAR);
		int year = calOne.get(Calendar.YEAR);
		Calendar calTwo = new GregorianCalendar(year, 11, 31);
		int day = calTwo.get(Calendar.DAY_OF_YEAR);
		int total_days = day - dayOfYear;
		int tempD = 52 - ((int) (total_days / 7));
		return this.formatDouble(temp * tempD);
	}

	private static double formatDouble(double d) {

		return Math.floor(d * 100) / 100.0;
	}

	public static void makeStub(Payroll pemps) {

	}

}
