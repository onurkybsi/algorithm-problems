package org.kybprototyping.problems;

final class MaximumAreaOfLongestDiagonalRectangle {

  private MaximumAreaOfLongestDiagonalRectangle() {}

  public int areaOfMaxDiagonal(int[][] dimensions) {
    double maxDiagonal = Double.MIN_VALUE;
    int[] dimensionOfMaxDiagonal = null;
    for (int[] dimension : dimensions) {
      double diagonal = diagonalOf(dimension[0], dimension[1]);
      if (diagonal > maxDiagonal) {
        maxDiagonal = diagonal;
        dimensionOfMaxDiagonal = dimension;
      } else if (diagonal == maxDiagonal && areaOf(dimension) > areaOf(dimensionOfMaxDiagonal)) {
        maxDiagonal = diagonal;
        dimensionOfMaxDiagonal = dimension;
      }
    }
    return dimensionOfMaxDiagonal[0] * dimensionOfMaxDiagonal[1];
  }

  private static double diagonalOf(int length, int width) {
    return Math.sqrt((length * length) + (width * width));
  }

  private static int areaOf(int[] dimension) {
    return dimension[0] * dimension[1];
  }

}
