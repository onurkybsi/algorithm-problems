package org.kybprototyping.problems;

import java.util.Arrays;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.MODULE)
final class PaintHouse {

  private int[][] costs;
  private int[][] memo;

  public int minCost(int[][] costs) {
    this.costs = costs;
    this.memo = new int[costs.length][4];
    for (int[] row : this.memo) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }
    return minCost(0, 3);
  }

  public int minCost(int houseIx, int colorOfPrevious) {
    if (this.costs.length == houseIx) {
      return 0;
    }
    if (this.memo[houseIx][colorOfPrevious] != Integer.MAX_VALUE) {
      return this.memo[houseIx][colorOfPrevious];
    }

    int minCost = Integer.MAX_VALUE;
    if (colorOfPrevious != 0) {
      minCost = this.costs[houseIx][0] + minCost(houseIx + 1, 0);
    }
    if (colorOfPrevious != 1) {
      minCost = Math.min(minCost, this.costs[houseIx][1] + minCost(houseIx + 1, 1));
    }
    if (colorOfPrevious != 2) {
      minCost = Math.min(minCost, this.costs[houseIx][2] + minCost(houseIx + 1, 2));
    }

    this.memo[houseIx][colorOfPrevious] = minCost;
    return minCost;
  }

}
