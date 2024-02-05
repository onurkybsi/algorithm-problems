package org.kybprototyping.problems;

import java.util.HashSet;

final class LongestConsecutiveSequence {

  private LongestConsecutiveSequence() {}

  public int longestConsecutive(int[] nums) {
    HashSet<Integer> uniqueNums = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      uniqueNums.add(nums[i]);
    }

    int longestConsecutive = 0;
    HashSet<Integer> alreadyIncluded = new HashSet<>();
    for (Integer uniqueNum : uniqueNums) {
      if (!alreadyIncluded.contains(uniqueNum)) {
        int lengthForUniqueNum = 1;

        int consecutive = uniqueNum + 1;
        while (uniqueNums.contains(consecutive)) {
          lengthForUniqueNum++;
          alreadyIncluded.add(consecutive);
          consecutive++;
        }

        if (lengthForUniqueNum > longestConsecutive) {
          longestConsecutive = lengthForUniqueNum;
        }
      }
    }
    return longestConsecutive;
  }

}
