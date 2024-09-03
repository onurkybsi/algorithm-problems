package org.kybprototyping.problems;

final class RemoveAllAdjacentDuplicatesInString {

  private RemoveAllAdjacentDuplicatesInString() {}

  public static String removeDuplicates(String s) {
    StringBuilder finalStringBuilder = new StringBuilder(s);

    int i = 0;
    while (i < finalStringBuilder.length()) {
      if (i + 1 < finalStringBuilder.length()
          && finalStringBuilder.charAt(i) == finalStringBuilder.charAt(i + 1)) {
        finalStringBuilder.deleteCharAt(i);
        finalStringBuilder.deleteCharAt(i);
        i = Math.max(i - 1, 0);
      } else {
        i++;
      }
    }

    return finalStringBuilder.toString();
  }
}
