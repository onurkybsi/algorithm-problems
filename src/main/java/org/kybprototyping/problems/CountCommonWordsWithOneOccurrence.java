package org.kybprototyping.problems;

import java.util.HashMap;

final class CountCommonWordsWithOneOccurrence {

  private CountCommonWordsWithOneOccurrence() {}

  public int countWords(String[] words1, String[] words2) {
    HashMap<String, Integer> words1Map = new HashMap<>();
    for (String word : words1) {
      int occurences = words1Map.getOrDefault(word, 0);
      words1Map.put(word, occurences + 1);
    }
    HashMap<String, Integer> words2Map = new HashMap<>();
    for (String word : words2) {
      int occurences = words2Map.getOrDefault(word, 0);
      words2Map.put(word, occurences + 1);
    }

    int commonWordsCount = 0;
    for (var word : words1Map.entrySet()) {
      if (word.getValue() == 1) {
        int occurencesInWords2 = words2Map.getOrDefault(word.getKey(), 0);
        if (occurencesInWords2 == 1) {
          commonWordsCount++;
        }
      }
    }
    return commonWordsCount;
  }

}
