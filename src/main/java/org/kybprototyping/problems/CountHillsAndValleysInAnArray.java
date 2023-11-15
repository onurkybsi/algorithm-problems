package org.kybprototyping.problems;

final class CountHillsAndValleysInAnArray {

  private CountHillsAndValleysInAnArray() {}

  public static int countHillValley(int[] nums) {
    int count = 0;

    int i = 1;
    while (i < nums.length - 1) {
      if (nums[i - 1] < nums[i] && nums[i + 1] < nums[i]) {
        count++;
      } else if (nums[i - 1] < nums[i] && nums[i + 1] == nums[i]) {
        int j = i + 1;
        while (j < nums.length - 1 && nums[j] == nums[i])
          j++;
        if (nums[j] < nums[i]) {
          count++;
          i = j - 1;
        }
      } else if (nums[i - 1] > nums[i] && nums[i + 1] > nums[i]) {
        count++;
      } else if (nums[i - 1] > nums[i] && nums[i + 1] == nums[i]) {
        int j = i + 1;
        while (j < nums.length - 1 && nums[j] == nums[i])
          j++;
        if (nums[j] > nums[i]) {
          count++;
          i = j - 1;
        }
      }

      i++;
    }

    return count;
  }

}
