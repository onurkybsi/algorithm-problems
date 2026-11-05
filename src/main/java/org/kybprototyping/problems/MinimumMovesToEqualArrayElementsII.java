package org.kybprototyping.problems;

import java.util.Arrays;

final class MinimumMovesToEqualArrayElementsII {
  private MinimumMovesToEqualArrayElementsII() {
  }

  public int minMoves2(int[] nums) {
    Arrays.sort(nums);
    int median = nums[nums.length / 2];
    int ans = 0;
    for (int num : nums) {
      ans += Math.abs(num - median);
    }
    return ans;
  }
}
