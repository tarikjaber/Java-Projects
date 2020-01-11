
public class Book {
	private String title;
	private String author;

	public Book() {
		this(null, null);
	}

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String toString() {
		if (this == null) {
			return "Nothing";
		} else {
			return "Author: " + this.getAuthor() + " ,Title: " + this.getTitle();
		}
	}
}
