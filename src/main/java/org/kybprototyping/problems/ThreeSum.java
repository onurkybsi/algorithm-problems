package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

final class ThreeSum {

  private ThreeSum() {}

  public List<List<Integer>> threeSum(int[] nums) {
    HashMap<Integer, Integer> numsMap = new HashMap<>();
    for (int num : nums) {
      int occurence = numsMap.getOrDefault(num, 0);
      numsMap.put(num, occurence + 1);
    }

    HashSet<Triple> triples = new HashSet<>();
    HashSet<Integer> alreadyVisited = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (alreadyVisited.contains(nums[i])) {
        continue;
      }

      for (int j = i + 1; j < nums.length; j++) {
        int twoSum = nums[i] + nums[j];
        int complement = 0 - twoSum;
        int complementOccurence = numsMap.getOrDefault(complement, 0);
        int complementOccurenceRequired = 1;
        if (nums[i] == complement) {
          complementOccurenceRequired++;
        }
        if (nums[j] == complement) {
          complementOccurenceRequired++;
        }
        if (complementOccurence >= complementOccurenceRequired) {
          var triple = new ArrayList<>(List.of(nums[i], nums[j], complement));
          triple.sort(Comparator.naturalOrder());
          triples.add(new Triple(triple.get(0), triple.get(1), triple.get(2)));
        }
      }
      alreadyVisited.add(nums[i]);
    }

    List<List<Integer>> threeSums = new ArrayList<>();
    for (var triple : triples) {
      threeSums.add(Arrays.asList(triple.first, triple.second, triple.third));
    }
    return threeSums;
  }

  private record Triple(int first, int second, int third) {
  }

}
