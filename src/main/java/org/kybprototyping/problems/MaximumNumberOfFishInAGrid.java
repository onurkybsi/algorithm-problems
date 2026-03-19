package org.kybprototyping.problems;

import java.util.HashSet;

final class MaximumNumberOfFishInAGrid {
  private MaximumNumberOfFishInAGrid() {}

  private int[][] grid;

  public int findMaxFish(int[][] grid) {
    this.grid = grid;
    int max = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] != 0) {
          max = Math.max(max, findMaxFish(new Cell(i, j), new HashSet<>()));
        }
      }
    }
    return max;
  }

  private int findMaxFish(Cell from, HashSet<Cell> curPath) {
    int max = grid[from.i][from.j];
    curPath.add(from);

    Cell right = new Cell(from.i, from.j + 1);
    if (from.j + 1 < grid[0].length && grid[from.i][from.j + 1] != 0 && !curPath.contains(right)) {
      var nextPath = new HashSet<Cell>(curPath);
      max += findMaxFish(right, nextPath);
      curPath.addAll(nextPath);
    }
    Cell left = new Cell(from.i, from.j - 1);
    if (from.j - 1 >= 0 && grid[from.i][from.j - 1] != 0 && !curPath.contains(left)) {
      var nextPath = new HashSet<Cell>(curPath);
      max += findMaxFish(left, nextPath);
      curPath.addAll(nextPath);
    }
    Cell top = new Cell(from.i - 1, from.j);
    if (from.i - 1 >= 0 && grid[from.i - 1][from.j] != 0 && !curPath.contains(top)) {
      var nextPath = new HashSet<Cell>(curPath);
      max += findMaxFish(top, nextPath);
      curPath.addAll(nextPath);
    }
    Cell bottom = new Cell(from.i + 1, from.j);
    if (from.i + 1 < grid.length && grid[from.i + 1][from.j] != 0 && !curPath.contains(bottom)) {
      var nextPath = new HashSet<Cell>(curPath);
      max += findMaxFish(bottom, nextPath);
      curPath.addAll(nextPath);
    }

    return max;
  }

  private record Cell(int i, int j) {
  }
}
