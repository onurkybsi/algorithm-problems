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
		isValid(args.get(argsOrder - 1).getS());
		ConsoleUtils.INSTANCE.info(args);
	}

	private static boolean isValid(String s) {
		int ix1 = 0;
		int ix2 = 1;
		int ix3 = 2;
		int ix4 = 3;
		boolean toOutside = false;
		while (ix1 > -1 && ix2 > -1 && ix2 < s.length() && ix4 < s.length()) {
			if (toOutside) {
				if (Character.valueOf(s.charAt(ix3)).equals(getPair(Character.valueOf(s.charAt(ix4))))) {
					ix3--;
					ix4++;
				} else {
					return false;
				}
			}
			if (Character.valueOf(s.charAt(ix1)).equals(getPair(Character.valueOf(s.charAt(ix2))))) {
				ix1 += 2;
				ix2 += 2;
				ix3 += 2;
				ix4 += 2;
			} else {
				ix1 += 1;
				ix2 += 1;
				ix3 = ix1 - 1;
				ix4 = ix2 + 1;
				if (!toOutside) {
					toOutside = Character.valueOf(s.charAt(ix1)).equals(getPair(Character.valueOf(s.charAt(ix2))));
				}
			}
		}

		return true;
	}

	static Character getPair(Character onePair) {
		if (onePair.equals('(')) {
			return Character.valueOf(')');
		}
		if (onePair.equals(')')) {
			return Character.valueOf('(');
		}
		if (onePair.equals('{')) {
			return Character.valueOf('}');
		}
		if (onePair.equals('}')) {
			return Character.valueOf('{');
		}
		if (onePair.equals('[')) {
			return Character.valueOf(']');
		}
		if (onePair.equals(']')) {
			return Character.valueOf('[');
		}
		return null;
	}
}
