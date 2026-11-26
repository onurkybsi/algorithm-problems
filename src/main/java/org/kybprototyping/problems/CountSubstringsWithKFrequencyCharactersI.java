package org.kybprototyping.problems;

import java.util.HashMap;

final class CountSubstringsWithKFrequencyCharactersI {
  private CountSubstringsWithKFrequencyCharactersI() {
  }

  class Solution {
    public int numberOfSubstrings(String s, int k) {
      int ans = 0;
      var occurences = new HashMap<Character, Integer>();
      int left = 0;
      for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        int occurence = occurences.getOrDefault(c, 0);
        occurences.put(c, occurence + 1);

        if (occurence + 1 == k) {
          while (occurences.containsKey(c) && occurences.get(c) == k) {
            ans += s.length() - right;

            char cLeft = s.charAt(left++);
            int cLeftOccurence = occurences.get(cLeft);
            if (cLeftOccurence - 1 == 0) {
              occurences.remove(cLeft);
            } else {
              occurences.put(cLeft, cLeftOccurence - 1);
            }
          }
        } else {
          occurences.put(c, occurence + 1);
        }
      }
      return ans;
    }
  }
}
