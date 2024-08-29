package org.kybprototyping.problems;

import java.util.HashSet;

final class CheckIfNumberIsASumOfPowersOfThree {

  private CheckIfNumberIsASumOfPowersOfThree() {}

  public static boolean checkPowersOfThree(int n) {
    HashSet<Integer> alreadyUsedPowers = new HashSet<>();
    while (n >= 3) {
      int toSubstract = (int) Math.pow(3, biggestPowerLowerThan(n));
      if (alreadyUsedPowers.contains(toSubstract)) {
        return false;
      }

      alreadyUsedPowers.add(toSubstract);
      n -= toSubstract;
    }
    return n == 1 || n == 0;
  }

  private static int biggestPowerLowerThan(int n) {
    int biggestPower = 0;
    while (n >= 3) {
      biggestPower++;
      n /= 3;
    }
    return biggestPower;
  }

}
