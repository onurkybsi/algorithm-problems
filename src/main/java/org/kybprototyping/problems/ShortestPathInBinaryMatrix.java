package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

final class ShortestPathInBinaryMatrix {

  private ShortestPathInBinaryMatrix() {}

  public int shortestPathBinaryMatrix(int[][] grid) {
    if (grid[0][0] != 0) {
      return -1;
    }

    HashSet<Cell> visited = new HashSet<>();
    Queue<List<Cell>> queue = new LinkedList<>();
    queue.add(Arrays.asList(new Cell(0, 0)));
    Cell target = new Cell(grid.length - 1, grid[0].length - 1);
    while (!queue.isEmpty()) {
      List<Cell> curPath = queue.remove();
      Cell curCell = curPath.get(curPath.size() - 1);
      if (curCell.equals(target)) {
        return curPath.size();
      }

      List<Cell> adjacencies = extractAdjacencies(curCell, grid);
      for (Cell adjacent : adjacencies) {
        if (!visited.contains(adjacent)) {
          ArrayList<Cell> newPath = new ArrayList<>(curPath);
          newPath.add(adjacent);
          queue.add(newPath);
          visited.add(adjacent);
        }
      }
    }
    return -1;
  }

  private static List<Cell> extractAdjacencies(Cell cell, int[][] grid) {
    ArrayList<Cell> adjacencies = new ArrayList<>();
    int i = cell.i;
    int j = cell.j;

    if (i - 1 >= 0 && j - 1 >= 0 && grid[i - 1][j - 1] == 0) {
      adjacencies.add(new Cell(i - 1, j - 1));
    }
    if (i - 1 >= 0 && grid[i - 1][j] == 0) {
      adjacencies.add(new Cell(i - 1, j));
    }
    if (i - 1 >= 0 && j + 1 < grid[0].length && grid[i - 1][j + 1] == 0) {
      adjacencies.add(new Cell(i - 1, j + 1));
    }

    if (i + 1 < grid.length && j - 1 >= 0 && grid[i + 1][j - 1] == 0) {
      adjacencies.add(new Cell(i + 1, j - 1));
    }
    if (i + 1 < grid.length && grid[i + 1][j] == 0) {
      adjacencies.add(new Cell(i + 1, j));
    }
    if (i + 1 < grid.length && j + 1 < grid[0].length && grid[i + 1][j + 1] == 0) {
      adjacencies.add(new Cell(i + 1, j + 1));
    }

    if (j - 1 >= 0 && grid[i][j - 1] == 0) {
      adjacencies.add(new Cell(i, j - 1));
    }
    if (j + 1 < grid[0].length && grid[i][j + 1] == 0) {
      adjacencies.add(new Cell(i, j + 1));
    }

    return adjacencies;
  }

  private record Cell(int i, int j) {
  }

}
