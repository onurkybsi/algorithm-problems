package org.kybprototyping.problems;

import java.util.HashSet;
import java.util.Random;

final class InsertDeleteGetRandomO1 {

  private InsertDeleteGetRandomO1() {}

  static class RandomizedSet {

    private static Random RANDOM = new java.security.SecureRandom();

    private final HashSet<Integer> set;

    public RandomizedSet() {
      this.set = new HashSet<>();
    }

    // Inserts an item val into the set if not present. Returns true if the item was not present,
    // false otherwise.
    public boolean insert(int val) {
      if (set.contains(val)) {
        return false;
      }

      set.add(val);
      return true;
    }

    // Removes an item val from the set if present. Returns true if the item was present, false
    // otherwise.
    public boolean remove(int val) {
      if (set.contains(val)) {
        set.remove(val);
        return true;
      }

      return false;
    }

    // Returns a random element from the current set of elements (it's guaranteed that at least one
    // element exists when this method is called). Each element must have the same probability of
    // being returned.
    public int getRandom() {
      int i = RANDOM.nextInt(set.size());

      var iter = set.iterator();
      int val = iter.next();
      while (i > 0) {
        val = iter.next();
        i--;
      }

      return val;
    }
  }


}
