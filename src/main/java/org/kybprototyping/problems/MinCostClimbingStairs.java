package org.kybprototyping.problems;

final class MinCostClimbingStairs {

  private MinCostClimbingStairs() {}

  public static int minCostClimbingStairs(int[] cost) {
    int costAtStep = 0;
    int costAtOtherStep = Integer.MAX_VALUE - cost[cost.length - 1];
    for (int i = cost.length - 1; i >= 0; i--) {
      int cur = Math.min(costAtStep + cost[i], costAtOtherStep + cost[i]);

      costAtOtherStep = costAtStep;
      costAtStep = cur;
    }
    return Math.min(costAtStep, costAtOtherStep);
  }

}
