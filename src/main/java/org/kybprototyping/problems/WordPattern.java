package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.HashMap;

final class WordPattern {

  private static final char SPACE = ' ';

  private WordPattern() {}

  public static boolean wordPattern(String pattern, String s) {
    ArrayList<String> splitS = splitInOrder(s);
    if (pattern.length() != splitS.size()) {
      return false;
    }

    HashMap<Character, String> mapWithCharKey = new HashMap<>();
    HashMap<String, Character> mapWithStringKey = new HashMap<>();
    for (int i = 0; i < pattern.length(); i++) {
      char c = pattern.charAt(i);
      String str = splitS.get(i);

      Character cInMap = mapWithStringKey.get(str);
      String strInMap = mapWithCharKey.get(c);

      if (strInMap != null && !strInMap.equals(str)) {
        return false;
      }
      if (cInMap != null && !cInMap.equals(c)) {
        return false;
      }
      if (strInMap == null) {
        mapWithCharKey.put(c, str);
      }
      if (cInMap == null) {
        mapWithStringKey.put(str, c);
      }
    }

    return true;
  }

  private static ArrayList<String> splitInOrder(String s) {
    ArrayList<String> splitS = new ArrayList<>();
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == SPACE) {
        splitS.add(b.toString());
        b.setLength(0);
      } else if (i == s.length() - 1) {
        b.append(s.charAt(i));
        splitS.add(b.toString());
      } else {
        b.append(s.charAt(i));
      }
    }
    return splitS;
  }

}
