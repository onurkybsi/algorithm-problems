package org.kybprototyping.problems;

import org.kybprototyping.BootstrapHelper;
import org.kybprototyping.ConsoleUtils;

import java.util.List;
import java.util.Map;

import lombok.Data;

public class ValidParentheses implements AlgorithmProblem<ValidParentheses.ValidParenthesesArgs> {
	private static List<ValidParenthesesArgs> args = BootstrapHelper
			.getProblemArgs(ValidParenthesesArgs.class);

	@Data
	public static class ValidParenthesesArgs {
		private String s;
	}

	@Override
	public String getName() {
		return "ValidParentheses";
	}

	@Override
	public String getDescriptionLink() {
		return "https://leetcode.com/problems/valid-parentheses/";
	}

	@Override
	public List<ValidParenthesesArgs> getProblemArgs() {
		return args;
	}

	@Override
	public void runSolution(int argsOrder) {
		// TODO Auto-generated method stub
		isValid(args.get(argsOrder - 1).getS());
		ConsoleUtils.INSTANCE.info(args);
	}

	private static boolean isValid(String s) {
		Map<Character, Character> vcp = Map.of('(', ')', '{', '}', '[', ']');

		int i = 0;
		int j = 1;
		while (j < s.length()) {
		}

		return true;
	}
}
