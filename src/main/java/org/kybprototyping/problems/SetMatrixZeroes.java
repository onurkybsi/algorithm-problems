package org.kybprototyping.problems;

import java.util.ArrayList;

final class SetMatrixZeroes {

  private SetMatrixZeroes() {}

  public static void setZeroes(int[][] matrix) {
    int n = matrix[0].length;
    int m = matrix.length;

    ArrayList<Integer> rowsToSetZero = new ArrayList<>();
    ArrayList<Integer> columnsToSetZero = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          rowsToSetZero.add(i);
          columnsToSetZero.add(j);
        }
      }
    }

    for (Integer row : rowsToSetZero) {
      for (int i = 0; i < matrix[0].length; i++) {
        matrix[row][i] = 0;
      }
    }
    for (Integer column : columnsToSetZero) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][column] = 0;
      }
    }
  }

}
