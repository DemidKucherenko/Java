package ru.ifmo.ctddev.kucherenko.task6;

public class MatrixSizeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MatrixSizeException() {
		super();
	}

	public MatrixSizeException(int i, int j) {
		super("Matrix have wrong sizes: " + i + ", " + j);
	}

	public MatrixSizeException(String s) {
		super(s);
	}
}
