import java.util.*;

public class Matrix {

	double[][] nums;

	public Matrix() {

	}

	public Matrix(Matrix m) {
		int numRows = m.nums.length;
		int numColumns = m.nums[0].length;

		nums = new double[numRows][numColumns];
		nums = m.nums;
	}

	public Matrix(double[][] arrNums) {
		int numRows = arrNums.length;
		int numColumns = arrNums[0].length;

		nums = new double[numRows][numColumns];
		nums = arrNums;
	}

	public int getNumRows() {
		return this.nums.length;
	}

	public boolean isSquare() {
		if (this.getNumColumns() == this.getNumRows()) {
			return true;
		} else {
			return false;
		}
	}

	public double getDeterminant() {
		double determinant = 0;

		if (this.isSquare()) {
			if(this.getNumColumns() == 1) {
				determinant = this.nums[0][0];
			} else if (this.getNumColumns() == 2) {
				determinant = this.getDeterminant2();
			} else {
				for (int i = 0; i < this.getNumColumns(); i++) {
					determinant += this.nums[0][i] * (this.remove(0, i)).getDeterminant() * Math.pow(-1, i);
				}
			}
		}

		return determinant;
	}

	public Matrix remove(int row, int column) {
		Matrix m = new Matrix(new double[this.getNumRows() - 1][this.getNumColumns() - 1]);

		for (int i = 0; i < this.getNumRows(); i++) {
			for (int j = 0; j < this.getNumColumns(); j++) {
				if (i != row && j != column) {
					if (i < row && j < column) {
						m.nums[i][j] = this.nums[i][j];
					} else if (i < row && j > column) {
						m.nums[i][j - 1] = this.nums[i][j];
					} else if (i > row && j < column) {
						m.nums[i - 1][j] = this.nums[i][j];
					} else if (i > row && j > column) {
						m.nums[i - 1][j - 1] = this.nums[i][j];
					}
				}
			}
		}

		return m;
	}

	public double getDeterminant2() {
		return (this.nums[0][0] * this.nums[1][1] - this.nums[1][0] * this.nums[0][1]);
	}

	public int getNumColumns() {
		return this.nums[0].length;
	}

	public boolean ChAddSubt(Matrix M2) {
		if (this.getNumRows() == M2.getNumRows() && this.getNumColumns() == M2.getNumColumns()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean ChMult(Matrix M2) {
		if (this.getNumColumns() == M2.getNumRows()) {
			return true;
		} else {
			return false;
		}
	}

	public Matrix Add(Matrix M2) {

		double[][] arrNums = null;

		if (this.ChAddSubt(M2)) {
			arrNums = new double[this.getNumRows()][this.getNumColumns()];
			for (int i = 0; i < this.getNumRows(); i++) {
				for (int j = 0; j < this.getNumColumns(); j++) {
					arrNums[i][j] += (M2.nums[i][j] + this.nums[i][j]);
				}
			}
			Matrix m = new Matrix(arrNums);
			return m;
		} else {
			Matrix m = new Matrix(arrNums);
			return m;
		}
	}

	public Matrix Subt(Matrix M2) {

		double[][] arrNums = null;

		if (this.ChAddSubt(M2)) {
			arrNums = new double[this.getNumRows()][this.getNumColumns()];
			for (int i = 0; i < this.getNumRows(); i++) {
				for (int j = 0; j < this.getNumColumns(); j++) {
					arrNums[i][j] += (-M2.nums[i][j] + this.nums[i][j]);
				}
			}
			Matrix m = new Matrix(arrNums);
			return m;
		} else {
			Matrix m = new Matrix(arrNums);
			return m;
		}
	}

	public Matrix sMult(double s) {
		for (int i = 0; i < this.getNumRows(); i++) {
			for (int j = 0; j < this.getNumColumns(); j++) {
				this.nums[i][j] = (this.nums[i][j] * s);
			}
		}

		return this;
	}

	public Matrix transpose() {
		Matrix constant = this;
		Matrix trans = new Matrix(new double[constant.getNumColumns()][constant.getNumRows()]);

		for (int i = 0; i < constant.getNumRows(); i++) {
			for (int j = 0; j < constant.getNumColumns(); j++) {
				trans.nums[j][i] = constant.nums[i][j];
			}
		}

		return trans;
	}

	public Matrix checkerboard() {
		Matrix checkerboard = new Matrix(new double[this.getNumColumns()][this.getNumRows()]);
		int c = 0;
		for (int i = 0; i < this.getNumRows(); i++) {
			for (int j = 0; j < this.getNumColumns(); j++) {
				checkerboard.nums[i][j] = (int) (this.nums[i][j] * Math.pow(-1, c));
				c++;
			}
			if (this.getNumColumns() % 2 == 0) {
				c++;
			}
		}
		return checkerboard;
	}

	public Matrix adjugate() {
		
			Matrix adjugate = new Matrix(new double[this.getNumColumns()][this.getNumRows()]);
			Matrix transpose = this.transpose();

			for (int i = 0; i < this.getNumRows(); i++) {
				for (int j = 0; j < this.getNumColumns(); j++) {
					adjugate.nums[i][j] = (int) (transpose.remove(i, j).getDeterminant());
				}
			}

			return adjugate.checkerboard();
	}

	public Matrix inverse() {
		if (this.isSquare()) {
			if(this.getNumColumns() == 1) {
				double invnum = 1/this.nums[0][0];
				double[][] n = new double[1][1];
				n[0][0] = invnum;
				Matrix inverse = new Matrix(n);
				return inverse;
			} else {
				return (this.adjugate().sMult(1 / this.getDeterminant()));
			}
		} else {
			return null;
		}
	}

	public Matrix Mult(Matrix M2) {

		double[][] arrNums = null;

		if (this.ChMult(M2)) {
			arrNums = new double[this.getNumRows()][M2.getNumColumns()];

			for (int i = 0; i < this.getNumRows(); i++) {
				for (int j = 0; j < M2.getNumColumns(); j++) {
					double num = 0;
					for (int k = 0; k < this.nums[0].length; k++) {
						num += this.nums[i][k] * M2.nums[k][j];
					}
					arrNums[i][j] = num;
				}
			}
			Matrix m = new Matrix(arrNums);
			return m;
		} else {
			Matrix m = new Matrix(arrNums);
			return m;
		}
	}

	public int dotProduct(int[] a1, int[] a2) {
		int sum = 0;

		if (a1.length == a2.length) {
			for (int i = 0; i < a1.length; i++) {
				sum += a1[i] * a2[i];
			}
		} else {
			System.exit(-1);
		}

		return sum;
	}

	public String toString() {
		String output = "[";
		for (int i = 0; i < this.getNumRows(); i++) {
			for (int j = 0; j < this.getNumColumns(); j++) {
				output += this.nums[i][j];
				if (j + 1 != this.getNumColumns()) {
					output += " ";
				}
			}

			if (i + 1 != this.getNumRows()) {
				output += "]\n[";
			}
		}
		output += "]\n";
		return output;
	}

}
