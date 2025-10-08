package org.kybprototyping.problems;

import java.util.Arrays;

final class NextPermutation {

  private NextPermutation() {}

  public void nextPermutation(int[] nums) {
    if (nums.length <= 1) {
      return;
    }

    int smallestNumOnRight = Integer.MAX_VALUE;
    int smallestIxOnRight = -1;
    for (int i = nums.length - 2; i >= 0; i--) {
      smallestNumOnRight = Integer.MAX_VALUE;
      smallestIxOnRight = -1;
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] < smallestNumOnRight && nums[j] > nums[i]) {
          smallestNumOnRight = nums[j];
          smallestIxOnRight = j;
        }
      }
      if (smallestNumOnRight != Integer.MAX_VALUE && smallestNumOnRight > nums[i]) {
        int temp = nums[i];
        nums[i] = smallestNumOnRight;
        nums[smallestIxOnRight] = temp;
        Arrays.sort(nums, i + 1, nums.length);
        return;
      }
    }

    Arrays.sort(nums);
  }

}
