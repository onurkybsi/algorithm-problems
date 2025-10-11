package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class StrobogrammaticNumberII {

  private StrobogrammaticNumberII() {}

  private static Map<String, String> matchingPairs =
      Map.of("0", "0", "1", "1", "6", "9", "8", "8", "9", "6");

  private int n;

  public List<String> findStrobogrammatic(int n) {
    this.n = n;

    List<String> strobogrammaticNumbers = new ArrayList<>();
    add(new StringBuilder(), 0, strobogrammaticNumbers);
    return strobogrammaticNumbers;
  }

  private void add(StringBuilder b, int curIx, List<String> strobogrammaticNumbers) {
    if (b.length() == this.n) {
      strobogrammaticNumbers.add(b.toString());
      return;
    }

    if (curIx < (this.n / 2)) {
      for (String num : matchingPairs.keySet()) {
        if (curIx == 0 && num.equals("0")) {
          continue;
        }

        StringBuilder _b = new StringBuilder(b);
        _b.append(num);
        add(_b, curIx + 1, strobogrammaticNumbers);
      }
    } else if ((this.n % 2 != 0) && curIx == this.n / 2) {
      add(new StringBuilder(b).append("0"), curIx + 1, strobogrammaticNumbers);
      add(new StringBuilder(b).append("1"), curIx + 1, strobogrammaticNumbers);
      add(new StringBuilder(b).append("8"), curIx + 1, strobogrammaticNumbers);
    } else {
      int matchingIx = this.n - curIx - 1;
      String matchingNum = matchingPairs.get(String.valueOf(b.charAt(matchingIx)));
      b.append(matchingNum);
      add(b, curIx + 1, strobogrammaticNumbers);
    }
  }
}
