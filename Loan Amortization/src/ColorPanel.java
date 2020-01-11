import javax.imageio.ImageIO;
import javax.swing.*;



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class ColorPanel extends JPanel {
		
	public ColorPanel(Color backColor) {
	
		setBackground(backColor);
		setOpaque(false);
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
	}
	
	public void createTable(double purchasePrice) {
		Table table = new Table(purchasePrice);
		this.updateUI();
		repaint();
	}
	
}
