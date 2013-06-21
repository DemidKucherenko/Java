package ru.ifmo.ctddev.kucherenko.task6;

public class SizeIncompatibleException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SizeIncompatibleException() {
		super();
	}

	public SizeIncompatibleException(int oldn, int oldm, int newn, int newm) {
		super("(" + oldn + ", " + oldm + ") and (" + newn + ", " + newm + ")");
	}

	public SizeIncompatibleException(String s) {
		super(s);
	}
}
