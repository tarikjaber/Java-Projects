import java.util.*;
import java.io.*;
import javax.swing.JList;
import javax.swing.JOptionPane;
import junit.framework.Test;

public class Main {

	private Formatter x;

	// private static DecimalFormat

	public static void main(String[] args) throws IOException {

		Double rate = null;

		JList list = new JList(new String[] { "Read", "Write", "Input" });
		JOptionPane.showMessageDialog(null, list, "Choose option:", JOptionPane.PLAIN_MESSAGE);
		String choice = Arrays.toString(list.getSelectedIndices());

		if (choice.contains("[2]")) {
			String strSalary = JOptionPane.showInputDialog("Enter starting salary");
			Double salary = Double.parseDouble(strSalary);

			String educationLevel = JOptionPane.showInputDialog("Enter education level");

			if (educationLevel.toUpperCase().equals("PHD")) {
				rate = 1.04;
			} else if (educationLevel.toUpperCase().equals("M")) {
				rate = 1.03;
			} else if (educationLevel.toUpperCase().equals("B")) {
				rate = 1.02;
			} else {
				System.out.println(educationLevel.toUpperCase());
				rate = 0.0;
			}

			String strYears = JOptionPane.showInputDialog("Enter years worked");
			Double years = Double.parseDouble(strYears);

			int sYear = 2019;
			int yNum = 0;

			double bsalary = salary;
			double msalary = salary;
			double psalary = salary;

			System.out.format("%11s", "Year:");

			for (int i = 0; i < 21; i++) {
				yNum += 1;
				System.out.format("%12s", "Year " + yNum + " ");

				// System.out.print("Year " + yNum + " ");
			}

			System.out.println();
			System.out.format("%11s", "Bachelor's");

			for (int i = 0; i < 21; i++) {
				System.out.print(String.format("%12s", "$" + String.format("%,.2f", (float) bsalary)));
				// System.out.print(Math.round(bsalary) + " ");
				bsalary = bsalary * 1.02;
			}

			System.out.println();
			System.out.format("%11s", "Master's");

			for (int i = 0; i < 21; i++) {
				System.out.print(String.format("%12s", "$" + String.format("%,.2f", (float) msalary)));
				// System.out.format("%9s", Math.round(msalary));
				// System.out.print(Math.round(msalary) + " ");
				msalary = msalary * 1.03;
			}

			System.out.println();
			System.out.format("%11s", "PHD");

			for (int i = 0; i < 21; i++) {
				System.out.print(String.format("%12s", "$" + String.format("%,.2f", (float) psalary)));
				// System.out.format("%9s", Math.round(psalary));
				// System.out.print(Math.round(psalary) + " ");
				psalary = psalary * 1.04;
			}

			for (int i = 0; i < years; i++) {

				if (i != years - 1) {
					salary = salary * rate;
				}
				sYear += 1;
			}

			Double rsalary = (double) (Math.round(salary * 100) / 100.0);

			JOptionPane.showMessageDialog(null, "$" + rsalary);
		} else if (choice.contains("[1]")) {
			// Write
			// System.out.println("Write");

			PrintWriter writer = new PrintWriter(
					"C:\\Users\\yusef\\OneDrive\\Desktop\\Java Projects\\4.10\\src\\tsw.txt", "UTF-8");

			String strSalary = JOptionPane.showInputDialog("Enter starting salary");
			Double salary = Double.parseDouble(strSalary);

			String educationLevel = JOptionPane.showInputDialog("Enter education level");

			if (educationLevel.toUpperCase().equals("PHD")) {
				rate = 1.04;
			} else if (educationLevel.toUpperCase().equals("M")) {
				rate = 1.03;
			} else if (educationLevel.toUpperCase().equals("B")) {
				rate = 1.02;
			} else {
				System.out.println(educationLevel.toUpperCase());
				rate = 0.0;
			}

			String strYears = JOptionPane.showInputDialog("Enter years worked");
			Double years = Double.parseDouble(strYears);

			int sYear = 2019;
			int yNum = 0;

			double bsalary = salary;
			double msalary = salary;
			double psalary = salary;

			writer.format("%11s", "Year:");

			for (int i = 0; i < 21; i++) {
				yNum += 1;
				writer.format("%12s", "Year " + yNum + " ");

				// System.out.print("Year " + yNum + " ");
			}

			writer.println();
			writer.format("%11s", "Bachelor's");

			for (int i = 0; i < 21; i++) {
				writer.print(String.format("%12s", "$" + String.format("%,.2f", (float) bsalary)));
				// System.out.print(Math.round(bsalary) + " ");
				bsalary = bsalary * 1.02;
			}

			writer.println();
			writer.format("%11s", "Master's");

			for (int i = 0; i < 21; i++) {
				writer.print(String.format("%12s", "$" + String.format("%,.2f", (float) msalary)));
				// System.out.format("%9s", Math.round(msalary));
				// System.out.print(Math.round(msalary) + " ");
				msalary = msalary * 1.03;
			}

			writer.println();
			writer.format("%11s", "PHD");

			for (int i = 0; i < 21; i++) {
				writer.print(String.format("%12s", "$" + String.format("%,.2f", (float) psalary)));
				// System.out.format("%9s", Math.round(psalary));
				// System.out.print(Math.round(psalary) + " ");
				psalary = psalary * 1.04;
			}

			for (int i = 0; i < years; i++) {

				if (i != years - 1) {
					salary = salary * rate;
				}
				sYear += 1;
			}

			Double rsalary = (double) (Math.round(salary * 100) / 100.0);

			writer.close();

			JOptionPane.showMessageDialog(null, "$" + rsalary);
		} else if (choice.contains("[0]")) {
			// Read
			// System.out.println("Read");

			// URL url = Test.class.getClassLoader().getResource("Teacher Schedule
			// Read.txt");
			// System.out.println(url.getPath());

			// File file = new File(System.getProperty("user.dir") + "/Teacher Schedule
			// Read.txt");

			// Scanner x = new Scanner(new File("C:\\Users\\yusef\\OneDrive\\Desktop\\Java
			// Projects\\4.10\\src\\Teacher Schedule Read.txt"));

			BufferedReader br = new BufferedReader(
					new FileReader("C:\\Users\\yusef\\OneDrive\\Desktop\\Java Projects\\4.10\\src\\tsr.txt"));

			Double salary = 0.0;
			int years = 0;
			int degree = 0;
			int sYear = 0;

			int j = 0;
			try {
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();

				while (line != null) {

					if (j % 3 == 0) {
						salary = Double.parseDouble(line);
					} else if (j % 3 == 1) {
						degree = Integer.parseInt(line);
					} else if (j % 3 == 2) {
						years = Integer.parseInt(line);
					}

					j++;

					sb.append(line);
					sb.append(System.lineSeparator());
					line = br.readLine();
				}
				String everything = sb.toString();
				
			} finally {
				br.close();
			}
			
			if (degree == 0) {
				rate = 1.02;
			} else if (degree == 1) {
				rate = 1.03;
			} else if (degree == 2) {
				rate = 1.04;
			} else {
				System.out.println("Read rate is messed up");
				rate = 0.0;
			}

			double bsalary = salary;
			double msalary = salary;
			double psalary = salary;

			int yNum = 0;

			System.out.format("%11s", "Year:");

			for (int i = 0; i < 21; i++) {
				yNum += 1;
				System.out.format("%12s", "Year " + yNum + " ");

				// System.out.print("Year " + yNum + " ");
			}

			System.out.println();
			System.out.format("%11s", "Bachelor's");

			for (int i = 0; i < 21; i++) {
				System.out.print(String.format("%12s", "$" + String.format("%,.2f", (float) bsalary)));
				// System.out.print(Math.round(bsalary) + " ");
				bsalary = bsalary * 1.02;
			}

			System.out.println();
			System.out.format("%11s", "Master's");

			for (int i = 0; i < 21; i++) {
				System.out.print(String.format("%12s", "$" + String.format("%,.2f", (float) msalary)));
				// System.out.format("%9s", Math.round(msalary));
				// System.out.print(Math.round(msalary) + " ");
				msalary = msalary * 1.03;
			}

			System.out.println();
			System.out.format("%11s", "PHD");

			for (int i = 0; i < 21; i++) {
				System.out.print(String.format("%12s", "$" + String.format("%,.2f", (float) psalary)));
				// System.out.format("%9s", Math.round(psalary));
				// System.out.print(Math.round(psalary) + " ");
				psalary = psalary * 1.04;
			}

			for (int i = 0; i < years; i++) {

				if (i != years - 1) {
					salary = salary * rate;
				}
				sYear += 1;
			}

			Double rsalary = (double) (Math.round(salary * 100) / 100.0);

			JOptionPane.showMessageDialog(null, "$" + rsalary);

		}

		// Write and reading to file
		/*
		 * PrintWriter pw = new
		 * PrintWriter("C:\\Users\\yusef\\OneDrive\\Desktop\\Java Projects\\4.10\\src\\tsw.txt"
		 * , "UTF-8"); pw.print("hello"); pw.close();
		 */

	}

}
