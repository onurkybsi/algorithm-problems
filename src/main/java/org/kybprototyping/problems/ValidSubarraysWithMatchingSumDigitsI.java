package org.kybprototyping.problems;

final class ValidSubarraysWithMatchingSumDigitsI {
  private ValidSubarraysWithMatchingSumDigitsI() {
  }

  public int countValidSubarrays(int[] nums, int x) {
    int ans = 0;
    for (int i = 0; i < nums.length; i++) {
      long sum = 0;
      for (int j = i; j < nums.length; j++) {
        sum += nums[j];
        if (sum % 10 == x && firstDigit(sum) == x) {
          ans++;
        }
      }
    }
    return ans;
  }

  private static int firstDigit(long num) {
    while (num >= 10) {
      num /= 10;
    }
    return (int) num;
  }
}
