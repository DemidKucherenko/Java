package ru.ifmo.ctddev.kucherenko.task6;

public class Matrix {
	public Matrix(int n, int m) throws MatrixSizeException {
		super();
		this.n = n;
		this.m = m;
		this.a = new int[n][m];
	}

	public Matrix(int n, int m, int[][] a) throws SizeIncompatibleException {
		super();
		this.n = n;
		this.m = m;
		if (a.length != n || a[0].length != m)
			throw new SizeIncompatibleException(n, m, a.length, a[0].length);
		construct(a);
	}

	public Matrix(int[][] a) throws MatrixSizeException {
		super();
		construct(a);
	}

	public int get(int i, int j) throws ElementNotFoundException {
		if (i <= 0 || n < i || j <= 0 || m < j) {
			throw new ElementNotFoundException(i, j);
		}
		return a[i - 1][j - 1];
	}

	public void set(int i, int j, int value) throws ElementNotFoundException {
		if (i <= 0 || i > n || j <= 0 || j > m) {
			throw new ElementNotFoundException(i, j);
		}
		a[i - 1][j - 1] = value;
	}

	public Matrix add(Matrix oth) throws SizeIncompatibleException {
		if (this.n != oth.n || this.m != oth.m) {
			throw new SizeIncompatibleException(this.n, this.m, oth.n, oth.m);
		}
		Matrix res = new Matrix(n, m);
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.m; j++) {
				res.a[i][j] = this.a[i][j] + oth.a[i][j];
			}
		}
		return res;
	}

	public Matrix subtract(Matrix oth) throws SizeIncompatibleException {
		return (this.add(oth.scale(-1)));
	}

	public Matrix scale(int x)  {
		Matrix res = new Matrix(n, m);
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.m; j++) {
				res.a[i][j] = this.a[i][j] * x;
			}
		}
		return res;
	}

	public Matrix multiply(Matrix oth) throws SizeIncompatibleException {
		if (this.m != oth.n) {
			throw new SizeIncompatibleException(this.n, this.m, oth.n, oth.m);
		}
		Matrix res = new Matrix(this.n, oth.m);
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < oth.m; j++) {
				for (int k = 0; k < this.m; k++) {
					res.a[i][j] += (this.a[i][k] * oth.a[k][j]);
				}
			}
		}
		return res;
	}

	public Matrix transpose() {
		Matrix res = new Matrix(this.m, this.n);
		for (int i = 0; i < res.n; i++) {
			for (int j = 0; j < res.m; j++) {
				res.a[i][j] = this.a[j][i];
			}
		}
		return res;
	}

	public void print() {
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.m - 1; j++) {
				System.out.print(this.a[i][j] + " ");
			}
			System.out.println(this.a[i][this.m - 1]);
		}
	}

	private int n, m;
	private int[][] a;

	private void construct(int[][] a) throws MatrixSizeException {
		this.n = a.length;
		for (int i = 0; i < n; i++) {
			if (a[i].length != a[0].length) {
				throw new MatrixSizeException("It is not matrix, because length of " + (i+1) + " row not equal to 1 row");
			}
		}
		this.m = a[0].length;
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.m; j++) {
				this.a[i][j] = a[i][j];
			}
		}
	}
}
