package org.kybprototyping.problems;

import java.util.Arrays;
import java.util.HashSet;

final class IntersectionOfTwoArrays {
  IntersectionOfTwoArrays() {
  }

  public int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> set = new HashSet<>();
    for (int num : nums1) {
      set.add(num);
    }

    int[] arr = new int[Math.min(nums1.length, nums2.length)];
    int i = 0;
    for (int num : nums2) {
      if (set.remove(num)) {
        arr[i++] = num;
      }
    }
    return Arrays.copyOf(arr, i);
  }
}
