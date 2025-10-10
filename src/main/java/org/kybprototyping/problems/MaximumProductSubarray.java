package org.kybprototyping.problems;

import java.util.HashMap;

final class MaximumProductSubarray {

  private MaximumProductSubarray() {}

  private int[] nums;
  private HashMap<Pair, Integer> memo;

  public int maxProduct(int[] nums) {
    this.nums = nums;
    this.memo = new HashMap<>();

    int maxProduct = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      maxProduct = Math.max(maxProduct, maxProduct(1, i));
    }
    return maxProduct;
  }

  private int maxProduct(int curProduct, int curIx) {
    if (curIx >= this.nums.length) {
      return Integer.MIN_VALUE;
    }
    if (this.memo.containsKey(new Pair(curProduct, curIx))) {
      return this.memo.get(new Pair(curProduct, curIx));
    }

    int num = this.nums[curIx];
    int maxProduct = Math.max(curProduct * num, maxProduct(curProduct * num, curIx + 1));
    this.memo.put(new Pair(curProduct, curIx), maxProduct);
    return maxProduct;
  }

  private record Pair(int left, int right) {
  }
}
