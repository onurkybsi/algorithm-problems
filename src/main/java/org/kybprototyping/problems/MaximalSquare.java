package org.kybprototyping.problems;

final class MaximalSquare {

  private MaximalSquare() {}

  public int maximalSquare(char[][] matrix) {
    int maxLength = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == '1') {
          maxLength = Math.max(maxLength, maximalEdge(matrix, i, j));
        }
      }
    }
    return maxLength * maxLength;
  }

  private static int maximalEdge(char[][] matrix, int startingI, int startingJ) {
    int horizontalLength = 1;
    for (int j = startingJ + 1; j < matrix[0].length && matrix[startingI][j] == '1'; j++) {
      horizontalLength++;
    }

    int verticalLength = 1;
    for (int i = startingI + 1; i < matrix.length && matrix[i][startingJ] == '1'
        && verticalLength < horizontalLength; i++) {
      verticalLength++;
    }

    int edgeLength = Math.min(horizontalLength, verticalLength);
    for (int i = startingI + 1; i < startingI + edgeLength; i++) {
      int j = startingJ + 1;
      while (j < startingJ + edgeLength && matrix[i][j] == '1') {
        j++;
      }
      edgeLength = 1 + (j - (startingJ + 1));
    }
    return edgeLength;
  }

}
