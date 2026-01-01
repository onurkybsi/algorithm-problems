package org.kybprototyping.problems;

import java.util.TreeSet;

final class MyCalendarI {
  private MyCalendarI() {}

  static class MyCalendar {
    private final TreeSet<int[]> events;

    public MyCalendar() {
      this.events = new TreeSet<>((e1, e2) -> Integer.compare(e1[0], e2[0]));
    }

    public boolean book(int startTime, int endTime) {
      int[] event = new int[] {startTime, endTime};
      int[] previousEvent = this.events.floor(event);
      int[] nextEvent = this.events.higher(event);
      if (previousEvent != null && previousEvent[0] == event[0]) {
        return false;
      }
      if (previousEvent != null && previousEvent[1] > event[0]) {
        return false;
      }
      if (nextEvent != null && nextEvent[0] < event[1]) {
        return false;
      }
      this.events.add(event);
      return true;
    }
  }
}
