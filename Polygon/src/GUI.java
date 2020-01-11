import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GUI {

	int jc = 0;

	public GUI() throws IOException {

		JFrame[] frames = new JFrame[100];
		frames[jc] = new JFrame();

		outputGUI(frames[jc], false);

		frames[jc - 1].addWindowListener(new WindowListener() {

			@Override
			public void windowClosing(WindowEvent e) {
				frames[jc] = new JFrame();
				try {
					outputGUI(frames[jc], true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosed(WindowEvent e) {

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

		});

	}

	public void outputGUI(JFrame theGUI, boolean rb) throws IOException {
		String inputStr;
		int numSides = 0;
		inputStr = JOptionPane.showInputDialog("Enter type of input: 1(mouse press), 2(random), 3(file), 4(Quit)", "");
		int inputType = Integer.parseInt(inputStr);
		if (inputType == 1) {
			numSides = 0;

			do {
				inputStr = JOptionPane.showInputDialog("Enter the number of sides you want to enter", "");
				numSides = Integer.parseInt(inputStr);

				if (numSides > 2) {

					ColorPanel panel;

					theGUI.setTitle("GUI Program");
					// theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					theGUI.setSize(750, 350);

					panel = new ColorPanel(Color.white, numSides);

					Container pane = theGUI.getContentPane();
					pane.add(panel);

					JButton graph = new JButton("Graph");
					graph.setBounds(0, 0, 10, 10);

					graph.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.out.println("graph");
						}
					});

					theGUI.setVisible(true);
					jc++;
				} else {
					JOptionPane.showMessageDialog(null, "The polygon must have three or more sides");
				}
			} while (numSides < 3);

		} else if (inputType == 2) {
			System.out.println("Random constructor");
			
			PolygonArray parray = new PolygonArray(3);
			
			ColorPanel panel;

			theGUI.setTitle("GUI Program");
			// theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			theGUI.setSize(750, 350);

			panel = new ColorPanel(Color.white, parray);

			Container pane = theGUI.getContentPane();
			pane.add(panel);

			JButton graph = new JButton("Graph");
			graph.setBounds(0, 0, 10, 10);

			graph.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("graph");
				}
			});

			theGUI.setVisible(false);
			jc++;

		} else if (inputType == 3) {
			inputStr = JOptionPane.showInputDialog("Enter the number of sides you want to enter", "");
			numSides = Integer.parseInt(inputStr);
			
			PolygonArray parray = new PolygonArray("RandomNums.txt", numSides);
			
			System.out.println(parray.polys[0].toString());
			
			ColorPanel panel;

			theGUI.setTitle("GUI Program");
			// theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			theGUI.setSize(750, 350);

			panel = new ColorPanel(Color.white, parray);

			Container pane = theGUI.getContentPane();
			pane.add(panel);

			JButton graph = new JButton("Graph");
			graph.setBounds(0, 0, 10, 10);

			graph.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("graph");
				}
			});

			theGUI.setVisible(false);
			jc++;
		} else if (inputType == 4) {
			System.exit(-1);
		} else {
			JOptionPane.showMessageDialog(null, "Please enter a valid input number");
		}
	}

}
