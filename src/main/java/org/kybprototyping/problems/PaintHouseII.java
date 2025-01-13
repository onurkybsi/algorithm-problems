package org.kybprototyping.problems;

import java.util.Arrays;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.MODULE)
final class PaintHouseII {

  private int[][] costs;
  private int numOfColors;
  private int[][] memo;

  public int minCostII(int[][] costs) {
    this.costs = costs;
    this.numOfColors = costs[0].length;
    this.memo = new int[costs.length][numOfColors + 1];
    for (int[] row : this.memo) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }
    return minCost(0, numOfColors);
  }

  public int minCost(int houseIx, int colorOfPrevious) {
    if (this.costs.length == houseIx) {
      return 0;
    }
    if (this.memo[houseIx][colorOfPrevious] != Integer.MAX_VALUE) {
      return this.memo[houseIx][colorOfPrevious];
    }

    int minCost = Integer.MAX_VALUE;
    for (int i = 0; i < numOfColors; i++) {
      if (colorOfPrevious != i) {
        minCost = Math.min(minCost, this.costs[houseIx][i] + minCost(houseIx + 1, i));
      }
    }

    this.memo[houseIx][colorOfPrevious] = minCost;
    return minCost;
  }

}
