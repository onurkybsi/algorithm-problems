package org.kybprototyping.problems;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
final class BestTimeToBuyAndSellStockWithCooldown {

  private static int[] stockPrices;
  private static int[][] memo;

  public static int maxProfit(int[] prices) {
    stockPrices = prices;
    memo = new int[prices.length][3];
    return maxProfit(0, 1);
  }

  private static int maxProfit(int curDayIx, int operationPermitted) {
    if (curDayIx == stockPrices.length) {
      return 0;
    }
    if (memo[curDayIx][operationPermitted - 1] != 0) {
      return memo[curDayIx][operationPermitted - 1];
    }

    int maxProfit;
    if (operationPermitted == 1) { // buying
      maxProfit = Math.max(-stockPrices[curDayIx] + maxProfit(curDayIx + 1, 2),
          maxProfit(curDayIx + 1, operationPermitted));
    } else if (operationPermitted == 2) { // selling
      maxProfit = Math.max(stockPrices[curDayIx] + maxProfit(curDayIx + 1, 3),
          maxProfit(curDayIx + 1, operationPermitted));
    } else { // cooldown
      maxProfit = maxProfit(curDayIx + 1, 1);
    }

    memo[curDayIx][operationPermitted - 1] = maxProfit;
    return maxProfit;
  }

}
