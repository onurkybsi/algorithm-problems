package org.kybprototyping.problems;

import java.util.HashMap;
import java.util.PriorityQueue;

final class TopKFrequentElements {

  private TopKFrequentElements() {}

  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int occurence = map.getOrDefault(nums[i], 0);
      map.put(nums[i], occurence + 1);
    }

    PriorityQueue<Pair> queue = new PriorityQueue<>((p1, p2) -> p2.left - p1.left);
    for (var entry : map.entrySet()) {
      queue.add(new Pair(entry.getValue(), entry.getKey()));
    }

    int[] answer = new int[k];
    int i = 0;
    while (i < k) {
      answer[i] = queue.remove().right;
      i++;
    }
    return answer;
  }

  private record Pair(int left, int right) {
  }
}
