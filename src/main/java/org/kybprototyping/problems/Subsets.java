package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class Subsets {
  private Subsets() {}

  public List<List<Integer>> subsets(int[] nums) {
    var answer = new ArrayList<List<Integer>>();
    answer.add(Collections.emptyList());
    for (int i = 1; i <= nums.length; i++) {
      answer.addAll(subsets(nums, 0, i));
    }
    return answer;
  }

  private List<List<Integer>> subsets(int[] nums, int startingFrom, int n) {
    var answer = new ArrayList<List<Integer>>();
    for (int i = startingFrom; i < nums.length; i++) {
      var subsetsWithoutI = subsets(nums, i + 1, n - 1);
      if (subsetsWithoutI.isEmpty() && n == 1) {
        answer.add(new ArrayList<>(List.of(nums[i])));
      } else {
        for (var subset : subsetsWithoutI) {
          subset.add(nums[i]);
          answer.add(subset);
        }
      }
    }
    return answer;
  }
}
