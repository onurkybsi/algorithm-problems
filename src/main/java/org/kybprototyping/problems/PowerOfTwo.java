package org.kybprototyping.problems;

final class PowerOfTwo {

  private PowerOfTwo() {}

  public boolean isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0;
  }

}
