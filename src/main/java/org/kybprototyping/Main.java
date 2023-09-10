package org.kybprototyping;

import org.kybprototyping.problems.AlgorithmProblem;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@SuppressWarnings({"java:S106", "java:S112"})
public class Main {
	private static Pattern patternChecksNumericChar = Pattern.compile("-?\\d+(\\.\\d+)?");
	private static final List<AlgorithmProblem<?>> allProblems;

	static {
		String problemClassesPackageName = "org.kybprototyping.problems";
		InputStream stream = ClassLoader.getSystemClassLoader()
				.getResourceAsStream(problemClassesPackageName.replaceAll("[.]", "/"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

		allProblems = reader.lines().filter(line -> line.endsWith(".class")).map(className -> {
			try {
				return Class.forName(
						problemClassesPackageName + "." + className.substring(0, className.lastIndexOf('.')));
			} catch (ClassNotFoundException e) {
				ConsoleUtils.INSTANCE.error(e);
				throw new RuntimeException(e);
			}
		}).filter(problemClass -> !problemClass.isMemberClass() && !problemClass.isInterface())
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

		var problemToRun =
				allProblems.stream().filter(p -> p.getName().equals("SubstringWithConcatenationOfAllWords"))
						.findFirst().orElseThrow();
		// problemToRun.runSolution(1);
		// problemToRun.runSolution(2);
		problemToRun.runSolution(3); // Needs to be [6,9,12]
		// problemToRun.runSolution(4);
		// problemToRun.runSolution(5);
		// problemToRun.runSolution(6);
		// problemToRun.runSolution(7);
		// problemToRun.runSolution(8);
		// problemToRun.runSolution(9);
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

	private static boolean validateEnteredNumber(String enteredValue, Integer lowerBound,
			Integer upperBound) {
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
			argsConsoleOutput
					.append(ConsoleUtils.INSTANCE.toPrettyString(problem.getProblemArgs().get(i)));
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
				problem.getName(), problem.getDescriptionLink(), argsConsoleOutput.toString(),
				ConsoleUtils.INSTANCE.toRed("Press backspace to go back to see all the problems...")));
	}
}
