package org.kybprototyping.problems;

import java.util.Collections;
import java.util.List;

final class ValidWordSquare {
  public boolean validWordSquare(List<String> words) {
    int rowMax = words.size();
    int colMax =
        Collections.max(words, (w1, w2) -> Integer.compare(w1.length(), w2.length())).length();
    if (rowMax != colMax) {
      return false;
    }
    for (int i = 1; i <= rowMax; i++) {
      if (!areTheySame(words, i)) {
        return false;
      }
    }
    return true;
  }

  private static boolean areTheySame(List<String> words, int k) {
    String s1 = words.get(k - 1);
    StringBuilder s2 = new StringBuilder();
    for (String word : words) {
      if (word.length() >= k) {
        s2.append(word.charAt(k - 1));
      }
    }
    return s1.equals(s2.toString());
  }
}
