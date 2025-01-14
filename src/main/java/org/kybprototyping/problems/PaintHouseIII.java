package org.kybprototyping.problems;

import java.util.Arrays;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
final class PaintHouseIII {

  private int[] houses;
  private int[][] cost;
  private int n;
  private int target;
  private int[][][] memo;

  public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
    this.houses = houses;
    this.cost = cost;
    this.n = n;
    this.target = target;
    this.memo = new int[houses.length][n + 1][target + 1];
    for (int[][] temp1 : this.memo) {
      for (int[] temp2 : temp1) {
        Arrays.fill(temp2, Integer.MAX_VALUE);
      }
    }
    return minCost(0, 0, 0);
  }

  public int minCost(int houseIx, int colorOfPrevious, int curNeighborhoods) {
    if (curNeighborhoods > target) {
      return -1;
    }
    if (houseIx == this.houses.length) {
      return curNeighborhoods == target ? 0 : -1;
    }
    if (this.memo[houseIx][colorOfPrevious][curNeighborhoods] != Integer.MAX_VALUE) {
      return this.memo[houseIx][colorOfPrevious][curNeighborhoods];
    }

    // Already painted
    int minCost = Integer.MAX_VALUE;
    if (this.houses[houseIx] != 0) {
      if (this.houses[houseIx] == colorOfPrevious) {
        minCost = minCost(houseIx + 1, this.houses[houseIx], curNeighborhoods);
      } else {
        minCost = minCost(houseIx + 1, this.houses[houseIx], curNeighborhoods + 1);
      }
    } else {
      for (int i = 1; i <= n; i++) {
        int costOfColorI = this.cost[houseIx][i - 1];

        if (i == colorOfPrevious) {
          int costOfRest = minCost(houseIx + 1, i, curNeighborhoods);
          if (costOfRest != -1) {
            minCost = Math.min(minCost, costOfColorI + costOfRest);
          }
        } else {
          int costOfRest = minCost(houseIx + 1, i, curNeighborhoods + 1);
          if (costOfRest != -1) {
            minCost = Math.min(minCost, costOfColorI + costOfRest);
          }
        }
      }
    }

    this.memo[houseIx][colorOfPrevious][curNeighborhoods] =
        minCost == Integer.MAX_VALUE ? -1 : minCost;
    return this.memo[houseIx][colorOfPrevious][curNeighborhoods];
  }

}
