package org.kybprototyping.problems;

final class FactorialTrailingZeroes {

  private FactorialTrailingZeroes() {}

  public static int trailingZeroes(int n) {
    int twosCount = 0;
    int fivesCount = 0;
    int temp;
    for (int i = 1; i <= n; i++) {
      temp = i;
      while (temp % 2 == 0) {
        twosCount++;
        temp /= 2;
      }

      temp = i;
      while (temp % 5 == 0) {
        fivesCount++;
        temp /= 5;
      }
    }
    return twosCount > fivesCount ? fivesCount : twosCount;
  }

}
