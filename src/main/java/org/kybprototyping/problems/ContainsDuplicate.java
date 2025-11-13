package org.kybprototyping.problems;

import java.util.HashSet;

final class ContainsDuplicate {

  private ContainsDuplicate() {}

  public boolean containsDuplicate(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (set.contains(num)) {
        return true;
      }
      set.add(num);
    }
    return false;
  }

}
