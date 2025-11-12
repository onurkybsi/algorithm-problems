package org.kybprototyping.problems;

import java.util.List;

final class AdjacentIncreasingSubarraysDetectionI {

  private AdjacentIncreasingSubarraysDetectionI() {}

  public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
    for (int i = 0; i <= nums.size() - (k * 2); i++) {
      if (isStrictlyIncreasing(nums, i, i + k) && isStrictlyIncreasing(nums, i + k, i + (2 * k))) {
        return true;
      }
    }
    return false;
  }

  private static boolean isStrictlyIncreasing(List<Integer> nums, int from, int to) {
    int i = from + 1;
    while (i < nums.size() && i < to) {
      if (nums.get(i) <= nums.get(i - 1)) {
        return false;
      }
      i++;
    }
    return i == to;
  }

}
