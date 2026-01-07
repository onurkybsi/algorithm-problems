package org.kybprototyping.problems;

final class GreatestCommonDivisorOfStrings {
  private GreatestCommonDivisorOfStrings() {}

  public String gcdOfStrings(String str1, String str2) {
    String shorter = str1.length() < str2.length() ? str1 : str2;
    String longer = shorter.equals(str1) ? str2 : str1;
    int dividerLength = shorter.length();
    while (dividerLength > 0) {
      String divider = shorter.substring(0, dividerLength);
      if (canBeDivided(shorter, divider) && canBeDivided(longer, divider)) {
        return divider;
      }
      dividerLength--;
    }
    return "";
  }

  private boolean canBeDivided(String dividend, String divider) {
    if (divider.equals(dividend)) {
      return true;
    }
    int i = 0;
    while (dividend.indexOf(divider, i) == i) {
      i += divider.length();
    }
    return i == dividend.length();
  }
}
