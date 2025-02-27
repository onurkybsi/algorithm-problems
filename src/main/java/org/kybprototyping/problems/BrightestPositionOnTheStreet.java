package org.kybprototyping.problems;

import java.util.TreeMap;

final class BrightestPositionOnTheStreet {

  private BrightestPositionOnTheStreet() {}

  public static int brightestPosition(int[][] lights) {
    var changesInBrightness = new TreeMap<Integer, Integer>();
    for (int[] light : lights) {
      changesInBrightness.put(light[0] - light[1],
          changesInBrightness.getOrDefault(light[0] - light[1], 0) + 1);
      changesInBrightness.put(light[0] + light[1] + 1,
          changesInBrightness.getOrDefault(light[0] + light[1] + 1, 0) - 1);
    }

    int brightness = 0;
    int maxBrightness = 0;
    int bestPosition = 0;
    for (var changeInBrightness : changesInBrightness.entrySet()) {
      brightness += changeInBrightness.getValue();

      if (brightness > maxBrightness) {
        maxBrightness = brightness;
        bestPosition = changeInBrightness.getKey();
      }
    }
    return bestPosition;
  }

}
