package org.kybprototyping.problems;

import java.util.HashMap;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
final class DominoAndTrominoTiling {

  private static final int MODULO = 1_000_000_007;

  private int n;
  private HashMap<Triple, Integer> memo;

  public int numTilings(int n) {
    this.n = n;
    this.memo = new HashMap<>();
    return numTilings(0, 0, 1, 0);
  }

  private int numTilings(int top, int bottom, int col, int numOfFilledCells) {
    if (col > this.n) {
      return numOfFilledCells == (this.n * 2) ? 1 : 0;
    }

    var stateVariables = new Triple(top, bottom, col);
    if (this.memo.containsKey(stateVariables)) {
      return this.memo.get(stateVariables);
    }

    if (top == 1 && bottom == 0) {
      if (col + 1 > this.n) {
        return 0;
      }

      int numTilings = (numTilings(0, 1, col + 1, numOfFilledCells + 2)
          + numTilings(0, 0, col + 2, numOfFilledCells + 3)) % MODULO;

      this.memo.put(stateVariables, numTilings);
      return numTilings;
    }

    if (top == 0 && bottom == 1) {
      if (col + 1 > this.n) {
        return 0;
      }

      int numTilings = (numTilings(1, 0, col + 1, numOfFilledCells + 2)
          + numTilings(0, 0, col + 2, numOfFilledCells + 3)) % MODULO;

      this.memo.put(stateVariables, numTilings);
      return numTilings;
    }

    // top == 0 && bottom == 0
    int numTilings = numTilings(0, 0, col + 1, numOfFilledCells + 2);
    if (col + 1 <= this.n) {
      numTilings = (numTilings + numTilings(0, 0, col + 2, numOfFilledCells + 4)) % MODULO;
      numTilings = (numTilings + numTilings(1, 0, col + 1, numOfFilledCells + 3)) % MODULO;
      numTilings = (numTilings + numTilings(0, 1, col + 1, numOfFilledCells + 3)) % MODULO;
    }

    this.memo.put(stateVariables, numTilings);
    return numTilings;
  }

  private record Triple(int first, int second, int third) {
  }

}
