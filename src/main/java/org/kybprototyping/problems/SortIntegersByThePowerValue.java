package org.kybprototyping.problems;

import java.util.ArrayList;

final class SortIntegersByThePowerValue {
  private SortIntegersByThePowerValue() {}

  public int getKth(int lo, int hi, int k) {
    ArrayList<Pair> numberPowerPairs = new ArrayList<>();
    for (int i = lo; i <= hi; i++) {
      numberPowerPairs.add(new Pair(i, powerOf(i)));
    }
    numberPowerPairs.sort((p1, p2) -> {
      if (Integer.compare(p1.power, p2.power) != 0) {
        return Integer.compare(p1.power, p2.power);
      }
      return Integer.compare(p1.number, p2.number);
    });
    return numberPowerPairs.get(k - 1).number;
  }

  private int powerOf(int number) {
    int power = 0;
    while (number != 1) {
      if (number % 2 == 0) {
        number /= 2;
      } else {
        number = (3 * number) + 1;
      }
      power++;
    }
    return power;
  }

  private record Pair(int number, int power) {
  }
}
