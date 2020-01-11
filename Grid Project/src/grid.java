import javax.swing.*;
import java.util.Scanner;
import java.awt.*;
public class grid {
	public static void main(String[] args) {
		JFrame theGUI = new JFrame();
		theGUI.setTitle("First GUI Program");
		theGUI.setSize(300, 200);
		theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theGUI.setVisible(true);
		
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter width: ");
		int gwidth = myObj.nextInt();
		System.out.println("Enter height: ");
		int gheight = myObj.nextInt();
		
		Container pane = theGUI.getContentPane();
		
		for (int i = 0; i < gwidth; i++) {
			for(int j = 0; j < gheight; j++) {
				JPanel panel = new JPanel();
				Color randColor = new Color((int)(Math.random() * 256),(int)(Math.random() * 256),(int)(Math.random() * 256));
				panel.setBackground(randColor);
				pane.add(panel);
			}
		}
		
		pane.setLayout(new GridLayout(gheight, gwidth));
		
		theGUI.setVisible(true);
	}
}
