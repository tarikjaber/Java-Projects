import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		double sum = 0;
		double count = 0;
		double average = 0;
		double prob = 0;
		int trials = 0;

		String ans = "n";

		do {
			sum = 0;
			count = 0;
			
			System.out.println("Enter probability");

			Scanner reader = new Scanner(System.in);

			prob = reader.nextDouble();

			System.out.println("Enter number of trials");

			trials = reader.nextInt();

			for (int i = 0; i < trials; i++) {
				double r = Math.random();

				if (r <= prob) {
					sum++;
					System.out.print("1 - ");
				} else {
					System.out.print("0 - ");
				}

				count++;

				average = sum / count;
				System.out.println(formatDecimal(average));
			}
			System.out.println("Sum: " + sum);
			System.out.println("Average: " + formatDecimal(average));
			
			System.out.println("Continue? y/n");
			ans = reader.next();
		} while (ans.equals("y") || ans.equals("Y"));
	}
	
	public static double formatDecimal(double d) {
		return ((int)(d * 100))/100.0;
	}
}
