package org.kybprototyping.problems;

import java.util.HashSet;

final class HappyNumber {

  private HappyNumber() {}

  public static boolean isHappy(int n) {
    return isHappy(n, new HashSet<>());
  }

  private static boolean isHappy(int n, HashSet<Integer> alreadySeen) {
    if (alreadySeen.contains(n)) {
      return false;
    }

    int sum = sum(n);
    if (sum == 1) {
      return true;
    }

    alreadySeen.add(n);
    return isHappy(sum, alreadySeen);
  }

  private static int sum(int n) {
    int sum = 0;
    while (n != 0) {
      int digit = n % 10;
      sum += Math.pow(digit, 2);
      n /= 10;
    }
    return sum;
  }

}
