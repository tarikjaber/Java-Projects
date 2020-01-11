
public class Patron {

	String name;
	Book book1 = null;
	Book book2 = null;
	Book book3 = null;

	public Patron() {
		this("");
	}

	public Patron(String name) {
		this.name = name;
	}

	public String b1ts() {
		if (book1 == null) {
			return "Nothing";
		} else {
			return book1.toString();
		}
	}

	public String b2ts() {
		if (book2 == null) {
			return "Nothing";
		} else {
			return book2.toString();
		}
	}

	public String b3ts() {
		if (book3 == null) {
			return "Nothing";
		} else {
			return book3.toString();
		}
	}

	public boolean borrow(Book book) {
		if (book1 == null) {
			book1 = book;
			return true;
		} else if (book2 == null) {
			book2 = book;
			return true;
		} else if (book3 == null) {
			book3 = book;
			return true;
		} else {
			return false;
		}
	}

	public void returnBook(String title) {
		if (book1 != null) {
			if (book1.getTitle().equals(title)) {
				book1 = null;
			}
		}
		if (book2 != null) {
			if (book2.getTitle().equals(title)) {
				book2 = null;
			}
		}
		if (book3 != null) {
			if (book3.getTitle().equals(title)) {
				book3 = null;
			}
		}
	}

	public boolean borrowed(String title) {

			if(book1 != null) {
				if(book1.getTitle().equals(title)) {
					return true;
				}
			} 
			
			if(book2 != null) {
				if(book2.getTitle().equals(title)) {
					return true;
				}
			} 
			
			if(book3 != null) {
				if(book3.getTitle().equals(title)) {
					return true;
				}
			} 
			
			return false;
	}

	public String toString() {
		String b1, b2, b3;

		if (book1 == null) {
			b1 = "Nothing";
		} else {
			b1 = book1.toString();
		}

		if (book2 == null) {
			b2 = "Nothing";
		} else {
			b2 = book2.toString();
		}

		if (book3 == null) {
			b3 = "Nothing";
		} else {
			b3 = book3.toString();
		}

		return "Name: " + this.name + "\n" + "Book1| " + b1 + "\n" + "Book2| " + b2 + "\n" + "Book3| " + b3;
	}

	public String getName() {
		return name;
	}

}
