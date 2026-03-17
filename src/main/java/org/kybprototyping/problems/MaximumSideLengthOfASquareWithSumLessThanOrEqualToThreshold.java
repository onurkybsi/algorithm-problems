package org.kybprototyping.problems;

final class MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold {
  private MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold() {}

  private int[][] mat;
  private int m;
  private int n;
  private int threshold;

  public int maxSideLength(int[][] mat, int threshold) {
    this.mat = mat;
    this.m = mat.length;
    this.n = mat[0].length;
    this.threshold = threshold;

    int ans = 0;
    for (int j = 0; j < n; j++) {
      for (int i = 0; i < m; i++) {
        ans = Math.max(ans, maxSideLength(i, j));
      }
    }
    return ans;
  }

  private int maxSideLength(int i, int j) {
    if (mat[i][j] > threshold) {
      return 0;
    } else if (mat[i][j] == threshold) {
      return 1;
    } else {
      int ans = 1;
      int max = Math.min(m - i, n - j);
      int previous = mat[i][j];
      for (int k = 2; k <= max; k++) {
        int cur = 0;
        for (int l = j; l < j + k; l++) {
          cur += mat[i + k - 1][l];
        }
        for (int l = i; l < i + k - 1; l++) {
          cur += mat[l][j + k - 1];
        }
        if (previous + cur <= threshold) {
          ans = k;
          previous += cur;
        } else {
          return ans;
        }
      }
      return ans;
    }
  }
}
