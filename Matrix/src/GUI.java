import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class GUI {
	public GUI() {
		KeyFrame theGUI = new KeyFrame();
		theGUI.setTitle("GUI Program");
		theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theGUI.setSize(1100, 500);
		ColorPanel panel = new ColorPanel(Color.white);
		panel.setOpaque(false);
		Container pane = theGUI.getContentPane();
		pane.add(panel);
		theGUI.setVisible(true);
	}
}
