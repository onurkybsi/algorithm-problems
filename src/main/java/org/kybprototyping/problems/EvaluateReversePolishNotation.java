package org.kybprototyping.problems;

import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

final class EvaluateReversePolishNotation {

  private static final Map<String, BiFunction<Integer, Integer, Integer>> OPERATORS = Map.of("+",
      (x, y) -> x + y, "-", (x, y) -> x - y, "*", (x, y) -> x * y, "/", (x, y) -> x / y);

  private EvaluateReversePolishNotation() {}

  public static int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();

    for (String token : tokens) {
      if (!OPERATORS.containsKey(token)) {
        stack.push(Integer.valueOf(token));
        continue;
      }

      int number2 = stack.pop();
      int number1 = stack.pop();
      stack.push(OPERATORS.get(token).apply(number1, number2));
    }

    return stack.pop();
  }

}
