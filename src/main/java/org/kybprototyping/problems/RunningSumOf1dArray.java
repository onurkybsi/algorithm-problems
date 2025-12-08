package org.kybprototyping.problems;

final class RunningSumOf1dArray {

  private RunningSumOf1dArray() {}

  public int[] runningSum(int[] nums) {
    if (nums.length == 0) {
      return new int[0];
    }

    int[] answer = new int[nums.length];
    answer[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      answer[i] = answer[i - 1] + nums[i];
    }
    return answer;
  }

}
