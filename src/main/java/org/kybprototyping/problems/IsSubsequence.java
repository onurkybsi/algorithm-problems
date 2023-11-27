package org.kybprototyping.problems;

final class IsSubsequence {

  private IsSubsequence() {}

  public static boolean isSubsequence(String s, String t) {
    int i = 0;
    int lastIx = -1;
    while (i < s.length()) {
      char c = s.charAt(i);
      int ix = t.indexOf(c, lastIx + 1);

      if (ix == -1 || ix <= lastIx) {
        return false;
      }
      lastIx = ix;
      i++;
    }

    return true;
  }

}
