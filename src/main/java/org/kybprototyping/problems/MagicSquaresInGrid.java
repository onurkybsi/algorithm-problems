package org.kybprototyping.problems;

import java.util.HashSet;

final class MagicSquaresInGrid {
  private MagicSquaresInGrid() {}

  public int numMagicSquaresInside(int[][] grid) {
    int answer = 0;
    for (int i = 0; i <= grid.length - 3; i++) {
      for (int j = 0; j <= grid[0].length - 3; j++) {
        if (isMagicSquare(grid, i, j)) {
          answer++;
        }
      }
    }
    return answer;
  }

  private static boolean isMagicSquare(int[][] grid, int leftTopRowIx, int leftTopColIx) {
    final int sum = diagonalSum(grid, leftTopRowIx, leftTopColIx);
    if (sum == -1) {
      return false;
    }

    // Verify rows sum and distinct numbers
    HashSet<Integer> numsVisited = new HashSet<>();
    for (int i = leftTopRowIx; i < leftTopRowIx + 3; i++) {
      int rowSum = rowSum(grid, i, leftTopColIx, numsVisited);
      if (sum == -1 || rowSum != sum) {
        return false;
      }
    }
    if (numsVisited.size() != 9) {
      return false;
    }

    // Verify columns sum
    for (int i = leftTopColIx; i < leftTopColIx + 3; i++) {
      int colSum = colSum(grid, leftTopRowIx, i);
      if (sum == -1 || colSum != sum) {
        return false;
      }
    }
    return true;
  }

  private static int diagonalSum(int[][] grid, int leftTopRowIx, int leftTopColIx) {
    int sumOfDiagoalFromLeft = grid[leftTopRowIx][leftTopColIx];
    sumOfDiagoalFromLeft += grid[leftTopRowIx + 1][leftTopColIx + 1];
    sumOfDiagoalFromLeft += grid[leftTopRowIx + 2][leftTopColIx + 2];
    int sumOfDiagoalFromRight = grid[leftTopRowIx][leftTopColIx + 2];
    sumOfDiagoalFromRight += grid[leftTopRowIx + 1][leftTopColIx + 1];
    sumOfDiagoalFromRight += grid[leftTopRowIx + 2][leftTopColIx];
    if (sumOfDiagoalFromLeft != sumOfDiagoalFromRight) {
      return -1;
    }
    return sumOfDiagoalFromLeft;
  }

  private static int rowSum(int[][] grid, int rowIx, int colIx, HashSet<Integer> numsVisited) {
    int sum = 0;
    for (int i = colIx; i < colIx + 3; i++) {
      if (grid[rowIx][i] < 1 || grid[rowIx][i] > 9) {
        return -1;
      }
      sum += grid[rowIx][i];
      numsVisited.add(grid[rowIx][i]);
    }
    return sum;
  }

  private static int colSum(int[][] grid, int rowIx, int colIx) {
    int sum = 0;
    for (int i = rowIx; i < rowIx + 3; i++) {
      if (grid[i][colIx] < 1 || grid[i][colIx] > 9) {
        return -1;
      }
      sum += grid[i][colIx];
    }
    return sum;
  }
}
