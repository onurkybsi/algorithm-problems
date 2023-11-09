package org.kybprototyping.problems;

final class NextPermutation {

  private NextPermutation() {}

  // TODO: Edge cases exist. Check the test data.
  public static void nextPermutation(int[] nums) {
    int i = nums.length - 1, j = i - 1;

    int ixLeft = 0;
    int ixRight = nums.length;
    double minIncrease = Double.MAX_VALUE;
    while (i > ixLeft) {
      if (nums[i] > nums[j]) {
        double increase = calculateIncrease(nums, j, i);
        if (increase < minIncrease) {
          minIncrease = increase;
          ixLeft = j;
          ixRight = i;

          i -= 1;
          j = i;
        }
      }

      if (j == ixLeft) {
        i -= 1;
        j = i - 1;
      } else {
        j -= 1;
      }
    }

    if (!(ixLeft == 0 && ixRight == nums.length)) {
      int temp = nums[ixLeft];
      nums[ixLeft] = nums[ixRight];
      nums[ixRight] = temp;
      countingSort(nums, ixLeft + 1, nums.length);
    } else {
      countingSort(nums, 0, nums.length);
    }
  }

  private static double calculateIncrease(int[] nums, int ixLeft, int ixRight) {
    // double difference = 0;
    // difference +=
    // (double) (nums[ixRight] - nums[ixLeft]) * (Math.pow(10, (nums.length - ixLeft - 1) / 2));
    // difference +=
    // (double) (nums[ixLeft] - nums[ixRight]) * (Math.pow(10, (nums.length - ixRight - 1) / 2));
    return (double) (nums[ixRight] - nums[ixLeft])
        * (Math.pow(10, (double) (nums.length - ixLeft - 1) / (double) 10)
            - Math.pow(10, (double) (nums.length - ixRight - 1) / (double) 10));
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
