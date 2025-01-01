package org.kybprototyping.problems;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
final class CoinChange2 {

  private static int[] coins;
  private static Integer[][] memo;

  public static int change(int amount, int[] coins) {
    CoinChange2.coins = coins;
    CoinChange2.memo = new Integer[amount][coins.length];
    return change(amount, 0);
  }

  private static int change(int amount, int coinIx) {
    if (amount == 0) {
      return 1;
    }
    if (coinIx == coins.length) {
      return 0;
    }
    if (memo[amount - 1][coinIx] != null) {
      return memo[amount - 1][coinIx];
    }

    if (coins[coinIx] > amount) {
      memo[amount - 1][coinIx] = change(amount, coinIx + 1);
    } else {
      memo[amount - 1][coinIx] =
          change(amount - coins[coinIx], coinIx) + change(amount, coinIx + 1);
    }

    return memo[amount - 1][coinIx];
  }

}
