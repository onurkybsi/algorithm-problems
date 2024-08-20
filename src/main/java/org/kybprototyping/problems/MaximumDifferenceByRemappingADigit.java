package org.kybprototyping.problems;

final class MaximumDifferenceByRemappingADigit {

  private MaximumDifferenceByRemappingADigit() {}

  public static int minMaxDifference(int num) {
    int numOfDigits = findNumOfDigits(num);

    Integer toMapNine = findBiggestDigitIn(num, numOfDigits, 9);
    int max = mapIn(num, numOfDigits, toMapNine, 9);

    Integer toMapZero = findBiggestDigitIn(num, numOfDigits, 0);
    int min = mapIn(num, numOfDigits, toMapZero, 0);

    return max - min;
  }

  private static int findNumOfDigits(int num) {
    int numOfDigits = 0;
    while (num != 0) {
      num /= 10;
      numOfDigits++;
    }
    return numOfDigits;
  }

  private static Integer findBiggestDigitIn(int num, int numOfDigits, int otherThan) {
    while (numOfDigits > 0) {
      int divider = (int) Math.pow(10, --numOfDigits);
      int digit = num / divider;
      if (digit != otherThan) {
        return digit;
      }

      num -= digit * divider;
    }
    return null;
  }

  private static int mapIn(int num, int numOfDigits, Integer from, int to) {
    if (from == null) {
      return num;
    }

    int mapped = 0;
    for (int i = 0; i < numOfDigits; i++) {
      int digit = num % 10;
      if (digit == from.intValue()) {
        mapped += to * Math.pow(10, i);
      } else {
        mapped += digit * Math.pow(10, i);
      }

      num /= 10;
    }
    return mapped;
  }

}
