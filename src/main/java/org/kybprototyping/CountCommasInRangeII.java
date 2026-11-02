package org.kybprototyping;

final class CountCommasInRangeII {
  CountCommasInRangeII() {
  }

  public long countCommas(long n) {
    int digits = digits(n);
    if (digits < 4) {
      return 0;
    }

    long ans = 0;
    for (int i = 4; i < digits; i++) {
      // num of commas * count of numbers for the num of digits
      ans += ((i - 1) / 3) * (Math.pow(10, i) - Math.pow(10, i - 1));
    }
    ans += ((digits - 1) / 3) * ((n - Math.pow(10, digits - 1)) + 1);
    return ans;
  }

  private static int digits(long n) {
    int digits = 0;
    while (n != 0) {
      n /= 10;
      digits++;
    }
    return digits;
  }
}
