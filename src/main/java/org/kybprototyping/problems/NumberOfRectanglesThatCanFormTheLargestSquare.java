package org.kybprototyping.problems;

final class NumberOfRectanglesThatCanFormTheLargestSquare {

  private NumberOfRectanglesThatCanFormTheLargestSquare() {}

  public int countGoodRectangles(int[][] rectangles) {
    int maxLen = Integer.MIN_VALUE;
    int numOfMaxLen = 0;
    for (int[] rectangle : rectangles) {
      int min = Math.min(rectangle[0], rectangle[1]);
      if (min == maxLen) {
        numOfMaxLen++;
      }
      if (min > maxLen) {
        maxLen = min;
        numOfMaxLen = 1;
      }
    }
    return numOfMaxLen;
  }

}
