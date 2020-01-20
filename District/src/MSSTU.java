
public class MSSTU extends Student{
	int stuID;

	public MSSTU() {
		super();
		stuID = 0;
		numMS++;
	}
	
	public MSSTU(int rand) {
		super(rand);
		stuID = ID;
		numMS++;
	}

	public MSSTU(int gradeLevel, double score1, double score2, double score3, String firstName, String lastName) {
		super(gradeLevel, score1, score2, score3, firstName, lastName);
		stuID = ID;
		numMS++;
	}

	double getAvg() {
		return roundDecimal((s1 + s2 + s3)/3.0);
	}
	
	public String toString() {
		return("Type: Middle School " + "ID: " + stuID + " " + super.toString() + " Average Score: " + getAvg());
	}
}
