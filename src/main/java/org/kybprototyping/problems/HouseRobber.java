package org.kybprototyping.problems;

final class HouseRobber {

  private HouseRobber() {}

  public static int rob(int[] nums) {
    int[] temp = new int[nums.length + 1];
    temp[nums.length] = 0;
    temp[nums.length - 1] = nums[nums.length - 1];
    for (int i = nums.length - 2; i >= 0; i--) {
      temp[i] = Math.max(temp[i + 1], temp[i + 2] + nums[i]);
    }
    return temp[0];
  }

}
