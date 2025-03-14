package org.kybprototyping.problems;

import java.util.Stack;

final class MinimizingArrayAfterReplacingPairsWithTheirProduct {

  private MinimizingArrayAfterReplacingPairsWithTheirProduct() {}

  public int minArrayLength2(int[] nums, int k) {
    Stack<Integer> stack = new Stack<>();

    for (int num : nums) {
      while (!stack.isEmpty() && (long) stack.peek() * num <= k) {
        num *= stack.pop();
      }
      stack.push(num);
    }

    return stack.size();
  }
}
