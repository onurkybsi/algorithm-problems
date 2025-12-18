package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

final class MinimumAreaRectangle {

  private MinimumAreaRectangle() {}

  public int minAreaRect(int[][] points) {
    HashSet<Point> pointsSet = new HashSet<Point>();
    HashMap<Integer, ArrayList<Point>> xPoints = new HashMap<>();
    HashMap<Integer, ArrayList<Point>> yPoints = new HashMap<>();
    for (var point : points) {
      int x = point[0];
      int y = point[1];
      var _point = new Point(x, y);

      var pointsAtX = xPoints.getOrDefault(x, new ArrayList<>());
      pointsAtX.add(_point);
      xPoints.put(x, pointsAtX);

      var pointsAtY = yPoints.getOrDefault(y, new ArrayList<>());
      pointsAtY.add(_point);
      yPoints.put(y, pointsAtY);

      pointsSet.add(_point);
    }

    int min = Integer.MAX_VALUE;
    for (var point : pointsSet) {
      min = Math.min(min, minAreaRectIncluding(pointsSet, xPoints, yPoints, point));
    }
    return min == Integer.MAX_VALUE ? 0 : min;
  }

  private int minAreaRectIncluding(HashSet<Point> pointsSet,
      HashMap<Integer, ArrayList<Point>> xPoints, HashMap<Integer, ArrayList<Point>> yPoints,
      Point point) {
    int min = Integer.MAX_VALUE;
    for (Point pointAtSameX : xPoints.get(point.x)) {
      if (pointAtSameX.equals(point)) {
        continue;
      }
      for (Point pointAtSameY : yPoints.get(point.y)) {
        Point forth = new Point(pointAtSameY.x, pointAtSameX.y);
        if (!pointsSet.contains(forth)) {
          continue;
        }
        if (pointAtSameY.equals(point) || pointAtSameY.equals(pointAtSameX)) {
          continue;
        }
        min = Math.min(min, Math.abs((point.y - pointAtSameX.y) * (point.x - pointAtSameY.x)));
      }
    }
    return min;
  }

  private record Point(int x, int y) {
  }

}
