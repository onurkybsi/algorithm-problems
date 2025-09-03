package org.kybprototyping.problems;

final class MakeArrayNonDecreasing {
  private int[] nums;

  private MakeArrayNonDecreasing() {}

  public int maximumPossibleSize(int[] nums) {
    this.nums = nums;
    return maximumPossibleSize(0, Integer.MIN_VALUE);
  }

  private int maximumPossibleSize(int startingFrom, int lowerBound) {
    if (startingFrom == this.nums.length) {
      return 0;
    }

    if (this.nums[startingFrom] >= lowerBound) {
      return 1 + maximumPossibleSize(startingFrom + 1, this.nums[startingFrom]);
    }
    return maximumPossibleSize(startingFrom + 1, lowerBound);
  }
}
