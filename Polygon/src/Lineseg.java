public class Lineseg {

	private Point myBP, myEP;
	
	public Lineseg() {
		this.myBP = new Point (0.0, 0.0);
		this.myEP = new Point (0.0, 0.0);
	}
	
	public Lineseg(int r) {
		this.myBP = new Point(0);
		this.myEP = new Point(0);
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
	
	public void setMyBP(double x, double y) {
		this.myBP.setMyx(x);
		this.myBP.setMyy(y);
	}
	
	public void setMyBP(Point p) {
		this.myBP = p;
	}
	
	public void setMyEP(Point p) {
		this.myEP = p;
	}

	public Point getMyEP() {
		return myEP;
	}
	
	public boolean inBetween(double a, double b, double c) {
		if ((a < b && b < c) || (c < b && b < a)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean pointIntersect(Point i) {
		if (inBetween(this.myBP.getMyx(), i.getMyx(), this.myEP.getMyx()) && inBetween(this.myBP.getMyy(), i.getMyy(), this.myEP.getMyy())) {
			return true;
		} else {
			return false;
		}
	}

	public boolean intersects(Lineseg l) {
		Point pi = new Point();
		double ix, iy;
		ix = (l.getIntercept() - this.getIntercept())/(this.getSlope()-l.getSlope());
		iy = this.getSlope() * ix + this.getIntercept();
		pi.setMyx(ix);
		pi.setMyy(iy);
		
		if(this.pointIntersect(pi) && l.pointIntersect(pi)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void setMyEP(double x, double y) {
		this.myEP.setMyx(x);
		this.myEP.setMyy(y);
	}
	
	public double getSlope() {
		double slope;
		slope = (myEP.getMyy() - myBP.getMyy())/(myEP.getMyx() - myBP.getMyx());
		return slope;
	}
	
	public double getIntercept() {
		return (this.getMyBP().getMyy()- this.getMyBP().getMyx()*((this.getMyEP().getMyy()-this.getMyBP().getMyy())/(this.getMyEP().getMyx()-this.getMyBP().getMyx())));
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
 