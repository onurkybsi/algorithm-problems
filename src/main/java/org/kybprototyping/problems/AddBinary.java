package org.kybprototyping.problems;

final class AddBinary {

  private AddBinary() {}

  private static final char ONE = '1';

  public static String addBinary(String a, String b) {
    int ai = a.length() - 1;
    int bi = b.length() - 1;


    StringBuilder result = new StringBuilder();
    int remaning = 0;
    while (ai >= 0 || bi >= 0) {
      int ac = ai >= 0 && a.charAt(ai) == ONE ? 1 : 0;
      int bc = bi >= 0 && b.charAt(bi) == ONE ? 1 : 0;


      int sum = ac + bc + remaning;
      result.append(sum % 2);
      remaning = sum / 2;
      ai--;
      bi--;
    }
    if (remaning != 0)
      result.append('1');


    return result.reverse().toString();
  }

}
