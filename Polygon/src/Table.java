import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Table {
	String[][] data = new String[100][6];
	String[] columns = { "Poly Num", "Area", "Perimeter", "Num Sides", "Type", "Num diagonals" };
	int numPolys = 0;

	JTable j;
	
	public void addMouseListener() {
		j.addMouseListener(new java.awt.event.MouseAdapter() {

			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = j.rowAtPoint(evt.getPoint());
				System.out.println(row);
			}
		});
	}

	public Table() {

		JFrame table = new JFrame();

		table.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		j = new JTable(data, columns);
		j.setBounds(30, 40, 200, 300);

		JScrollPane sp = new JScrollPane(j);
		table.add(sp);
		table.setSize(400, 400);

		j.addMouseListener(new java.awt.event.MouseAdapter() {

			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = j.rowAtPoint(evt.getPoint());
				System.out.println(row);
			}
		});

		j.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		table.add(sp);
		table.setVisible(true);
	}

	public Table(PolygonArray p) {

		JFrame table = new JFrame();

		table.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		for (int i = 0; i < 100; i++) {
			data[numPolys][0] = new String(Integer.toString(i + 1));
			data[numPolys][1] = new String(Double.toString(p.polys[i].formatDecimal(p.polys[i].getArea())));
			data[numPolys][2] = new String(Double.toString(p.polys[i].formatDecimal(p.polys[i].getPerimeter())));
			data[numPolys][3] = new String(Integer.toString(p.polys[i].nsides));
			data[numPolys][4] = p.polys[i].getType();
			data[numPolys][5] = new String(Integer.toString(p.polys[i].numDiagonals()));
		}

		j = new JTable(data, columns);
		j.setBounds(30, 40, 200, 300);

		JScrollPane sp = new JScrollPane(j);
		table.add(sp);
		table.setSize(400, 400);

		j.addMouseListener(new java.awt.event.MouseAdapter() {

			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = j.rowAtPoint(evt.getPoint());

			}
		});

		j.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		table.add(sp);
		table.setVisible(true);
	}

	public void addPoly(Polygon p) {
		data[numPolys][0] = new String(Integer.toString(numPolys + 1));
		data[numPolys][1] = new String(Double.toString(p.formatDecimal(p.getArea())));
		data[numPolys][2] = new String(Double.toString(p.formatDecimal(p.getPerimeter())));
		data[numPolys][3] = new String(Integer.toString(p.nsides));
		data[numPolys][4] = p.getType();
		// data[numPolys][5] = p.toString();
		data[numPolys][5] = new String(Integer.toString(p.numDiagonals()));

		j.repaint();

		numPolys++;
	}

	
}
