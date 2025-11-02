package org.kybprototyping.problems;

import java.util.stream.IntStream;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
final class LongestIncreasingSubsequence {

  public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    for (int i = nums.length - 1; i >= 0; i--) {
      int max = 1;
      for (int j = i + 1; j < dp.length; j++) {
        if (nums[i] < nums[j]) {
          max = Math.max(max, 1 + dp[j]);
        }
      }
      dp[i] = max;
    }
    return IntStream.of(dp).max().orElseThrow();
  }

}
