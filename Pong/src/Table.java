import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Table {
	String[][] data = new String[10][4];
	String[] columns = { "Rank", "Name", "Player Score", "Opponent Score"};
	

	JTable j;
	
	public Table() {
		
	}
	
	public Table(Player [] players) {

		JFrame table = new JFrame();

		table.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		for (int i = 0; i < 10; i ++) {
			data[i][0] = Integer.toString(i + 1);
			data[i][1] = players[i].getName();
			data[i][2] = Integer.toString(players[i].getOpponentScore());
			data[i][3] = Integer.toString(players[i].getPlayerScore());
		}

		j = new JTable(data, columns);
		j.setBounds(30, 40, 400, 400);

		JScrollPane sp = new JScrollPane(j);
		table.add(sp);
		table.setSize(400, 220);

		j.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		table.setVisible(true);
	}
	
}
