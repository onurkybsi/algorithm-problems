package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

final class GroupAnagrams {

  private GroupAnagrams() {}

  public static List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> groups = new ArrayList<>();

    HashSet<Integer> alreadyGrouped = new HashSet<>();
    for (int i = 0; i < strs.length; i++) {
      if (alreadyGrouped.contains(i)) {
        continue;
      }
      HashMap<Character, Integer> groupChars = extractChars(strs[i]);

      List<String> group = new ArrayList<>();
      group.add(strs[i]);
      for (int j = i + 1; j < strs.length; j++) {
        if (strs[i].length() != strs[j].length() || alreadyGrouped.contains(j)) {
          continue;
        }

        HashMap<Character, Integer> chars = extractChars(strs[j]);
        if (areSameCharsets(groupChars, chars)) {
          group.add(strs[j]);
          alreadyGrouped.add(j);
        }
      }

      groups.add(group);
    }

    return groups;
  }

  private static HashMap<Character, Integer> extractChars(String str) {
    HashMap<Character, Integer> chars = new HashMap<>(str.length());
    for (int i = 0; i < str.length(); i++) {
      int count = chars.getOrDefault(str.charAt(i), 0);
      chars.put(str.charAt(i), count + 1);
    }
    return chars;
  }

  private static boolean areSameCharsets(HashMap<Character, Integer> groupChars,
      HashMap<Character, Integer> chars) {
    if (groupChars.isEmpty() && chars.isEmpty()) {
      return true;
    }
    if (groupChars.isEmpty() || chars.isEmpty()) {
      return false;
    }

    for (Map.Entry<Character, Integer> groupChar : groupChars.entrySet()) {
      Integer charCount = chars.get(groupChar.getKey());
      if (charCount == null) {
        return false;
      }
      if (!charCount.equals(groupChar.getValue())) {
        return false;
      }
    }
    return true;
  }

}
