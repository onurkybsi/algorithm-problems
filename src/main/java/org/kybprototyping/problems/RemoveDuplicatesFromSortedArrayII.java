package org.kybprototyping.problems;

import java.util.HashMap;

final class RemoveDuplicatesFromSortedArrayII {

  private RemoveDuplicatesFromSortedArrayII() {}

  public static int removeDuplicates(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int k = 0;
    for (int i = 0; i < nums.length; i++) {
      int count = map.getOrDefault(nums[i], 0);
      if (count < 2) {
        map.put(nums[i], count + 1);
        k++;
      }
    }

    for (int i = 0; i < nums.length; i++) {
      int count = map.get(nums[i]);
      if (count <= 0) {
        nums[i] = Integer.MIN_VALUE;

      } else {
        map.put(nums[i], count - 1);
      }
    }

    int lastNonEmptyIx = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == Integer.MIN_VALUE) {
        int nextNonEmptyIx = findNextNonEmptyIx(i, lastNonEmptyIx, nums);
        if (nextNonEmptyIx == Integer.MAX_VALUE) {
          break;
        }

        nums[i] = nums[nextNonEmptyIx];
        nums[nextNonEmptyIx] = Integer.MIN_VALUE;
        lastNonEmptyIx = nextNonEmptyIx;
      }
    }

    return k;
  }

  private static int findNextNonEmptyIx(int i, int lastNonEmptyIx, int[] nums) {
    int from = Math.max(i, lastNonEmptyIx);
    while (from < nums.length && nums[from] == Integer.MIN_VALUE) {
      from++;
    }
    return from == nums.length ? Integer.MAX_VALUE : from;
  }

}
