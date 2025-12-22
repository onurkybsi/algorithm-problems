package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.List;

final class PalindromePartitioning {

  private PalindromePartitioning() {}

  public List<List<String>> partition(String s) {
    return partition(s, 0, s.length() - 1);
  }

  public List<List<String>> partition(String s, int leftIx, int rightIx) {
    List<List<String>> answer = new ArrayList<>();
    for (int i = leftIx + 1; i <= rightIx + 1; i++) {
      String subStr = s.substring(leftIx, i);
      if (isPalindrome(subStr)) {
        var partitionsWithoutSubStr = partition(s, i, rightIx);
        if (partitionsWithoutSubStr.isEmpty()) {
          answer.add(new ArrayList<>(List.of(subStr)));
        } else {
          partitionsWithoutSubStr.forEach(p -> p.add(0, subStr));
          answer.addAll(partitionsWithoutSubStr);
        }
      }
    }
    return answer;
  }

  private static boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

}
