package org.kybprototyping.problems;

final class FirstBadVersion {
  FirstBadVersion() {
  }

  public int firstBadVersion(int n) {
    return firstBadVersion(1, n);
  }

  private int firstBadVersion(int left, int right) {
    if (left > right) {
      return Integer.MAX_VALUE;
    }

    int middle = left + ((right - left) / 2);
    if (isBadVersion(middle)) {
      return Math.min(middle, firstBadVersion(left, middle - 1));
    }
    return firstBadVersion(middle + 1, right);
  }

  private boolean isBadVersion(int version) {
    // Coming from VersionControl
    return true;
  }
}
