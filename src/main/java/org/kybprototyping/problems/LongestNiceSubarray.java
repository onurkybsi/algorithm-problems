package org.kybprototyping.problems;

import java.util.HashSet;

final class LongestNiceSubarray {
  private LongestNiceSubarray() {
  }

  public int longestNiceSubarray(int[] nums) {
    int ans = 1;
    var occupied = new HashSet<Integer>();
    int left = 0;
    for (int right = 0; right < nums.length; right++) {
      while (!canAdd(nums[right], occupied)) {
        removeBits(nums[left++], occupied);
      }
      addBits(nums[right], occupied);
      ans = Math.max(ans, right - left + 1);
    }
    return ans;
  }

  private static boolean canAdd(int num, HashSet<Integer> occupied) {
    for (int i = 0; i < 32; i++) {
      if (((num >>> i) & 1) == 1 && occupied.contains(i)) {
        return false;
      }
    }
    return true;
  }

  private static void addBits(int num, HashSet<Integer> occupied) {
    for (int i = 0; i < 32; i++) {
      if (((num >>> i) & 1) == 1) {
        occupied.add(i);
      }
    }
  }

  private static void removeBits(int num, HashSet<Integer> occupied) {
    for (int i = 0; i < 32; i++) {
      if (((num >>> i) & 1) == 1) {
        occupied.remove(i);
      }
    }
  }
}
