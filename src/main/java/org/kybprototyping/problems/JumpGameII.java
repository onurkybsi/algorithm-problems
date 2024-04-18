package org.kybprototyping.problems;

final class JumpGameII {

  private JumpGameII() {}

  public static int jump(int[] nums) {
    int numOfJump = 0;
    int i = 0;
    int curRange = nums[i];
    while (i + curRange < nums.length - 1) {
      i = findNextIx(nums, i, curRange);
      curRange = nums[i];
      numOfJump++;
    }
    return i < nums.length - 1 ? numOfJump + 1 : numOfJump;
  }

  private static int findNextIx(int[] nums, int i, int curRange) {
    int nextIx = i + 1;
    int nextIxRange = nums[i + 1];
    for (int j = nextIx + 1; j <= i + curRange; j++) {
      if (j + nums[j] > nextIx + nextIxRange) {
        nextIx = j;
        nextIxRange = nums[j];
      }
    }
    return nextIx;
  }

}
