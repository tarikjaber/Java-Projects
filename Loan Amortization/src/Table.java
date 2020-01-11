import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Table {
	String[][] data = new String[100][6];
	String[] columns = { "Month #", "Balance", "Interest", "Principal", "Payment", "Remaining Balance" };

	JTable j;

	public Table(double purchasePrice) {
		JFrame table = new JFrame();

		table.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		int[] month = new int[100];
		double[] totalBalance = new double[100];
		double[] interest = new double[100];
		double[] principal = new double[100];
		double[] payment = new double[100];
		double[] remainingBalance = new double[100];

		double rate = 0.12;

		double downPayment = .10 * purchasePrice;
		double monthlyPayment = .05 * (purchasePrice - downPayment);
		double b = 0;

		for(int i = 0; ; i ++) {
			month[i] = i + 1;
			data[i][0] = Integer.toString(month[i]);

			if (i == 0) {
				totalBalance[i] = 0.9 * purchasePrice;
				data[i][1] = Double.toString(formatDecimal(totalBalance[i]));
			} else {
				totalBalance[i] = remainingBalance[i - 1];
				data[i][1] = Double.toString(formatDecimal(totalBalance[i]));
			}

			interest[i] = totalBalance[i] * (rate / 12.0);
			data[i][2] = Double.toString(formatDecimal(interest[i]));

			payment[i] = monthlyPayment;
			data[i][4] = Double.toString(formatDecimal(payment[i]));

			principal[i] = payment[i] - interest[i];
			data[i][3] = Double.toString(formatDecimal(principal[i]));

			remainingBalance[i] = totalBalance[i] - principal[i];
			b = remainingBalance[i];
			
			if(remainingBalance[i] < 0) {
				remainingBalance[i] = 0.0;
				data[i][5] = Double.toString(formatDecimal(remainingBalance[i]));
				break;
			}
			data[i][5] = Double.toString(formatDecimal(remainingBalance[i]));
			
		}

		j = new JTable(data, columns);

		j.setBounds(30, 40, 500, 460);

		JScrollPane sp = new JScrollPane(j);
		table.add(sp);
		table.setSize(500, 460);

		j.getColumnModel().getColumn(5).setPreferredWidth(200);
		j.updateUI();

		table.setVisible(true);
	}
	
	private double formatDecimal(Double d) {
		return Math.round(d * 100.0)/100.0;
	}

}
