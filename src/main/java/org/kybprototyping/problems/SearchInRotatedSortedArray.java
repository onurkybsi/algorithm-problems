package org.kybprototyping.problems;

final class SearchInRotatedSortedArray {

  private SearchInRotatedSortedArray() {}

  public static int search(int[] nums, int target) {
    boolean shouldIterateFromStart = target >= nums[0];
    boolean shouldIterateFromEnd = target <= nums[nums.length - 1];

    int i = 0;

    if (shouldIterateFromStart) {
      i = 0;
      while (i + 1 < nums.length && nums[i] < nums[i + 1]) {
        if (nums[i] == target) {
          return i;
        }
        i++;
      }
    }

    if (shouldIterateFromEnd) {
      i = nums.length - 1;
      while (i - 1 > 0 && nums[i] > nums[i - 1]) {
        if (nums[i] == target) {
          return i;
        }
        i--;
      }
    }

    return nums[i] == target ? i : -1;
  }

}
