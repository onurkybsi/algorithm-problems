package org.kybprototyping.problems;

final class TrappingRainWater {

  private TrappingRainWater() {}

  public int trap(int[] height) {
    int[] leftMaxs = new int[height.length];
    leftMaxs[0] = height[0];
    int[] rightMaxs = new int[height.length];
    rightMaxs[height.length - 1] = height[height.length - 1];
    for (int i = 1; i < height.length; i++) {
      leftMaxs[i] = Math.max(leftMaxs[i - 1], height[i]);
    }
    for (int i = height.length - 2; i >= 0; i--) {
      rightMaxs[i] = Math.max(rightMaxs[i + 1], height[i]);
    }

    int water = 0;
    for (int i = 1; i < height.length; i++) {
      water += Math.min(leftMaxs[i], rightMaxs[i]) - height[i];
    }
    return water;
  }

}
