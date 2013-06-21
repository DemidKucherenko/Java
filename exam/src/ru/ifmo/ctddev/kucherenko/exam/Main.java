package ru.ifmo.ctddev.kucherenko.exam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Main {

	/**
	 * Print message about illegal script format
	 */
	// static void IllegalScriptFormat() {
	// System.out.println("Illegal script format");
	// }

	/**
	 * @param args
	 *            Name of file, which contains script
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static void main(String[] args) {
		if (args.length != 1) {
			throw new ArrayIndexOutOfBoundsException(
					"Incorrect number of files in command line");
		}
		String input = args[0];
		File inputFile = new File(input);
		char[] buf = new char[100000];
		String s = "";
		MyMap myMap = new MyMap();

		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					new FileInputStream(inputFile), "UTF-8"));

			try {

				while (true) {
					int count = in.read(buf, 0, 100000);

					if (count == -1) {
						break;
					}
					StringBuilder sb = new StringBuilder(s);
					for (int i = 0; i < count; i++) {
						if (Character.LINE_SEPARATOR == buf[i]) {
							s = sb.toString();
							String[] st = s.split(" ");
							if ("add".equals(st[0])) {
								if (st.length != 3) {
									throw new IllegalArgumentException(
											"Illegal script format");
								}
								int index = Integer.parseInt(st[1]);
								myMap.add(index, st[2]);

							} else {
								if ("remove".equals(st[0])) {
									if (st.length != 2) {
										throw new IllegalArgumentException(
												"Illegal script format");
									}
									int index = Integer.parseInt(st[1]);
									myMap.remove(index);
								} else {
									if ("print".equals(st[0])) {
										if (st.length != 1) {
											throw new IllegalArgumentException(
													"Illegal script format");
										}
										myMap.print();
									} else {
										throw new IllegalArgumentException(
												"Illegal script format");
									}
								}
							}
							s = "";
							sb = new StringBuilder(s);
							i++;
							if (i < count && buf[i] != 10) {
								i--;
							}
						} else {
							sb.append(buf[i]);
						}
					}
				}

			} finally {
				try {
					in.close();
				} catch (IOException ee) { /* Ignoring */
				}

			}
		} catch (UnsupportedEncodingException e) {
			System.out.println("");
			return;
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		} catch (IOException e) {
			System.out.println("Can't read");
		} catch (NumberFormatException e) {
			System.out.println("Index is not a number");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}
	