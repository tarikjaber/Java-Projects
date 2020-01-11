import java.awt.Color;
import java.awt.Container;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GUI {

	public GUI() throws FileNotFoundException {
		
		
		PlayerFile pf = new PlayerFile();
		pf.fill("Players.txt");
		pf.sort();
		System.out.println(pf.toString());
		
		
		Player[] players = new Player[10];
		
		
		players = pf.getTopTen();
		
		ImageIcon img = new ImageIcon("Tennis.png");
		
		JFrame theGUI = new JFrame();
		theGUI.setTitle("Pong");
		theGUI.setSize(790, 548);
		theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ColorPanel mama = new ColorPanel(Color.black, img);
		Container  pane = theGUI.getContentPane();
		
		pane.add(mama);

		theGUI.setVisible(true);
	}
}
