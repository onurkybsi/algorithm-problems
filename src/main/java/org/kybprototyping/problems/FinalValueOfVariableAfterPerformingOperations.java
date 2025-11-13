package org.kybprototyping.problems;

import java.util.Set;

final class FinalValueOfVariableAfterPerformingOperations {

  private FinalValueOfVariableAfterPerformingOperations() {}

  private static Set<String> incrementOperations = Set.of("X++", "++X");

  public int finalValueAfterOperations(String[] operations) {
    int ans = 0;
    for (String operation : operations) {
      if (incrementOperations.contains(operation)) {
        ans++;
      } else {
        ans--;
      }
    }
    return ans;
  }
}
