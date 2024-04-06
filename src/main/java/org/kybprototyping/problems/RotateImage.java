package org.kybprototyping.problems;

final class RotateImage {

  private RotateImage() {}

  public static void rotate(int[][] matrix) {
    int n = matrix.length;

    int[][] temp = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int tempI = j;
        int tempJ = n - i - 1;
        temp[tempI][tempJ] = matrix[i][j];
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = temp[i][j]; // NOSONAR
      }
    }
  }

}
