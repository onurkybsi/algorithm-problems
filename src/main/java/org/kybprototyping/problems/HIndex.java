package org.kybprototyping.problems;

import java.util.Arrays;

final class HIndex {

  private HIndex() {}

  public static int hIndex(int[] citations) {
    Arrays.sort(citations);

    int n = citations.length;

    for (int i = n; i >= 0; i--) {
      int frequency = 0;
      int j = n - 1;
      while (j >= 0 && citations[j] >= i) {
        frequency++;
        j--;
      }

      if (frequency >= i) {
        return i;
      }
    }

    return 0;
  }

}
