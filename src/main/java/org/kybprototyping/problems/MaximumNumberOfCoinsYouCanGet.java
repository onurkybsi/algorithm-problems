package org.kybprototyping.problems;

import java.util.Arrays;

final class MaximumNumberOfCoinsYouCanGet {

  private MaximumNumberOfCoinsYouCanGet() {}

  public int maxCoins(int[] piles) {
    Arrays.sort(piles);

    int maxCoins = 0;
    int numOfPilesToGet = piles.length / 3;
    int i = piles.length - 2;
    while (numOfPilesToGet > 0) {
      maxCoins += piles[i];
      i -= 2;
      numOfPilesToGet--;
    }
    return maxCoins;
  }

}
