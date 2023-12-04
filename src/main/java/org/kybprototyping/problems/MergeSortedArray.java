package org.kybprototyping.problems;

final class MergeSortedArray {

  private MergeSortedArray() {}

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    if (n == 0) {
      return;
    }

    int[] tempArr = new int[m + n];

    int i = 0;
    int j = 0;
    int k = 0;
    while (i < m || j < n) {
      if ((j == n) || (i < m && nums1[i] < nums2[j])) {
        tempArr[k] = nums1[i];
        i++;
      } else if (j < n) {
        tempArr[k] = nums2[j];
        j++;
      }

      k++;
    }

    for (int l = 0; l < tempArr.length; l++) {
      nums1[l] = tempArr[l];
    }

  }

}
