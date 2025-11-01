package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.stream.IntStream;

final class RandomPickWithWeight {

  private final int sum;
  private ArrayList<Range> ranges = new ArrayList<>();

  public RandomPickWithWeight(int[] w) {
    this.sum = IntStream.of(w).sum();

    java.math.BigDecimal previousLowerBound = java.math.BigDecimal.ZERO;
    for (int i = 0; i < w.length; i++) {
      java.math.BigDecimal probability = java.math.BigDecimal.valueOf((double) w[i] / sum)
          .setScale(2, java.math.RoundingMode.HALF_UP);
      var upperBound = previousLowerBound.add(probability);
      ranges.add(new Range(i, previousLowerBound, upperBound));

      previousLowerBound = upperBound;
    }

    ranges.sort((r1, r2) -> r1.lowerBound.compareTo(r2.upperBound));
  }

  public int pickIndex() {
    java.math.BigDecimal random =
        new java.math.BigDecimal(Math.round(Math.random() * 100.0) / 100.0).setScale(2,
            java.math.RoundingMode.HALF_UP);
    return findIx(random);
  }

  private int findIx(java.math.BigDecimal val) {
    var left = 0;
    var right = this.ranges.size() - 1;
    while (left <= right) {
      int middle = left + (right - left) / 2;
      Range range = this.ranges.get(middle);

      if (val.compareTo(range.lowerBound) >= 0 && val.compareTo(range.upperBound) < 0) {
        return range.ix;
      } else if (range.upperBound.compareTo(val) > 0) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }

    return this.ranges.size() - 1;
  }

  private record Range(int ix, java.math.BigDecimal lowerBound, java.math.BigDecimal upperBound) {
  }

}
