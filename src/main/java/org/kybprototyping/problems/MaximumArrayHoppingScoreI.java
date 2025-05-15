package org.kybprototyping.problems;

import java.util.HashMap;

final class MaximumArrayHoppingScoreI {

  private MaximumArrayHoppingScoreI() {}

  private int[] nums;
  private HashMap<Integer, Integer> memo;

  public int maxScore(int[] nums) {
    this.nums = nums;
    this.memo = new HashMap<>();
    return dp(0);
  }

  private int dp(int startingFrom) {
    if (this.memo.containsKey(startingFrom)) {
      return this.memo.get(startingFrom);
    }
    if (startingFrom == this.nums.length - 1) {
      return 0;
    }

    int maxScore = 0;
    for (int i = startingFrom + 1; i < this.nums.length; i++) {
      maxScore = Math.max(maxScore, ((i - startingFrom) * this.nums[i]) + dp(i));
    }

    this.memo.put(startingFrom, maxScore);
    return maxScore;
  }

}
