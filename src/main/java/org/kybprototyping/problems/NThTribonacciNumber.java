package org.kybprototyping.problems;

final class NThTribonacciNumber {

  private NThTribonacciNumber() {}

  public static int tribonacci(int n) {
    if (n == 0) {
      return 0;
    }
    if (n <= 2) {
      return 1;
    }

    int nMinusThree = 0, nMinusTwo = 1, nMinusOne = 1;
    for (int i = 3; i <= n; i++) {
      int tribonacciN = nMinusThree + nMinusTwo + nMinusOne;

      nMinusThree = nMinusTwo;
      nMinusTwo = nMinusOne;
      nMinusOne = tribonacciN;
    }
    return nMinusOne;
  }

}
