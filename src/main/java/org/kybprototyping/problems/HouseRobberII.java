package org.kybprototyping.problems;

import java.util.HashMap;

final class HouseRobberII {

  private HouseRobberII() {}

  private HashMap<State, Integer> memo;

  public int rob(int[] nums) {
    this.memo = new HashMap<>();
    return Math.max(nums[0] + rob(nums, true, true, 1), rob(nums, false, false, 1));
  }

  private int rob(int[] nums, boolean isFirstHouseRobbed, boolean isPreviousHouseRobbed,
      int startingFrom) {
    if (startingFrom == nums.length) {
      return 0;
    }
    if (startingFrom == nums.length - 1 && (isPreviousHouseRobbed || isFirstHouseRobbed)) {
      return 0;
    }

    var state = new State(isFirstHouseRobbed, isPreviousHouseRobbed, startingFrom);
    if (this.memo.containsKey(state)) {
      return this.memo.get(state);
    }
    if (startingFrom < nums.length - 1 && isPreviousHouseRobbed) {
      return rob(nums, isFirstHouseRobbed, false, startingFrom + 1);
    }
    int max = nums[startingFrom] + rob(nums, isFirstHouseRobbed, true, startingFrom + 1);
    max = Math.max(max, rob(nums, isFirstHouseRobbed, false, startingFrom + 1));
    this.memo.put(state, max);
    return max;
  }

  private record State(boolean isFirstHouseRobbed, boolean isPreviousHouseRobbed,
      int startingFrom) {
  }

}
