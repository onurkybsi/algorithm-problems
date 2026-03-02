package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.HashMap;

final class LonelyPixelI {
  private LonelyPixelI() {}

  public int findLonelyPixel(char[][] picture) {
    var rowsWithBlack = new HashMap<Integer, ArrayList<Cell>>();
    var colsWithBlack = new HashMap<Integer, ArrayList<Cell>>();
    for (int i = 0; i < picture.length; i++) {
      for (int j = 0; j < picture[0].length; j++) {
        if (picture[i][j] == 'B') {
          var cell = new Cell(i, j);

          var rowCells = rowsWithBlack.getOrDefault(i, new ArrayList<>());
          rowCells.add(cell);
          rowsWithBlack.put(i, rowCells);

          var columnCells = colsWithBlack.getOrDefault(j, new ArrayList<>());
          columnCells.add(cell);
          colsWithBlack.put(j, columnCells);
        }
      }
    }

    int answer = 0;
    for (var entry : rowsWithBlack.entrySet()) {
      var cells = entry.getValue();
      if (cells.size() > 1) {
        continue;
      }

      var cell = cells.get(0);
      if (colsWithBlack.get(cell.j).size() == 1) {
        answer++;
      }
    }
    return answer;
  }

  private record Cell(int i, int j) {
  }
}
