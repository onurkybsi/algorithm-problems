package org.kybprototyping.problems;

import java.util.HashMap;

final class SplitTheArray {

  private SplitTheArray() {}

  public boolean isPossibleToSplit(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      var occurences = map.getOrDefault(num, 0);
      if (occurences >= 2) {
        return false;
      }
      map.put(num, occurences + 1);
    }
    return map.size() >= nums.length / 2;
  }

}
