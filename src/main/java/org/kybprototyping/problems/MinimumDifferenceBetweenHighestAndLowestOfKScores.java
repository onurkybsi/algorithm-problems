package org.kybprototyping.problems;

import java.util.Arrays;

final class MinimumDifferenceBetweenHighestAndLowestOfKScores {
  private MinimumDifferenceBetweenHighestAndLowestOfKScores() {
  }

  public int minimumDifference(int[] nums, int k) {
    if (nums.length == 1 || k > nums.length) {
      return 0;
    }
    Arrays.sort(nums);
    int ans = Integer.MAX_VALUE;
    for (int i = k - 1; i < nums.length; i++) {
      ans = Math.min(ans, nums[i] - nums[i - (k - 1)]);
    }
    return ans;
  }
}
