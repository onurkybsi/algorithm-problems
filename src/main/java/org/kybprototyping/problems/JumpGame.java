package org.kybprototyping.problems;

final class JumpGame {

  private JumpGame() {}

  public static boolean canJump(int[] nums) {
    int i = 0;
    while (i < nums.length - 1) {
      int nextIx = getBestNext(i, nums[i], nums);

      if (nextIx == i) {
        return false;
      } else {
        i = nextIx;

      }
    }

    return true;
  }

  private static int getBestNext(int curIx, int range, int[] nums) {
    int nextIx = curIx;
    int max = Integer.MIN_VALUE;
    for (int i = curIx + 1; i <= curIx + range && i < nums.length; i++) {
      if (i + nums[i] > max) {
        max = i + nums[i];
        nextIx = i;
      }
    }

    return nextIx;
  }

}
