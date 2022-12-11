package org.kybprototyping;

import org.kybprototyping.problems.AlgorithmProblem;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@SuppressWarnings({ "java:S106", "java:S112" })
public class Main {
	private static Pattern patternChecksNumericChar = Pattern.compile("-?\\d+(\\.\\d+)?");
	private static final List<AlgorithmProblem<?>> allProblems;

	static {
		String problemClassesPackageName = "org.kybprototyping.problems";
		InputStream stream = ClassLoader.getSystemClassLoader()
				.getResourceAsStream(problemClassesPackageName.replaceAll("[.]", "/"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

		allProblems = reader.lines()
				.filter(line -> line.endsWith(".class"))
				.map(className -> {
					try {
						return Class.forName(problemClassesPackageName + "."
								+ className.substring(0, className.lastIndexOf('.')));
					} catch (ClassNotFoundException e) {
						ConsoleUtils.INSTANCE.error(e);
						throw new RuntimeException(e);
					}
				})
				.filter(problemClass -> !problemClass.isMemberClass() && !problemClass.isInterface())
				.map(problem -> {
					try {
						return (AlgorithmProblem<?>) problem.getDeclaredConstructors()[0].newInstance();
					} catch (Exception e) {
						ConsoleUtils.INSTANCE.error(e);
						throw new RuntimeException(e);
					}
				}).collect(Collectors.toList());
	}

	public static void main(String[] args) throws Exception {
		// greetClient();
		// printAllProblemsToTheConsole();
		// String problemNumberWillBeSolved = System.console().readLine();
		// while (!validateEnteredNumber(problemNumberWillBeSolved, 1,
		// allProblems.size())) {
		// ConsoleUtils.INSTANCE.info("Please enter a valid number!");
		// Thread.sleep(1000);
		// ConsoleUtils.INSTANCE.clearConsole();
		// greetClient();
		// printAllProblemsToTheConsole();
		// problemNumberWillBeSolved = System.console().readLine();
		// }
		// printProblemDetails(allProblems.get(Integer.parseInt(problemNumberWillBeSolved)
		// - 1));

		// allProblems.get(1).runSolution(1);
		// allProblems.get(1).runSolution(2);
		// allProblems.get(1).runSolution(3);
		// allProblems.get(1).runSolution(4);
		// allProblems.get(1).runSolution(5);
		// allProblems.get(1).runSolution(6);
		// allProblems.get(1).runSolution(7);
		// allProblems.get(1).runSolution(8);
		// allProblems.get(1).runSolution(9);
		// allProblems.get(1).runSolution(10);
		// allProblems.get(1).runSolution(11);
		allProblems.get(0).runSolution(1);
	}

	private static void greetClient() {
		ConsoleUtils.INSTANCE.info(
				"""
						------------------------------------------------------------------------------------------------------------------

						Hello World! Onur Kayabasi speaking :)

						This project includes some algorithm problems from some resources like LeetCode and the solutions of mine for them.
						Choose a problem and its arguments by using console! And see the result that my algorithm finds!

						------------------------------------------------------------------------------------------------------------------
						""");
	}

	private static void printAllProblemsToTheConsole() {
		for (int i = 0; i < allProblems.size(); i++) {
			AlgorithmProblem<?> problem = allProblems.get(i);
			ConsoleUtils.INSTANCE.info(String.format("%s. %s", i + 1, problem.getName()));
		}
	}

	private static boolean validateEnteredNumber(String enteredValue, Integer lowerBound, Integer upperBound) {
		if (enteredValue == null) {
			return false;
		}
		if (!patternChecksNumericChar.matcher(enteredValue).matches()) {
			return false;
		}
		Integer enteredIntValue = Integer.parseInt(enteredValue);
		return enteredIntValue >= lowerBound && enteredIntValue <= upperBound;
	}

	private static void printProblemDetails(AlgorithmProblem<?> problem) {
		ConsoleUtils.INSTANCE.clearConsole();

		StringBuilder argsConsoleOutput = new StringBuilder();
		for (int i = 0; i < problem.getProblemArgs().size(); i++) {
			argsConsoleOutput.append(ConsoleUtils.INSTANCE.toGreen(i + 1));
			argsConsoleOutput.append(" -> ");
			argsConsoleOutput.append(ConsoleUtils.INSTANCE.toPrettyString(problem.getProblemArgs().get(i)));
			argsConsoleOutput.append(System.lineSeparator());
			argsConsoleOutput.append(System.lineSeparator());
		}

		ConsoleUtils.INSTANCE.info(String.format(
				"""
						%s
						------------------------------------------------------------------------------------------------------------------
						You can examine the problem description from: %s

						%s

						%s
						""",
				problem.getName(),
				problem.getDescriptionLink(),
				argsConsoleOutput.toString(),
				ConsoleUtils.INSTANCE.toRed("Press backspace to go back to see all the problems...")));
	}
}
