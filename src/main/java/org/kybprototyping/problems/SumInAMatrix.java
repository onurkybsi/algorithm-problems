package org.kybprototyping.problems;

import java.util.Arrays;

final class SumInAMatrix {
  private SumInAMatrix() {}

  public int matrixSum(int[][] nums) {
    for (int i = 0; i < nums.length; i++) {
      Arrays.sort(nums[i]);
    }

    int ans = 0;
    for (int j = nums[0].length - 1; j >= 0; j--) {
      int largest = Integer.MIN_VALUE;
      for (int i = 0; i < nums.length; i++) {
        largest = Math.max(largest, nums[i][j]);
      }
      ans += largest;
    }
    return ans;
  }
}
