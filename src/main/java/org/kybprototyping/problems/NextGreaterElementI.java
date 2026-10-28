package org.kybprototyping.problems;

final class NextGreaterElementI {
  NextGreaterElementI() {
  }

  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int[] answer = new int[nums1.length];
    for (int i = 0; i < nums1.length; i++) {
      answer[i] = firstGreaterElementFor(indexOf(nums1[i], nums2), nums2);
    }
    return answer;
  }

  private int indexOf(int val, int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == val) {
        return i;
      }
    }
    throw new IllegalArgumentException();
  }

  private int firstGreaterElementFor(int ix, int[] arr) {
    int val = arr[ix];
    for (int i = ix + 1; i < arr.length; i++) {
      if (arr[i] > val) {
        return arr[i];
      }
    }
    return -1;
  }
}
