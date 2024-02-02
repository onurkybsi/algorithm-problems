package org.kybprototyping.problems;

final class NumberOf1Bits {

  private NumberOf1Bits() {}

  public static int hammingWeight(int n) {
    int hammingWeight = 0;
    int mask = 1;
    for (int i = 0; i < 32; i++) {
      if ((n & mask) != 0) {
        hammingWeight++;
      }
      mask = mask << 1;
    }
    return hammingWeight;
  }

}
