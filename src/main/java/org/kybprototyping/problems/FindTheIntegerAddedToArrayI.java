package org.kybprototyping.problems;

final class FindTheIntegerAddedToArrayI {

  private FindTheIntegerAddedToArrayI() {}

  public static int addedInteger(int[] nums1, int[] nums2) {
    int num1Min = min(nums1);
    int num2Min = min(nums2);
    return num2Min - num1Min;
  }

  private static int min(int[] nums2) {
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < nums2.length; i++) {
      min = Math.min(min, nums2[i]);
    }
    return min;
  }

}
