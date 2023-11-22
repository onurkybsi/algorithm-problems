package org.kybprototyping.problems;

import java.util.HashMap;

final class FirstUniqueCharacterInAString {

  private FirstUniqueCharacterInAString() {}

  // Brute force solution, Time complexity: O(n),
  // space complexity: O(1) (because 's' consists of only lowercase English letters.)
  public static int firstUniqChar(String s) {
    HashMap<Character, Integer> cache = new HashMap<>();
    for (int i = 0; i < s.length(); i++) { // O(n)
      char c = s.charAt(i); // O(1)

      Integer v = cache.getOrDefault(c, 0); // O(1)
      cache.put(c, v + 1); // O(1)
    }

    for (int i = 0; i < s.length(); i++) { // O(n)
      char c = s.charAt(i); // O(1)

      if (cache.get(c).equals(1)) { // O(1)
        return i;
      }
    }

    return -1;
  }

}
