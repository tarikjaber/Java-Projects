import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.*;  

public class ColorPanel extends JPanel {
	
	public ColorPanel(Color backColor) {
		//setBackground(backColor);
		this.setOpaque(false);
		repaint();
	}

	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);

	}

}
