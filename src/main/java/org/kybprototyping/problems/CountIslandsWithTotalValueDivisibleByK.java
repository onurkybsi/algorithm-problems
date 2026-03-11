package org.kybprototyping.problems;

import java.util.HashSet;

final class CountIslandsWithTotalValueDivisibleByK {
  private CountIslandsWithTotalValueDivisibleByK() {}

  public int countIslands(int[][] grid, int k) {
    int answer = 0;
    HashSet<Cell> visited = new HashSet<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] != 0 && !visited.contains(new Cell(i, j))) {
          var islandCells = new HashSet<Cell>();
          int value = countIsland(grid, k, i, j, islandCells);
          if (value > 0 && value % k == 0) { // Integer overflow
            answer++;
          }
          visited.addAll(islandCells);
        }
      }
    }
    return answer;
  }

  private static int countIsland(int[][] grid, int k, int i, int j, HashSet<Cell> visited) {
    if (i < 0 || i >= grid.length) {
      return 0;
    }
    if (j < 0 || j >= grid[0].length) {
      return 0;
    }
    if (grid[i][j] == 0) {
      return 0;
    }

    var cell = new Cell(i, j);
    if (visited.contains(cell)) {
      return 0;
    }
    visited.add(cell);

    int cur = grid[i][j];
    int left = countIsland(grid, k, i, j - 1, visited);
    int right = countIsland(grid, k, i, j + 1, visited);
    int up = countIsland(grid, k, i - 1, j, visited);
    int down = countIsland(grid, k, i + 1, j, visited);
    return cur + left + right + up + down;
  }

  private record Cell(int i, int j) {
  }
}
