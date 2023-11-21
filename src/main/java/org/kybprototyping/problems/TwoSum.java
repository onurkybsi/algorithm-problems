package org.kybprototyping.problems;

import java.util.HashMap;

final class TwoSum {

  private TwoSum() {}

  // Brute force solution -- Time complexity: O(n^2), space complexity: O(1)
  public static int[] twoSum_V1(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[] {i, j};
        }
      }
    }

    throw new IllegalArgumentException("Invalid arguments!");
  }

  // Time complexity: O(n), space complexity: O(n)
  public static int[] twoSum_V2(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) { // O(n)
      if (map.containsKey(target - nums[i])) {
        return new int[] {i, map.get(target - nums[i])};
      } else {
        map.put(nums[i], i);
      }
    }

    throw new IllegalArgumentException("Invalid arguments!");
  }

}
