package org.kybprototyping.problems;

import java.util.HashSet;

final class DistinctPointsReachableAfterSubstringRemoval {
  private DistinctPointsReachableAfterSubstringRemoval() {
  }

  public int distinctPoints(String s, int k) {
    int x = 0;
    int y = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      x = moveX(x, c);
      y = moveY(y, c);
    }

    HashSet<String> distinctPoints = new HashSet<>();
    int left = 0;
    for (int right = 0; right < s.length(); right++) {
      char c = s.charAt(right);
      x = rollbackX(x, c);
      y = rollbackY(y, c);
      if (right - left + 1 == k) {
        distinctPoints.add(x + "," + y);
        left++;
        c = s.charAt(left - 1);
        x = moveX(x, c);
        y = moveY(y, c);
      }
    }
    return distinctPoints.size();
  }

  private static int moveX(int x, char c) {
    return switch (c) {
      case 'U' -> x;
      case 'D' -> x;
      case 'L' -> x - 1;
      case 'R' -> x + 1;
      default -> throw new IllegalArgumentException();
    };
  }

  private static int moveY(int y, char c) {
    return switch (c) {
      case 'U' -> y + 1;
      case 'D' -> y - 1;
      case 'L' -> y;
      case 'R' -> y;
      default -> throw new IllegalArgumentException();
    };
  }

  private static int rollbackX(int x, char c) {
    return switch (c) {
      case 'U' -> x;
      case 'D' -> x;
      case 'L' -> x + 1;
      case 'R' -> x - 1;
      default -> throw new IllegalArgumentException();
    };
  }

  private static int rollbackY(int y, char c) {
    return switch (c) {
      case 'U' -> y - 1;
      case 'D' -> y + 1;
      case 'L' -> y;
      case 'R' -> y;
      default -> throw new IllegalArgumentException();
    };
  }
}
