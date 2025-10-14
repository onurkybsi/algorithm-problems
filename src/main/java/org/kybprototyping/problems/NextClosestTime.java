package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

final class NextClosestTime {

  private NextClosestTime() {}

  public String nextClosestTime(String time) {
    HashSet<Integer> digits = new HashSet<>();
    List<Integer> cur = new ArrayList<>();
    digits.add(time.charAt(0) - 48);
    cur.add(time.charAt(0) - 48);
    digits.add(time.charAt(1) - 48);
    cur.add(time.charAt(1) - 48);
    digits.add(time.charAt(3) - 48);
    cur.add(time.charAt(3) - 48);
    digits.add(time.charAt(4) - 48);
    cur.add(time.charAt(4) - 48);

    do {
      cur = next(cur);
    } while (!cur.stream().allMatch(d -> digits.contains(d)));

    StringBuilder b = new StringBuilder();
    b.append(cur.get(0));
    b.append(cur.get(1));
    b.append(":");
    b.append(cur.get(2));
    b.append(cur.get(3));
    return b.toString();
  }

  private static List<Integer> next(List<Integer> cur) {
    int curMin = (10 * Integer.valueOf(cur.get(2))) + Integer.valueOf(cur.get(3));
    int nextMin = (curMin + 1) % 60;

    int nextHour = (10 * Integer.valueOf(cur.get(0))) + Integer.valueOf(cur.get(1));
    if (nextMin == 0) {
      nextHour = (nextHour + 1) % 24;
    }

    List<Integer> digits = new ArrayList<>();
    if (nextHour < 10) {
      digits.add(0);
      digits.add(nextHour);
    } else {
      digits.add(nextHour / 10);
      digits.add(nextHour % 10);
    }
    if (nextMin < 10) {
      digits.add(0);
      digits.add(nextMin);
    } else {
      digits.add(nextMin / 10);
      digits.add(nextMin % 10);
    }
    return digits;
  }
}
