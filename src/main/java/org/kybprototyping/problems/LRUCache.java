package org.kybprototyping.problems;

import java.util.HashMap;
import java.util.LinkedHashSet;

final class LRUCache {

  private final HashMap<Integer, Integer> cache = new HashMap<>();
  private final LinkedHashSet<Integer> usedKeysInOrder = new LinkedHashSet<>();

  private int capacity;

  public LRUCache(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if (!cache.containsKey(key)) {
      return -1;
    }

    int value = cache.get(key);
    usedKeysInOrder.remove(key);
    usedKeysInOrder.add(key);
    return value;
  }

  public void put(int key, int value) {
    if (!cache.containsKey(key) && cache.size() == capacity) {
      int keyToRemove = usedKeysInOrder.iterator().next();
      usedKeysInOrder.remove(keyToRemove);
      cache.remove(keyToRemove);
    }

    usedKeysInOrder.remove(key);
    usedKeysInOrder.add(key);
    cache.put(key, value);
  }

}
