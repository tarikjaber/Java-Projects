import java.awt.Graphics;

public class Point {

	private double myx,myy, dx, dy;
	
	
	
	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public Point() {
		this.myx = 0.0;
		this.myy = 0.0;
	}
	
	public Point(double x, double y) {
		this.myx = x;
		this.myy = y;
	}

	public double getMyx() {
		return myx;
	}

	public void setMyx(double myx) {
		this.myx = myx;
	}

	public double getMyy() {
		return myy;
	}

	public void setMyy(double myy) {
		this.myy = myy;
	}
	
	public String toString() {
		return "(" + myx + ", " + myy + ")";
	}
	
	

}
