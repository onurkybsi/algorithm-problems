package org.kybprototyping.problems;

import java.util.Stack;

final class RemoveAllAdjacentDuplicatesInStringII {

  private RemoveAllAdjacentDuplicatesInStringII() {}

  // Brute-force, time limit exceeded.
  // public String removeDuplicates(String s, int k) {
  // int i = 0;
  // int j = 0;
  // StringBuilder b = new StringBuilder(s);
  // while (i < b.length()) {
  // char c = b.charAt(i);
  // j = i + 1;
  // while (j < b.length() && b.charAt(j) == c) {
  // j++;
  // }

  // if ((j - i) % k == 0) {
  // b.delete(i, j);
  // i = 0;
  // } else {
  // i++;
  // }
  // }
  // return b.toString();
  // }

  public String removeDuplicates(String s, int k) {
    Stack<Tuple> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (stack.isEmpty()) {
        stack.add(new Tuple(c, 1));
      } else {
        Tuple t = stack.peek();

        if (t.c() == c && t.occurence() + 1 == k) {
          stack.pop();
        } else if (t.c() == c) {
          Tuple increased = new Tuple(c, t.occurence() + 1);
          stack.pop();
          stack.add(increased);
        } else {
          stack.add(new Tuple(c, 1));
        }
      }
    }

    StringBuilder b = new StringBuilder();
    while (!stack.isEmpty()) {
      Tuple t = stack.pop();
      for (int i = 0; i < t.occurence(); i++) {
        b.append(t.c());
      }
    }
    return b.reverse().toString();
  }

  private record Tuple(char c, int occurence) {
  }
}
