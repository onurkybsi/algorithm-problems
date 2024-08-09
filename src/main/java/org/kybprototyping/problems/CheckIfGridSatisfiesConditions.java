package org.kybprototyping.problems;

import java.util.Arrays;

final class CheckIfGridSatisfiesConditions {

  private CheckIfGridSatisfiesConditions() {}

  public static boolean satisfiesConditions(int[][] grid) {
    int[] firstRow = grid[0];
    for (int i = 0; i < firstRow.length - 1; i++) {
      if (firstRow[i] == firstRow[i + 1]) {
        return false;
      }
    }

    for (int i = 1; i < grid.length; i++) {
      if (!Arrays.equals(firstRow, grid[i])) {
        return false;
      }
    }
    return true;
  }

}
