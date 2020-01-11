import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PEmp extends Employee{

	private int ndep;
	
	public PEmp() {
		super();
		ndep = 0;
	}
	
	public PEmp(int r) throws IOException {
		super(r);
		ndep = (int)(Math.random() * 6);
	}
	
	public String toString() {
		return super.toString() + "|NOD: " + this.ndep;
	}
	
	public String dataOutput() {
		return this.getfname() + " " + this.getlname() + 
				" " + this.gethours() + " " + this.getrate()
				+ " " + this.getid() + " " + this.getage() + " " + 
				this.getgender() + " " + this.getPay() + " " + getNdep();
	}
	
	public double findGP() {
		return this.getPay();
	}
	
	public double findFed() {
		double fedTax = 0.0;;
		double grossPay = this.findGP();
		
		if (grossPay < 9526.0) {
			fedTax = .10 * grossPay;
		} else if (grossPay > 9525.0 && grossPay < 38701.0) {
			fedTax = 952.50 + .12 * (grossPay - 9525);
		} else if (grossPay > 38700.0 && grossPay < 82501.0) {
			fedTax = 4453.50 + .24 * (grossPay - 82500);
		} else if (grossPay > 82500.0 && grossPay < 157501.0) {
			fedTax = 14089.50 + .24 * (grossPay - 38700);
		} else if (grossPay > 157500.0 && grossPay < 200001.0) {
			fedTax = 32089.50 + .32 * (grossPay - 157500);
		} else if (grossPay > 200000.0 && grossPay < 500001.0) {
			fedTax = 45689.50 + .35 * (grossPay - 200000);
		} else if (grossPay > 500000.0) {
			fedTax = 150689.50 + .37 * (grossPay - 500000);
		}
		
		fedTax -= this.getNdep() * .002 * this.findGP();
		
		return fedTax;
	}
	
	public double findState() {
		double stateTax = 0.0;;
		double grossPay = this.findGP();
		
		if (grossPay < 5201.0) {
			stateTax = .00495 * grossPay;
		} else if (grossPay > 5200.0 && grossPay < 10401.0) {
			stateTax = .00990 * grossPay;
		} else if (grossPay > 10400.0 && grossPay < 15651.0) {
			stateTax = .0198 * grossPay;
		} else if (grossPay > 15650.0 && grossPay < 20901.0) {
			stateTax = .02476 * grossPay;
		} else if (grossPay > 20900.0 && grossPay < 41701.0) {
			stateTax = .02969 * grossPay;
		} else if (grossPay > 41700.0 && grossPay < 83351.0) {
			stateTax = .03465 * grossPay;
		} else if (grossPay > 83350.0 && grossPay < 104251.0) {
			stateTax = .03960 * grossPay;
		} else if (grossPay > 104250.0 && grossPay < 208501.0) {
			stateTax = .04597 * grossPay;
		} else if (grossPay > 208500.0) {
			stateTax = .04997 * grossPay;
		}
		
		//stateTax -= this.getNdep() * .01 * this.findGP();
		
		return stateTax;
	}
	
	public double findLoc() {
		return .0112 * this.findGP();
	}
	
	public double findSS() {
		double ssTax = 0.0;
		double grossPay = this.findGP();
		if (grossPay > 132900.0) {
			ssTax = 8239.9;
		} else if (grossPay > 0 && grossPay < 132901.0) {
			ssTax = grossPay * .062;
		}
		
		return ssTax;
	}
	
	public double calcYTD(double temp) {
		Calendar calOne = Calendar.getInstance();
		int dayOfYear = calOne.get(Calendar.DAY_OF_YEAR);
		int year = calOne.get(Calendar.YEAR);
		Calendar calTwo = new GregorianCalendar(year, 11, 31);
		int day = calTwo.get(Calendar.DAY_OF_YEAR);
		int total_days = day - dayOfYear;
		int tempD = 52 - ((int)(total_days/7));
		return this.formatDouble(temp * tempD);
	}
	
private double formatDouble(double d) {
		
		return Math.floor(d * 100)/100.0;
	}
	
	public double findNP() {
		return (this.findGP() - this.findFed() - this.findState() - this.findLoc() - this.findSS());
	}

	public int getNdep() {
		return ndep;
	}

	public void setNdep(int ndep) {
		this.ndep = ndep;
	}

}
