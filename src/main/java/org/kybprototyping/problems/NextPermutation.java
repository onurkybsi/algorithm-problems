package org.kybprototyping.problems;

final class NextPermutation {

  private NextPermutation() {}

  public static void nextPermutation(int[] nums) {
    int i = nums.length - 1, j = i - 1;

    int ixLeft = -1;
    int ixRight = nums.length;
    long minIncrease = Long.MAX_VALUE;
    while (i > 0) {
      if (nums[i] > nums[j]) {
        long increase = calculateIncrease(nums, j, i);
        if (increase < minIncrease) {
          minIncrease = increase;
          ixLeft = j;
          ixRight = i;
        }

        if (j == 0) {
          i -= 1;
          j = i - 1;
        } else {
          j -= 1;
        }
      } else if (j == 0) {
        i -= 1;
        j = i - 1;
      } else {
        j -= 1;
      }
    }

    if (!(ixLeft == -1 && ixRight == nums.length)) {
      int temp = nums[ixLeft];
      nums[ixLeft] = nums[ixRight];
      nums[ixRight] = temp;
      countingSort(nums, ixRight - 1, nums.length);
    } else {
      countingSort(nums, 0, nums.length);
    }
  }

  private static long calculateIncrease(int[] nums, int ixLeft, int ixRight) {
    long diffference = 0;
    diffference += (long) nums[ixLeft] * ((long) Math.pow(10, nums.length - ixRight - 1)
        - (long) Math.pow(10, nums.length - ixLeft - 1));
    diffference += (long) nums[ixRight] * ((long) Math.pow(10, nums.length - ixLeft - 1)
        - (long) Math.pow(10, nums.length - ixRight - 1));
    return diffference;
  }

  private static void countingSort(int[] arr, int from, int to) {
    int max = findMax(arr, from, to);

    int[] countingArr = new int[max + 1];
    for (int i = from; i < to; i++) {
      countingArr[arr[i]] += 1;
    }

    for (int i = 1; i < max + 1; i++) {
      countingArr[i] += countingArr[i - 1];
    }

    int[] temp = new int[to - from];
    for (int i = to - 1; i >= from; i--) {
      temp[countingArr[arr[i]] - 1] = arr[i];
      countingArr[arr[i]]--;
    }

    for (int i = 0; i < temp.length; i++) {
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
