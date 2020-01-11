import java.io.FileNotFoundException;

public class TopTen {

	private Player [] topTen = new Player[10];
	private PlayerFile pf = new PlayerFile();
	
	public TopTen() {
		
	}
	
	public void fillLeaderboard() throws FileNotFoundException {
		topTen = pf.getTopTen();
	}
	
	public void outputLeaderBoard() {
		Table t = new Table(topTen);
	}
}
