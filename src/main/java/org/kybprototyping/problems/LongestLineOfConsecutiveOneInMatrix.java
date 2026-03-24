package org.kybprototyping.problems;

final class LongestLineOfConsecutiveOneInMatrix {
  private LongestLineOfConsecutiveOneInMatrix() {}

  private int[][] mat;
  private int m;
  private int n;

  public int longestLine(int[][] mat) {
    this.mat = mat;
    this.m = mat.length;
    this.n = mat[0].length;

    int max = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (mat[i][j] == 1) {
          max = Math.max(max, longestLine(i, j));
        }
      }
    }
    return max;
  }

  private int longestLine(int startingI, int startingJ) {
    int max = horizontalLongestLine(startingI, startingJ);
    max = Math.max(max, verticalLongestLine(startingI, startingJ));
    max = Math.max(max, diagonalLongestLine(startingI, startingJ));
    max = Math.max(max, antiDiagonalLongestLine(startingI, startingJ));
    return max;
  }

  private int horizontalLongestLine(int startingI, int startingJ) {
    int j = startingJ + 1;
    while (j < n && mat[startingI][j] == 1) { // right
      j++;
    }
    int max = j - startingJ;

    j = startingJ - 1;
    while (j >= 0 && mat[startingI][j] == 1) { // left
      j--;
    }
    max = Math.max(max, startingJ - j);

    return max;
  }

  private int verticalLongestLine(int startingI, int startingJ) {
    int i = startingI + 1;
    while (i < m && mat[i][startingJ] == 1) { // bottom
      i++;
    }
    int max = i - startingI;

    i = startingI - 1;
    while (i >= 0 && mat[i][startingJ] == 1) { // top
      i--;
    }
    max = Math.max(max, startingI - i);

    return max;
  }

  private int diagonalLongestLine(int startingI, int startingJ) {
    int i = startingI + 1;
    int j = startingJ + 1;
    while (i < m && j < n && mat[i][j] == 1) {
      i++;
      j++;
    }
    return i - startingI;
  }

  private int antiDiagonalLongestLine(int startingI, int startingJ) {
    int i = startingI + 1;
    int j = startingJ - 1;
    while (i < m && j >= 0 && mat[i][j] == 1) {
      i++;
      j--;
    }
    return i - startingI;
  }
}
