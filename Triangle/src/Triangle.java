import java.awt.Graphics;
import java.util.*;

public class Triangle {
	Lineseg myL1, myL2, myL3;
	
	public Triangle() {
		this.myL1 = new Lineseg(0,0,0,0);
		this.myL2 = new Lineseg(0,0,0,0);
		this.myL3 = new Lineseg(0,0,0,0);
	}
	
	public Triangle(String random) {
		Random r = new Random();
		
		Point p1 = new Point(r.nextInt(100) + 1,r.nextInt(100) + 1);
		Point p2 = new Point(r.nextInt(100) + 1,r.nextInt(100) + 1);
		Point p3 = new Point(r.nextInt(100) + 1,r.nextInt(100) + 1);
		
		this.myL1 = new Lineseg(p1, p2);
		this.myL2 = new Lineseg(p2, p3);
		this.myL3 = new Lineseg(p3, p1);
	}
	
	public Triangle(Point p1, Point p2, Point p3) {
		this.myL1 = new Lineseg(p1, p2);
		this.myL2 = new Lineseg(p2, p3);
		this.myL3 = new Lineseg(p3, p1);
	}
	
	public Triangle(Lineseg l1, Lineseg l2, Lineseg l3) {
		this.myL1 = l1;
		this.myL2 = l2;
		this.myL3 = l3;
	}
	
	public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
		this.myL1 = new Lineseg(x1,y1,x2,y2);
		this.myL2 = new Lineseg(x2,y2,x3,y3);
		this.myL3 = new Lineseg(x3,y3,x1,y1);
	}

	public Lineseg getMyL1() {
		return myL1;
	}

	public void setMyL1(Lineseg myL1) {
		this.myL1 = myL1;
	}

	public Lineseg getMyL2() {
		return myL2;
	}

	public void setMyL2(Lineseg myL2) {
		this.myL2 = myL2;
	}

	public Lineseg getMyL3() {
		return myL3;
	}

	public void setMyL3(Lineseg myL3) {
		this.myL3 = myL3;
	}
	
	public double getPerimeter() {
		double perimeter;
		perimeter = myL1.getDistance() + myL2.getDistance() + myL3.getDistance();
		return perimeter;
	}
	
	public double getArea() {
		double area, s;
		s = this.getPerimeter()/2;
		area = Math.sqrt(s * (s - myL1.getDistance()) * (s - myL2.getDistance()) * (s - myL3.getDistance()));
		return area;
	}
	
	public String isTri() {
		if ((myL1.getDistance() + myL2.getDistance() > myL3.getDistance()) & (myL1.getDistance() + myL2.getDistance() > myL3.getDistance()) & (myL1.getDistance() + myL2.getDistance() > myL3.getDistance())) {
			return "The triangle is valid";
		} else {
			return "The triangle is invalid";
		}
	}
	
	public double getA1() {
		double a;
		double A = myL1.getDistance();
		double B = myL2.getDistance();
		double C = myL3.getDistance();
		a = Math.toDegrees(Math.acos((Math.pow(B, 2) + Math.pow(C, 2) - Math.pow(A, 2))/(2 * C * B))); 
		return a;
	}
	
	public double getA2() {
		double b;
		double A = myL1.getDistance();
		double B = myL2.getDistance();
		double C = myL3.getDistance();
		b = Math.toDegrees(Math.acos((Math.pow(A, 2) + Math.pow(C, 2) - Math.pow(B, 2))/(2 * C * A))); 
		return b;
	}

	public double getA3() {
		double c;
		double A = myL1.getDistance();
		double B = myL2.getDistance();
		double C = myL3.getDistance();
		c = Math.toDegrees(Math.acos((Math.pow(A, 2) + Math.pow(B, 2) - Math.pow(C, 2))/(2 * A * B))); 
		return c;
	}
	
	public String getType() {
		String type = "";
		
		if (this.getA1() < 90 & this.getA2() < 90 & this.getA3() < 90) {
			type += "Acute ";
		} else if (this.getA1() == 90 || this.getA2() == 90 || this.getA3() == 90) {
			type += "Right ";
		} else {
			type += "Obtuse ";
		}
		
		if ((myL1.getDistance() == myL2.getDistance()) & (myL2.getDistance() == myL3.getDistance())){
			type += "Equilateral";
		} else if (myL1.getDistance() == myL2.getDistance() || myL1.getDistance() == myL3.getDistance() || myL2.getDistance() == myL3.getDistance()) {
			type += "Isoceles";
		} else {
			type += "Scalene";
		}
		
		return type;
	}
	
	public String toString() {
		return "Pt1:" + myL1.getMyBP().toString() + ", " + "Pt2:" + myL1.getMyEP().toString() + ", " + "Pt3:" + myL2.getMyEP().toString();
	}
}
