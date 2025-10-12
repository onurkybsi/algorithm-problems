package org.kybprototyping.problems;

import java.util.Map;
import java.util.Stack;

final class ValidParentheses {

	private ValidParentheses() {}

	private static final Map<Character, Character> brackets = Map.of('(', ')', '{', '}', '[', ']');

	public boolean isValid(String s) {
		Stack<Character> openBrackets = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			boolean isOpenBracket = brackets.containsKey(s.charAt(i));
			if (isOpenBracket) {
				openBrackets.add(s.charAt(i));
			} else if (!openBrackets.isEmpty() && brackets.get(openBrackets.peek()).equals(s.charAt(i))) {
				openBrackets.pop();
			} else {
				return false;
			}
		}
		return openBrackets.isEmpty();
	}

}
