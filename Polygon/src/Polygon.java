import java.util.Random;

public class Polygon {
	int nsides;
	Lineseg [] linesegs;
	Point [] points;

	public Polygon() {
		nsides = 0;
			for (int i = 0; i < nsides; i++) {
				this.linesegs[i] = new Lineseg(0,0,0,0);
			}
		}
	
	public Polygon(Point [] points) {
		nsides = points.length;
		
		this.setLinesegs(new Lineseg[nsides]);
		this.setPoints(new Point[nsides]);
		
		for (int i = 0; i < points.length; i++) {
			this.points[i] = points[i];
		}
		
		for (int i = 0; i < points.length; i++) {
			this.linesegs[i] = new Lineseg(this.points[i], 
					this.points[(i + 1)%nsides]);
		}
		
	}
	
	public Polygon(Lineseg [] lines) {
		nsides = lines.length;
		
		this.setLinesegs(new Lineseg[nsides]);
		this.setPoints(new Point[nsides]);
	
		for (int i = 0; i < lines.length; i++) {
			this.linesegs[i] = lines[i];
			
			this.points[i] = this.linesegs[i].getMyBP();
			this.points[(i + 1)%3] = this.linesegs[i].getMyEP();
		}
	}
	
	public Polygon(int r) {
		nsides = (int)(9 * Math.random() + 3);
		
		this.setLinesegs(new Lineseg[nsides]);
		this.setPoints(new Point[nsides]);
		
		for (int i = 0; i < nsides; i++) {
			this.linesegs[i] = new Lineseg(0);
			
			this.points[i] = this.linesegs[i].getMyBP();
			this.points[(i + 1)%3] = this.linesegs[i].getMyEP();
		}
	}
	
	public int numDiagonals() {
		return ((nsides * (nsides - 3))/2);
	}
	
	public Lineseg[] getLinesegs() {
		return linesegs;
	}

	public void setLinesegs(Lineseg[] linesegs) {
		this.linesegs = linesegs;
	}

	public Point[] getPoints() {
		return points;
	}

	public void setPoints(Point[] points) {
		this.points = points;
	}


	public Polygon(String random) {
			Random r = new Random();
			
			Point p1 = new Point(r.nextInt(100) + 1,r.nextInt(100) + 1);
			Point p2 = new Point(r.nextInt(100) + 1,r.nextInt(100) + 1);
			Point p3 = new Point(r.nextInt(100) + 1,r.nextInt(100) + 1);
		}

	public double getPerimeter() {
		double perimeter = 0;
		for (int i = 0; i < nsides; i++) {
			perimeter += this.linesegs[i].getDistance();
		}
		return perimeter;
	}

	public double getArea() {
		double upSum = 0; double downSum = 0;
		
		for (int i = 0; i < nsides; i++) {
			upSum += this.points[i].getMyx()*this.points[(i+1)%nsides].getMyy();
			downSum += this.points[(i+1)%nsides].getMyx()*this.points[i].getMyy();
		}
		
		double totalSum = Math.abs(downSum - upSum);
		
		double area = totalSum/2.0;
		
		return area;
	}


	public boolean isPoly() {
		boolean isPoly = true;
		for(int i = 0; i < nsides; i++) {
			for(int j = i + 1; j < nsides; j++) {
				if (this.linesegs[i].intersects(this.linesegs[j])) {
					isPoly = false;
				}
			}
		}
		return isPoly;
	}
	
	public boolean isRegular() {
		boolean isRegular = true;
		for (int i = 0; i < nsides; i++) {
			if (formatDecimal(this.linesegs[i].getDistance()) != formatDecimal(this.linesegs[(i+1)%3].getDistance())) {
				isRegular = false;
			}
		}
		return isRegular;
	}
	
	public Double[] getAngles() {
		String output = "";
		Double[] angles = new Double[nsides];
		for(int i = 0; i < nsides; i++) {
			double A = this.linesegs[i].getDistance();
			double B = this.linesegs[(i + 1)%nsides].getDistance();
			
			Point c1 = this.linesegs[i].getMyBP();
			Point c2 = this.linesegs[(i+1)%nsides].getMyEP();
			Lineseg lineC = new Lineseg(c1,c2);
			
			double C = lineC.getDistance();		
			
			angles[i] = formatDecimal(Math.toDegrees(Math.acos((Math.pow(B, 2) + Math.pow(A, 2) - Math.pow(C, 2)) / (2 * A * B))));
	
		}
		
		return angles;
	}
	
	public String printLinesegLengths() {
		String output = "";
		for (int i = 0; i < nsides; i++) {
			output += "Lineseg " + (i + 1) + " Distance:" + formatDecimal(this.linesegs[i].getDistance()) + " ";
		}
		return output;
	}
	
	public String printAngles() {
		Double[] angles = getAngles();
		String output = "";
		for(int i = 0; i < nsides; i++) {
			output += "Angle " + (i + 1) + ":" + angles[i] + " ";
		}
		return output;
	}

	public String getType() {
		Double[] angles = getAngles();
		boolean isConvex = true;
		System.out.println(printAngles());
		for(int i = 0; i < nsides; i++) {
			if (angles[i] > 180) {
				isConvex = false;
			}
		}
		
		if (isConvex) {
			return "Convex";
		} else {
			return "Concave";
		}
	}
	
	public double formatDecimal(double d) {
		return Math.round(d * 100)/100.0;
	}

	public String toString() {
		String toString = "";
		for (int i = 0; i < nsides; i++) {
			toString += "Point " + (i + 1) + ":" + points[i].toString() + " ";
		}
		return toString;
	}
}
