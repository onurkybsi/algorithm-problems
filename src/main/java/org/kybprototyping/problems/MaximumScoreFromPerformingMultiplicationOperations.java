package org.kybprototyping.problems;

import java.util.HashMap;

final class MaximumScoreFromPerformingMultiplicationOperations {

  private MaximumScoreFromPerformingMultiplicationOperations() {}

  public static int maximumScore(int[] nums, int[] multipliers) {
    return maximumScore(nums, multipliers, 0, 0, new HashMap<>());
  }

  private static int maximumScore(int[] nums, int[] multipliers, int numsLeftIx, int multipliersIx,
      HashMap<Tuple, Integer> cache) {
    if (multipliersIx == multipliers.length) {
      return 0;
    }

    var stateVariables = new Tuple(numsLeftIx, multipliersIx);
    if (cache.containsKey(stateVariables)) {
      return cache.get(stateVariables);
    }

    int withNumsLeftIx = nums[numsLeftIx] * multipliers[multipliersIx]
        + maximumScore(nums, multipliers, numsLeftIx + 1, multipliersIx + 1, cache);
    int withoutNumsLeftIx =
        nums[(nums.length - 1) - (multipliersIx - numsLeftIx)] * multipliers[multipliersIx]
            + maximumScore(nums, multipliers, numsLeftIx, multipliersIx + 1, cache);

    int maximumScore = Math.max(withNumsLeftIx, withoutNumsLeftIx);
    cache.put(stateVariables, maximumScore);

    return maximumScore;
  }

  private record Tuple(int first, int second) {
  }

}
