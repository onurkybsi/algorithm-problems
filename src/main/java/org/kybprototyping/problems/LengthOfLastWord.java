package org.kybprototyping.problems;

final class LengthOfLastWord {

  private static final char SPACE = 32;

  private LengthOfLastWord() {}

  public static int lengthOfLastWord(String s) {
    boolean building = false;
    StringBuilder lastWordBuilder = new StringBuilder();

    for (int i = s.length() - 1; i >= 0; i--) {
      char c = s.charAt(i);

      if (building && c == SPACE) {
        break;
      } else if (c != SPACE) {
        building = true;
        lastWordBuilder.append(c);
      }
    }

    return lastWordBuilder.length();
  }

}
