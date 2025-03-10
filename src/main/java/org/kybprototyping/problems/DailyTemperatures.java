package org.kybprototyping.problems;

import java.util.HashMap;

final class DailyTemperatures {

  private DailyTemperatures() {}

  public int[] dailyTemperatures(int[] temperatures) {
    var cache = new HashMap<Integer, Integer>();
    int result[] = new int[temperatures.length];
    for (int i = 0; i < temperatures.length; i++) {
      if (cache.containsKey(temperatures[i]) && cache.get(temperatures[i]) > i) {
        result[i] = cache.get(temperatures[i]) - i;
      } else if (cache.containsKey(temperatures[i]) && cache.get(temperatures[i]) == 0) {
        result[i] = 0;
      } else {
        int warmerDayIndex = warmerDayIndexOf(i, temperatures);
        setCacheBy(temperatures[i], warmerDayIndex, temperatures, cache);
        result[i] = Math.max(warmerDayIndex - i, 0);
      }
    }
    return result;
  }

  private static int warmerDayIndexOf(int i, int[] temperatures) {
    for (int j = i + 1; j < temperatures.length; j++) {
      if (temperatures[j] > temperatures[i]) {
        return j;
      }
    }
    return 0;
  }

  private static void setCacheBy(int lowerBoundTemperature, int warmerDayIndex, int[] temperatures,
      HashMap<Integer, Integer> cache) {
    for (int i = lowerBoundTemperature; i < temperatures[warmerDayIndex]; i++) {
      cache.put(i, warmerDayIndex);
    }
  }
}
