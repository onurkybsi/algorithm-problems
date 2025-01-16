package org.kybprototyping.problems;

import java.util.Arrays;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
final class MaximumLengthOfRepeatedSubarray {

  private int[] nums1;
  private int[] nums2;
  private int[][] memo;

  public int findLength(int[] nums1, int[] nums2) {
    this.nums1 = nums1;
    this.nums2 = nums2;
    this.memo = new int[nums1.length][nums2.length];
    for (int[] row : this.memo) {
      Arrays.fill(row, -1);
    }
    return findLength(0, 0);
  }

  private int findLength(int num1Ix, int num2Ix) {
    if (num1Ix == this.nums1.length || num2Ix == this.nums2.length) {
      return 0;
    }
    if (this.memo[num1Ix][num2Ix] != -1) {
      return this.memo[num1Ix][num2Ix];
    }

    int max = 0;
    int i = num1Ix;
    int j = num2Ix;
    while (i < this.nums1.length && j < this.nums2.length && this.nums1[i] == this.nums2[j]) {
      max++;
      i++;
      j++;
    }
    max = Math.max(max, findLength(num1Ix + 1, num2Ix));
    max = Math.max(max, findLength(num1Ix, num2Ix + 1));

    this.memo[num1Ix][num2Ix] = max;
    return max;
  }

}
