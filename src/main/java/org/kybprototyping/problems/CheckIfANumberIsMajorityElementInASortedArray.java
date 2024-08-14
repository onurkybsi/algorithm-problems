package org.kybprototyping.problems;

final class CheckIfANumberIsMajorityElementInASortedArray {

  private CheckIfANumberIsMajorityElementInASortedArray() {}

  public static boolean isMajorityElement(int[] nums, int target) {
    int appearance = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) {
        appearance++;

        if (appearance > nums.length / 2) {
          return true;
        }
      }
    }
    return false;
  }
}
