package org.kybprototyping.problems;

final class FindPeakElement {
  FindPeakElement() {
  }

  public int findPeakElement(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int middle = left + (right - left) / 2;
      if (isPeak(nums, middle)) {
        return middle;
      }
      if (middle + 1 < nums.length && nums[middle + 1] >= nums[middle]) {
        left = middle + 1;
      } else if (middle - 1 >= 0 && nums[middle - 1] >= nums[middle]) {
        right = middle - 1;
      }
    }
    throw new IllegalArgumentException("No peak element exists!");
  }

  private static boolean isPeak(int[] nums, int ix) {
    if (ix - 1 >= 0 && nums[ix - 1] >= nums[ix]) {
      return false;
    }
    if (ix + 1 < nums.length && nums[ix + 1] >= nums[ix]) {
      return false;
    }
    return true;
  }
}
