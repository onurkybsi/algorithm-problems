package org.kybprototyping.problems;

import java.util.HashMap;

final class IsomorphicStrings {

  public static boolean isIsomorphic(String s, String t) {
    HashMap<Character, Character> map = new HashMap<>(s.length());

    for (int i = 0; i < s.length(); i++) {
      char si = s.charAt(i);
      char ti = t.charAt(i);

      if (map.containsKey(si) && !map.get(si).equals(ti)) {
        return false;
      }
      if (map.containsKey(si) && map.get(si).equals(ti)) {
        continue;
      }
      if (map.containsValue(ti)) {
        return false;
      }

      map.put(si, ti);
    }

    return true;
  }

}
