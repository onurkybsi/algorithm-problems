package org.kybprototyping.problems;

import java.util.HashMap;

final class UncommonWordsFromTwoSentences {

  private UncommonWordsFromTwoSentences() {}

  public String[] uncommonFromSentences(String s1, String s2) {
    HashMap<String, Integer> wordOccurences = new HashMap<>();

    String[] s1Words = s1.split(" ");
    for (String s1Word : s1Words) {
      int occurences = wordOccurences.getOrDefault(s1Word, 0);
      wordOccurences.put(s1Word, occurences + 1);
    }

    String[] s2Words = s2.split(" ");
    for (String s2Word : s2Words) {
      int occurences = wordOccurences.getOrDefault(s2Word, 0);
      wordOccurences.put(s2Word, occurences + 1);
    }

    return wordOccurences.entrySet().stream().filter(e -> e.getValue() == 1).map(e -> e.getKey())
        .toArray(String[]::new);
  }
}
