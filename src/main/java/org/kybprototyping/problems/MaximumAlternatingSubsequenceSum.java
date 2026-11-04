package org.kybprototyping.problems;

final class MaximumAlternatingSubsequenceSum {
  private MaximumAlternatingSubsequenceSum() {
  }

  private int[] nums;
  private long[][] memo;

  public long maxAlternatingSum(int[] nums) {
    this.nums = nums;
    this.memo = new long[nums.length][2];
    return Math.max(maxAlternatingSum(0, 1), maxAlternatingSum(0, 0));
  }

  private long maxAlternatingSum(int ix, int even) {
    if (ix >= nums.length) {
      return 0;
    }
    if (memo[ix][even] != 0) {
      return memo[ix][even];
    }
    if (even == 1) {
      long max = Math.max(
          nums[ix] + maxAlternatingSum(ix + 1, 0),
          maxAlternatingSum(ix + 1, 1));
      memo[ix][even] = max;
      return max;
    } else {
      long max = Math.max(
          (-1 * nums[ix]) + maxAlternatingSum(ix + 1, 1),
          maxAlternatingSum(ix + 1, 0));
      memo[ix][even] = max;
      return max;
    }
  }
}
