package org.kybprototyping.problems;

import java.util.Arrays;

final class RotateArray {

  private RotateArray() {}

  // Time complexity: O(n), space complexity: O(n)
  public static void rotate(int[] nums, int k) {
    int n = nums.length;
    int[] copy = Arrays.copyOf(nums, n);

    for (int i = 0; i < n; i++) {
      if (i + k <= n - 1) {
        nums[i + k] = copy[i];
      } else {
        nums[(i + k) % n] = copy[i];
      }
    }
  }

}
