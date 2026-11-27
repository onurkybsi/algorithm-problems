package org.kybprototyping.problems;

import java.util.HashMap;

final class MaximumLengthSubstringWithTwoOccurrences {
  private MaximumLengthSubstringWithTwoOccurrences() {
  }

  public int maximumLengthSubstring(String s) {
    int ans = 0;
    var occurences = new HashMap<Character, Integer>();
    int left = 0;
    for (int right = 0; right < s.length(); right++) {
      char cr = s.charAt(right);
      int occurence = occurences.getOrDefault(cr, 0);
      occurences.put(cr, occurence + 1);

      while (occurences.get(cr) > 2) {
        char cl = s.charAt(left++);
        occurence = occurences.get(cl);
        if (occurence == 1) {
          occurences.remove(cl);
        } else {
          occurences.put(cl, occurence - 1);
        }
      }

      if (occurences.get(cr) <= 2) {
        ans = Math.max(ans, right - left + 1);
      }
    }
    return ans;
  }
}
