import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class Player {
	String name;
	int opponentScore, playerScore;

	public Player() {
		this("", 0, 0);
	}

	public int calcDiff() {
		return playerScore - opponentScore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOpponentScore() {
		return opponentScore;
	}

	public void setOpponentScore(int opponentScore) {
		this.opponentScore = opponentScore;
	}

	public int getPlayerScore() {
		return playerScore;
	}

	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}

	public Player(String n, int o, int p) {
		name = n;
		opponentScore = o;
		playerScore = p;
	}

	public void addToFile() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("Players.txt", true));
		writer.newLine(); // Add new line
		writer.write(this.toString());
		writer.close();
	}

	public String toString() {
		return this.name + " " + this.opponentScore + " " + this.playerScore;
	}
}
