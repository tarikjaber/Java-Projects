import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.math.*;

public class ColorPanel extends JPanel {

	Double[] x;
	Double[] y;

	Double[] dx;
	Double[] dy;

	Point[] ps;

	int pc;
	int c = 0;
	int numPolys = 0;
	
	Table jlist = new Table();
	
	

	public PolygonArray parray = new PolygonArray();

	public void setPA(PolygonArray pa) {
		parray = pa;
	}

	public void setPC(int PC) {
		pc = PC;
	}

	public PolygonArray getPA() {

		return parray;
	}

	public int getPC() {
		return pc;
	}
	
	public ColorPanel(Color backColor, PolygonArray pa) {
		parray = pa;
		numPolys = 100;
		
		for (int i = 0; i < numPolys; i++) {
			jlist.addPoly(parray.polys[i]);
		}
		repaint();
	}

	public ColorPanel(Color backColor, int p) {
		setBackground(backColor);

		addMouseListener(new PanelListener());
		pc = p;

		this.setX(new Double[pc]);
		this.setY(new Double[pc]);

		this.setDx(new Double[pc]);
		this.setDy(new Double[pc]);

		this.setPs(new Point[pc]);
	}

	public Point[] getPs() {
		return ps;
	}

	public void setPs(Point[] ps) {
		this.ps = ps;
	}

	public void setX(Double[] x) {
		this.x = x;
	}

	public void setY(Double[] y) {
		this.y = y;
	}

	public Double[] getDx() {
		return dx;
	}

	public void setDx(Double[] dx) {
		this.dx = dx;
	}

	public Double[] getDy() {
		return dy;
	}

	public void setDy(Double[] dy) {
		this.dy = dy;
	}

	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}

	public PolygonArray getParray() {
		return parray;
	}

	public void setParray(PolygonArray parray) {
		this.parray = parray;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);

		int xw = getWidth() / 2;
		int yw = getHeight() / 2;

		g.drawLine(xw, 0, xw, getHeight());
		g.drawLine(0, yw, getWidth(), yw);

		Polygon t1 = new Polygon();

		for (int i = 0; i < numPolys; i++) {
			plotpoly(parray.polys[i], g);
			System.out.println(parray.polys[i].toString());
		}

	}

	public void plotpoly(Polygon t, Graphics g) {

		for (int i = 0; i < pc; i++) {

			plotp(t.points[i], g);
			plotl(t.linesegs[i], g);
		}
	}

	
	  public void plotp(Point p, Graphics g) { 
		  g.drawString("(" + (int)p.getMyx() + ", " + (int)
	  p.getMyy() + ")", (int)(getWidth()/2 + p.getMyx()), (int)(getHeight()/2 +
	  -p.getMyy())); g.drawOval((int)(getWidth()/2 + p.getMyx()),(int)(getHeight()/2
	  - p.getMyy()), 6, 6); 
	  }
	  
	  public void plotl(Lineseg l, Graphics g) {
		  g.drawLine((int)(getWidth()/2 + l.getMyBP().getMyx()), (int)(getHeight()/2 - 
		  l.getMyBP().getMyy()),(int)(getWidth()/2 + l.getMyEP().getMyx()), (int)(getHeight()/2 - l.getMyEP().getMyy())); 
		  }
	 /*
	public void plotp(Point p, Graphics g) {
		g.drawString("(" + ((int) (-getWidth() / 2 + p.getMyx())) + ", " + (-(int) (-getHeight() / 2 + p.getMyy())) + ")",
				(int) (p.getMyx()), (int) (p.getMyy()));
		g.drawOval((int) (p.getMyx()), (int) (p.getMyy()), 6, 6);
	}

	public void plotl(Lineseg l, Graphics g) {
		g.drawLine((int) (l.getMyBP().getMyx()), (int) (l.getMyBP().getMyy()), (int) (l.getMyEP().getMyx()),
				(int) (l.getMyEP().getMyy()));
	}
*/
	public double manx(double x) {
		double nx;
		double x1 = getWidth();

		nx = x / x1;

		double px = -x1 + nx * (x1 - -x1);
		return px;
	}

	public void newPoly() {

	}

	public double many(double y) {
		double ny;

		double y1 = getHeight();

		ny = y / y1;

		double py = -y1 + ny * (y1 - -y1);
		return -py;

	}

	private class PanelListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {

			x[c] = (double) e.getX();
			y[c] = (double) e.getY();

			dx[c] = x[c] - getWidth() / 2;
			dy[c] = y[c] - getHeight() / 2;

			ps[c] = new Point(dx[c], -dy[c]);

			c++;

			if (c == getPC()) {
				parray.polys[numPolys] = new Polygon(ps);

				if (parray.polys[numPolys].isPoly()) {
					System.out.println(parray.polys[numPolys].getType());
					System.out.println(parray.polys[numPolys].getArea());
					System.out.println(parray.polys[numPolys].isPoly());
					System.out.println(parray.polys[numPolys].toString());
					System.out.println("Regular:" + parray.polys[numPolys].isRegular());
					jlist.addPoly(parray.polys[numPolys]);
					repaint();
					numPolys++;
				} else {
					JOptionPane.showMessageDialog(null, "Not a valid polygon");
				}
				c = 0;
			}

		}
	}
}
