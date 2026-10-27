package org.kybprototyping.problems;

import java.math.BigInteger;

final class CountGoodNumbers {
  CountGoodNumbers() {
  }

  private static final BigInteger MOD = BigInteger.valueOf(1_000_000_007);

  public int countGoodNumbers(long n) {
    if (n == 1) {
      return 5;
    }
    BigInteger base = BigInteger.valueOf(20);
    BigInteger exp = BigInteger.valueOf(n / 2);
    BigInteger ans = base.modPow(exp, MOD);
    if (n % 2 == 1) {
      ans = ans.multiply(BigInteger.valueOf(5)).mod(MOD);
    }
    return ans.intValue();
  }
}
