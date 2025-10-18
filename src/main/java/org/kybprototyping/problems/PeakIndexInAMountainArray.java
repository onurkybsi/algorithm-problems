package org.kybprototyping.problems;

final class PeakIndexInAMountainArray {

  private PeakIndexInAMountainArray() {}

  public int peakIndexInMountainArray(int[] arr) {
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
      int middle = left + (right - left) / 2;
      if (isPeakElement(arr, middle)) {
        return middle;
      }
      if ((middle > 0 && arr[middle - 1] < arr[middle])
          || (middle + 1 < arr.length && arr[middle + 1] > arr[middle])) {
        left = middle + 1;
      } else {
        right = middle - 1;
      }
    }
    throw new RuntimeException("Invalid 'arr'! No peak element found!");
  }

  private static boolean isPeakElement(int[] arr, int ix) {
    if (ix == 0 && arr[ix + 1] < arr[ix]) {
      return true;
    }
    if (ix == arr.length - 1 && arr[ix - 1] < arr[ix]) {
      return true;
    }
    if (ix - 1 >= 0 && ix + 1 < arr.length && arr[ix - 1] < arr[ix] && arr[ix + 1] < arr[ix]) {
      return true;
    }
    return false;
  }

}
