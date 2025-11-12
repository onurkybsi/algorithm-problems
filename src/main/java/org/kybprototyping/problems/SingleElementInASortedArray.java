package org.kybprototyping.problems;

final class SingleElementInASortedArray {

  private SingleElementInASortedArray() {}

  public int singleNonDuplicate(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (mid % 2 == 1) {
        mid--; // Always check even indices
      }

      if (nums[mid] == nums[mid + 1]) {
        left = mid + 2;
      } else {
        right = mid;
      }
    }
    return nums[left];
  }

}
