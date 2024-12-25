package org.kybprototyping.problems;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
final class BestTimeToBuyAndSellStockIV {

  private static int[] stockPrices;
  private static int[][][] memo;

  public static int maxProfit(int k, int[] prices) {
    stockPrices = prices;
    memo = new int[prices.length][k][2];
    return maxProfit(0, k, 1);
  }

  private static int maxProfit(int curDayIx, int numOfTransactionsRemaning, int isBuying) {
    if (curDayIx == stockPrices.length) {
      return 0;
    }
    if (numOfTransactionsRemaning == 0) {
      return 0;
    }
    if (memo[curDayIx][numOfTransactionsRemaning - 1][isBuying] != 0) {
      return memo[curDayIx][numOfTransactionsRemaning - 1][isBuying];
    }

    int maxProfit;
    int profitPassingTheDay = maxProfit(curDayIx + 1, numOfTransactionsRemaning, isBuying);
    if (isBuying == 1) {
      maxProfit =
          Math.max(-stockPrices[curDayIx] + maxProfit(curDayIx + 1, numOfTransactionsRemaning, 0),
              profitPassingTheDay);
    } else {
      maxProfit = Math.max(
          stockPrices[curDayIx] + maxProfit(curDayIx + 1, numOfTransactionsRemaning - 1, 1),
          profitPassingTheDay);
    }
    memo[curDayIx][numOfTransactionsRemaning - 1][isBuying] = maxProfit;
    return maxProfit;
  }

}
