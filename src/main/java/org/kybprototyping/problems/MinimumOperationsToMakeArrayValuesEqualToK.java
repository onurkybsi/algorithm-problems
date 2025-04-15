package org.kybprototyping.problems;

import java.util.Arrays;

final class MinimumOperationsToMakeArrayValuesEqualToK {

  private MinimumOperationsToMakeArrayValuesEqualToK() {}

  public int minOperations(int[] nums, int k) {
    Arrays.sort(nums);
    if (nums[0] < k) {
      return -1;
    }

    int minOperations = 0;
    int temp = nums[nums.length - 1];
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] < temp) {
        minOperations++;
        temp = nums[i];
      }
    }
    return temp == k ? minOperations : minOperations + 1;
  }

}
