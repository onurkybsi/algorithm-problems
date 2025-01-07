package org.kybprototyping.problems;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
final class UniquePaths {

  public int uniquePaths(int m, int n) {
    int[][] memo = new int[m][n];
    memo[0][0] = 1;

    for (int row = 0; row < m; row++) {
      for (int col = 0; col < n; col++) {
        if (row - 1 >= 0) {
          memo[row][col] += memo[row - 1][col];
        }
        if (col - 1 >= 0) {
          memo[row][col] += memo[row][col - 1];
        }
      }
    }

    return memo[m - 1][n - 1];
  }

}
