package org.kybprototyping.problems;

final class FindValidMatrixGivenRowAndColumnSums {

  private FindValidMatrixGivenRowAndColumnSums() {}

  public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
    int[][] matrix = new int[rowSum.length][colSum.length];
    for (int i = 0; i < matrix.length; i++) {
      matrix[i][0] = rowSum[i];
    }

    for (int i = colSum.length - 1; i > 0; i--) {
      int targetSum = colSum[i];
      for (int j = 0; j < matrix.length; j++) {
        int temp = matrix[j][0];
        if (temp >= targetSum) {
          matrix[j][i] += targetSum;
          temp -= targetSum;
          matrix[j][0] = temp;
          break;
        } else {
          matrix[j][i] += temp;
          matrix[j][0] = 0;
          targetSum -= temp;
        }
      }
    }

    return matrix;
  }

}
