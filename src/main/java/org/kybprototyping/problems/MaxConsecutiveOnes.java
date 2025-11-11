package org.kybprototyping.problems;

final class MaxConsecutiveOnes {

  private MaxConsecutiveOnes() {}

  public int findMaxConsecutiveOnes(int[] nums) {
    int max = Integer.MIN_VALUE;
    int cur = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        max = Math.max(max, cur);
        cur = 0;
      } else {
        cur++;
      }
    }
    return Math.max(max, cur);
  }

}
