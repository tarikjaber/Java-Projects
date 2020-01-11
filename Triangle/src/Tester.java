import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class Tester {
	
	static int panelcreated = 0;
	static int ln = 0;

	public static void main(String[] args) {
		
		TriangleArray tarray = new TriangleArray();
	
		Point p1 = new Point(0,0);
		Point p2 = new Point(4,0);
		Point p3 = new Point(0,3);
		tarray.tris[0] = new Triangle(p1,p2,p3);
		System.out.println("Point constructor");
		printInfo(tarray.tris[0]);
		
		Lineseg l1 = new Lineseg(0,0,4,0);
		Lineseg l2 = new Lineseg(p2,p3);
		Lineseg l3 = new Lineseg(0,3,0,0);
		tarray.tris[1] = new Triangle(l1, l2, l3);
		System.out.println("Line constructor");
		printInfo(tarray.tris[1]);
		
		tarray.tris[2] = new Triangle(1,2,4,5,9,10);
		System.out.println("Number constructor");
		printInfo(tarray.tris[2]);
		
		tarray.tris[3] = new Triangle("Random");
		System.out.println("Random constructor");
		printInfo(tarray.tris[3]);
		
		for (int i = 0; i < 4; i ++) {
			//printInfo(tarray.tris[i]);
		}
		String name = "panel";
		
		ColorPanel panel;
		
		JFrame theGUI = new JFrame();
		theGUI.setTitle("GUI Program");
		theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theGUI.setSize(500, 500);
		
		panel = new ColorPanel(Color.white);
		
		Container pane = theGUI.getContentPane();
		pane.add(panel);
			
		if (panelcreated == 0) {
			theGUI.setVisible(true);
			panelcreated++;
		}
		
		for (int i = 0; i < panel.getTC(); i++) {
			System.out.println("Ya YAedh");
			System.out.println(panel.getTA().tris[i].toString());
		}
	
		
	}
	
	private static void printInfo(Triangle t) {
		System.out.println(t.toString());
		System.out.println(t.isTri());
		System.out.println("Perimeter:" + t.getPerimeter());
		System.out.println("Area:" + t.getArea());
		System.out.println(t.getType());
		System.out.println();
		
	}

	

}
