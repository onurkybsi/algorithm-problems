package org.kybprototyping.problems;

final class PlusOne {

  private PlusOne() {}

  public static int[] plusOne(int[] digits) {
    int n = digits.length;

    if (digits[n - 1] + 1 < 10) {
      digits[n - 1]++;
      return digits;
    }

    int remainder = (digits[n - 1] + 1) / 10;
    digits[n - 1] = (digits[n - 1] + 1) % 10;
    for (int i = n - 2; i >= 0 && remainder > 0; i--) { // O(n-1)
      int newValue = digits[i] + remainder;
      digits[i] = newValue % 10;

      remainder = newValue >= 10 ? newValue / 10 : 0;
    }

    if (remainder > 0) {
      int[] newDigits = new int[digits.length + 1]; // O(n+1)
      newDigits[0] = remainder;
      for (int i = 1; i < newDigits.length; i++) { // O(n-1)
        newDigits[i] = digits[i - 1];
      }

      return newDigits;
    }

    return digits;
  }

}
