package org.kybprototyping.problems;

import java.util.HashSet;
import java.util.List;

final class SubarraysDistinctElementSumOfSquaresI {
  SubarraysDistinctElementSumOfSquaresI() {
  }

  public int sumCounts(List<Integer> nums) {
    int answer = 0;
    for (int i = 0; i < nums.size(); i++) {
      var distinctValues = new HashSet<Integer>();
      for (int j = i; j < nums.size(); j++) {
        distinctValues.add(nums.get(j));
        answer += (distinctValues.size() * distinctValues.size());
      }
    }
    return answer;
  }
}
