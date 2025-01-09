package org.kybprototyping.problems;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
final class MinimumFallingPathSum {

  public int minFallingPathSum(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] memo = new int[m][n];

    int min = Integer.MAX_VALUE;
    for (int row = 0; row < m; row++) {
      for (int col = 0; col < n; col++) {
        if (row == 0) {
          memo[row][col] = matrix[row][col];
        } else {
          int minPreviousCell = memo[row - 1][col];
          if (col - 1 >= 0) {
            minPreviousCell = Math.min(minPreviousCell, memo[row - 1][col - 1]);
          }
          if (col + 1 < n) {
            minPreviousCell = Math.min(minPreviousCell, memo[row - 1][col + 1]);
          }

          memo[row][col] = minPreviousCell + matrix[row][col];
        }

        if (row == n - 1) {
          min = Math.min(min, memo[row][col]);
        }
      }
    }

    return min;
  }

}
