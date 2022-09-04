package org.kybprototyping;

import org.kybprototyping.problems.RemoveNthNodeFromEndOfList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings({ "java:S106" })
public class Main {
	private static final List<Class<?>> allProblemClasses = getAllProblemClasses();

	public static void main(String[] args) throws IOException {
		SimpleLogger.INSTANCE.logInfo(
				"""
						Hello World! Onur Kayabasi speaking :)
						This project includes some algorithm problems from some resources like LeetCode and the solutions of mine for them.
						Choose a problem by entering the number! And see the result that my algorithm finds!
						""");
		RemoveNthNodeFromEndOfList.runSolution(1);
	}

	public static String[] getAllProblemNames() {
		String[] allProblemNames = new String[allProblemClasses.size()];

		for (int i = 0; i < allProblemClasses.size(); i++) {
			allProblemNames[i] = allProblemClasses.get(i).getSimpleName();
		}

		return allProblemNames;
	}

	private static List<Class<?>> getAllProblemClasses() {
		String problemClassesPackageName = "org.kybprototyping.problems";
		InputStream stream = ClassLoader.getSystemClassLoader()
				.getResourceAsStream(problemClassesPackageName.replaceAll("[.]", "/"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		return reader.lines()
				.filter(line -> line.endsWith(".class"))
				.map(line -> getClass(line, problemClassesPackageName))
				.filter(problemClass -> !problemClass.isMemberClass())
				.collect(Collectors.toList());
	}

	private static Class<?> getClass(String className, String packageName) {
		try {
			return Class.forName(packageName + "."
					+ className.substring(0, className.lastIndexOf('.')));
		} catch (ClassNotFoundException e) {
			System.err.println(String.format(
					"The parameters -> className: %s & packageName: %s", className, packageName));
			System.exit(1);
		}
		return null;
	}
}
