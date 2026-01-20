package org.kybprototyping.problems;

final class SpiralMatrixII {
  private SpiralMatrixII() {}

  public int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];
    int startingIx = 0;
    int curNum = 1;
    for (int i = n; i > 0; i -= 2) {
      curNum = fillMatrix(matrix, i, startingIx, startingIx, curNum);
      startingIx++;
    }
    return matrix;
  }

  private static int fillMatrix(int[][] matrix, int size, int startingI, int startingJ,
      int curNum) {
    for (int j = startingJ; j < startingJ + size; j++) {
      matrix[startingI][j] = curNum++;
    }
    for (int i = startingI + 1; i < startingI + size; i++) {
      matrix[i][startingJ + size - 1] = curNum++;
    }
    for (int j = startingJ + size - 2; j >= startingJ; j--) {
      matrix[startingI + size - 1][j] = curNum++;
    }
    for (int i = startingI + size - 2; i > startingI; i--) {
      matrix[i][startingJ] = curNum++;
    }
    return curNum;
  }
}
