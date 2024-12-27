package org.kybprototyping.problems;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
final class OnesAndZeroes {
  private static String[] strings;
  private static int[][][] memo;

  public static int findMaxForm(String[] strs, int m, int n) {
    strings = strs;
    memo = new int[strs.length][m + 1][n + 1];
    return findMaxForm(0, m, n);
  }

  private static int findMaxForm(int curIx, int numOfRemaningZeros, int numOfRemaningOnes) {
    if (curIx == strings.length) {
      return 0;
    }
    if (numOfRemaningZeros == 0 && numOfRemaningOnes == 0) {
      return 0;
    }
    if (memo[curIx][numOfRemaningZeros][numOfRemaningOnes] != 0) {
      return memo[curIx][numOfRemaningZeros][numOfRemaningOnes];
    }

    int max = findMaxForm(curIx + 1, numOfRemaningZeros, numOfRemaningOnes);

    boolean canThisStrBeTaken = true;
    int numOfZeros = 0;
    int numOfOnes = 0;
    for (int i = 0; i < strings[curIx].length(); i++) {
      if (strings[curIx].charAt(i) == '0') {
        numOfZeros++;
      } else if (strings[curIx].charAt(i) == '1') {
        numOfOnes++;
      }

      if (numOfZeros > numOfRemaningZeros || numOfOnes > numOfRemaningOnes) {
        canThisStrBeTaken = false;
        break;
      }
    }
    if (canThisStrBeTaken) {
      max = Math.max(max, 1
          + findMaxForm(curIx + 1, numOfRemaningZeros - numOfZeros, numOfRemaningOnes - numOfOnes));
    }

    memo[curIx][numOfRemaningZeros][numOfRemaningOnes] = max;
    return max;
  }
}
