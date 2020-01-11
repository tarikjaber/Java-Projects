import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ratings {
	private List<Reader> readers;

	public Ratings(String filePath) {
		try {
			Scanner input = new Scanner(new File(filePath));
			readers = readFromFile(input, Stream.empty()).collect(Collectors.toList());
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<Reader> getReaders() {
		return this.readers;
	}

	public int getRecommendationA(int readerIndex) {
		return getTopIndex(filterRead(rankBooks(readers).toArray(Integer[]::new), readerIndex));
	}

	public int getRecommendationB(int readerIndex) {
		return getTopIndex(
				filterRead(readers.get(getTopIndex(rankReaders(readers, readerIndex).toArray(Integer[]::new)))
						.getRatings().toArray(Integer[]::new), readerIndex));
	}

	public int getRecommendationC(int readerIndex) {

		Integer[][] individualRatings = readers.stream().map(a -> a.getRatings().toArray(Integer[]::new))
				.toArray(Integer[][]::new);

		List<Integer> rankings = rankReaders(readers, readerIndex);

		for (int r = 0; r < individualRatings.length; r++) {
			for (int b = 0; b < individualRatings[r].length; b++) {
				individualRatings[r][b] = individualRatings[r][b] * rankings.get(b);
			}
		}

		return getTopIndex(filterRead(rankBooks(Arrays.stream(individualRatings)
				.map(a -> new Reader("", Arrays.stream(a).collect(Collectors.toList()))).collect(Collectors.toList()))
						.toArray(Integer[]::new),
				readerIndex));
	}
	
	public int findReaderIndexByName(String name) {
		return readers.stream().map(a -> a.getName()).collect(Collectors.toList()).indexOf(name);
	}
	
	private Stream<Reader> readFromFile(Scanner a, Stream<Reader> b) {
		if (!a.hasNext())
			return b;

		Stream<Reader> in = Stream.concat(b, Stream.of(new Reader(a.nextLine(),
				Arrays.stream(a.nextLine().split(" ")).map(c -> Integer.parseInt(c)).collect(Collectors.toList()))));

		return readFromFile(a, in);
	}

	private static List<Integer> rankReaders(List<Reader> readers, int baseReaderIndex) {
		List<Integer> out = new ArrayList<Integer>();

		for (int i = 0; i < readers.size(); i++) {
			if (i == baseReaderIndex) {
				out.add(0);
			} else {
				int rating = 0;
				for (int j = 0; j < readers.get(i).getRatings().size(); j++) {
					rating += readers.get(i).getRatings().get(j) * readers.get(baseReaderIndex).getRatings().get(j);
				}
				out.add(rating);
			}
		}

		return out;
	}

	private static List<Integer> rankBooks(List<Reader> readers) {
		List<Integer> out = new ArrayList<Integer>();

		for (int i = 0; i < readers.get(0).getRatings().size(); i++) {
			int ranking = 0;
			int amt = 0;
			for (int j = 0; j < readers.size(); j++) {
				if (readers.get(j).getRatings().get(i) != 0) {
					ranking += readers.get(j).getRatings().get(i);
					amt++;
				}
			}

			if (amt != 0)
				ranking /= amt;

			out.add(ranking);
		}

		return out;
	}

	private int getTopIndex(Integer[] data) {
		int highestIndex = 0;

		for (int i = 0; i < data.length; i++) {
			if (data[highestIndex] < data[i])
				highestIndex = i;
		}

		return highestIndex;
	}

	private Integer[] filterRead(Integer[] data, int readerIndex) {
		Integer[] out = data.clone();

		for (int i = 0; i < out.length; i++) {
			if (readers.get(readerIndex).getRatings().get(i) != 0) {
				out[i] = -100;
			}
		}

		return out;
	}

}
