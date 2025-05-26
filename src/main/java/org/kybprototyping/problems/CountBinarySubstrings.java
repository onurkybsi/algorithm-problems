package org.kybprototyping.problems;

final class CountBinarySubstrings {

  private CountBinarySubstrings() {}

  public int countBinarySubstrings(String s) {
    int binarySubstringsCount = 0;
    for (int i = 0; i < s.length();) {
      char ref = s.charAt(i);
      char other = s.charAt(i) == '1' ? '0' : '1';
      int refCount = 1;
      int otherCount = 0;
      int j = i + 1;
      while (j < s.length() && s.charAt(j) == ref) {
        refCount++;
        j++;
      }
      while (j < s.length() && s.charAt(j) == other && otherCount < refCount) {
        otherCount++;
        j++;
      }

      if (otherCount == refCount) {
        binarySubstringsCount += refCount;
        i += refCount;
      } else {
        i++;
      }
    }
    return binarySubstringsCount;
  }

}
