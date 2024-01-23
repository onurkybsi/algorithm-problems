package org.kybprototyping.problems;

final class ValidPalindrome {

  private ValidPalindrome() {}

  public static boolean isPalindrome(String s) {
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isLetter(c) || Character.isDigit(c)) {
        b.append(Character.toLowerCase(c));
      }
    }

    String str = b.toString();
    String strReverse = b.reverse().toString();
    return str.equals(strReverse);
  }

}
