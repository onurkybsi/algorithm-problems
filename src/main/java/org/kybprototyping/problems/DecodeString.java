package org.kybprototyping.problems;

import java.util.LinkedList;
import java.util.Queue;

final class DecodeString {

  private DecodeString() {}

  public String decodeString(String s) {
    Queue<String> queue = new LinkedList<>();
    for (int i = 0; i < s.length();) {
      char c = s.charAt(i);
      if (c == '[') {
        int numOfOpenBrackets = 1;
        int j = i + 1;
        while (numOfOpenBrackets > 0) {
          if (s.charAt(j) == '[') {
            numOfOpenBrackets++;
            j++;
          } else if (s.charAt(j) == ']') {
            numOfOpenBrackets--;
            j++;
          } else {
            j++;
          }
        }
        queue.add(decodeString(s.substring(i + 1, j - 1)));
        i = j;
      } else if (isInteger(c)) {
        StringBuilder b = new StringBuilder();
        int j = i;
        while (isInteger(s.charAt(j))) {
          b.append(s.charAt(j));
          j++;
        }
        queue.add(b.toString());
        i = j;
      } else {
        queue.add(String.valueOf(c));
        i++;
      }
    }
    return buildDecoded(queue);
  }

  private static String buildDecoded(Queue<String> queue) {
    StringBuilder b = new StringBuilder();
    int num = 1;
    while (!queue.isEmpty()) {
      String cur = queue.remove();
      if (isInteger(cur)) {
        num = Integer.parseInt(cur);
      } else {
        for (int i = 0; i < num; i++) {
          b.append(cur);
        }
        num = 1;
      }
    }
    return b.toString();
  }

  private static boolean isInteger(String s) {
    return s.charAt(0) >= 48 && s.charAt(0) < 58;
  }

  private static boolean isInteger(char c) {
    return c >= 48 && c < 58;
  }

}
