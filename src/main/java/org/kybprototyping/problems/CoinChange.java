package org.kybprototyping.problems;

import java.util.HashMap;

final class CoinChange {

  private static final HashMap<Pair, Integer> memo = new HashMap<>();

  private CoinChange() {}

  public static int coinChange(int[] coins, int amount) {
    return coinChange(coins, amount, 0);
  }

  private static int coinChange(int[] coins, int amount, int curIx) {
    var pair = new Pair(amount, curIx);

    if (amount == 0) {
      memo.put(pair, 0);
      return 0;
    }
    if (curIx == coins.length) {
      memo.put(pair, -1);
      return -1;
    }
    if (memo.containsKey(pair)) {
      return memo.get(pair);
    }

    int i = 0;
    int min = Integer.MAX_VALUE;
    while ((coins[curIx] * i) <= amount && i < min) {
      int temp = coinChange(coins, amount - (coins[curIx] * i), curIx + 1);
      if (temp != -1) {
        min = Math.min(min, i + temp);
      }
      i++;
    }

    if (min == Integer.MAX_VALUE) {
      memo.put(pair, -1);
      return -1;
    } else {
      memo.put(pair, min);
      return min;
    }
  }

  private record Pair(int first, int second) {
  }

}
