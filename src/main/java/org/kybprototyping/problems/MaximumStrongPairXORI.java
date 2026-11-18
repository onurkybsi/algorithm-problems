package org.kybprototyping.problems;

final class MaximumStrongPairXORI {
  private MaximumStrongPairXORI() {
  }

  public int maximumStrongPairXor(int[] nums) {
    int ans = Integer.MIN_VALUE;
    for (int left = 0; left < nums.length; left++) {
      for (int right = 0; right < nums.length; right++) {
        if (Math.abs(nums[left] - nums[right]) <= Math.min(nums[left], nums[right])) {
          ans = Math.max(ans, nums[left] ^ nums[right]);
        }
      }
    }
    return ans;
  }
}
