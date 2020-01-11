import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays; 
public class Employee {
	
	private String lname;
	private String fname;
	private String name;
	private int empCount = 0;
	private int hours;
	private double rate;
	private int age;
	private char gender;
	private double pay;
	
	public Employee() {
		this.fname = "";
		this.lname = "";
		this.hours = 0;
		this.rate = 0.0;
		this.id = 0;
		this.age = 0;
		this.gender = ' ';
		this.pay = rate * hours;
	}
	
	public Employee(String fname, String lname, int hours, double rate, int id, int age, char gender) {
		this.fname = fname;
		this.lname = lname;
		this.hours = hours;
		this.rate = rate;
		this.id = id;
		this.age = age;
		this.gender = gender;
		this.pay = rate * hours;
		
		empCount += 1;
		
	}
	
	public Employee(int r) throws IOException {
		Scanner x = null;
		Scanner y = null;
		Scanner z = null;
		
		x = new Scanner(new File("LastNames.txt"));
		y = new Scanner(new File("MaleNamesDictionary.txt"));
		z = new Scanner(new File("FemaleNamesDictionary.txt"));
		
		double mf = Math.random();
		
		int numMale = (int)(Math.random()*1220);
		int numLast = (int)(Math.random()*65537);
		int numFemale = (int)(Math.random()*4276);
		
		String gender = "";
		String rname = "";
		String rlast = "";
		
		if (mf < .5) {
			gender = "M";
		} else {
			gender = "F";
		}
		
		gender = "M";
		
		if (gender.equals("M")) {
			int c = 0;
			while (y.hasNext()) {
				
				rname = y.next();
				
				if (c == numMale) {
					
					break;
				}
				c++;
			}
		} else if (gender.equals("F")) {
			int c2 = 0;
			while (z.hasNext()) {
				
				rname = z.nextLine();
				
				if (c2 == numFemale) {
					
					break;
				}
				c2 ++;
			}
		}
		
	
			
		int c3 = 0;
		
		while (x.hasNext()) {
			
			rlast = x.nextLine();
			
			if (c3 == numLast) {
				
				break;
			}
			
			c3 ++;
		}
	
		//System.out.printf("%s %s", rname, rlast);
		
		this.fname = rname;
		this.lname = rlast;
		this.gender = gender.charAt(0);
		this.hours = (int) (Math.random()* 1200) + 1200;
		this.rate = (int)(Math.random()* 25000)/100;
		this.id = (int) (Math.random() * 800);
		this.age = (int) (Math.random() * 50);
		this.pay = rate * hours;
		
		x.close();
		y.close();
		z.close();
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee(String fname) throws IOException{
		int rand = (int) (Math.random() * 34);
	 
		  openFile(fname);
		  
		  int counter = 1;
			while (x.hasNext()) {
				
				String a = x.next();
				String b = x.next();
				String c = x.next();
				
				if (rand == counter) {
					
					this.fname = a;
					this.lname = b;
					this.gender = c.charAt(0);
				}
				counter += 1;
			}
			
		  closeFile();
		
			    this.hours = (int) (Math.random()* 40);
				this.rate = (int)(Math.random()* 2000)/100;
				this.id = (int) (Math.random() * 800);
				this.age = (int) (Math.random() * 50);
				this.pay = rate * hours;
				
	}

	public Employee(String fname, String lname, char gender) {
		this.fname = fname;
		this.lname = lname;
		this.hours = (int) (Math.random()* 40);
		this.rate = (int)(Math.random()* 2000)/100;
		this.id = (int) (Math.random() * 800);
		this.age = (int) (Math.random() * 50);
		this.gender = gender;
		this.pay = rate * hours;
	}
	
	public double getPay() {
		return rate * hours;
	}

	public String getName() {
		return fname + " " + lname;
	}

	public int getEmpCount() {
		return empCount;
	}

	public void setEmpCount(int empCount) {
		this.empCount = empCount;
	}

	public void setName(String name) {
		var spaceLoc = 0;
		for (int i = 0; i < name.length(); i++) {
			
			if (Character.isWhitespace(name.charAt(i))) {
					
					spaceLoc = i;
			}
		}
		fname = name.substring(0, spaceLoc);
		lname = name.substring(spaceLoc + 1, name.length());
	}

	public void setPay(double pay) {
		this.pay = rate * hours;
	}

	int id;
	
	private Scanner x;
	
	public void openFile(String fname) {
		try {
			x = new Scanner(new File(fname));
		} catch (Exception e){
			System.out.println("could not open file");
		}
	}
	
	public void readFile(int rand) {
		int counter = 1;
		while (x.hasNext()) {
			
			String a = x.next();
			String b = x.next();
			String c = x.next();
			
			if (rand == counter) {
				this.fname = a;
				this.lname = b;
				this.gender = c.charAt(0);
			}
			counter += 1;
		}
	}
	
	public void closeFile() {
		x.close();
	}
	
	public String getfname() {
		return fname;
	}
	
	public String getlname() {
		return lname;
	}
	
	public int gethours() {
		return hours;
	}
	
	public double getrate() {
		return rate;
	}
	
	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getid() {
		return id;
	}
	
	public int getage() {
		return age;
	}
	
	public char getgender() {
		return gender;
	}
	
	public String toString() {
		return("Name: " + this.getfname() + " " + this.getlname() + 
				"|Hours: " + this.gethours() + "|Rate: " + this.getrate()
				+ "|ID: " + this.getid()) + "|Age: " + this.getage() + "|Gender: " + 
				this.getgender() + "|Pay: " + this.getPay();
	}
	
}
