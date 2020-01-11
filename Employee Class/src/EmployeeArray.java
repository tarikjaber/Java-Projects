import java.util.*;

import java.io.*;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class EmployeeArray {
	public Employee[] emps = new Employee[100];
	Scanner x;

	public EmployeeArray() {

	}
	
	public void outputArray() {
		for (int i = 0; i < 100; i++) {
			System.out.println(this.emps[i].toString());
		}
	}
	
	public void writeArray() throws FileNotFoundException {
		PrintWriter writer = new PrintWriter("WriteEmployee.txt");
		
		String write = "";
		
		for (int i = 0; i < 100; i++) {
			write += (i + 1) + "  " + this.emps[i].toString() + "\n";
			//System.out.println(this.emps[i].toString());
		}
		
		writer.println(write);
		writer.close();
	}

}
