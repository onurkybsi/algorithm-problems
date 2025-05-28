package org.kybprototyping.problems;

final class FindNUniqueIntegersSumUpToZero {

  public int[] sumZero(int n) {
    if (n % 2 == 0) {
      int[] result = new int[n];
      for (int i = 0; i < n / 2; i++) {
        result[i] = i + 1;
        result[i + (n / 2)] = -result[i];
      }
      return result;
    } else {
      int[] result = new int[n];
      for (int i = 0; i < n / 2; i++) {
        result[i] = i + 1;
        result[i + (n / 2) + 1] = -result[i];
      }
      result[n / 2] = 0;
      return result;
    }
  }

}
