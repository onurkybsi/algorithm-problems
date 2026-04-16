package org.kybprototyping.problems;

final class MatrixBlockSum {
  private MatrixBlockSum() {}

  private int[][] mat;
  private int m;
  private int n;

  public int[][] matrixBlockSum(int[][] mat, int k) {
    this.mat = mat;
    this.m = mat.length;
    this.n = mat[0].length;

    int[][] answer = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        answer[i][j] = compute(k, i, j);
      }
    }
    return answer;
  }

  private int compute(int k, int i, int j) {
    int sum = 0;
    for (int r = Math.max(0, i - k); r <= Math.min(m - 1, i + k); r++) {
      for (int c = Math.max(0, j - k); c <= Math.min(n - 1, j + k); c++) {
        sum += mat[r][c];
      }
    }
    return sum;
  }
}
