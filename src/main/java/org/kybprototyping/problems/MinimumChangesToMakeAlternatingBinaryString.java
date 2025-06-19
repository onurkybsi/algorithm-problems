package org.kybprototyping.problems;

final class MinimumChangesToMakeAlternatingBinaryString {

  private MinimumChangesToMakeAlternatingBinaryString() {}

  public int minOperations(String s) {
    return Math.min(minOperations(s, s.charAt(0)), minOperations(s, otherOf(s.charAt(0))));
  }

  public int minOperations(String s, char startingChar) {
    int minOperations = 0;
    char previous = startingChar;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == previous) {
        previous = otherOf(previous);
        minOperations++;
      } else {
        previous = s.charAt(i);
      }
    }
    return minOperations;
  }

  private static char otherOf(char c) {
    if (c == '0') {
      return '1';
    }
    return '0';
  }

}
