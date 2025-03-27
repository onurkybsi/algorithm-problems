package org.kybprototyping.problems;

final class LargestTriangleArea {

  LargestTriangleArea() {}

  public double largestTriangleArea(int[][] points) {
    double largestTriangleArea = 0;
    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        for (int k = j + 1; k < points.length; k++) {
          double x1 = points[i][0], y1 = points[i][1];
          double x2 = points[j][0], y2 = points[j][1];
          double x3 = points[k][0], y3 = points[k][1];

          double area = 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));

          largestTriangleArea = Math.max(largestTriangleArea, area);
        }
      }
    }
    return largestTriangleArea;
  }

}
