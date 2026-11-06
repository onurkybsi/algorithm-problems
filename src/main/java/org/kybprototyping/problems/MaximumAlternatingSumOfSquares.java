package org.kybprototyping.problems;

import java.util.Arrays;

final class MaximumAlternatingSumOfSquares {
  private MaximumAlternatingSumOfSquares() {
  }

  public long maxAlternatingSum(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      nums[i] = Math.abs(nums[i]);
    }
    Arrays.sort(nums);

    long ans = 0;
    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      ans -= (nums[left] * nums[left]);
      ans += (nums[right] * nums[right]);
      left++;
      right--;
    }
    if (nums.length % 2 != 0) {
      ans += (nums[right] * nums[right]);
    }
    return ans;
  }
}
