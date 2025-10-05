package org.kybprototyping.problems;

final class MedianOfTwoSortedArrays {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    // Ensure nums1 is the smaller array
    if (nums1.length > nums2.length) {
      return findMedianSortedArrays(nums2, nums1);
    }

    int m = nums1.length;
    int n = nums2.length;
    int totalLeft = (m + n + 1) / 2; // +1 handles both even/odd total lengths

    int left = 0;
    int right = m;
    while (left <= right) {
      int i = left + (right - left) / 2; // num of elements taken from nums1 for the left partition
      int j = totalLeft - i; // num of elements taken from nums2 for the left partition

      int nums1LeftMax = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1]; // No element taken from nums1
      int nums1RightMin = (i == m) ? Integer.MAX_VALUE : nums1[i];
      int nums2LeftMax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1]; // No element taken from nums2
      int nums2RightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];

      if (nums1LeftMax <= nums2RightMin && nums2LeftMax <= nums1RightMin) {
        // Found the correct partitioning
        if ((m + n) % 2 == 1) {
          // Odd total length
          return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
          // Even total length
          return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))
              / 2.0;
        }
      } else if (nums1LeftMax > nums2RightMin) {
        // Move left
        right = i - 1;
      } else {
        // Move right
        left = i + 1;
      }
    }

    throw new IllegalArgumentException("Input arrays are not valid!");
  }
}
