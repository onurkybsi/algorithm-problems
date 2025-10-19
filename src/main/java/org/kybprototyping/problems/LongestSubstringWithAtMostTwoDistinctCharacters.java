package org.kybprototyping.problems;

import java.util.HashMap;

final class LongestSubstringWithAtMostTwoDistinctCharacters {

  private LongestSubstringWithAtMostTwoDistinctCharacters() {}

  public int lengthOfLongestSubstringTwoDistinct(String s) {
    int maxLength = Integer.MIN_VALUE;
    int left = 0;
    int right = 0;
    int cur = 0;
    boolean isLeftMove = false;
    HashMap<Character, Integer> charOccurences = new HashMap<>();
    while (cur < s.length()) {
      char c = s.charAt(cur);

      if (!isLeftMove) {
        int occurence = charOccurences.getOrDefault(c, 0);
        charOccurences.put(c, occurence + 1);
      }

      if (charOccurences.size() <= 2) {
        maxLength = Math.max(maxLength, right - left + 1);

        cur = ++right;
        isLeftMove = false;
      } else {
        char toRemove = s.charAt(left);
        int toRemoveOccurence = charOccurences.get(toRemove);
        if (toRemoveOccurence == 1) {
          charOccurences.remove(toRemove);
        } else {
          charOccurences.put(toRemove, toRemoveOccurence - 1);
        }

        cur = ++left;
        isLeftMove = true;
      }
    }
    return maxLength;
  }

}
