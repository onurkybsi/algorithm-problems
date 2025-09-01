package org.kybprototyping.problems;

final class CheckIfStringIsAPrefixOfArray {

  private CheckIfStringIsAPrefixOfArray() {}

  public boolean isPrefixString(String s, String[] words) {
    int i = 0;
    for (String word : words) {
      if (s.indexOf(word, i) != i) {
        break;
      }
      i += word.length();
    }
    return i == s.length();
  }

}
