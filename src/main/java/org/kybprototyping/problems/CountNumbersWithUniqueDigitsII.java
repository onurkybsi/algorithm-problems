package org.kybprototyping.problems;

import java.util.HashSet;

final class CountNumbersWithUniqueDigitsII {

  private CountNumbersWithUniqueDigitsII() {}

  public static int numberCount(int a, int b) {
    int countOfNumbersWithUniqueDigits = 0;
    for (int i = a; i <= b; i++) {
      countOfNumbersWithUniqueDigits += hasUniqueDigits(i) ? 1 : 0;
    }
    return countOfNumbersWithUniqueDigits;
  }

  private static boolean hasUniqueDigits(int i) {
    HashSet<Integer> digits = new HashSet<>();

    int numOfDigits = 0;
    int remaing = i;
    while (remaing != 0) {
      digits.add(remaing % 10);
      remaing /= 10;

      numOfDigits++;
    }

    return digits.size() == numOfDigits;
  }

}
