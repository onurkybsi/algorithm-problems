package org.kybprototyping.problems;

final class InsertInterval {

  private InsertInterval() {}

  public int[][] insert(int[][] intervals, int[] newInterval) {
    if (intervals.length == 0) {
      return new int[][] {newInterval};
    }

    int previousStartIx = findPreviousStartIx(intervals, newInterval[0]);
    if (previousStartIx >= 0 && intervals[previousStartIx][0] == newInterval[0]) {
      return merge(intervals, newInterval, previousStartIx);
    } else if (previousStartIx >= 0 && intervals[previousStartIx][0] < newInterval[0]
        && intervals[previousStartIx][1] >= newInterval[0]) {
      return merge(intervals, newInterval, previousStartIx);
    } else if (previousStartIx + 1 < intervals.length
        && intervals[previousStartIx + 1][0] == newInterval[0]) {
      return merge(intervals, newInterval, previousStartIx + 1);
    } else if (previousStartIx + 1 < intervals.length
        && intervals[previousStartIx + 1][0] > newInterval[0]
        && newInterval[1] >= intervals[previousStartIx + 1][0]) {
      return merge(intervals, newInterval, previousStartIx + 1);
    } else {
      int[][] newIntervals = new int[intervals.length + 1][2];
      for (int i = 0; i < newIntervals.length; i++) {
        if (i <= previousStartIx) {
          newIntervals[i] = intervals[i];
        } else if (i == previousStartIx + 1) {
          newIntervals[i] = newInterval;
        } else {
          newIntervals[i] = intervals[i - 1];
        }
      }
      return newIntervals;
    }
  }

  private static int[][] merge(int[][] intervals, int[] newInterval, int mergeStartIx) {
    int[] mergeInterval = intervals[mergeStartIx];
    if (newInterval[0] < mergeInterval[0]) {
      mergeInterval[0] = newInterval[0];
    }
    if (newInterval[1] > mergeInterval[1]) {
      mergeInterval[1] = newInterval[1];
    }

    int mergeEndIx = mergeStartIx;
    while (mergeEndIx < intervals.length && mergeInterval[1] >= intervals[mergeEndIx][0]) {
      mergeEndIx++;
    }
    mergeEndIx--;
    if (mergeEndIx <= mergeStartIx) {
      return intervals;
    }

    mergeInterval =
        new int[] {mergeInterval[0], Math.max(intervals[mergeEndIx][1], mergeInterval[1])};
    int newLength = intervals.length - (mergeEndIx - mergeStartIx);
    int[][] newIntervals = new int[newLength][2];
    for (int i = 0; i < newIntervals.length; i++) {
      if (i < mergeStartIx) {
        newIntervals[i] = intervals[i];
      } else if (i == mergeStartIx) {
        newIntervals[i] = mergeInterval;
      } else {
        newIntervals[i] = intervals[i + (mergeEndIx - mergeStartIx)];
      }
    }
    return newIntervals;
  }

  private static int findPreviousStartIx(int[][] intervals, int newIntervalStart) {
    int left = 0;
    int right = intervals.length - 1;
    while (left < right) {
      int middle = left + (right - left) / 2;
      if (intervals[middle][0] == newIntervalStart) {
        return middle;
      }

      if (intervals[middle][0] < newIntervalStart) {
        left = middle + 1;
      } else {
        right = middle - 1;
      }
    }
    return intervals[left][0] < newIntervalStart ? left : left - 1;
  }

}
