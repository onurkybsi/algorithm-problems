package org.kybprototyping.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

final class SentenceSimilarity {

  private SentenceSimilarity() {}

  public boolean areSentencesSimilar(String[] sentence1, String[] sentence2,
      List<List<String>> similarPairs) {
    if (sentence1.length != sentence2.length) {
      return false;
    }
    HashMap<String, HashSet<String>> similarPairsMap = new HashMap<>();
    for (var similarPair : similarPairs) {
      var word1 = similarPairsMap.getOrDefault(similarPair.get(0), new HashSet<>());
      var word2 = similarPairsMap.getOrDefault(similarPair.get(1), new HashSet<>());
      word1.add(similarPair.get(1));
      word2.add(similarPair.get(0));
      similarPairsMap.put(similarPair.get(0), word1);
      similarPairsMap.put(similarPair.get(1), word2);
    }
    for (int i = 0; i < sentence1.length; i++) {
      if (sentence1[i].equals(sentence2[i])) {
        continue;
      }
      if (!similarPairsMap.containsKey(sentence1[i])) {
        return false;
      }
      if (!similarPairsMap.get(sentence1[i]).contains(sentence2[i])) {
        return false;
      }
    }
    return true;
  }

}
