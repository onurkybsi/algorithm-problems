package org.kybprototyping.problems;

import java.util.HashSet;

final class RottingOranges {

  private RottingOranges() {}

  public int orangesRotting(int[][] grid) {
    HashSet<Cell> rotten = new HashSet<>();
    int numOfOranges = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 2) {
          rotten.add(new Cell(i, j));
        }
        if (grid[i][j] != 0) {
          numOfOranges++;
        }
      }
    }

    int numOfRottenOranges = rotten.size();
    int duration = 0;
    while (numOfRottenOranges < numOfOranges) {
      progress(grid, rotten);
      if (rotten.size() == numOfRottenOranges) {
        return -1;
      }

      numOfRottenOranges = rotten.size();
      duration++;
    }
    return duration;
  }

  private static void progress(int[][] grid, HashSet<Cell> rotten) {
    HashSet<Cell> newlyRotten = new HashSet<>();
    for (Cell rottenOrange : rotten) {
      int i = rottenOrange.i;
      int j = rottenOrange.j;
      if (i - 1 >= 0 && grid[i - 1][j] == 1) {
        newlyRotten.add(new Cell(i - 1, j));
        grid[i - 1][j] = 2;
      }
      if (i + 1 < grid.length && grid[i + 1][j] == 1) {
        newlyRotten.add(new Cell(i + 1, j));
        grid[i + 1][j] = 2;
      }
      if (j - 1 >= 0 && grid[i][j - 1] == 1) {
        newlyRotten.add(new Cell(i, j - 1));
        grid[i][j - 1] = 2;
      }
      if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
        newlyRotten.add(new Cell(i, j + 1));
        grid[i][j + 1] = 2;
      }
    }
    rotten.addAll(newlyRotten);
  }

  private record Cell(int i, int j) {
  }

}
