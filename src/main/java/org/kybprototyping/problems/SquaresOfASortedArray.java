package org.kybprototyping.problems;

final class SquaresOfASortedArray {
  SquaresOfASortedArray() {
  }

  public int[] sortedSquares(int[] nums) {
    var sortedSquares = new int[nums.length];
    int ix = startingIx(nums);
    int rightIx = ix + 1;
    int leftIx = ix - 1;
    int sortedSquaresIx = 0;
    while (sortedSquaresIx < sortedSquares.length) {
      sortedSquares[sortedSquaresIx++] = nums[ix] * nums[ix];

      int rightIxVal = rightIx < nums.length ? Math.abs(nums[rightIx]) : Integer.MAX_VALUE;
      int leftIxVal = leftIx >= 0 ? Math.abs(nums[leftIx]) : Integer.MAX_VALUE;
      if (rightIxVal < leftIxVal) {
        ix = rightIx;
        rightIx++;
      } else {
        ix = leftIx;
        leftIx--;
      }
    }
    return sortedSquares;
  }

  private static int startingIx(int[] nums) {
    int minIx = 0;
    int minVal = Math.abs(nums[minIx]);
    for (int i = 1; i < nums.length; i++) {
      if (Math.abs(nums[i]) < minVal) {
        minVal = Math.abs(nums[i]);
        minIx = i;
      }
    }
    return minIx;
  }
}
