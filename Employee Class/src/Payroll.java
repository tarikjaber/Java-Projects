import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Payroll {
	public PEmp[] pra = new PEmp[100];
	Scanner x;

	public Payroll() {

	}
	
	public void fill() throws IOException {
		for (int i = 0; i < 100; i++) {
			this.pra[i] = new PEmp(0);
		}
	}
	
	public void output() {
		for (int i = 0; i < 100; i++) {
			System.out.println(this.pra[i].toString());
		}
	}
	
	public void write() throws FileNotFoundException {
		PrintWriter writer = new PrintWriter("WritePayroll.txt");
		
		String write = "";
		
		for (int i = 0; i < 100; i++) {
			write += this.pra[i].dataOutput() + "\n";
			//System.out.println(this.emps[i].toString());
		}
		
		writer.println(write);
		writer.close();
	}
}
