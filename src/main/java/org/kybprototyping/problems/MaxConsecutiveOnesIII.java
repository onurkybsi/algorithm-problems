package org.kybprototyping.problems;

final class MaxConsecutiveOnesIII {
  private MaxConsecutiveOnesIII() {
  }

  public int longestOnes(int[] nums, int k) {
    int ans = Integer.MIN_VALUE;
    int budget = k;
    int left = 0;
    int right = 0;
    while (right < nums.length) {
      if (nums[right] == 0) {
        budget--;
      }
      if (budget < 0) {
        ans = Math.max(ans, right - left);
        while (budget < 0) {
          if (nums[left] == 0) {
            budget++;
          }
          left++;
        }
      }
      right++;
    }
    return Math.max(ans, right - left);
  }
}
