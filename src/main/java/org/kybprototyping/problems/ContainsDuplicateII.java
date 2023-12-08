package org.kybprototyping.problems;

import java.util.HashMap;

final class ContainsDuplicateII {

  private ContainsDuplicateII() {}

  // Time complexity: O(n), space complexity: O(1)
  public static boolean containsNearbyDuplicate(int[] nums, int k) {
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length && j <= k + i; j++) {
        if (nums[i] == nums[j]) {
          return true;
        }
      }
    }
    return false;
  }

  // Time complexity: O(n), space complexity: O(n)
  public static boolean containsNearbyDuplicateWithHashMap(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      Integer ix = map.get(nums[i]);
      if (ix == null) {
        map.put(nums[i], i);
      } else if (i - ix > k) {
        map.put(nums[i], i);
      } else {
        return true;
      }
    }
    return false;
  }

}
