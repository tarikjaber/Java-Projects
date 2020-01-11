import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Library {
	private List<Book> books;

	public Library(String filePath) {
		try {
			Scanner input = new Scanner(new File(filePath));
			books = readFromFile(input, Stream.empty()).collect(Collectors.toList());
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<Book> getBooks() {
		return this.books;
	}

	private Stream<Book> readFromFile(Scanner a, Stream<Book> b) {
		if (!a.hasNext())
			return b;

		Stream<Book> in = Stream.concat(b,
				Stream.of(a.nextLine()).map(c -> c.split(",", 2)).map(d -> new Book(d[0], d[1])));

		return readFromFile(a, in);
	}
}
