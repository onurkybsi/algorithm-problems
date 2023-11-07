package org.kybprototyping.problems;

final class NextPermutation {

  private NextPermutation() {}

  public static void nextPermutation(int[] nums) {
    int i = nums.length - 1, j = i - 1;

    while (i > 0) {
      if (nums[i] > nums[j]) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;

        countingSort(nums, j + 1, nums.length);
        return;
      } else if (j == 0) {
        i -= 1;
        j = i - 1;
      } else {
        j -= 1;
      }
    }

    countingSort(nums, 0, nums.length);
  }

  public static void countingSort(int[] arr, int from, int to) {
    int max = findMax(arr, from, to); // O(n)

    // initialized with zero values.
    int[] countingArr = new int[max + 1]; // O(max + 1) in RAM model
    for (int i = from; i < to; i++) { // O(n)
      countingArr[arr[i]] += 1;
    }

    for (int i = 1; i < max + 1; i++) { // O(max + 1)
      countingArr[i] += countingArr[i - 1];
    }

    int[] temp = new int[to - from];
    // iterating from the end at this point makes the algorithm stable.
    for (int i = to - 1; i >= from; i--) { // O(n)
      temp[countingArr[arr[i]] - 1] = arr[i];
      countingArr[arr[i]]--;
    }

    for (int i = 0; i < temp.length; i++) { // O(n)
      arr[from + i] = temp[i];
    }
  }

  private static int findMax(int[] arr, int from, int to) {
    int max = arr[from];

    for (int i = from; i < to; i++) {
      if (max < arr[i]) {
        max = arr[i];
      }
    }

    return max;
  }

}
