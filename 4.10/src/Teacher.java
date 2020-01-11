
public class Teacher {
	private int yearsWorked;
	private String educationLevel;
	private double startingSalary;
	private int numYears;
	
	public String getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}
	
	public Teacher() {
		this.yearsWorked = 0;
		this.startingSalary = 0.0;
		this.numYears = 0;
	}
	
	public Teacher(int yw, double ss, int ny) {
		this.yearsWorked = yw;
		this.startingSalary = ss;
		this.numYears = ny;
	}
	
	public int getYearsWorked() {
		return yearsWorked;
	}
	public void setYearsWorked(int yearsWorked) {
		this.yearsWorked = yearsWorked;
	}
	public double getStartingSalary() {
		return startingSalary;
	}
	public void setStartingSalary(double startingSalary) {
		this.startingSalary = startingSalary;
	}
	public int getNumYears() {
		return numYears;
	}
	public void setNumYears(int numYears) {
		this.numYears = numYears;
	}
	
	public String toString() {
		return(this.getStartingSalary() + " " + this.getEducationLevel() + " " + this.getNumYears());
	}
	
	
}
