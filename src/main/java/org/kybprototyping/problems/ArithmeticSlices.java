package org.kybprototyping.problems;

final class ArithmeticSlices {
  private ArithmeticSlices() {
  }

  public int numberOfArithmeticSlices(int[] nums) {
    if (nums.length < 3) {
      return 0;
    }
    int ans = 0;
    int left = 0;
    int right = 2;
    int diff = nums[1] - nums[0];
    while (right < nums.length) {
      if (nums[right] - nums[right - 1] != diff) {
        int len = right - left;
        if (len >= 3) {
          ans += (len - 1) * (len - 2) / 2;
        }
        left = right - 1;
        diff = nums[right] - nums[left];
      }
      right++;
    }
    int len = right - left;
    if (len >= 3) {
      ans += (len - 1) * (len - 2) / 2;
    }
    return ans;
  }
}
