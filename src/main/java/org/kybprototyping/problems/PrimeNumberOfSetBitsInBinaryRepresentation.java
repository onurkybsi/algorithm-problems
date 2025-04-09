package org.kybprototyping.problems;

import java.util.Set;

final class PrimeNumberOfSetBitsInBinaryRepresentation {

  private static final Set<Integer> primeNumbers = Set.of(2, 3, 5, 7, 11, 13, 17, 19);

  private PrimeNumberOfSetBitsInBinaryRepresentation() {}

  public int countPrimeSetBits(int left, int right) {
    int countPrimeSetBits = 0;
    for (int i = left; i <= right; i++) {
      if (hasPrimeNumberOfSetBits(i)) {
        countPrimeSetBits++;
      }
    }
    return countPrimeSetBits;
  }

  private boolean hasPrimeNumberOfSetBits(int i) {
    int numberOfSetBits = 0;
    while (i != 0) {
      if (i % 2 == 1) {
        numberOfSetBits++;
      }
      i /= 2;
    }
    return primeNumbers.contains(numberOfSetBits);
  }

}
