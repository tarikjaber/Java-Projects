import com.github.javafaker.Faker;

abstract public class Student {
	static int ID = 0;
	int GL;
	double s1,s2,s3;
	String fname, lname;
	
	static double avgGPA;
	static double sumGPA;
	
	static int numMS = 0;
	static int numES = 0;
	static int numHS = 0;
	
	abstract double getAvg();
	
	public Student() {
		this(0,0.0,0.0,0.0,"","");
		ID++;
	}
	
	public Student(int rand) {
		if (this instanceof HSSTU) {
			GL = (int) (Math.round(Math.random()*3) + 9);
		} else if (this instanceof MSSTU) {
			GL = (int) (Math.round(Math.random()*1) + 7);
		} else if (this instanceof ESSTU) {
			GL = (int) (Math.round(Math.random()*2) + 4);
		}
		s1 = roundDecimal(Math.random() * 50 + 50);
		s2 = roundDecimal(Math.random() * 50 + 50);
		s3 = roundDecimal(Math.random() * 50 + 50);
		fname = randFirst();
		lname = randLast();
		ID++;
	}
	
	public Student(int gradeLevel, double score1, double score2, double score3, String firstName, String lastName) {
		GL = gradeLevel;
		s1 = score1;
		s2 = score2;
		s3 = score3;
		fname = firstName;
		lname = lastName;
		ID++;
	}
	
	public double roundDecimal(double d) {
		return(Math.round(d*100.0)/100.0);
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
		return("Grade level: " + GL + " Score 1: " + s1 + " Score 2: " + s2 + " Score 3: " + s3 + " Name: " + fname + " " + lname);
	}
	
}
