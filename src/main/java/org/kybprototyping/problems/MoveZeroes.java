package org.kybprototyping.problems;

final class MoveZeroes {

  private MoveZeroes() {}

  public void moveZeroes(int[] nums) {
    int i = nums.length - 1;
    while (i >= 0) {
      if (nums[i] == 0) {
        for (int j = i + 1; j < nums.length && nums[j] != 0; j++) {
          int temp = nums[j];
          nums[j] = 0;
          nums[j - 1] = temp;
        }
      }
      i--;
    }
  }

}
