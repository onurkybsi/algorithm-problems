package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.HashMap;

final class FindOccurrencesOfAnElementInAnArray {

  private FindOccurrencesOfAnElementInAnArray() {}

  public static int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
    var map = new HashMap<Integer, Integer>();
    int i = 1;
    for (int j = 0; j < nums.length; j++) {
      if (nums[j] == x) {
        map.put(i, j);
        i++;
      }
    }

    var occurrencesOfElement = new ArrayList<>();
    for (int j = 0; j < queries.length; j++) {
      occurrencesOfElement.add(map.getOrDefault(queries[j], -1));
    }

    return occurrencesOfElement.stream().mapToInt(o -> (int) o).toArray();
  }

}
