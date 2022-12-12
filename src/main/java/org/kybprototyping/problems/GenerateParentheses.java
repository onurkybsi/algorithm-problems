package org.kybprototyping.problems;

import org.kybprototyping.BootstrapHelper;
import org.kybprototyping.ConsoleUtils;

import java.util.List;

import lombok.Data;

public class GenerateParentheses implements AlgorithmProblem<GenerateParentheses.GenerateParenthesesArgs> {
	private static List<GenerateParenthesesArgs> args = BootstrapHelper.getProblemArgs(GenerateParenthesesArgs.class);

	@Data
	public static class GenerateParenthesesArgs {
		private int n;
	}

	@Override
	public String getName() {
		return "GenerateParentheses";
	}

	@Override
	public String getDescriptionLink() {
		return "https://leetcode.com/problems/generate-parentheses/";
	}

	@Override
	public List<GenerateParenthesesArgs> getProblemArgs() {
		return args;
	}

	@Override
	public void runSolution(int argsOrder) {
		GenerateParenthesesArgs arg = args.get(argsOrder - 1);
		List<String> result = generateParenthesis(arg.getN());
		ConsoleUtils.INSTANCE.info(result);
	}

	private static List<String> generateParenthesis(int n) {
		// Input: n = 3
		// Output: ["((()))","(()())","(())()","()(())","()()()"]

		// 111000
		// 110100
		// 110010
		// 101100
		// 101010

		// By the solution, let's test n = 4, it could shift n-1 times
		// 11110000
		// 11101000
		// 11100010
		// 11011000
		// 11010100
		// 11010010
		// 10111000
		// 10110010
		// 10110001

		// - Shift the latest 1 to right side n-1 times
		// - Shift the left 1 of the latest 1 to right side n-1 times ...
		return null;
	}
}
