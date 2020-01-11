import java.util.List;
import java.util.stream.Collectors;

public class Reader {
	private String name;
	private List<Integer> ratings;

	public Reader(String name, List<Integer> ratings) {
		this.name = name;
		this.ratings = ratings;
	}

	public String toString() {
		return name + ": " + ratings.stream().map(a -> Integer.toString(a) + ", ").collect(Collectors.joining());
	}

	public String getName() {
		return name;
	}

	public List<Integer> getRatings() {
		return ratings;
	}
}
