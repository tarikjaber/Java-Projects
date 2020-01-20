
public class HSSTU extends Student{
	int stuID;
	double GPA;
	
	public HSSTU() {
		super();
		stuID = 0;
		numHS += 1;
	}
	
	public HSSTU(int rand) {
		super(rand);
		GPA = roundDecimal(Math.random() * 4 + 0.5);
		
		sumGPA += GPA;
		numHS += 1;
		avgGPA = roundDecimal(sumGPA/numHS);
		stuID = ID;
	}
	
	public HSSTU(int gradeLevel, double score1, double score2, double score3, 
			String firstName, String lastName, double gradePointAverage) {
		super(gradeLevel, score1, score2, score3, firstName, lastName);
		GPA = gradePointAverage;
		stuID = ID;
		numHS += 1;
	}
	
	double getAvg() {
		return roundDecimal((s1 + s2 + s3)/3.0);
	}
	
	public String toString() {
		return("Type: High School " + "ID: " + stuID + " " + super.toString() + " GPA: " + GPA + " Average Score: " + getAvg());
	}

}
