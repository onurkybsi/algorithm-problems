package org.kybprototyping.problems;

import java.util.HashMap;

final class EqualSumGridPartitionI {
  private EqualSumGridPartitionI() {}

  public boolean canPartitionGrid(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    long total = 0;
    HashMap<Integer, Long> rowSum = new HashMap<>();
    HashMap<Integer, Long> colSum = new HashMap<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        total += grid[i][j];
        long row = rowSum.getOrDefault(i, 0L);
        long col = colSum.getOrDefault(j, 0L);
        rowSum.put(i, row + grid[i][j]);
        colSum.put(j, col + grid[i][j]);
      }
    }
    if (total % 2 != 0) {
      return false;
    }

    // vertical
    long leftSum = 0;
    for (int i = 1; i < n; i++) {
      leftSum += colSum.get(i - 1);
      if (leftSum == total / 2) {
        return true;
      }
    }

    // horizontal
    long upperSum = 0;
    for (int i = 1; i < m; i++) {
      upperSum += rowSum.get(i - 1);
      if (upperSum == total / 2) {
        return true;
      }
    }

    return false;
  }
}
