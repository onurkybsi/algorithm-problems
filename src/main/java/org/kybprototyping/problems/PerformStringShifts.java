package org.kybprototyping.problems;

final class PerformStringShifts {

  private PerformStringShifts() {}

  public static String stringShift(String s, int[][] shift) {
    for (int[] shiftItem : shift) {
      if (shiftItem[0] == 0) {
        s = stringShiftLeft(s, shiftItem[1]);
      } else {
        s = stringShiftRight(s, shiftItem[1]);
      }
    }
    return s;
  }

  public static String stringShiftLeft(String s, int times) {
    int length = s.length();

    char[] newS = new char[length];
    for (int i = 0; i < length; i++) {
      int newIx = (i - (times % length) + length) % length;
      newS[newIx] = s.charAt(i);
    }

    return String.valueOf(newS);
  }

  public static String stringShiftRight(String s, int times) {
    int length = s.length();

    char[] newS = new char[length];
    for (int i = 0; i < length; i++) {
      int newIx = (i + times) % length;
      newS[newIx] = s.charAt(i);
    }

    return String.valueOf(newS);
  }

}
