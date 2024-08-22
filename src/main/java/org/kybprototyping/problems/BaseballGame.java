package org.kybprototyping.problems;

import java.util.Stack;

final class BaseballGame {

  private BaseballGame() {}

  public static int calPoints(String[] operations) {
    var stack = new Stack<Integer>();

    int sum = 0;
    for (int i = 0; i < operations.length; i++) {
      String operation = operations[i];

      if ("+".equals(operation)) {
        var first = stack.pop();
        var second = stack.pop();
        stack.add(second);
        stack.add(first);
        stack.add(first + second);

        sum += first + second;
      } else if ("D".equals(operation)) {
        var first = stack.peek();
        stack.add(first * 2);

        sum += first * 2;
      } else if ("C".equals(operation)) {
        sum -= stack.pop();
      } else {
        stack.add(Integer.valueOf(operation));

        sum += Integer.valueOf(operation);
      }
    }

    return sum;
  }

}
