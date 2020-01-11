import java.util.Scanner;
import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) {
		String choice;
		String bookName, bookAuthor;
		String bookNum;
		Book[] books = new Book[100];
		int numBooks = 0;

		Library library = new Library();

		Scanner reader = new Scanner(System.in);

		Patron p = new Patron("Tarik Jaber");

		outputMenu();

		while (true) {
			System.out.println("Select option:");
			choice = reader.nextLine();

			if (choice.equals("1")) {
				System.out.println("What is the title of the book you would like to add?");
				bookName = reader.nextLine();

				System.out.println("Who is the author of the book you would like to add?");
				bookAuthor = reader.nextLine();

				Book newBook = new Book(bookName, bookAuthor);

				library.ba[numBooks] = newBook;
				System.out.println(newBook.toString());
				for (int i = 0; i < numBooks; i++) {
					System.out.println(library.ba[i].toString());
				}
				numBooks++;
			} else if (choice.equals("2")) {

				System.out.println("Which book do you want to view? 1/2/3");
				bookNum = reader.nextLine();

				if (bookNum.equals("1")) {
					System.out.println(p.b1ts());
				} else if (bookNum.equals("2")) {
					System.out.println(p.b2ts());
				} else if (bookNum.equals("3")) {
					System.out.println(p.b3ts());
				}
			} else if (choice.equals("3")) {
				boolean bookExists = false;
				int bookSameNum = 0;

				System.out.println("What is the title of the book you want to borrow?");
				bookName = reader.nextLine();

				for (int i = 0; i < 50; i++) {
					if (library.ba[i] != null) {
						if (bookName.equals(library.ba[i].getTitle())) {
							bookExists = true;
							bookSameNum = i;
						}
					}
				}

				if (bookExists) {
					//System.out.println("Who is the author of the book you want to borrow?");
					//bookAuthor = reader.nextLine();
					bookAuthor = library.ba[bookSameNum].getAuthor();
					Book bookToBorrow = new Book(bookName, bookAuthor);
					p.borrow(bookToBorrow);

					System.out.println(p.toString());
				} else {
					System.out.println("Book does not exist");
				}
			} else if (choice.equals("4")) {
				System.out.println("What is the title of the book you want to be returned?");
				bookName = reader.nextLine();
				p.returnBook(bookName);

				System.out.println(p.toString());
			} else if (choice.equals("5")) {

				System.out.println("What is the title of the book you want to be check is borrowed?");

				bookName = reader.nextLine();

				System.out.println(p.borrowed(bookName));

				System.out.println(p.toString());

			} else if (choice.equals("6")) {
				System.exit(0);
			} else {
				System.out.println("Enter a valid option");
			}
		}

	}

	public static void outputMenu() {
		System.out.println("");
		System.out.println("Menu: (select option)");
		System.out.println("1) Add a book");
		System.out.println("2) View a book");
		System.out.println("3) Borrow a book");
		System.out.println("4) Return a book");
		System.out.println("5) Check if book has been borrowed");
		System.out.println("6) Quit");
		System.out.println();
	}

}
