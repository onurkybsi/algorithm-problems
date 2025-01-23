package org.kybprototyping.problems;

import java.util.PriorityQueue;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
final class KClosestPointsToOrigin {
  public int[][] kClosest(int[][] points, int k) {
    var priorityQueue =
        new PriorityQueue<Point>(k, (p1, p2) -> p2.distanceToOrigin - p1.distanceToOrigin);
    for (int[] point : points) {
      int distance = (point[0] * point[0]) + (point[1] * point[1]);
      if (priorityQueue.size() < k || distance < priorityQueue.peek().distanceToOrigin) {
        if (priorityQueue.size() == k) {
          priorityQueue.remove();
        }
        priorityQueue.add(new Point(point[0], point[1], distance));
      }
    }

    int[][] kClosest = new int[k][2];
    int i = 0;
    while (priorityQueue.size() > 0) {
      var point = priorityQueue.poll();
      kClosest[i][0] = point.x;
      kClosest[i][1] = point.y;
      i++;
    }
    return kClosest;
  }

  private record Point(int x, int y, int distanceToOrigin) {
  }
}
