package org.kybprototyping.problems;

final class HouseRobber {

  private HouseRobber() {}

  public static int rob(int[] nums) {
    int[] robbed = new int[nums.length + 1];
    robbed[nums.length] = 0;
    robbed[nums.length - 1] = nums[nums.length - 1];
    for (int i = nums.length - 2; i >= 0; i--) {
      robbed[i] = Math.max(robbed[i + 1], robbed[i + 2] + nums[i]);
    }
    return robbed[0];
  }

}
