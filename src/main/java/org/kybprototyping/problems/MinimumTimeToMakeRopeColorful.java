package org.kybprototyping.problems;

final class MinimumTimeToMakeRopeColorful {

  private String colors;
  private int[] neededTime;

  private MinimumTimeToMakeRopeColorful() {}

  public int minCost(String colors, int[] neededTime) {
    this.colors = colors;
    this.neededTime = neededTime;
    return minCost(0, (char) 0, 0);
  }

  private int minCost(int startingFrom, char lastColor, int lastColorCost) {
    if (startingFrom == this.colors.length()) {
      return 0;
    }

    char curColor = this.colors.charAt(startingFrom);
    int curBalloonCost = this.neededTime[startingFrom];

    if (curColor == lastColor) {
      return Math.min(curBalloonCost, lastColorCost)
          + minCost(startingFrom + 1, curColor, Math.max(curBalloonCost, lastColorCost));
    } else {
      return minCost(startingFrom + 1, curColor, this.neededTime[startingFrom]);
    }
  }

}
