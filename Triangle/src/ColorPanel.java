import javax.swing.*;



import java.awt.*;
import java.awt.event.*;
import java.math.*;

public class ColorPanel extends JPanel {
	
	
	int x1, y1, x2, y2, x3, y3;
	
	int t = 0;
	
	double dx1, dy1, dx2, dy2, dx3, dy3;
	
	int tc = 0;
	
	public TriangleArray tarray = new TriangleArray();
	
	public void setTA(TriangleArray ta) {
		tarray = ta;
	}
	
	public void setTC(int TC) {
		tc = TC;
	}
	
	public TriangleArray getTA(){
	        
	      return tarray;
	}
	
	public int getTC() {
		return tc;
	}
	
	public ColorPanel(Color backColor) {
		setBackground(backColor);
		
		x1 = 100;
		y1 = 100;
		
		addMouseListener(new PanelListener());
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		
		int xw = getWidth() / 2;
		int yw = getHeight() /2;
		
		
		g.drawLine(xw, 0, xw, getHeight());
		g.drawLine(0, yw, getWidth(), yw);
		
		Triangle t1 = new Triangle(0,0,50,0,0,40);
		
		for (int i = 0; i < tc; i ++) {
			plott(tarray.tris[i], g);
		}
		
	}
	
	public void plott(Triangle t, Graphics g) {
		plotl(t.myL1, g);
		plotl(t.myL2, g);
		plotl(t.myL3, g);
		
		plotp(t.myL1.getMyBP(), g);
		plotp(t.myL1.getMyEP(), g);
		plotp(t.myL2.getMyEP(), g);
	}
	
	public void plotp(Point p, Graphics g) {
		g.drawString("(" + manx((int)(getWidth()/2 + p.getMyx())) + ", " + many((int)(getHeight()/2 + p.getMyy())) + ")", (int)(getWidth()/2 + p.getMyx()), (int)(getHeight()/2 + p.getMyy()));
		g.drawOval((int)(getWidth()/2  + p.getMyx()),(int)(getHeight()/2 + p.getMyy()), 6, 6);
	}
	
	public void plotl(Lineseg l, Graphics g) {
		g.drawLine((int)(getWidth()/2 + l.getMyBP().getMyx()), (int)(getHeight()/2 + l.getMyBP().getMyy()), (int)(getWidth()/2 + l.getMyEP().getMyx()), (int)(getHeight()/2 + l.getMyEP().getMyy()));
	}
	
	public double manx(double x) {
		double nx;
		double x1 = getWidth();
		
		nx = x/x1;
		
		double px = -x1 + nx * (x1 - -x1);
		return px;
	}
	
	public double many(double y) {
		double ny;
		
		double y1 = getHeight();
		
		ny = y/y1;
		
		double py = -y1 + ny * (y1 - -y1);
		return -py;
		
	}
	
	private class PanelListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
		
				if (t % 3 == 0) {
					x1 = e.getX();
					y1 = e.getY();
			
					dx1 = x1 - getWidth()/2;
					dy1 = y1- getHeight()/2;
			
					t++;
			
					repaint();
				} else if (t % 3 == 1) {
					x2 = e.getX();
					y2 = e.getY();
					
					dx2 = x2 - getWidth()/2;
					dy2 = y2- getHeight()/2;
			
					t++;
			
					repaint();
				} else if (t % 3 == 2) {
					x3 = e.getX();
					y3 = e.getY();
			
					dx3 = x3 - getWidth()/2;
					dy3 = y3- getHeight()/2;
					
					t++;	
					
					tarray.tris[tc] = new Triangle(dx1, dy1, dx2, dy2, dx3, dy3);
					
					Triangle output = new Triangle(manx(x1), many(y1), manx(x2), many(y2), manx(x3), many(y3));
					System.out.println(output.toString()+"\n");
					System.out.println(output.getPerimeter());
					System.out.println(output.getArea());
					System.out.println(output.isTri());
					System.out.println(output.getType());
					System.out.println();
					
					tc++;
					
					repaint();
					
					
				}
			
		}
	}
}
