package org.kybprototyping.problems;

import java.util.HashMap;
import java.util.List;

final class MaximumSumOfAlmostUniqueSubarray {
  private MaximumSumOfAlmostUniqueSubarray() {
  }

  public long maxSum(List<Integer> nums, int m, int k) {
    long ans = 0;
    var occurences = new HashMap<Integer, Integer>();
    long cur = 0;
    int left = 0;
    for (int right = 0; right < nums.size(); right++) {
      int num = nums.get(right);
      int occurence = occurences.getOrDefault(num, 0);
      occurences.put(num, occurence + 1);
      cur += num;

      if (right - left + 1 == k && occurences.size() >= m) {
        ans = Math.max(ans, cur);
      }
      if (right - left + 1 == k) {
        int numLef = nums.get(left++);
        remove(occurences, numLef);
        cur -= numLef;
      }
    }
    return ans;
  }

  private static void remove(HashMap<Integer, Integer> occurences, int num) {
    int occurence = occurences.getOrDefault(num, 0);
    if (occurence <= 1) {
      occurences.remove(num);
    } else {
      occurences.put(num, occurence - 1);
    }
  }
}
