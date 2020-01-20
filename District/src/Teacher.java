import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.github.javafaker.Faker;

public class Teacher {

	private String lname;
	private String fname;
	private String name;
	private int hours;
	private double rate;
	private int age;
	private double pay;
	
	public Teacher() {
		this.fname = "";
		this.lname = "";
		this.hours = 0;
		this.rate = 0.0;
		this.age = 0;
		this.pay = rate * hours;
	}
	
	public Teacher(int rand) {
		this.fname = randFirst();
		this.lname = randLast();
		this.hours = (int)(Math.random() * 20 + 10);
		this.rate = roundDecimal(Math.random() * 20 + 10);
		this.age = (int)(Math.random() * 36 + 20);;
		this.pay = roundDecimal(rate * hours);
	}
	
	public Teacher(String firstName, String lastName, int hours, double hourlyRate, int ageYears, int payTotal) {
		this.fname = firstName;
		this.lname = lastName;
		this.hours = hours;
		this.rate = hourlyRate;
		this.age = ageYears;
		this.pay = roundDecimal(rate * hours);
	}
	
	public double roundDecimal(double d) {
		return(Math.round(d*100.0)/100.0);
	}
		
	public double getPay() {
		return rate * hours;
	}

	public String getName() {
		return fname + " " + lname;
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
	
	public int getage() {
		return age;
	}
	
	public String randFirst() {
		Faker faker = new Faker();
		return faker.name().firstName();
	}
	
	public String randLast() {
		Faker faker = new Faker();
		return faker.name().lastName();
	}
	
	public String toString() {
		return("Name: " + this.getfname() + " " + this.getlname() + 
				"|Hours: " + this.gethours() + "|Rate: " + this.getrate()
				 + "|Age: " + this.getage() + "|Pay: " + this.getPay());
	}
}
