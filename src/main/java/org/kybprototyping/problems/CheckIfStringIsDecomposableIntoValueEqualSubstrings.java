package org.kybprototyping.problems;

final class CheckIfStringIsDecomposableIntoValueEqualSubstrings {

  private CheckIfStringIsDecomposableIntoValueEqualSubstrings() {}

  public boolean isDecomposable(String s) {
    int numOfLengthTwoStr = 0;
    int numOfLengthThreeStr = 0;
    for (int i = 0; i < s.length();) {
      char c = s.charAt(i);
      int j = i;
      while (j < s.length() && j - i < 3 && s.charAt(j) == c) {
        j++;
      }

      if (j - i == 3) {
        numOfLengthThreeStr++;
      } else if (j - i == 2 && numOfLengthTwoStr != 0) {
        return false;
      } else if (j - i == 2) {
        numOfLengthTwoStr++;
      } else {
        return false;
      }

      i = j;
    }

    return numOfLengthTwoStr == 1 && numOfLengthThreeStr >= 0;
  }

}
