
public class Teachers {
	Teacher [] teachers = new Teacher[100];
	
	public Teachers() {
		for (int i = 0; i < 100; i++) {
			teachers[i] = new Teacher(i);
		}
	}
	
	public String toString() {
		String output = "";
		for (int i = 0; i < 100; i++) {
			output += teachers[i].toString() + "\n";
		}
		return output;
	}
}
