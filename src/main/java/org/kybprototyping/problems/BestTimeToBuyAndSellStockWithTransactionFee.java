package org.kybprototyping.problems;

import java.util.Arrays;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
final class BestTimeToBuyAndSellStockWithTransactionFee {

  private int[] prices;
  private int fee;
  private int[][] memo;

  public int maxProfit(int[] prices, int fee) {
    this.prices = prices;
    this.fee = fee;
    this.memo = new int[prices.length][2];
    for (int[] memoRow : this.memo) {
      Arrays.fill(memoRow, -1);
    }
    return maxProfit(0, 1);
  }

  public int maxProfit(int dayIx, int isBuying) {
    if (dayIx == this.prices.length) {
      return 0;
    }
    if (this.memo[dayIx][isBuying] != -1) {
      return this.memo[dayIx][isBuying];
    }

    int maxProfit = maxProfit(dayIx + 1, isBuying);
    if (isBuying == 1) {
      maxProfit = Math.max(maxProfit, -this.prices[dayIx] + maxProfit(dayIx + 1, 0));
    } else {
      maxProfit = Math.max(maxProfit, -fee + this.prices[dayIx] + maxProfit(dayIx + 1, 1));
    }

    this.memo[dayIx][isBuying] = maxProfit;
    return maxProfit;
  }

}
