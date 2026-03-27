package org.kybprototyping.problems;

import java.util.ArrayList;

final class CountSubmatricesWithEqualFrequencyOfXAndY {
  private CountSubmatricesWithEqualFrequencyOfXAndY() {}

  public int numberOfSubmatrices(char[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int ans = 0;
    ArrayList<Range> cache = new ArrayList<>();

    int xCount = 0;
    int yCount = 0;
    for (int j = 0; j < n; j++) {
      if (grid[0][j] == 'X') {
        xCount++;
      }
      if (grid[0][j] == 'Y') {
        yCount++;
      }

      var range = new Range(j + 1, xCount, yCount);
      cache.add(range);
      if (range.isValidSubmatrix()) {
        ans++;
      }
    }
    for (int i = 1; i < m; i++) {
      xCount = 0;
      yCount = 0;
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 'X') {
          xCount++;
        }
        if (grid[i][j] == 'Y') {
          yCount++;
        }

        var previousRow = cache.get(j);
        var curRow = new Range(j + 1, previousRow.xCount + xCount, previousRow.yCount + yCount);
        if (curRow.isValidSubmatrix()) {
          ans++;
        }
        cache.set(j, curRow);
      }
    }

    return ans;
  }

  private record Range(int col, int xCount, int yCount) {
    private boolean isValidSubmatrix() {
      return xCount >= 1 && xCount == yCount;
    }
  }
}
