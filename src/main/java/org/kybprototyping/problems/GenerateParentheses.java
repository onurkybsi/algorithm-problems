package org.kybprototyping.problems;

import org.kybprototyping.BootstrapHelper;
import org.kybprototyping.ConsoleUtils;

import java.util.Arrays;
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

		// ["(())(())", "(())()()", "()()(())", "()()()()"]

		// By the solution, let's test n = 4, it could shift n-1 times
		// 11110000
		// 11101000
		// 11100100
		// 11100010
		// 11011000
		// 11010100
		// 11010010

		// missing ones
		// 10101010
		// 10101100
		// 11001010
		// 11001100

		// 10111000
		// 10110100
		// 10110010

		// - Shift the latest 1 to right side n-1 times
		// - Shift the left 1 of the latest 1 to right side n-1 times ...

		// 1 -> 1 0 +1
		// 3 -> 5 2 - 2 +1
		// 4 -> 10 3 - 3 - 3 +1
		// 5 -> ? 4 - 4 - 4 - 4 +1
		// ((n-1) * (n-1)) + 1

		String[] result = new String[((n - 1) * (n - 1)) + 1];

		// start
		char[] initial = new char[n * 2];
		for (int i = 0; i <= 1; i++) {
			for (int j = n * i; j < n * (i + 1); j++) {
				if (i == 0) {
					initial[j] = '(';
				} else {
					initial[j] = ')';
				}
			}
		}
		result[0] = new String(initial);

		int resultIx = 1;
		char[] tmp = null;
		for (int i = n - 1; i > 0; i--) {
			for (int j = n; j < (n * 2) - 1; j++) {
				tmp = initial.clone();
				tmp[i] = ')';
				tmp[j] = '(';
				result[resultIx] = new String(tmp);
				resultIx++;
			}
		}

		return Arrays.asList(result);
	}
}
