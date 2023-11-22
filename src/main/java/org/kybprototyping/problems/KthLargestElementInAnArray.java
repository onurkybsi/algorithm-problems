package org.kybprototyping.problems;

import java.util.Arrays;
import java.util.PriorityQueue;

final class KthLargestElementInAnArray {

  private KthLargestElementInAnArray() {}

  // Brute force solution, Time complexity: O(nlogn), space complexity: O(n) (merge sort)
  public static int findKthLargest_WithSorting(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length - k];
  }

  // Time complexity: O(nlogk), space complexity: O(k) (min-heap has k size elements)
  public static int findKthLargest_WithMinHeap(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int num : nums) { // O(n)
      minHeap.add(num); // O(logk)
      if (minHeap.size() > k) {
        minHeap.remove(); // removes the root node, smallest one. Time complexity: O(logk)
      }
    }

    return minHeap.peek(); // returns root
  }

  // Time complexity: O(n + m), m = max - min + 1, space complexity: O(m)
  public int findKthLargest_WithCounting(int[] nums, int k) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int num : nums) { // O(n)
      min = Math.min(min, num);
      max = Math.max(max, num);
    }

    int[] countArr = new int[max - min + 1];
    for (int num : nums) {
      countArr[num - min]++;
    }

    int remain = k;
    for (int num = countArr.length - 1; num >= 0; num--) { // O(m)
      remain -= countArr[num];
      if (remain <= 0) {
        return num + min;
      }
    }

    throw new IllegalArgumentException("Invalid arguments!");
  }

}
