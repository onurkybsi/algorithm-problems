package org.kybprototyping.problems;

final class MinimumOperationsToWriteTheLetterYOnAGrid {
  private MinimumOperationsToWriteTheLetterYOnAGrid() {}

  public int minimumOperationsToWriteY(int[][] grid) {
    int n = grid.length;

    int[] yValueOccurences = new int[3];
    int[] nonYValueOccurences = new int[3];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (doesBelongToY(n, i, j)) {
          yValueOccurences[grid[i][j]]++;
        } else {
          nonYValueOccurences[grid[i][j]]++;
        }
      }
    }

    int answer = Integer.MAX_VALUE;
    int numOfYCells = yValueOccurences[0] + yValueOccurences[1] + yValueOccurences[2];
    int numOfNonYCells = (n * n) - numOfYCells;
    for (int i = 0; i < 3; i++) {
      int yValueOccurence = yValueOccurences[i];
      for (int j = 0; j < 3; j++) {
        if (i != j) {
          int nonYValueOccurence = nonYValueOccurences[j];
          answer = Math.min(answer,
              (numOfNonYCells - nonYValueOccurence) + (numOfYCells - yValueOccurence));
        }
      }
    }
    return answer;
  }

  private static boolean doesBelongToY(int n, int i, int j) {
    if (i == j && i <= n / 2) {
      return true;
    }
    if (i < n / 2 && i + j == n - 1) {
      return true;
    }
    if (j == n / 2 && i >= n / 2) {
      return true;
    }
    return false;
  }
}
