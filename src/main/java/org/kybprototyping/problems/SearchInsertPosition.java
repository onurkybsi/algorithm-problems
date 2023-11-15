package org.kybprototyping.problems;

final class SearchInsertPosition {

  private SearchInsertPosition() {}

  public static int searchInsert(int[] nums, int target) {
    int l = 0, r = nums.length - 1;

    int m = 0;
    while (l <= r) {
      m = l + (r - l) / 2;

      if (nums[m] == target) {
        return m;
      }

      if (nums[m] < target) {
        l = m + 1;
      } else {
        r = m - 1;
      }
    }

    return target > nums[m] ? m + 1 : m;
  }

}
