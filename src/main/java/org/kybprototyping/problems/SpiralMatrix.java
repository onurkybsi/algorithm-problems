package org.kybprototyping.problems;

import java.util.LinkedHashSet;
import java.util.List;

final class SpiralMatrix {

  private SpiralMatrix() {}

  public static List<Integer> spiralOrder(int[][] matrix) {
    int rowSize = matrix.length;
    int columnSize = matrix[0].length;

    int i = 0;
    int j = 0;
    boolean isInJDirection = true;
    LinkedHashSet<IJ> spiralOrder = new LinkedHashSet<>();
    while (spiralOrder.size() < rowSize * columnSize) {
      spiralOrder.add(new IJ(i, j));

      int nextJ;
      if (isInJDirection) {
        nextJ = decideNextJ(matrix, i, j, spiralOrder);
        if (nextJ != j) {
          j = nextJ;
          continue;
        } else {
          isInJDirection = false;
        }
      }

      int nextI = decideNextI(matrix, i, j, spiralOrder);
      if (nextI != i) {
        i = nextI;
      } else {
        isInJDirection = true;
      }
    }

    return spiralOrder.stream().map(ij -> matrix[ij.i][ij.j]).toList();
  }

  private static int decideNextJ(int[][] matrix, int i, int j, LinkedHashSet<IJ> spiralOrder) {
    Integer rightVal = j + 1 < matrix[0].length ? matrix[i][j + 1] : null;
    if (rightVal != null && !spiralOrder.contains(new IJ(i, j + 1))) {
      return j + 1;
    }
    Integer leftVal = j - 1 >= 0 ? matrix[i][j - 1] : null;
    if (leftVal != null && !spiralOrder.contains(new IJ(i, j - 1))) {
      return j - 1;
    }
    return j;
  }

  private static int decideNextI(int[][] matrix, int i, int j, LinkedHashSet<IJ> spiralOrder) {
    Integer bottomVal = i + 1 < matrix.length ? matrix[i + 1][j] : null;
    if (bottomVal != null && !spiralOrder.contains(new IJ(i + 1, j))) {
      return i + 1;
    }
    Integer topVal = i - 1 >= 0 ? matrix[i - 1][j] : null;
    if (topVal != null && !spiralOrder.contains(new IJ(i - 1, j))) {
      return i - 1;
    }
    return i;
  }

  private static class IJ {

    private final int i;
    private final int j;

    private IJ(int i, int j) {
      this.i = i;
      this.j = j;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + i;
      result = prime * result + j;
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      IJ other = (IJ) obj;
      if (i != other.i)
        return false;
      return j == other.j;
    }

  }

}
