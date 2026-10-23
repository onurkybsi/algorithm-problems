package org.kybprototyping.problems;

final class CouplesHoldingHands {
  CouplesHoldingHands() {
  }

  private int[] row;

  public int minSwapsCouples(int[] row) {
    this.row = row;
    return minSwapsCouples(0);
  }

  private int minSwapsCouples(int personIx) {
    if (personIx >= row.length - 1) {
      return 0;
    }
    int personId = row[personIx];
    int coupleIx = coupleIx(personId);
    if (coupleIx == personIx + 1) {
      return minSwapsCouples(personIx + 2);
    } else {
      int temp = row[personIx + 1];
      row[personIx + 1] = row[coupleIx];
      row[coupleIx] = temp;
      return 1 + minSwapsCouples(personIx + 2);
    }
  }

  private int coupleIx(int personId) {
    for (int i = 0; i < row.length; i++) {
      if (personId % 2 == 0 && row[i] == personId + 1) {
        return i;
      }
      if (personId % 2 == 1 && row[i] == personId - 1) {
        return i;
      }
    }
    throw new IllegalArgumentException();
  }
}
