package ru.ifmo.ctddev.kucherenko.task5;

import java.lang.reflect.Modifier;

public class Invoker {
	public static void main(String[] args) {

		if (args.length < 2) {
			System.out.println("Not enough arguments");
			return;
		}
		String className = args[0];
		String methodName = args[1];
		String[] arguments = new String[args.length - 2];
		for (int i = 0; i < arguments.length; i++) {
			arguments[i] = args[i + 2];
		}
		   try {
	            Class<?> curclass = Class.forName(className);
	            int currentModifier = curclass.getModifiers();
	            if (Modifier.isInterface(currentModifier)) {
	                System.err.println("Class " + className + " is an interface, cannot create an instance");
	                return;
	            }
	            if (Modifier.isInterface(currentModifier)) {
	                System.err.println("Class " + className + " is an abstract, cannot create an instance");
	                return;
	            }

		   } catch (ClassNotFoundException e) {
			   System.err.println("Class" + className + " not found");
		   }
		   

	}
}
