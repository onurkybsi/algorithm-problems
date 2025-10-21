package org.kybprototyping.problems;

final class SortColors {

  private SortColors() {}

  public void sortColors(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    int cur = 0;
    while (cur <= right) {
      if (nums[cur] == 0) {
        nums[cur] = nums[left];
        nums[left] = 0;
        cur = ++left;
      } else if (nums[cur] == 2) {
        nums[cur] = nums[right];
        nums[right] = 2;
        right--;
      } else if (nums[cur] > nums[right]) {
        int temp = nums[right];
        nums[right] = nums[cur];
        nums[cur] = temp;
      } else if (nums[cur] < nums[left]) {
        int temp = nums[left];
        nums[left] = nums[cur];
        nums[cur] = temp;
      } else {
        cur++;
      }
    }
  }

}
