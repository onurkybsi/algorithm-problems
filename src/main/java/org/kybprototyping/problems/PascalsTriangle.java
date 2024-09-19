package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.List;

final class PascalsTriangle {

  private PascalsTriangle() {}

  public static List<List<Integer>> generate(int numRows) {
    if (numRows == 1) {
      return List.of(List.of(1));
    }
    if (numRows == 2) {
      return List.of(List.of(1), List.of(1, 1));
    }

    var pascalsTriangle = generate(numRows - 1);
    return pascalsTriangleFrom(pascalsTriangle);
  }

  private static List<List<Integer>> pascalsTriangleFrom(List<List<Integer>> pascalsTriangle) {
    ArrayList<List<Integer>> pascalsTriangleWithNewRow = new ArrayList<>(pascalsTriangle);
    var newRow = new ArrayList<>(List.of(1));
    pascalsTriangleWithNewRow.add(newRow);
    var rowBeforeNewRow = pascalsTriangle.get(pascalsTriangle.size() - 1);
    for (int i = 0; i < rowBeforeNewRow.size() - 1; i++) {
      newRow.add(rowBeforeNewRow.get(i) + rowBeforeNewRow.get(i + 1));
    }
    newRow.add(1);
    return pascalsTriangleWithNewRow;
  }

}
