import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Paddle extends Rectangle{

	private Color color;
	private javax.swing.Timer timer;
	int speed;
	int direction;
	
	public int getDirection() {
		return direction;
	
	}
	
	public void setX(int xpos) {
		x= xpos;
	}
	
	public void setY(int ypos) {
		y = ypos;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public javax.swing.Timer getTimer() {
		return timer;
	}
	
	public Paddle() {
		super();
	}

	public Paddle(int x, int y, int w, int h, Color c) {
		super(x,y,w,h);
		color = c;
	}

	public void draw(Graphics g) {
		
		Color oldColor = g.getColor();
		g.setColor(color);
		
		//System.out.println(this.x + " " + this.y);
		g.drawRect(this.x, this.y, this.width, this.height);
		
		g.setColor(oldColor);
	}
	
	public void fill(Graphics g) {
		Color oldColor = g.getColor();
		g.setColor(color);
		
		g.fillRect((int)this.getX(), (int)this.getY(), (int)this.getWidth(), (int)this.getHeight());
	}

	public void setSpeed(int s) {
		speed = s;
	}
	
	public void move() {
		move(0, (int)(speed * Math.sin(direction)));
	}

	public Color getColor() {
		return color;
	}

	public int getSpeed() {
		return speed;
	}
	
	public void setLoc(int xpos, int ypos) {
		setX(x);
		setY(y);
	}

	public void setTimer(javax.swing.Timer timer) {
		this.timer = timer;
	}

	public void move(int xAmount, int yAmount) {
		x = x + xAmount;
		y = y + yAmount;
	}
	
}
