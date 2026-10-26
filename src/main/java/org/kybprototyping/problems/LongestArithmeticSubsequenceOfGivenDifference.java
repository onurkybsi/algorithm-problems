package org.kybprototyping.problems;

import java.util.HashMap;

final class LongestArithmeticSubsequenceOfGivenDifference {
  LongestArithmeticSubsequenceOfGivenDifference() {
  }

  public int longestSubsequence(int[] arr, int difference) {
    var memo = new HashMap<Integer, Integer>();
    int maxLength = Integer.MIN_VALUE;
    for (int i = arr.length - 1; i >= 0; i--) {
      int val = arr[i];
      int length = memo.getOrDefault(val + difference, 0) + 1;
      memo.put(val, length);
      maxLength = Math.max(maxLength, length);
    }
    return maxLength;
  }
}
