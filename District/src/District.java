
public class District {
	Students stus;
	Teachers tchrs;
	public District() {
		stus = new Students();
		tchrs = new Teachers();
	}
	
	public String toString() {
		String output = "";
		output += "Students: \n"; 
		output += stus.toString() + "\n";
		output += "Teachers: \n"; 
		output += tchrs.toString();
		return output;
	}
}
