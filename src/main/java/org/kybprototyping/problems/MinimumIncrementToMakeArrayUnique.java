package org.kybprototyping.problems;

import java.util.HashMap;

final class MinimumIncrementToMakeArrayUnique {

  private MinimumIncrementToMakeArrayUnique() {}

  public static int minIncrementForUnique(int[] nums) {
    int minNumOfMoves = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int toMakeUnique = nums[i];
      while (map.containsKey(toMakeUnique)) {
        var occurences = map.get(toMakeUnique);
        map.put(toMakeUnique, occurences + 1);
        toMakeUnique += occurences;
      }
      map.put(toMakeUnique, 1);
      minNumOfMoves += toMakeUnique - nums[i];
    }
    return minNumOfMoves;
  }

}
