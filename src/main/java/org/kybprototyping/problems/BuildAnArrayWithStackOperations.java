package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.List;

final class BuildAnArrayWithStackOperations {
  private BuildAnArrayWithStackOperations() {}

  public List<String> buildArray(int[] target, int n) {
    List<String> stackOperations = new ArrayList<>();
    int i = 0;
    int streamNum = 1;
    while (i < target.length) {
      while (streamNum < target[i]) { // Push until next target
        stackOperations.add("Push");
        streamNum++;
      }

      int j = i == 0 ? streamNum - 1 : streamNum - 1 - target[i - 1];
      while (j > 0) { // Pop until previous target
        stackOperations.add("Pop");
        j--;
      }

      stackOperations.add("Push"); // Push the target
      streamNum++;
      i++;
    }
    return stackOperations;
  }
}
