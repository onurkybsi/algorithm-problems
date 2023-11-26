package org.kybprototyping.problems;

import java.util.HashMap;

public final class ValidAnagram {

  // Time complexity: O(n), space complexity: O(n)
  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    HashMap<Character, Integer> map = new HashMap<>(s.length());

    for (int i = 0; i < s.length(); i++) { // O(n)
      char c = s.charAt(i);
      Integer v = map.getOrDefault(c, 0);
      map.put(c, v + 1);
    }

    for (int i = 0; i < t.length(); i++) { // O(n)
      char c = t.charAt(i);
      Integer v = map.get(c);
      if (v == null) {
        return false;
      }

      map.put(c, v - 1);
    }

    for (Integer v : map.values()) { // O(n)
      if (!v.equals(0)) {
        return false;
      }
    }

    return true;
  }

}
