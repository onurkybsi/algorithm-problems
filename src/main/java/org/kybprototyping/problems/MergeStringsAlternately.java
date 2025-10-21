package org.kybprototyping.problems;

final class MergeStringsAlternately {

  private MergeStringsAlternately() {}

  public String mergeAlternately(String word1, String word2) {
    int i = 0;
    int j = 0;
    StringBuilder b = new StringBuilder();
    while (i < word1.length() || j < word2.length()) {
      if (i < word1.length()) {
        b.append(word1.charAt(i));
      }
      if (j < word2.length()) {
        b.append(word2.charAt(j));
      }
      i++;
      j++;
    }
    return b.toString();
  }

}
