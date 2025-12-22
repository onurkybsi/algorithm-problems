package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.HashMap;

final class TimeBasedKeyValueStore {

  private TimeBasedKeyValueStore() {}

  static class TimeMap {
    private final HashMap<String, ArrayList<Value>> keyValueStore;

    public TimeMap() {
      this.keyValueStore = new HashMap<String, ArrayList<Value>>();
    }

    public void set(String key, String value, int timestamp) {
      var values = this.keyValueStore.getOrDefault(key, new ArrayList<>());
      values.add(new Value(timestamp, value));
      this.keyValueStore.put(key, values);
    }

    public String get(String key, int timestamp) {
      var values = this.keyValueStore.get(key);
      if (values == null) {
        return "";
      }
      return maybeFindSmallerValueBy(timestamp, values);
    }

    private static String maybeFindSmallerValueBy(int timestamp, ArrayList<Value> values) {
      int l = 0;
      int r = values.size() - 1;
      int m = (r - l) / 2;
      while (l <= r) {
        m = l + (r - l) / 2;
        if (values.get(m).timestamp() == timestamp) {
          return values.get(m).value();
        } else if (values.get(m).timestamp() < timestamp) {
          l = m + 1;
        } else {
          r = m - 1;
        }
      }

      if (values.get(m).timestamp() <= timestamp) {
        return values.get(m).value();
      }
      if (m - 1 >= 0 && values.get(m - 1).timestamp() <= timestamp) {
        return values.get(m - 1).value();
      }
      return "";
    }

    private record Value(int timestamp, String value) {
    }
  }
}
