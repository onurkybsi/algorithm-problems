package org.kybprototyping.problems;

final class MinimumMovesToEqualArrayElementsIII {
  private MinimumMovesToEqualArrayElementsIII() {
  }

  public int minMoves(int[] nums) {
    int max = max(nums);
    int minMoves = 0;
    for (int i = 0; i < nums.length; i++) {
      minMoves += max - nums[i];
    }
    return minMoves;
  }

  private static int max(int[] nums) {
    int max = Integer.MIN_VALUE;
    for (int num : nums) {
      max = Math.max(max, num);
    }
    return max;
  }
}
