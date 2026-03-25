package org.kybprototyping.problems;

final class SparseMatrixMultiplication {
  private SparseMatrixMultiplication() {}

  public int[][] multiply(int[][] mat1, int[][] mat2) {
    int m = mat1.length;
    int n = mat2[0].length;
    int[][] ans = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        ans[i][j] = multiply(mat1, mat2, i, j);
      }
    }
    return ans;
  }

  private static int multiply(int[][] mat1, int[][] mat2, int row, int col) {
    int ans = 0;
    for (int i = 0; i < mat1[0].length; i++) {
      ans += mat1[row][i] * mat2[i][col];
    }
    return ans;
  }
}
