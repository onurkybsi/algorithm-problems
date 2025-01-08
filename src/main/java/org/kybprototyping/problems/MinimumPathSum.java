package org.kybprototyping.problems;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
final class MinimumPathSum {

  public int minPathSum(int[][] grid) {
    int[][] memo = new int[grid.length][grid[0].length];

    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        if (row > 0 && col > 0) {
          memo[row][col] += Math.min(memo[row - 1][col], memo[row][col - 1]);
        } else if (row > 0) {
          memo[row][col] += memo[row - 1][col];
        } else if (col > 0) {
          memo[row][col] += memo[row][col - 1];
        }

        memo[row][col] += grid[row][col]; // Base case (0, 0) handled here!
      }
    }

    return memo[memo.length - 1][memo[0].length - 1];
  }

}
