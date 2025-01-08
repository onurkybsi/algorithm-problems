package org.kybprototyping.problems;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
final class UniquePathsII {

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int[][] memo = new int[obstacleGrid.length][obstacleGrid[0].length];
    memo[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0; // Base case

    for (int row = 0; row < obstacleGrid.length; row++) {
      for (int col = 0; col < obstacleGrid[0].length; col++) {
        if (obstacleGrid[row][col] == 1) {
          continue;
        }
        // Sum of number of ways to get previous cells
        if (row > 0 && obstacleGrid[row - 1][col] == 0) {
          memo[row][col] += memo[row - 1][col];
        }
        if (col > 0 && obstacleGrid[row][col - 1] == 0) {
          memo[row][col] += memo[row][col - 1];
        }
      }
    }

    return memo[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
  }

}
