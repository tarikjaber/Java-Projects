public class Lineseg {

	private Point myBP, myEP;
	
	public Lineseg() {
		this.myBP = new Point (0.0, 0.0);
		this.myEP = new Point (0.0, 0.0);
	}
	
	public Lineseg(Point p1, Point p2) {
		this.myBP = p1;
		this.myEP = p2;
	}
	
	public Lineseg(double x1, double y1, double x2, double y2) {
		this.myBP = new Point (x1, y1);
		this.myEP = new Point (x2, y2);
	}

	public Point getMyBP() {
		return myBP;
	}
	/*
	public void setMyBP(Point myBP) {
		this.myBP = myBP;
	}
	*/
	
	public void setMyBP(double x, double y) {
		this.myBP.setMyx(x);
		this.myBP.setMyy(y);
	}

	public Point getMyEP() {
		return myEP;
	}

	/*
	public void setMyEP(Point myEP) {
		this.myEP = myEP;
	}
	*/
	
	public void setMyEP(double x, double y) {
		this.myEP.setMyx(x);
		this.myEP.setMyy(y);
	}
	
	public double getSlope() {
		double slope;
		slope = (myEP.getMyy() - myBP.getMyy())/(myEP.getMyx() - myBP.getMyx());
		return slope;
	}
	
	public double getDistance() {
		double distance;
		distance = Math.sqrt(Math.pow((myEP.getMyx() - myBP.getMyx()), 2) + Math.pow((myEP.getMyy() - myBP.getMyy()),2));
		return distance;
	}
	
	public String toString() {
		return myBP.toString() + ", " + myEP.toString();
	}
	
}
 