package ru.ifmo.ctddev.kucherenko.task6;

public class ElementNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ElementNotFoundException() {
		super();
	}

	public ElementNotFoundException(int i, int j) {
		super("Element not found in position: " + i + ", " + j);
	}

	public ElementNotFoundException(String s) {
		super(s);
	}
}
