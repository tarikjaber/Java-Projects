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
	
	int x, y, px, py, dx, dy;

	private ImageIcon image;
	
	private Ball ball = new Ball(getWidth()/2,getHeight()/2, 10, Color.yellow);
	private Paddle paddle;
	
	private Paddle opponent;
	
	private javax.swing.Timer timer;
	
	int scorePlayer, scoreOpponent;
	
	
	public ColorPanel(Color backColor, ImageIcon i) {
	
		setBackground(backColor);
		
		System.out.println(getHeight());
				
		addMouseListener(new PanelListener());
		addMouseMotionListener(new MouseListener());

		ball.setSpeed(6);
		ball.setDirection(45);
		
		timer = new javax.swing.Timer(10, new MoveListener());
		timer.start();
		
		paddle = new Paddle(50, 500, 10, 100, Color.blue);
		opponent = new Paddle(700, 500, 10, 100, Color.blue);
		opponent.setSpeed(8);
		
		scorePlayer = 0;
		scoreOpponent = -1;
		
		image = i;
	}
	
	public void paintComponent(Graphics g) {

		
		super.paintComponent(g);
		
		Font font = new Font("Serif", Font.BOLD, 50);
	    g.setFont(font);
	    g.setColor(Color.white);
	   
	      
	    paddle.setLoc(50, getHeight()/2);
	    opponent.setLoc(getWidth() - 50, getHeight()/2);
	      
	    int x = (getWidth() - image.getIconWidth())/2;
		int y = (getHeight() - image.getIconHeight())/2;
	    
	    image.paintIcon(this, g, x, y);
	    
	    g.drawString(scorePlayer + "      " + scoreOpponent, getWidth()/2 - 60, 50);
		ball.fill(g);
		paddle.fill(g);
		opponent.fill(g);
		
	}
	
	private class MoveListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			int randomTurn = (int)(Math.random()*10) - 5;
			int x = ball.getX();
			String str;
			int y = ball.getY();
			int radius = ball.getRadius();
			int width = getWidth();
			int height = getHeight();
	
			Rectangle c = new Rectangle(ball.getX() - ball.getRadius(), ball.getY() - ball.getRadius(), ball.getRadius()*2,ball.getRadius()*2);
			
			Point topLeft = new Point(ball.getX(), ball.getY());
			Point topCenter = new Point(ball.getX() + ball.getRadius(), ball.getY());
			Point topRight = new Point(ball.getX() + ball.getRadius() * 2, ball.getY());
			Point leftCenter = new Point(ball.getX(), ball.getY() + ball.getRadius());
			Point rightCenter = new Point(ball.getX() + ball.getRadius() * 2, ball.getY() + ball.getRadius());
			Point bottomLeft = new Point(ball.getX(), ball.getY() + ball.getRadius()*2);
			Point bottomCenter = new Point(ball.getX() + ball.getRadius(), ball.getY() + ball.getRadius()*2);
			Point bottomRight = new Point(ball.getX() + ball.getRadius() * 2, ball.getY() + ball.getRadius()*2);
			
			//Rectangle top = new Rectangle(topLeft, topRight,1,1);
			
			if (paddle.intersects(c) || opponent.intersects(c)) {
				ball.setDirection(180 - ball.getDirection() + randomTurn);
				ball.setSpeed(ball.getSpeed() + 2);
				ball.turn((int)Math.random()*16 - 8);
			}
			
			int randomDirection = (int)(Math.random()*30 + 20);
			
			
			if(x - radius <= 0)  {
				ball.setDirection(180 - ball.getDirection());
				ball.setSpeed(4);
				ball.setCenter(getWidth()/2, getHeight()/2);
				
				ball.setDirection(randomDirection);
				scoreOpponent ++;
				
				if (scoreOpponent == 5) {
					JOptionPane.showMessageDialog(null, "You lose.");
					str = JOptionPane.showInputDialog("Enter name. Press 0 to quit.");
					
					if(str.equals("0")) {
						System.exit(0);
					} 
					
					Player p = new Player(str, scorePlayer, scoreOpponent);
					
					try {
						p.addToFile();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (UnsupportedEncodingException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					TopTen t = new TopTen();
					try {
						t.fillLeaderboard();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					t.outputLeaderBoard();
					
					scorePlayer = 0;
					scoreOpponent = 0;
					repaint();
				}
			}
				
			if(x + radius >= width) {
				ball.setDirection(180 - ball.getDirection());
				ball.setSpeed(4);
				ball.setCenter(getWidth()/2, getHeight()/2);
		
				System.out.println(getWidth());
				System.out.println(getHeight());
				ball.setDirection(randomDirection);
				scorePlayer ++;
				
				
				
				if (scorePlayer == 5) {
					JOptionPane.showMessageDialog(null, "You win!");
					str = JOptionPane.showInputDialog("Enter name. Press 0 to quit.");
					
					if(str.equals("0")) {
						System.exit(0);
					}
					
					Player p = new Player(str, scorePlayer, scoreOpponent);
					
					try {
						p.addToFile();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (UnsupportedEncodingException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					TopTen t = new TopTen();
					try {
						t.fillLeaderboard();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					t.outputLeaderBoard();
					
					scorePlayer = 0;
					scoreOpponent = 0;
					repaint();
				}
				
			}
			
			if(y - radius <= 0 || y + radius >= height) {
				ball.setDirection(-ball.getDirection() + randomTurn);
			}
			
			
			if(ball.getY() - opponent.getHeight()/2> opponent.getY()+ 10) {
				opponent.setDirection(90);
				opponent.move();
			} else if(ball.getY() - opponent.getHeight()/2< opponent.getY() - 10) {
				opponent.setDirection(-90);
				opponent.move();
			} else if(ball.getSpeed() < paddle.getSpeed()) {
			
				opponent.setLoc(paddle.getLocation().x, ball.getY());
			}
			
			
			ball.move();
			ball.turn(0);
			repaint();
		}
		
	}
	
	private class PanelListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			
		}
	}
	
	private class MouseListener extends MouseMotionAdapter {
		public void mouseMoved(MouseEvent e) {
			y = e.getY();
			
			paddle.setY(y);
		}
	}
	
}
