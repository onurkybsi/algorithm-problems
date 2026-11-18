package org.kybprototyping.problems;

final class CountSubstringsThatSatisfyKConstraintI {
  private CountSubstringsThatSatisfyKConstraintI() {
  }

  public int countKConstraintSubstrings(String s, int k) {
    int ans = 0;
    int zeros = 0;
    int ones = 0;
    int left = 0;
    for (int right = 0; right < s.length(); right++) {
      zeros += s.charAt(right) == '0' ? 1 : 0;
      ones += s.charAt(right) == '1' ? 1 : 0;
      while (zeros > k && ones > k) {
        zeros -= s.charAt(left) == '0' ? 1 : 0;
        ones -= s.charAt(left) == '1' ? 1 : 0;
        left++;
      }
      ans += right - left + 1;
    }
    return ans;
  }
}
