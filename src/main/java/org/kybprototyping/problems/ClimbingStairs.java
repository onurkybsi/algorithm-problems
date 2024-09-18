package org.kybprototyping.problems;

import java.util.HashMap;

final class ClimbingStairs {

  private ClimbingStairs() {}

  public static int climbStairs(int n) {
    return climbStairs(n, new HashMap<>());
  }

  public static int climbStairs(int n, HashMap<Integer, Integer> memo) {
    if (n == 1 || n == 2) {
      return n;
    }
    if (memo.containsKey(n)) {
      return memo.get(n);
    }

    int numOfWays = 0;
    numOfWays += climbStairs(n - 1, memo);
    numOfWays += climbStairs(n - 2, memo);
    memo.put(n, numOfWays);
    return numOfWays;
  }

}
