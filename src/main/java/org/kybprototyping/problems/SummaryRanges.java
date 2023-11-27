package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.List;

public final class SummaryRanges {

  private SummaryRanges() {}

  // Time complexity: O(n), space complexity: O(n)
  public static List<String> summaryRanges(int[] nums) {
    List<String> result = new ArrayList<>();
    for (int i = 0; i < nums.length;) {
      int j = i + 1;
      while (j < nums.length && nums[j] - 1 == nums[j - 1]) {
        j++;
      }

      if (j == i + 1) {
        result.add(Integer.toString(nums[i]));
      } else {
        result.add("%s->%s".formatted(nums[i], nums[j - 1]));
      }

      i = j;
    }

    return result;
  }

}
