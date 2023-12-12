package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.Arrays;

final class MergeIntervals {

  private MergeIntervals() {}

  public static int[][] merge(int[][] intervals) {
    if (intervals.length == 1) {
      return intervals;
    }

    Arrays.sort(intervals, (t1, t2) -> t1[0] - t2[0]);

    ArrayList<int[]> result = new ArrayList<>();
    for (int i = 0; i < intervals.length;) {
      int lowerBound = intervals[i][0];
      int upperBound = intervals[i][1];

      int j = i + 1;
      while (j < intervals.length && intervals[j][0] <= upperBound) {
        upperBound = Math.max(upperBound, intervals[j][1]);
        j++;
      }
      result.add(new int[] {lowerBound, upperBound});

      i = j;
    }

    return result.toArray(int[][]::new);
  }

}
