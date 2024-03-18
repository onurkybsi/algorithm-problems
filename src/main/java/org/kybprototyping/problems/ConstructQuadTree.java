package org.kybprototyping.problems;

import java.util.Arrays;

final class ConstructQuadTree {

  private ConstructQuadTree() {}

  public static Node construct(int[][] grid) {
    if (hasSameValues(grid)) {
      return new Node(grid[0][0] == 1, true);
    }

    Node root = new Node(true, false);
    root.topLeft = construct(extractTopLeft(grid));
    root.topRight = construct(extractTopRight(grid));
    root.bottomLeft = construct(extractBottomLeft(grid));
    root.bottomRight = construct(extractBottomRight(grid));
    return root;
  }

  private static boolean hasSameValues(int[][] grid) {
    int[] firstRow = grid[0];
    int firstCell = firstRow[0];
    if (!Arrays.stream(firstRow).allMatch(c -> c == firstCell)) {
      return false;
    }
    return Arrays.stream(grid).allMatch(c -> Arrays.equals(c, firstRow));
  }

  private static int[][] extractTopLeft(int[][] grid) {
    int n = grid.length / 2;

    int[][] topLeft = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        topLeft[i][j] = grid[i][j];
      }
    }
    return topLeft;
  }

  private static int[][] extractTopRight(int[][] grid) {
    int n = grid.length / 2;

    int[][] topRight = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        topRight[i][j] = grid[i][j + n];
      }
    }
    return topRight;
  }

  private static int[][] extractBottomLeft(int[][] grid) {
    int n = grid.length / 2;

    int[][] bottomLeft = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        bottomLeft[i][j] = grid[i + n][j];
      }
    }
    return bottomLeft;
  }

  private static int[][] extractBottomRight(int[][] grid) {
    int n = grid.length / 2;

    int[][] bottomRight = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        bottomRight[i][j] = grid[i + n][j + n];
      }
    }
    return bottomRight;
  }

  static class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
      this.val = false;
      this.isLeaf = false;
      this.topLeft = null;
      this.topRight = null;
      this.bottomLeft = null;
      this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
      this.val = val;
      this.isLeaf = isLeaf;
      this.topLeft = null;
      this.topRight = null;
      this.bottomLeft = null;
      this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft,
        Node bottomRight) {
      this.val = val;
      this.isLeaf = isLeaf;
      this.topLeft = topLeft;
      this.topRight = topRight;
      this.bottomLeft = bottomLeft;
      this.bottomRight = bottomRight;
    }
  }

}
