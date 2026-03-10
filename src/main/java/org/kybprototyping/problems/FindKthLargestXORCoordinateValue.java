package org.kybprototyping.problems;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

final class FindKthLargestXORCoordinateValue {
  private FindKthLargestXORCoordinateValue() {}

  public int kthLargestValue(int[][] matrix, int k) {
    var values = new int[matrix.length][matrix[0].length];
    var columnCache = new HashMap<Integer, Integer>();
    var valuesInOrder = new PriorityQueue<Integer>(Collections.reverseOrder());
    for (int i = 0; i < matrix.length; i++) {
      int columnVal = columnCache.getOrDefault(0, 0) ^ matrix[i][0];
      values[i][0] = columnVal;
      valuesInOrder.add(columnVal);
      columnCache.put(0, columnVal);

      for (int j = 1; j < matrix[0].length; j++) {
        int previousValue = values[i][j - 1];
        columnVal = columnCache.getOrDefault(j, 0) ^ matrix[i][j];
        values[i][j] = previousValue ^ columnVal;
        valuesInOrder.add(values[i][j]);
        columnCache.put(j, columnVal);
      }
    }

    for (int i = 1; i < k; i++) {
      valuesInOrder.poll();
    }
    return valuesInOrder.poll();
  }
}
