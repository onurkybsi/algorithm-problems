package org.kybprototyping.problems;

// different biggest
final class TwoBiggestElementsInArray {

  private TwoBiggestElementsInArray() {}

  // Time complexity: O(n)
  public static int[] findTwoBiggestElementsInArray(int[] nums) {
    int first = Integer.MIN_VALUE;
    int second = Integer.MIN_VALUE;

    for (int i = 0; i < nums.length; i++) { // O(n)
      if (nums[i] > first) {
        second = first;
        first = nums[i];
      } else if (nums[i] > second) {
        second = nums[i];
      }
    }

    return new int[] {first, second};
  }

}
