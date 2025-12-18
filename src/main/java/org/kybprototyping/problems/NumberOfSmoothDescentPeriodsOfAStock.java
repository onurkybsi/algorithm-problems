package org.kybprototyping.problems;

final class NumberOfSmoothDescentPeriodsOfAStock {

  private NumberOfSmoothDescentPeriodsOfAStock() {}

  public long getDescentPeriods(int[] prices) {
    long descentPeriods = 0;
    int i = 0;
    while (i < prices.length) {
      int j = i + 1;
      while (j < prices.length) {
        if (prices[j] - prices[j - 1] == -1) {
          j++;
        } else {
          break;
        }
      }
      long n = j - i;
      descentPeriods += n * (n + 1) / 2;
      i = j;
    }
    return descentPeriods;
  }

}
