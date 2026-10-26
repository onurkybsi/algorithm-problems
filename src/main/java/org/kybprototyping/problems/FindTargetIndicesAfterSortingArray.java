package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class FindTargetIndicesAfterSortingArray {
  FindTargetIndicesAfterSortingArray() {
  }

  public List<Integer> targetIndices(int[] nums, int target) {
    Arrays.sort(nums);
    var targetIndices = new ArrayList<Integer>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) {
        targetIndices.add(i);
      }
    }
    return targetIndices;
  }
}
