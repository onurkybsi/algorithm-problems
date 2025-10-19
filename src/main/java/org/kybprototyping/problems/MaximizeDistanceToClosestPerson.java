package org.kybprototyping.problems;

final class MaximizeDistanceToClosestPerson {

  private MaximizeDistanceToClosestPerson() {}

  public int maxDistToClosest(int[] seats) {
    int right = 0;
    while (seats[right] != 1) {
      right++;
    }

    int maxDist = right;
    int left = right;
    while (right < seats.length) {
      if (seats[right] == 0) {
        right++;
      } else {
        maxDist = Math.max(maxDist, (right - left) / 2);
        left = right;
        right++;
      }
    }
    maxDist = Math.max(maxDist, (seats.length - 1) - left);
    return maxDist;
  }

}
