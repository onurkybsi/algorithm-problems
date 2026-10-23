package org.kybprototyping.problems;

import java.util.ArrayList;

final class SumOfSortableIntegers {
  SumOfSortableIntegers() {
  }

  public int sortableIntegers(int[] nums) {
    if (nums.length == 1) {
      return 1;
    }

    var knums = knums(nums.length);
    int ans = 0;
    for (int k : knums) {
      ans += isSortable(nums, k) ? k : 0;
    }
    return ans;
  }

  private static boolean isSortable(int[] nums, int k) {
    int numOfPartitions = nums.length / k;
    int prevPartitionMax = Integer.MIN_VALUE;
    for (int i = 1; i <= numOfPartitions && prevPartitionMax != -1; i++) {
      prevPartitionMax = isSortable(nums, k, i, prevPartitionMax);
    }
    return prevPartitionMax != -1;
  }

  private static int isSortable(int[] nums, int k, int partition, int prevPartitionMax) {
    int base = k * (partition - 1);
    int descents = 0;
    int start = 0;
    for (int j = 0; j < k; j++) {
      if (nums[base + j] > nums[base + (j + 1) % k]) {
        descents++;
        start = (j + 1) % k;
      }
    }
    if (descents > 1) {
      return -1;
    }

    int min = nums[base + start];
    int max = nums[base + (start + k - 1) % k];
    if (min < prevPartitionMax) {
      return -1;
    }
    return max;
  }

  private static ArrayList<Integer> knums(int length) {
    ArrayList<Integer> knums = new ArrayList<>();
    knums.add(1);
    knums.add(length);
    for (int i = 2; i < length; i++) {
      if (length % i == 0) {
        knums.add(i);
      }
    }
    return knums;
  }
}
