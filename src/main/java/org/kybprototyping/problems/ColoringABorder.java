package org.kybprototyping.problems;

import java.util.HashSet;

final class ColoringABorder {
  private ColoringABorder() {}

  private int[][] grid;
  private int componentColor;
  private HashSet<Square> connectedComponent;

  public int[][] colorBorder(int[][] grid, int row, int col, int color) {
    this.grid = grid;
    this.componentColor = grid[row][col];
    this.connectedComponent = new HashSet<>();
    fillComponent(row, col);
    for (var square : connectedComponent) {
      if (isBorderSquare(square)) {
        grid[square.row][square.col] = color;
      }
    }
    return grid;
  }

  private void fillComponent(int row, int col) {
    if (row < 0 || row >= grid.length) {
      return;
    }
    if (col < 0 || col >= grid[0].length) {
      return;
    }
    if (grid[row][col] != componentColor) {
      return;
    }

    connectedComponent.add(new Square(row, col));
    if (!connectedComponent.contains(new Square(row - 1, col))) {
      fillComponent(row - 1, col);
    }
    if (!connectedComponent.contains(new Square(row + 1, col))) {
      fillComponent(row + 1, col);
    }
    if (!connectedComponent.contains(new Square(row, col - 1))) {
      fillComponent(row, col - 1);
    }
    if (!connectedComponent.contains(new Square(row, col + 1))) {
      fillComponent(row, col + 1);
    }
  }

  private boolean isBorderSquare(Square square) {
    if (square.row - 1 == -1 || square.row + 1 == grid.length) {
      return true;
    }
    if (square.col - 1 == -1 || square.col + 1 == grid[0].length) {
      return true;
    }
    if (!connectedComponent.contains(new Square(square.row - 1, square.col))) {
      return true;
    }
    if (!connectedComponent.contains(new Square(square.row + 1, square.col))) {
      return true;
    }
    if (!connectedComponent.contains(new Square(square.row, square.col - 1))) {
      return true;
    }
    if (!connectedComponent.contains(new Square(square.row, square.col + 1))) {
      return true;
    }
    return false;
  }

  private record Square(int row, int col) {
  }
}
