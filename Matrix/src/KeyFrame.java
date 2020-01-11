import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KeyFrame extends JFrame implements KeyListener {

	JTextField keyText = new JTextField(80);
	int rows1 = 1;
	int rows2 = 1;
	int columns1 = 1;
	int columns2 = 1;
	int rows3 = 1;
	int columns3 = 1;
	int c = 0;
	int c2 = 0;
	int c3 = 0;
	int ic = 0;
	String currentText = "";
	boolean firstMatrix = true;

	int[][][][] data = new int[2][100][][];
	JLabel[][][][] labels = new JLabel[3][100][][];
	// JLabel keyLabel = new JLabel("Press fire button");

	static JComboBox c1;

	public KeyFrame() {

		String f = "";
		int m = 50;

		repaint();

		keyText.addKeyListener(this);
		keyText.setVisible(true);

		keyText.setOpaque(false);

		setSize(1000, 500);
		setVisible(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		// add(keyLabel, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.add(keyText);
		add(panel, BorderLayout.CENTER);

		JLabel blank = new JLabel("");
		blank.setBounds(0, 0, 0, 0);

		// title
		JLabel title = new JLabel("Matrix Calculator");
		title.setBounds(450, 0, 100, 30);

		add(title);

		// output

		JLabel o = new JLabel("Output");
		o.setBounds(850, 20, 80, 40);

		add(o);

		// matrix 1
		JLabel m1 = new JLabel("Matrix 1");
		m1.setBounds(90, 20, 100, 30);

		JLabel row1 = new JLabel("Rows:");
		row1.setBounds(50, 40, 50, 40);
		JLabel column1 = new JLabel("Columns:");
		column1.setBounds(140, 40, 100, 40);

		add(m1);
		add(row1);
		add(column1);
		add(blank);

		// matrix 2
		JLabel m2 = new JLabel("Matrix 2");
		m2.setBounds(470, 30, 100, 20);

		JLabel row2 = new JLabel("Rows:");
		row2.setBounds(420, 50, 50, 20);
		JLabel column2 = new JLabel("Columns:");
		column2.setBounds(520, 50, 100, 20);

		add(m2);
		add(column2);
		add(row2);
		add(blank);

		JLabel jl = new JLabel();
		jl.setBounds(500, 500, 100, 40);
		JTextField jt = new JTextField(40);
		JButton jb = new JButton("Enter");

		jt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = jt.getText();
				jl.setText(input);

			}
		});

		add(jb);

		String s1[] = { "Add", "Subtract", "Multiply", "Inverse", "Determinant", "Adjugate", "Transpose",
				"Checkerboard", "Scalar" };

		// create checkbox
		c1 = new JComboBox(s1);
		c1.setBounds(770, 50, 110, 20);
		// add ItemListener
		c1.addItemListener(

				new ItemListener() {

					@Override
					public void itemStateChanged(ItemEvent e) {
						// int i = c1.getSelectedIndex();
						// System.out.println(i);
						keyText.requestFocus();

						repaint();
					}

				}

		);

		JLabel blank2 = new JLabel("");
		blank2.setBounds(0, 0, 0, 0);

		add(c1);

		add(blank2, BorderLayout.CENTER);

		JButton calculate = new JButton("Calculate");
		calculate.setBounds(880, 50, 100, 20);

		calculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int selectedIndex = c1.getSelectedIndex();

				switch (selectedIndex) {
				case 0:
					System.out.println("Add");

					if (1 == 1) {

						double[][] matrixData1 = new double[rows1][columns1];

						for (int i = 0; i < rows1; i++) {
							for (int j = 0; j < columns1; j++) {
								if (testDouble(labels[0][c][i][j].getText())) {
									matrixData1[i][j] = Double.parseDouble(labels[0][c][i][j].getText());
								} else {
									JOptionPane.showMessageDialog(null,
											"Check if all the values in Matrix 1 are numbers");
									break;
								}
							}
						}

						Matrix matrix1 = new Matrix(matrixData1);

						double[][] matrixData2 = new double[rows2][columns2];

						for (int i = 0; i < rows2; i++) {
							for (int j = 0; j < columns2; j++) {
								if (testDouble(labels[1][c2][i][j].getText())) {
									matrixData2[i][j] = Double.parseDouble(labels[1][c2][i][j].getText());
								} else {
									JOptionPane.showMessageDialog(null,
											"Check if all the values in Matrix 1 are numbers");
									break;
								}
							}
						}

						Matrix matrix2 = new Matrix(matrixData2);

						if (matrix1.ChAddSubt(matrix2)) {

							// System.out.println(matrix1.toString());
							// System.out.println(matrix1.getDeterminant());
							// System.out.println(matrix1.adjugate());

							System.out.println(matrix1);
							System.out.println(matrix2);

							Matrix output = new Matrix(matrix1.Add(matrix2));

							System.out.println(output);

							outputMatrix(output);

						} else {
							JOptionPane.showMessageDialog(null,
									"The matrices don't have the same number of rows and columns");
						}
					}
					break;
				case 1:
					System.out.println("Subtract");

					if (1 == 1) {

						double[][] matrixData1 = new double[rows1][columns1];

						for (int i = 0; i < rows1; i++) {
							for (int j = 0; j < columns1; j++) {
								if (testDouble(labels[0][c][i][j].getText())) {
									matrixData1[i][j] = Double.parseDouble(labels[0][c][i][j].getText());
								} else {
									JOptionPane.showMessageDialog(null,
											"Check if all the values in Matrix 1 are numbers");
									break;
								}
							}
						}

						Matrix matrix1 = new Matrix(matrixData1);

						double[][] matrixData2 = new double[rows2][columns2];

						for (int i = 0; i < rows2; i++) {
							for (int j = 0; j < columns2; j++) {
								if (testDouble(labels[1][c2][i][j].getText())) {
									matrixData2[i][j] = Double.parseDouble(labels[1][c2][i][j].getText());
								} else {
									JOptionPane.showMessageDialog(null,
											"Check if all the values in Matrix 1 are numbers");
									break;
								}
							}
						}

						Matrix matrix2 = new Matrix(matrixData2);

						if (matrix1.ChAddSubt(matrix2)) {

							// System.out.println(matrix1.toString());
							// System.out.println(matrix1.getDeterminant());
							// System.out.println(matrix1.adjugate());

							System.out.println(matrix1);
							System.out.println(matrix2);

							Matrix output = new Matrix(matrix1.Subt(matrix2));

							System.out.println(output);

							outputMatrix(output);

						} else {
							JOptionPane.showMessageDialog(null,
									"The matrices don't have the same number of rows and columns");
						}
					}
					break;
				case 2:
					System.out.println("Multiply");

					if (1 == 1) {

						double[][] matrixData1 = new double[rows1][columns1];

						for (int i = 0; i < rows1; i++) {
							for (int j = 0; j < columns1; j++) {
								if (testDouble(labels[0][c][i][j].getText())) {
									matrixData1[i][j] = Double.parseDouble(labels[0][c][i][j].getText());
								} else {
									JOptionPane.showMessageDialog(null,
											"Check if all the values in Matrix 1 are numbers");
									break;
								}
							}
						}

						Matrix matrix1 = new Matrix(matrixData1);

						double[][] matrixData2 = new double[rows2][columns2];

						for (int i = 0; i < rows2; i++) {
							for (int j = 0; j < columns2; j++) {
								if (testDouble(labels[1][c2][i][j].getText())) {
									matrixData2[i][j] = Double.parseDouble(labels[1][c2][i][j].getText());
								} else {
									JOptionPane.showMessageDialog(null,
											"Check if all the values in Matrix 1 are numbers");
									break;
								}
							}
						}

						Matrix matrix2 = new Matrix(matrixData2);

						if (matrix1.ChMult(matrix2)) {

							// System.out.println(matrix1.toString());
							// System.out.println(matrix1.getDeterminant());
							// System.out.println(matrix1.adjugate());

							System.out.println(matrix1);
							System.out.println(matrix2);

							Matrix output = new Matrix(matrix1.Mult(matrix2));

							System.out.println(output);

							outputMatrix(output);

						} else {
							JOptionPane.showMessageDialog(null,
									"The number of columns in the first matrix does not equal the number of rows in the second matrix");
						}
					}

					break;
				case 3:
					System.out.println("Inverse");

					if (rows1 == columns1) {

						double[][] matrixData1 = new double[rows1][columns1];

						for (int i = 0; i < rows1; i++) {
							for (int j = 0; j < columns1; j++) {
								if (testDouble(labels[0][c][i][j].getText())) {
									matrixData1[i][j] = Double.parseDouble(labels[0][c][i][j].getText());
								} else {
									JOptionPane.showMessageDialog(null,
											"Check if all the values in Matrix 1 are numbers");
									break;
								}
							}
						}

						Matrix matrix1 = new Matrix(matrixData1);

						// System.out.println(matrix1.toString());
						// System.out.println(matrix1.getDeterminant());
						// System.out.println(matrix1.adjugate());

						Matrix output = new Matrix(matrix1.inverse());

						System.out.println(output);

						outputMatrix(output);
					} else {
						JOptionPane.showMessageDialog(null, "Matrix must be square to have an inverse");
					}
					break;
				case 4:
					System.out.println("Determinant");

					if (rows1 == columns1) {

						double[][] matrixData1 = new double[rows1][columns1];

						for (int i = 0; i < rows1; i++) {
							for (int j = 0; j < columns1; j++) {
								if (testDouble(labels[0][c][i][j].getText())) {
									matrixData1[i][j] = Double.parseDouble(labels[0][c][i][j].getText());
								} else {
									JOptionPane.showMessageDialog(null,
											"Check if all the values in Matrix 1 are numbers");
									break;
								}
							}
						}

						Matrix matrix1 = new Matrix(matrixData1);

						// System.out.println(matrix1.toString());
						// System.out.println(matrix1.getDeterminant());
						// System.out.println(matrix1.adjugate());

						double determinant = matrix1.getDeterminant();

						double[][] nums = new double[1][1];
						nums[0][0] = determinant;
						Matrix output = new Matrix(nums);

						System.out.println(output);

						outputMatrix(output);
					} else {
						JOptionPane.showMessageDialog(null, "Matrix must be square to have an inverse");
					}
					break;
				case 5:
					System.out.println("Adjugate");

					if (rows1 == columns1) {

						double[][] matrixData1 = new double[rows1][columns1];

						for (int i = 0; i < rows1; i++) {
							for (int j = 0; j < columns1; j++) {
								if (testDouble(labels[0][c][i][j].getText())) {
									matrixData1[i][j] = Double.parseDouble(labels[0][c][i][j].getText());
								} else {
									JOptionPane.showMessageDialog(null,
											"Check if all the values in Matrix 1 are numbers");
									break;
								}
							}
						}

						Matrix matrix1 = new Matrix(matrixData1);

						// System.out.println(matrix1.toString());
						// System.out.println(matrix1.getDeterminant());
						// System.out.println(matrix1.adjugate());

						Matrix output = new Matrix(matrix1.adjugate());

						System.out.println(output);

						outputMatrix(output);
					} else {
						JOptionPane.showMessageDialog(null, "Matrix must be square to have an adjugate");
					}
					break;
				case 6:
					System.out.println("Transpose");

					if (1 == 1) {

						double[][] matrixData1 = new double[rows1][columns1];

						for (int i = 0; i < rows1; i++) {
							for (int j = 0; j < columns1; j++) {
								if (testDouble(labels[0][c][i][j].getText())) {
									matrixData1[i][j] = Double.parseDouble(labels[0][c][i][j].getText());
								} else {
									JOptionPane.showMessageDialog(null,
											"Check if all the values in Matrix 1 are numbers");
									break;
								}
							}
						}

						Matrix matrix1 = new Matrix(matrixData1);

						// System.out.println(matrix1.toString());
						// System.out.println(matrix1.getDeterminant());
						// System.out.println(matrix1.adjugate());

						Matrix output = new Matrix(matrix1.transpose());

						System.out.println(output);

						outputMatrix(output);
					}
					break;
				case 7:
					System.out.println("Checkerboard");

					double[][] matrixData1 = new double[rows1][columns1];

					for (int i = 0; i < rows1; i++) {
						for (int j = 0; j < columns1; j++) {
							if (testDouble(labels[0][c][i][j].getText())) {
								matrixData1[i][j] = Double.parseDouble(labels[0][c][i][j].getText());
							} else {
								JOptionPane.showMessageDialog(null, "Check if all the values in Matrix 1 are numbers");
								break;
							}
						}
					}

					Matrix matrix1 = new Matrix(matrixData1);

					// System.out.println(matrix1.toString());
					// System.out.println(matrix1.getDeterminant());
					// System.out.println(matrix1.adjugate());

					Matrix output = new Matrix(matrix1.checkerboard());

					System.out.println(output);

					outputMatrix(output);

					break;
				case 8:
					System.out.println("Scalar");
					break;
				}

				keyText.requestFocus();

				repaint();
			}
		});
		add(calculate);

		JTextField rowsField1 = new JTextField(16);
		rowsField1.setBounds(90, 50, 20, 20);
		add(rowsField1);

		labels[0][c] = new JLabel[rows1][columns1];

		for (int i = 0; i < rows1; i++) {
			for (int j = 0; j < columns1; j++) {
				labels[0][c][i][j] = new JLabel(f);
				labels[0][c][i][j].setBounds(74 + m * i, 107 + m * (j - 1), 40, 40);

				add(labels[0][c][i][j]);

				repaint();
			}
		}

		rowsField1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (testInt(rowsField1.getText())) {
					for (int i = 0; i < rows1; i++) {
						for (int j = 0; j < columns1; j++) {
							// System.out.println("i:" + i + " j: " + j);
							remove(labels[0][c][i][j]);
						}
					}

					rows1 = Integer.parseInt(rowsField1.getText());
					System.out.println(rows1);
					System.out.println(columns1);

					c++;

					data = new int[0][c][rows1][columns1];

					labels[0][c] = new JLabel[rows1][columns1];

					for (int i = 0; i < rows1; i++) {
						for (int j = 0; j < columns1; j++) {
							labels[0][c][i][j] = new JLabel(f);
							labels[0][c][i][j].setBounds(74 + m * j, 77 + m * (i), 40, 40);
							// labels[0][c][i][j].setBounds(74 + 40 * i, 40 * (j - 1), 40, 40);
							add(labels[0][c][i][j]);
						}
					}

					ic = 0;

					add(blank);

					// outputLabels(0, rows1, columns1);

					rowsField1.transferFocus();

					repaint();

				}
			}

		});

		JTextField columnsField1 = new JTextField(16);
		columnsField1.setBounds(200, 50, 20, 20);
		add(columnsField1);

		columnsField1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (testInt(columnsField1.getText())) {
					for (int i = 0; i < rows1; i++) {
						for (int j = 0; j < columns1; j++) {
							// System.out.println("i:" + i + " j: " + j);
							remove(labels[0][c][i][j]);
						}
					}

					columns1 = Integer.parseInt(columnsField1.getText());

					c++;

					data = new int[0][c][rows1][columns1];

					labels[0][c] = new JLabel[rows1][columns1];

					for (int i = 0; i < rows1; i++) {
						for (int j = 0; j < columns1; j++) {
							labels[0][c][i][j] = new JLabel(f);
							labels[0][c][i][j].setBounds(74 + m * j, 77 + m * (i), 40, 40);
							// labels[0][c][i][j].setBounds(74 + 40 * i, 40 * (j - 1), 40, 40);
							add(labels[0][c][i][j]);
						}
					}

					ic = 0;

					add(blank);

					keyText.requestFocus();

					repaint();
				}
			}

		});

		labels[1][c2] = new JLabel[rows2][columns2];

		for (int i = 0; i < rows2; i++) {
			for (int j = 0; j < columns2; j++) { 
				labels[1][c2][i][j] = new JLabel(f);
				labels[1][c2][i][j].setBounds(445 + m * i, 107 + m * (j - 1), 40, 40);

				add(labels[1][c2][i][j]);

				repaint();
			}
		}

		JTextField rowsField2 = new JTextField(16);
		rowsField2.setBounds(460, 50, 20, 20);
		add(rowsField2);

		rowsField2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (testInt(rowsField2.getText())) {
					for (int i = 0; i < rows2; i++) {
						for (int j = 0; j < columns2; j++) {
							// System.out.println("i:" + i + " j: " + j);
							remove(labels[1][c2][i][j]);
						}
					}

					rows2 = Integer.parseInt(rowsField2.getText());
					System.out.println(rows2);
					System.out.println(columns2);

					c2++;

					data = new int[1][c2][rows2][columns2];

					ic = 0;

					labels[1][c2] = new JLabel[rows2][columns2];

					for (int i = 0; i < rows2; i++) {
						for (int j = 0; j < columns2; j++) {
							labels[1][c2][i][j] = new JLabel(f);
							labels[1][c2][i][j].setBounds(445 + m * j, 77 + m * (i), 40, 40);
							// labels[0][c][i][j].setBounds(74 + 40 * i, 40 * (j - 1), 40, 40);
							add(labels[1][c2][i][j]);
						}
					}

					add(blank);

					// outputLabels(0, rows1, columns1);

					rowsField2.transferFocus();

					repaint();
				}
			}

		});

		JTextField columnsField2 = new JTextField(16);
		columnsField2.setBounds(580, 50, 20, 20);
		add(columnsField2);

		columnsField2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (testInt(columnsField2.getText())) {
					for (int i = 0; i < rows2; i++) {
						for (int j = 0; j < columns2; j++) {
							// System.out.println("i:" + i + " j: " + j);
							remove(labels[1][c2][i][j]);
						}
					}

					columns2 = Integer.parseInt(columnsField2.getText());

					c2++;

					ic = 0;

					data = new int[1][c2][rows2][columns2];

					labels[1][c2] = new JLabel[rows2][columns2];

					for (int i = 0; i < rows2; i++) {
						for (int j = 0; j < columns2; j++) {
							labels[1][c2][i][j] = new JLabel(f);
							labels[1][c2][i][j].setBounds(445 + m * j, 77 + m * (i), 40, 40);
							// labels[0][c][i][j].setBounds(74 + 40 * i, 40 * (j - 1), 40, 40);
							add(labels[1][c2][i][j]);
						}
					}

					add(blank);

					keyText.requestFocus();

					repaint();
				}
			}

		});

		labels[2][c3] = new JLabel[rows3][columns3];

		for (int i = 0; i < rows3; i++) {
			for (int j = 0; j < columns3; j++) {
				labels[2][c3][i][j] = new JLabel("");
				labels[2][c3][i][j].setBounds(805 + 40 * j, 77 + 40 * (i), 40, 40);

				add(labels[2][c3][i][j]);
			}
		}

		JButton rand1 = new JButton("Random");
		rand1.setBounds(50, 400, 90, 20);

		rand1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < rows1; i++) {
					for (int j = 0; j < columns1; j++) {
						labels[0][c][i][j].setText(Double.toString(formatDecimal((Math.random() - .5) * 40)));
						repaint();
					}
				}
				keyText.requestFocus();
			}
		});

		add(rand1);

		JButton file1 = new JButton("File");
		file1.setBounds(200, 400, 90, 20);

		file1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Scanner x = null;

				try {
					x = new Scanner(new File("RandomNums.txt"));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}

				for (int i = 0; i < rows1; i++) {
					for (int j = 0; j < columns1; j++) {
						if (x.hasNext()) {
							labels[0][c][i][j].setText(Double.toString(formatDecimal(x.nextDouble())));
							repaint();
						}
					}
				}
				
				keyText.requestFocus();

			}
		});

		add(file1);

		JButton rand2 = new JButton("Random");
		rand2.setBounds(400, 400, 90, 20);

		rand2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < rows2; i++) {
					for (int j = 0; j < columns2; j++) {
						labels[1][c2][i][j].setText(Double.toString(formatDecimal((Math.random() - .5) * 40)));
						repaint();
					}
				}
				keyText.requestFocus();
			}

		
		});

		add(rand2);

		JButton file2 = new JButton("File");
		file2.setBounds(550, 400, 90, 20);

		file2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Scanner x = null;

				try {
					x = new Scanner(new File("RandomNums.txt"));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}

				for (int i = 0; i < rows2; i++) {
					for (int j = 0; j < columns2; j++) {
						if (x.hasNext()) {
							labels[1][c2][i][j].setText(Double.toString(formatDecimal(x.nextDouble())));
							repaint();
						}
					}
				}
				keyText.requestFocus();
			}
		});

		add(file2);

	}

	public void outputMatrix(Matrix output) {

		System.out.println(rows3);
		System.out.println(columns3);
		
		int m = 50;

		JLabel blank = new JLabel("");
		blank.setBounds(0, 0, 1, 1);

		for (int i = 0; i < rows3; i++) {
			for (int j = 0; j < columns3; j++) {
				System.out.println("i:" + i + " j: " + j + " c3: " + c3);
				remove(labels[2][c3][i][j]);
			}
		}

		rows3 = output.nums.length;
		columns3 = output.nums[0].length;

		labels[2][c3] = new JLabel[rows3][columns3];

		c3++;

		// data = new int[1][c2][rows2][columns2];

		labels[2][c3] = new JLabel[rows3][columns3];

		for (int i = 0; i < rows3; i++) {
			for (int j = 0; j < columns3; j++) {
				labels[2][c3][i][j] = new JLabel(Double.toString(formatDecimal(output.nums[i][j])));
				labels[2][c3][i][j].setBounds(805 + m * j - 40, 77 + m * i, 50, 40);

				add(labels[2][c3][i][j]);
			}
		}

		add(blank);

		repaint();
	}

	public void outputLabels(int lan, int rows, int columns) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				labels[lan][c] = new JLabel[rows2][columns2];

				labels[lan][c][i][j] = new JLabel("0");
				labels[lan][c][i][j].setBounds(70 + 40 * i, 100 + 40 * (j - 1), 40, 40);
				add(labels[lan][c][i][j]);
			}
		}
	}

	public void paint(Graphics g) {
		super.paint(g); // fixes the immediate problem.

		// setBackground(new Color(0, 0, 0, 0));
		// setOpacity(0);
		int a = -32;
		int m = 50;

		Graphics2D g2 = (Graphics2D) g;

		Line2D lin11 = new Line2D.Float(70, 110, 80, 110);
		Line2D lin12 = new Line2D.Float(70, 110, 70, 110 + m * rows1);
		Line2D lin13 = new Line2D.Float(70, 110 + m * rows1, 80, 110 + m * rows1);

		Line2D lin14 = new Line2D.Float(60 + m * columns1, 110, 70 + m * columns1, 110);
		Line2D lin15 = new Line2D.Float(70 + m * columns1, 110, 70 + m * columns1, 110 + m * rows1);
		Line2D lin16 = new Line2D.Float(60 + m * columns1, 110 + m * rows1, 70 + m * columns1, 110 + m * rows1);

		Line2D lin21 = new Line2D.Float(440, 110, 450, 110);
		Line2D lin22 = new Line2D.Float(440, 110, 440, 110 + m * rows2);
		Line2D lin23 = new Line2D.Float(440, 110 + m * rows2, 450, 110 + m * rows2);

		Line2D lin24 = new Line2D.Float(430 + m * columns2, 110, 440 + m * columns2, 110);
		Line2D lin25 = new Line2D.Float(440 + m * columns2, 110, 440 + m * columns2, 110 + m * rows2);
		Line2D lin26 = new Line2D.Float(430 + m * columns2, 110 + m * rows2, 440 + m * columns2, 110 + m * rows2);

		Line2D lin31 = new Line2D.Float(800 + a, 110, 810 + a, 110);
		Line2D lin32 = new Line2D.Float(800 + a, 110, 800 + a, 110 + m * rows3);
		Line2D lin33 = new Line2D.Float(800 + a, 110 + m * rows3, 810 + a, 110 + m * rows3);

		Line2D lin34 = new Line2D.Float(790 + m * columns3 + a, 110, 800 + m * columns3 + a, 110);
		Line2D lin35 = new Line2D.Float(800 + m * columns3 + a, 110, 800 + m * columns3 + a, 110 + m * rows3);
		Line2D lin36 = new Line2D.Float(790 + m * columns3 + a, 110 + m * rows3, 800 + m * columns3 + a, 110 + m * rows3);

		g2.draw(lin11);
		g2.draw(lin12);
		g2.draw(lin13);
		g2.draw(lin14);
		g2.draw(lin15);
		g2.draw(lin16);
		g2.draw(lin21);
		g2.draw(lin22);
		g2.draw(lin23);
		g2.draw(lin24);
		g2.draw(lin25);
		g2.draw(lin26);
		g2.draw(lin31);
		g2.draw(lin32);
		g2.draw(lin33);
		g2.draw(lin34);
		g2.draw(lin35);
		g2.draw(lin36);

		/*
		 * for (int i = 0; i < rows1; i++) { for (int j = 0; j < columns1; j++) {
		 * System.out.println("i:" + i + " j: " + j); remove(labels[0][c][i][j]); } }
		 * 
		 * c++;
		 * 
		 * labels[0][c] = new JLabel[rows1][columns1];
		 * 
		 * for (int i = 0; i < rows1 - 1; i++) { for (int j = 0; j < columns1; j++) {
		 * labels[0][c][i][j] = new JLabel("0"); labels[0][c][i][j].setBounds(74 + 40 *
		 * i, 107 + 40 * (j), 40, 40); //labels[0][c][i][j].setBounds(74 + 40 * i, 40 *
		 * (j - 1), 40, 40); add(labels[0][c][i][j]); } }
		 */

	}

	public boolean testInt(String s) {
		try {
			if (Double.parseDouble(s) == Integer.parseInt(s)) {
				return true;
			} else {
				return false;
			}

		} catch (NumberFormatException e) {
			return false;
		}

	}

	public boolean testDouble(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}

	}

	public void keyTyped(KeyEvent e) {

		// System.out.println(e.getKeyChar());

		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			// System.out.println("Backspace pressed");
		}

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			// System.out.println("Enter pressed");
		}

		/*
		 * if (testDouble(Character.toString(e.getKeyChar()))) {
		 * System.out.println("true"); } else { System.out.println("false"); }
		 */

	}

	public void keyPressed(KeyEvent e) {

		// System.out.println(ic);
		if (firstMatrix) {
			if ((ic) < rows1 * columns1) {

				int currentRow = (int) (ic / columns1);
				int currentColumn = ic - (currentRow) * (columns1);

				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					if (ic != 0) {
						labels[0][c][currentRow][currentColumn].setText("");
						ic--;
					}
					repaint();
				} else if (e.getKeyCode() == 37) {
					if (ic != 0) {
						ic--;
					}
					repaint();
				} else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					String s = labels[0][c][currentRow][currentColumn].getText();
					if (!s.equals("")) {
						labels[0][c][currentRow][currentColumn].setText(s.substring(0, s.length() - 1));
					}
					repaint();
				} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					ic++;

					if ((ic) >= columns1 * rows1) {
						ic = 0;
						firstMatrix = false;
					}
				} else if (e.getKeyChar() == KeyEvent.VK_SPACE) {
					ic++;

					if ((ic) >= columns1 * rows1) {
						ic = 0;
						firstMatrix = false;
					}
				} else if (e.getKeyCode() == 39) {
					ic++;

					if ((ic) >= columns1 * rows1) {
						ic = 0;
						firstMatrix = false;
					}
				} else {

					labels[0][c][currentRow][currentColumn]
							.setText(labels[0][c][currentRow][currentColumn].getText() + e.getKeyChar());

					repaint();

				}
			}
		} else {
			if ((ic) >= rows2 * columns2) {
				JOptionPane.showMessageDialog(null, "Matrices are full");
				ic--;
			} else if ((ic) < rows2 * columns2) {

				int currentRow = (int) (ic / columns2);
				int currentColumn = ic - (currentRow) * (columns2);

				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					if (ic != 0) {
						labels[1][c2][currentRow][currentColumn].setText("");
						ic--;
					} else {
						labels[1][c2][currentRow][currentColumn].setText("");
						ic = columns1 * rows1 - 1;
						firstMatrix = true;
					}
					repaint();
				} else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					String s = labels[1][c2][currentRow][currentColumn].getText();
					if (!s.equals("")) {
						labels[1][c2][currentRow][currentColumn].setText(s.substring(0, s.length() - 1));
					}
					repaint();
				} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					ic++;
				} else if (e.getKeyChar() == KeyEvent.VK_SPACE) {
					ic++;
				} else if (e.getKeyCode() == 37) {
					if (ic != 0) {
						ic--;
					} else {
						ic = columns1 * rows1 - 1;
						firstMatrix = true;
					}
					repaint();
				} else if (e.getKeyCode() == 39) {
					ic++;
				} else {

					labels[1][c2][currentRow][currentColumn]
							.setText(labels[1][c2][currentRow][currentColumn].getText() + e.getKeyChar());

					repaint();

				}
			} else if (ic == 0) {
				ic = columns1 * rows1 - 1;
				firstMatrix = true;
			}
		}

	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			// System.out.println("Backspace pressed");
		}

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			// System.out.println("Enter pressed");
		}
	}

	public double formatDecimal(double d) {
		return ((int) (d * 100)) / 100.0;
	}

}