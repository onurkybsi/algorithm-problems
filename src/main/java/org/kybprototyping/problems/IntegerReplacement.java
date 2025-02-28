package org.kybprototyping.problems;

import java.util.HashMap;

final class IntegerReplacement {

  private HashMap<Long, Integer> cache = new HashMap<>();

  private IntegerReplacement() {}

  public int integerReplacement(int n) {
    return integerReplacement((long) n);
  }

  private int integerReplacement(long n) {
    if (n == 1) {
      return 0;
    }
    if (cache.containsKey(n)) {
      return cache.get(n);
    }

    int minNumberOfOperations = 0;
    if (n % 2 == 0) {
      minNumberOfOperations = 1 + integerReplacement(n / 2);
    } else { // odd
      minNumberOfOperations = 1 + Math.min(integerReplacement(n + 1), integerReplacement(n - 1));
    }

    cache.put(n, minNumberOfOperations);
    return minNumberOfOperations;
  }

}
