package org.kybprototyping.problems;

final class RotatingTheBox {
  private RotatingTheBox() {}

  public char[][] rotateTheBox(char[][] boxGrid) {
    int n = boxGrid.length;
    int m = boxGrid[0].length;

    char[][] answer = new char[m][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        answer[j][n - 1 - i] = boxGrid[i][j];
      }
    }

    for (int i = m - 1; i >= 0; i--) {
      for (int j = 0; j < n; j++) {
        if (answer[i][j] == '#') {
          setStone(answer, i, j);
        }
      }
    }
    return answer;
  }

  private static void setStone(char[][] grid, int i, int j) {
    int k = i + 1;
    while (k < grid.length && grid[k][j] == '.') {
      k++;
    }
    grid[i][j] = '.';
    grid[k - 1][j] = '#';
  }
}
