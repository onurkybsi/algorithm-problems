package org.kybprototyping.problems;

import java.util.HashMap;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
final class NumberOfDiceRollsWithTargetSum {

  private static final int MODULO = 1_000_000_007;

  private int k;
  private HashMap<Pair, Integer> memo;

  public int numRollsToTarget(int n, int k, int target) {
    this.k = k;
    this.memo = new HashMap<>();
    return numRollsToTarget(n, target);
  }

  private int numRollsToTarget(int numsDimes, int target) {
    if (numsDimes == 0 && target == 0) {
      return 1;
    }
    if (numsDimes == 0 || target == 0) {
      return 0;
    }

    var stateVariables = new Pair(numsDimes, target);
    if (this.memo.containsKey(stateVariables)) {
      return this.memo.get(stateVariables);
    }

    int numRollsToTarget = 0;
    for (int i = 1; i <= this.k; i++) {
      if (target - i >= 0) {
        numRollsToTarget =
            (numRollsToTarget + (numRollsToTarget(numsDimes - 1, target - i) % MODULO)) % MODULO;
      }
    }

    this.memo.put(stateVariables, numRollsToTarget);
    return numRollsToTarget;
  }

  private record Pair(int first, int second) {
  }

}
