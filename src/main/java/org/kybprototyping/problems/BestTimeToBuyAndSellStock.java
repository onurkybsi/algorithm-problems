package org.kybprototyping.problems;

import java.util.Arrays;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

final class BestTimeToBuyAndSellStock {

  public int maxProfit(int[] prices) {
    int minPrice = prices[0];
    int maxProfit = 0;
    for (int i = 0; i < prices.length; i++) {
      minPrice = Math.min(minPrice, prices[i]);

      if (prices[i] - minPrice > maxProfit) {
        maxProfit = prices[i] - minPrice;
      }
    }

    return maxProfit;
  }

  @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
  static class TopToBottom {

    private int[] prices;
    private int[][] memo;

    public int maxProfit(int[] prices) {
      this.prices = prices;
      this.memo = new int[prices.length][2];
      for (int[] m : this.memo)
        Arrays.fill(m, -1);
      return maxProfit(0, 1);
    }

    private int maxProfit(int ix, int isBuying) {
      if (ix == prices.length) {
        return 0;
      }
      if (this.memo[ix][isBuying] != -1) {
        return this.memo[ix][isBuying];
      }

      int maxProfit = 0;
      if (isBuying == 1) {
        maxProfit = Math.max(-prices[ix] + maxProfit(ix + 1, 0), maxProfit(ix + 1, isBuying));
      } else {
        maxProfit = Math.max(prices[ix], maxProfit(ix + 1, isBuying));
      }

      this.memo[ix][isBuying] = maxProfit;
      return maxProfit;
    }

  }

}
