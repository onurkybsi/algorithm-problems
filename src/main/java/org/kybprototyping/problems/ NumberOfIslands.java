package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

final class NumberOfIslands {

  private static final char ONE = 49;

  private NumberOfIslands() {}

  public static int numIslands(char[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    HashSet<Vertex> alreadySeen = new HashSet<>();
    int result = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == ONE) {
          var cur = new Vertex(i, j);
          if (!alreadySeen.contains(cur)) {
            buildLand(alreadySeen, cur, grid);
            result++;
          }
        }
      }
    }
    return result;
  }

  private static void buildLand(HashSet<Vertex> alreadySeen, Vertex cur, char[][] grid) {
    if (alreadySeen.contains(cur)) {
      return;
    }

    alreadySeen.add(cur);
    var neighbours = buildNeighbours(grid, cur.x, cur.y);
    for (Vertex neighbour : neighbours)
      buildLand(alreadySeen, neighbour, grid);
  }

  private static List<Vertex> buildNeighbours(char[][] grid, int i, int j) {
    int m = grid.length;
    int n = grid[0].length;

    var neighbours = new ArrayList<Vertex>();
    if (i - 1 >= 0 && grid[i - 1][j] == ONE) {
      neighbours.add(new Vertex(i - 1, j));
    }
    if (i + 1 < m && grid[i + 1][j] == ONE) {
      neighbours.add(new Vertex(i + 1, j));
    }
    if (j - 1 >= 0 && grid[i][j - 1] == ONE) {
      neighbours.add(new Vertex(i, j - 1));
    }
    if (j + 1 < n && grid[i][j + 1] == ONE) {
      neighbours.add(new Vertex(i, j + 1));
    }
    return neighbours;
  }

  private static record Vertex(int x, int y) {
  }

}
