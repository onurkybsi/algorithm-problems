package org.kybprototyping.problems;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

final class RepeatedDNASequences {

  private RepeatedDNASequences() {}

  public List<String> findRepeatedDnaSequences(String s) {
    if (s.length() < 10) {
      return Collections.emptyList();
    }

    HashMap<String, Integer> repeatedDnaSequences = new HashMap<>();
    for (int i = 0; i <= s.length() - 10; i++) {
      String cur = s.substring(i, i + 10);
      int numOfOccurences = repeatedDnaSequences.getOrDefault(cur, 0);
      repeatedDnaSequences.put(cur, numOfOccurences + 1);
    }
    return repeatedDnaSequences.entrySet().stream().filter(rs -> rs.getValue() > 1)
        .map(rs -> rs.getKey()).toList();
  }

}
