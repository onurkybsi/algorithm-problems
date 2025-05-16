package org.kybprototyping.problems;

import java.util.Arrays;

final class MaximumConsecutiveFloorsWithoutSpecialFloors {

  private MaximumConsecutiveFloorsWithoutSpecialFloors() {}

  public int maxConsecutive(int bottom, int top, int[] special) {
    Arrays.sort(special);

    int maxConsecutive = special[0] - bottom;
    for (int i = 1; i < special.length; i++) {
      maxConsecutive = Math.max(maxConsecutive, special[i] - special[i - 1] - 1);
    }
    maxConsecutive = Math.max(maxConsecutive, top - special[special.length - 1]);
    return maxConsecutive;
  }

}
