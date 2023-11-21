package org.kybprototyping.problems;

import java.util.HashMap;

final class MajorityElement {

  private MajorityElement() {}

  public static int majorityElement(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int newOccurenceCount = map.getOrDefault(nums[i], 0) + 1;
      if (newOccurenceCount > nums.length / 2) {
        return nums[i];
      }

      map.put(nums[i], newOccurenceCount);
    }

    throw new RuntimeException("Invalid input!");
  }

}
