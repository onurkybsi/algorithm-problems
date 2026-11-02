package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.List;

final class EmployeeFreeTime {
  EmployeeFreeTime() {
  }

  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    var intervals = new ArrayList<Interval>();
    for (var employee : schedule) {
      for (var interval : employee) {
        intervals.add(interval);
      }
    }
    intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

    var answer = new ArrayList<Interval>();
    int prevEnd = intervals.get(0).end;
    for (Interval interval : intervals) {
      if (interval.start > prevEnd) {
        answer.add(new Interval(prevEnd, interval.start));
      }
      prevEnd = Math.max(prevEnd, interval.end);
    }
    return answer;
  }

  static class Interval {
    public int start;
    public int end;

    public Interval() {
    }

    public Interval(int _start, int _end) {
      start = _start;
      end = _end;
    }
  };
}
