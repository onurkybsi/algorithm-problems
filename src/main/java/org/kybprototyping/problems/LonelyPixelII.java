package org.kybprototyping.problems;

import java.util.HashMap;
import java.util.HashSet;

final class LonelyPixelII {
  private LonelyPixelII() {}

  private char[][] picture;
  private int m;
  private int n;
  private HashMap<Integer, Pair> rowCache;

  public int findBlackPixel(char[][] picture, int target) {
    this.picture = picture;
    this.m = picture.length;
    this.n = picture[0].length;
    this.rowCache = buildRowCache();

    int ans = 0;
    for (int j = 0; j < n; j++) {
      int i = 0;
      var bRowIxs = new HashSet<Integer>();
      while (i < m) {
        if (picture[i][j] == 'B') {
          bRowIxs.add(i);
        }
        i++;
      }

      if (bRowIxs.size() != target) {
        continue;
      }

      int anyRowIx = bRowIxs.iterator().next();
      Pair anyRow = rowCache.get(anyRowIx);
      if (anyRow.left != target) {
        continue;
      }

      boolean haveAllRowsSameStr = true;
      String targetStr = anyRow.right;
      for (int rowIx : bRowIxs) {
        if (!rowCache.get(rowIx).right.equals(targetStr)) {
          haveAllRowsSameStr = false;
          break;
        }
      }
      if (haveAllRowsSameStr) {
        ans += bRowIxs.size();
      }
    }
    return ans;
  }

  private HashMap<Integer, Pair> buildRowCache() {
    HashMap<Integer, Pair> cache = new HashMap<>();
    for (int i = 0; i < m; i++) {
      int numOfBs = 0;
      for (int j = 0; j < n; j++) {
        if (picture[i][j] == 'B') {
          numOfBs++;
        }
      }
      cache.put(i, new Pair(numOfBs, new String(picture[i])));
    }
    return cache;
  }

  private record Pair(int left, String right) {
  }
}
