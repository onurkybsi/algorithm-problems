package org.kybprototyping.problems;

import java.util.HashMap;

final class CountTheNumberOfGoodSubarrays {
  private CountTheNumberOfGoodSubarrays() {
  }

  public long countGood(int[] nums, int k) {
    long ans = 0;
    var occurrences = new HashMap<Integer, Integer>();
    int pairCount = 0;
    int left = 0;
    for (int right = 0; right < nums.length; right++) {
      int occurence = occurrences.getOrDefault(nums[right], 0);
      occurrences.put(nums[right], occurence + 1);
      if (occurence == 1) {
        pairCount++;
      } else if (occurence > 1) {
        pairCount += occurence;
      }

      while (pairCount >= k) {
        ans += (nums.length - right);

        occurence = occurrences.get(nums[left]);
        occurrences.put(nums[left], occurence - 1);
        if (occurence == 2) {
          pairCount--;
        } else if (occurence > 2) {
          pairCount -= (occurence - 1);
        }
        left++;
      }
    }
    return ans;
  }
}
