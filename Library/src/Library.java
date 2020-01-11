
public class Library {
	Book[]ba = new Book[50];
	Patron[]pa = new Patron[50];
	
	public Library() {
		
	}
	
	public String toString() {
		String toString = "";
		toString += "Books:" + "\n";
		for(int i = 0; i < 50; i++) {
			toString += this.ba[i].toString() + "\n";
		}
		toString += "Patron:\n";
		for(int i = 0; i < 50; i++) {
			toString += this.pa[i].toString() + "\n";
		}
		return toString;
	}
}
