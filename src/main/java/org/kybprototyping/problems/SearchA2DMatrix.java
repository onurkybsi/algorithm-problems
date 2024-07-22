package org.kybprototyping.problems;

final class SearchA2DMatrix {

  private SearchA2DMatrix() {}

  public static boolean searchMatrix(int[][] matrix, int target) {
    return binarySearch(matrix, target) != -1;
  }

  private static int binarySearch(int[][] matrix, int target) {
    int l = 0, r = (matrix[0].length * matrix.length) - 1;

    while (l <= r) {
      int m = l + (r - l) / 2;
      int mVal = get(m, matrix);

      if (mVal == target) {
        return m;
      }

      if (mVal < target) {
        l = m + 1;
      } else {
        r = m - 1;
      }
    }

    return -1;
  }

  private static int get(int ix, int[][] matrix) {
    int i = ix / matrix[0].length;
    int j = ix % matrix[0].length;
    return matrix[i][j];
  }

}
