package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.HashMap;

final class NumberOfMatchingSubsequences {

  private NumberOfMatchingSubsequences() {}

  public static int numMatchingSubseq(String s, String[] words) {
    HashMap<Character, ArrayList<Integer>> sCharMap = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      var indices = sCharMap.getOrDefault(s.charAt(i), new ArrayList<>());
      indices.add(i);
      sCharMap.put(s.charAt(i), indices);
    }

    int numMatchingSubseq = 0;
    ArrayList<String> alreadyMatched = new ArrayList<>();
    for (String word : words) {
      if (anyMatchContains(alreadyMatched, word)) {
        numMatchingSubseq++;
        continue;
      }
      if (isMatchingSubsequence(word, sCharMap)) {
        numMatchingSubseq++;
        alreadyMatched.add(word);
      }
    }
    return numMatchingSubseq;
  }

  private static boolean anyMatchContains(ArrayList<String> alreadyMatched, String word) {
    for (String matched : alreadyMatched) {
      if (matched.indexOf(word) != -1) {
        return true;
      }
    }
    return false;
  }

  private static boolean isMatchingSubsequence(String word,
      HashMap<Character, ArrayList<Integer>> sCharMap) {
    int lastMatchingIx = -1;
    for (int i = 0; i < word.length(); i++) {
      if (!sCharMap.containsKey(word.charAt(i))) {
        return false;
      }

      var matchingIx = firstAfter(sCharMap.get(word.charAt(i)), lastMatchingIx);
      if (matchingIx == -1) {
        return false;
      }

      lastMatchingIx = matchingIx;
    }
    return true;
  }

  private static int firstAfter(ArrayList<Integer> indices, int lowerBound) {
    for (Integer ix : indices) {
      if (ix > lowerBound) {
        return ix;
      }
    }
    return -1;
  }

}
