package org.kybprototyping.problems;

import java.util.PriorityQueue;

final class MaximumSumWithAtMostKElements {

  private MaximumSumWithAtMostKElements() {}

  public long maxSum(int[][] grid, int[] limits, int k) {
    PriorityQueue<Pair> queue =
        new PriorityQueue<>((p1, p2) -> -1 * Integer.compare(p1.first, p2.first));
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        queue.add(new Pair(grid[i][j], i));
      }
    }

    long maxSum = 0;
    while (k > 0) {
      Pair next = queue.poll();
      if (limits[next.second] > 0) {
        maxSum += next.first;
        limits[next.second] -= 1;
        k--;
      }
    }
    return maxSum;
  }

  private record Pair(int first, int second) {
  }
}
