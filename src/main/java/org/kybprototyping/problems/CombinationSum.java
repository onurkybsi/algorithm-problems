package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.List;

final class CombinationSum {
  CombinationSum() {
  }

  private int[] candidates;

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    this.candidates = candidates;
    var combinations = new ArrayList<List<Integer>>();
    combinationSum(0, target, new ArrayList<>(), combinations);
    return combinations;
  }

  private void combinationSum(int start, int target, List<Integer> curCombination, List<List<Integer>> combinations) {
    if (target < 0) {
      return;
    }
    if (target == 0) {
      combinations.add(curCombination);
      return;
    }
    for (int i = start; i < candidates.length; i++) {
      var nextCombination = new ArrayList<Integer>(curCombination);
      nextCombination.add(candidates[i]);
      combinationSum(i, target - candidates[i], nextCombination, combinations);
    }
  }
}
