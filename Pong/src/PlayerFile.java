import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class PlayerFile {
	private Player[] players = new Player[100];
	
	public PlayerFile() {
		
	}
	
	public int fileNumLines(String fname) throws FileNotFoundException {
		
		Scanner x = new Scanner(new File(fname));
		
		String l;
		int c = 0;
		
		while(x.hasNext()) {
			l = x.nextLine();
			c++;
		}
		
		x.close();
		
		return c;
	}
	
	public Player[] getTopTen() throws FileNotFoundException {
		fill("Players.txt");
		
		sort();
		Player[] ps = new Player[10];
		for(int i = 0; i < 10; i++) {
			ps[i] = new Player();
			ps[i] = players[i];
		}
		return ps;
	}   
	
	public void sort() throws FileNotFoundException {
		for (int i = 0; i < fileNumLines("Players.txt"); i++) {
			for(int j = i + 1; j < fileNumLines("Players.txt"); j++) {
				if(players[i].calcDiff() > players[j].calcDiff()) {
					Player p = players[j];
					players[j] = players[i];
					players[i] = p;
				}
			}
		}
	}	
	
	public void fill(String fname) throws FileNotFoundException {
		
		Scanner x = new Scanner(new File(fname));
		
		int c = 0;
		int cp = 0;
		
		while (x.hasNext()) {
			
			if (c % 3 == 0) {
				players[cp] = new Player();
				players[cp].name = x.next();
			} else if (c % 3 == 1) {
				players[cp].opponentScore = x.nextInt();
			} else {
				players[cp].playerScore = x.nextInt();
				cp++;
			}
			c ++;
			
		}
		
		x.close();
		
	}
	
	public String toString() {
		
		String sb = "";
		try {
			for (int i = 0; i < fileNumLines("Players.txt"); i++) {
				sb += players[i].toString() + "\n";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return sb;
	}
}
