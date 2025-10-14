package org.kybprototyping.problems;

final class BackspaceStringCompare {

  private BackspaceStringCompare() {}

  public boolean backspaceCompare(String s, String t) {
    int i = s.length() - 1;
    int j = t.length() - 1;
    while (i >= 0 || j >= 0) {
      if (i >= 0) {
        i = next(s, i);
      }
      if (j >= 0) {
        j = next(t, j);
      }
      if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
        return false;
      }
      i--;
      j--;
    }
    return i == j;
  }

  private int next(String s, int ixFromEnd) {
    int numOfBackspaces = 0;
    int i = ixFromEnd;
    while (i >= 0) {
      if (s.charAt(i) == '#') {
        numOfBackspaces++;
      } else if (numOfBackspaces > 0) {
        numOfBackspaces--;
      } else {
        return i;
      }
      i--;
    }
    return i;
  }
}
