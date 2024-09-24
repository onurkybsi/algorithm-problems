package org.kybprototyping.problems;

final class TargetSum {

  private TargetSum() {}

  public static int findTargetSumWays(int[] nums, int target) {
    MutableInteger numOfWays = new MutableInteger(0);
    findTargetSumWays(nums, target, 0, 0, numOfWays);
    return numOfWays.val;
  }

  private static void findTargetSumWays(int[] nums, int target, int ix, int cur,
      MutableInteger numOfWays) {
    if (ix >= nums.length && cur == target) {
      numOfWays.val += 1;
      return;
    }
    if (ix >= nums.length && cur != target) {
      return;
    }

    findTargetSumWays(nums, target, ix + 1, cur + nums[ix], numOfWays);
    findTargetSumWays(nums, target, ix + 1, cur - nums[ix], numOfWays);
  }

  private static class MutableInteger {
    private int val;

    private MutableInteger(int val) {
      this.val = val;
    }
  }

}
