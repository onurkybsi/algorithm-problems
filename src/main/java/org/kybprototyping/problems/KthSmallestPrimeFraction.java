package org.kybprototyping.problems;

import java.util.PriorityQueue;

final class KthSmallestPrimeFraction {

  private KthSmallestPrimeFraction() {}

  public int[] kthSmallestPrimeFraction(int[] arr, int k) {
    var queue = new PriorityQueue<Triple>((p1, p2) -> Double.compare(p1.first, p2.first));
    for (int i = 0; i < arr.length; i++) {
      int dividend = arr[i];

      for (int j = 0; j < arr.length; j++) {
        queue.add(new Triple((double) dividend / arr[j], dividend, arr[j]));
      }
    }

    while (k > 1) {
      queue.remove();
      k--;
    }
    var kthSmallestPrimeFraction = queue.remove();

    return new int[] {kthSmallestPrimeFraction.second, kthSmallestPrimeFraction.third};
  }

  record Triple(Double first, int second, int third) {
  }

}
