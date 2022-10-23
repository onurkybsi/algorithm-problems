package org.kybprototyping.problems;

import org.kybprototyping.BootstrapHelper;
import org.kybprototyping.ConsoleUtils;

import java.util.List;

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
		boolean result = isValid(args.get(argsOrder - 1).getS());
		ConsoleUtils.INSTANCE.info(result);
	}

	private static boolean isValid(String s) {
		return false;
	}

	static char getPair(char onePair) {
		if (onePair == '(') {
			return ')';
		}
		if (onePair == ')') {
			return '(';
		}
		if (onePair == '{') {
			return '}';
		}
		if (onePair == '}') {
			return '{';
		}
		if (onePair == '[') {
			return ']';
		}
		if (onePair == ']') {
			return '[';
		}
		return 0;
	}
}
