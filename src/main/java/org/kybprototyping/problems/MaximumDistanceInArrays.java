package org.kybprototyping.problems;

import java.util.List;
import java.util.PriorityQueue;

final class MaximumDistanceInArrays {
  private MaximumDistanceInArrays() {}

  // TODO: Can be improved. We don't need all mins and maxs. Only first twos.
  public int maxDistance(List<List<Integer>> arrays) {
    var mins = new PriorityQueue<Pair>((p1, p2) -> p1.second - p2.second);
    var maxs = new PriorityQueue<Pair>((p1, p2) -> p2.second - p1.second);
    for (int i = 0; i < arrays.size(); i++) {
      var arr = arrays.get(i);
      int minInArr = arr.get(0);
      int maxInArr = arr.get(arr.size() - 1);
      mins.add(new Pair(i, minInArr));
      maxs.add(new Pair(i, maxInArr));
    }

    while (mins.peek().first == maxs.peek().first) {
      var min = mins.poll();
      if (mins.isEmpty()) {
        mins.add(min);
        continue;
      }
      var max = maxs.poll();
      if (maxs.isEmpty()) {
        maxs.add(max);
        continue;
      }
      if (maxs.peek().second - min.second >= max.second - mins.peek().second) {
        mins.add(min);
      } else {
        maxs.add(max);
      }
    }
    return maxs.peek().second - mins.peek().second;
  }

  private record Pair(int first, int second) {
  }
}
