package org.kybprototyping.problems;

import java.util.ArrayList;

final class ReverseWordsInAString {

  private static final char SPACE = ' ';

  private ReverseWordsInAString() {}

  public static String reverseWords(String s) {
    ArrayList<Character> reversedWords = new ArrayList<>();
    for (int i = s.length() - 1; i >= 0;) {
      char c = s.charAt(i);

      if (c != SPACE) {
        ArrayList<Character> word = new ArrayList<>();
        word.add(c);
        i--;

        while (i >= 0) {
          c = s.charAt(i);
          if (c == SPACE) {
            break;
          }

          word.add(c);
          i--;
        }

        addAllInReverseOrder(word, reversedWords);
        reversedWords.add(SPACE);
      } else {
        i--;
      }
    }
    return toStringWithoutLastChar(reversedWords);
  }

  private static void addAllInReverseOrder(ArrayList<Character> chars1,
      ArrayList<Character> chars2) {
    for (int i = chars1.size() - 1; i >= 0; i--) {
      chars2.add(chars1.get(i));
    }
  }

  private static String toStringWithoutLastChar(ArrayList<Character> chars) {
    char[] str = new char[chars.size() - 1];
    for (int i = 0; i < chars.size() - 1; i++) {
      str[i] = chars.get(i);
    }
    return new String(str);
  }

}
