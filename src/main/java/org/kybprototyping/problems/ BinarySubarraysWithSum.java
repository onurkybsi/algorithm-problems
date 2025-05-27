package org.kybprototyping.problems;

final class BinarySubarraysWithSum {

  private BinarySubarraysWithSum() {}

  public int numSubarraysWithSum(int[] nums, int goal) {
    int numSubarraysWithSum = 0;
    for (int i = 0; i < nums.length; i++) {
      int temp = nums[i];

      int j = i + 1;
      while (j < nums.length && temp < goal) {
        temp += nums[j];
        j++;
      }
      if (temp == goal) {
        numSubarraysWithSum++;
      }

      while (j < nums.length && temp == goal && nums[j] == 0) {
        numSubarraysWithSum++;
        j++;
      }
    }
    return numSubarraysWithSum;
  }

}
