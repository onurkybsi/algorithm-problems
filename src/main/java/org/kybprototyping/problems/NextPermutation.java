package org.kybprototyping.problems;

final class NextPermutation {

  private NextPermutation() {}

  public static void nextPermutation(int[] nums) {

    // 2 9 0 8
    // 2 9 8 0
    // 8 0 2 9
    // 8 0 9 2
    // 8 2 0 9
    // 8 2 9 0
    // 8 9 2 0
    // 9 0 2 8

    int j = nums.length - 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] > nums[j]) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
      }
    }

  }

}
