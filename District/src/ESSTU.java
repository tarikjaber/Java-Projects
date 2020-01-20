
public class ESSTU extends Student{
	int stuID;

	public ESSTU() {
		super();
		stuID = 0;
		numES += 1;
	}
	
	public ESSTU(int rand) {
		super(rand);
		stuID = ID;
		numES += 1;
	}

	public ESSTU(int gradeLevel, double score1, double score2, double score3, String firstName, String lastName) {
		super(gradeLevel, score1, score2, score3, firstName, lastName);
		stuID = ID;
		numES += 1;
	}

	double getAvg() {
		return roundDecimal((s1 + s2 + s3)/3.0);
	}

	public String toString() {
		return("Type: Elementary School " + "ID: " + stuID + " " + super.toString() + " Average Score: " + getAvg());
	}
}
