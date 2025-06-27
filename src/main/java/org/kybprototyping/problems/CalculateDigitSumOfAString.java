package org.kybprototyping.problems;

final class CalculateDigitSumOfAString {

  private CalculateDigitSumOfAString() {}

  public String digitSum(String s, int k) {
    while (s.length() > k) {
      int i = 0;
      StringBuilder temp = new StringBuilder();
      while (i < s.length()) {
        var sub = s.substring(i, Math.min(i + k, s.length()));
        temp.append(calculateSum(sub));
        i += k;
      }
      s = temp.toString();
    }
    return s;
  }

  private static String calculateSum(String sub) {
    int sum = 0;
    for (int i = 0; i < sub.length(); i++) {
      sum += sub.charAt(i) - '0';
    }
    return String.valueOf(sum);
  }

}
