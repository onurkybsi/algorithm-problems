package org.kybprototyping.problems;

final class AlternatingGroupsII {
  private AlternatingGroupsII() {
  }

  public int numberOfAlternatingGroups(int[] colors, int k) {
    int ans = 0;
    boolean isPreviousAlternating = false;
    int i = 0;
    while (i < colors.length) {
      if (isPreviousAlternating) {
        int end = ((i - 1) + k) % colors.length;
        int previousEnd = ((i - 1) + k - 1) % colors.length;
        if (colors[end] != colors[previousEnd]) {
          ans++;
          i++;
        } else if (end > i) {
          isPreviousAlternating = false;
          i = end;
        } else {
          break;
        }
      } else {
        int next = brokenAt(colors, k, i);
        if (next == -1) {
          ans++;
          isPreviousAlternating = true;
          i++;
        } else if (next > i) {
          i = next;
        } else {
          break;
        }
      }
    }
    return ans;
  }

  private static int brokenAt(int[] colors, int k, int start) {
    int color = colors[start];
    int i = (start + 1) % colors.length;
    int it = 1;
    while (it < k) {
      if (colors[i] == color) {
        return i;
      }
      color = colors[i];
      i = (i + 1) % colors.length;
      it++;
    }
    return -1;
  }
}
