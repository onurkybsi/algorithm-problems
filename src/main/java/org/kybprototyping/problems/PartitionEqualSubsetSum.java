package org.kybprototyping.problems;

import java.util.HashMap;

final class PartitionEqualSubsetSum {
  private PartitionEqualSubsetSum() {}

  private int nums[];
  private HashMap<State, Boolean> memo;

  public boolean canPartition(int[] nums) {
    if (nums.length < 2) {
      return false;
    }

    int totalSum = 0;
    for (int num : nums) {
      totalSum += num;
    }
    if (totalSum % 2 != 0) {
      return false;
    }

    this.nums = nums;
    this.memo = new HashMap<>();
    return doesTargetSumExist(totalSum / 2, 0);
  }

  private boolean doesTargetSumExist(int targetSum, int startingIx) {
    if (targetSum < 0 || startingIx >= this.nums.length) {
      return false;
    }
    if (targetSum == 0) {
      return true;
    }

    var state = new State(targetSum, startingIx);
    if (this.memo.containsKey(state)) {
      return this.memo.get(state);
    }

    boolean doesTargetSumExist = doesTargetSumExist(targetSum, startingIx + 1)
        || doesTargetSumExist(targetSum - this.nums[startingIx], startingIx + 1);
    this.memo.put(state, doesTargetSumExist);
    return doesTargetSumExist;
  }

  private record State(int targetSum, int startingIx) {
  }
}
