package org.kybprototyping.problems;

final class MatrixSimilarityAfterCyclicShifts {

  private MatrixSimilarityAfterCyclicShifts() {}

  public boolean areSimilar(int[][] mat, int k) {
    int[][] matAfterShifts = new int[mat.length][];
    for (int i = 0; i < mat.length; i++) {
      int[] temp = new int[mat[i].length];
      for (int j = 0; j < mat[i].length; j++) {
        temp[ixAfterShifts(i, j, k, mat[i].length)] = mat[i][j];
      }
      matAfterShifts[i] = temp;
    }
    return equals(mat, matAfterShifts);
  }

  private static int ixAfterShifts(int row, int col, int k, int n) {
    if (row % 2 == 0) {
      return (((col - k) % (n)) + n) % n;
    } else {
      return (col + k) % (n);
    }
  }

  private static boolean equals(int[][] arr1, int[][] arr2) {
    for (int i = 0; i < arr1.length; i++) {
      for (int j = 0; j < arr1[0].length; j++) {
        if (arr1[i][j] != arr2[i][j]) {
          return false;
        }
      }
    }
    return true;
  }
}
