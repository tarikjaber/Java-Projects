
public class Students {
	Student[] stus = new Student[1000];
	
	public Students() {
		int j = 0;

		for(int i = 0; i < 334; i++) {
			stus[j] = new HSSTU(j);	
			j++;
		}
	

		for(int i = 0; i < 333; i++) {
			stus[j] = new MSSTU(j);
			j++;
		}
		

		for(int i = 0; i < 333; i++) {
			stus[j] = new ESSTU(j);
			j++;
		}
	}
	
	public String toString() {
		String output = "";
		
		for(int i = 0; i < 1000; i++) {
			output += stus[i].toString() + "\n";
		}
		output += "Total high school students: " + stus[0].numHS + "\n";
		output += "Total middle school students: " + stus[0].numMS + "\n";
		output += "Total elementary school students: " + stus[0].numES + "\n";
		output += "Average GPA: " + stus[0].avgGPA;
		return output;
	}
	
}
