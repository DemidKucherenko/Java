package ru.ifmo.ctddev.kucherenko.task6;

public class Main {
	public static void main(String[] args) {
        if (args.length != 2) {
            throw new ArrayIndexOutOfBoundsException("Incorrect number of files in command line");
        }
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        Tester tester = new Tester(n);
//        tester.testWithParticularNumberOfThreads(m);
        tester.testWithSeveralThreads();

	}
}
