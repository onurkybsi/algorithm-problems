package org.kybprototyping.problems;

final class FindFirstAndLastPositionOfElementInSortedArray {

  private FindFirstAndLastPositionOfElementInSortedArray() {}

  public static int[] searchRange(int[] nums, int target) {
    int first = binarySearch(nums, target);

    if (first == -1) {
      return new int[] {-1, -1};
    }

    int last = first;

    int i = first - 1, j = last + 1;
    while (i >= 0 || j < nums.length) {
      if (i >= 0 && nums[i] == target) {
        first = i;
        i--;
      } else {
        i = -1;
      }

      if (j < nums.length && nums[j] == target) {
        last = j;
        j++;
      } else {
        j = nums.length;
      }
    }

    return new int[] {first, last};
  }

  private static int binarySearch(int[] nums, int target) {
    int l = 0, r = nums.length - 1;

    while (l <= r) {
      int m = l + (r - l) / 2;

      if (nums[m] == target) {
        return m;
      }

      if (nums[m] < target) {
        l = m + 1;
      } else {
        r = m - 1;
      }
    }

    return -1;
  }

}
