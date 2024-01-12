package org.kybprototyping.problems;

import java.util.HashMap;

final class RansomNote {

  private RansomNote() {}

  public static boolean canConstruct(String ransomNote, String magazine) {
    HashMap<Character, Integer> magazineLettersMap = new HashMap<>();
    for (int i = 0; i < magazine.length(); i++) {
      char c = magazine.charAt(i);
      int count = magazineLettersMap.getOrDefault(c, 0);
      magazineLettersMap.put(c, count + 1);
    }

    for (int i = 0; i < ransomNote.length(); i++) {
      char c = ransomNote.charAt(i);
      Integer cCountInMagazine = magazineLettersMap.get(c);
      if (cCountInMagazine == null || cCountInMagazine.equals(0)) {
        return false;
      } else {
        magazineLettersMap.put(c, cCountInMagazine - 1);
      }
    }

    return true;
  }

}
