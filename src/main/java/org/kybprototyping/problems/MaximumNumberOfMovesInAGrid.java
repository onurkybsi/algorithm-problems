package org.kybprototyping.problems;

final class MaximumNumberOfMovesInAGrid {
  private int[][] grid;
  private int[][] memo;

  public int maxMoves(int[][] grid) {
    this.grid = grid;
    this.memo = new int[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        memo[i][j] = -1;
      }
    }

    int maxMoves = 0;
    for (int i = 0; i < grid.length; i++) {
      maxMoves = Math.max(maxMoves, maxMovesFrom(i, 0));
    }
    return maxMoves;
  }

  private int maxMovesFrom(int i, int j) {
    if (memo[i][j] != -1) {
      return memo[i][j];
    }

    int curValue = grid[i][j];
    int maxMoves = 0;
    if (i - 1 >= 0 && j + 1 < grid[0].length && grid[i - 1][j + 1] > curValue) {
      maxMoves = 1 + maxMovesFrom(i - 1, j + 1);
    }
    if (j + 1 < grid[0].length && grid[i][j + 1] > curValue) {
      maxMoves = Math.max(maxMoves, 1 + maxMovesFrom(i, j + 1));
    }
    if (i + 1 < grid.length && j + 1 < grid[0].length && grid[i + 1][j + 1] > curValue) {
      maxMoves = Math.max(maxMoves, 1 + maxMovesFrom(i + 1, j + 1));
    }

    memo[i][j] = maxMoves;
    return maxMoves;
  }
}
