package org.kybprototyping.problems;

import java.util.HashMap;
import java.util.HashSet;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
final class DecodeWays {

  private static HashSet<String> validStringsToDecode = new HashSet<>();
  static {
    for (int i = 1; i <= 26; i++)
      validStringsToDecode.add(Integer.toString(i));
  }

  private String s;
  private HashMap<Integer, Integer> memo;

  public int numDecodings(String s) {
    this.s = s;
    this.memo = new HashMap<>(s.length());
    return numDecodings(0);
  }

  private int numDecodings(int ix) {
    if (ix == s.length()) {
      return 1;
    }
    if (memo.containsKey(ix)) {
      return memo.get(ix);
    }

    int numDecodings = 0;
    if (validStringsToDecode.contains(Character.toString(this.s.charAt(ix)))) {
      numDecodings += numDecodings(ix + 1);
    }
    if (ix + 1 < this.s.length() && validStringsToDecode.contains(this.s.substring(ix, ix + 2))) {
      numDecodings += numDecodings(ix + 2);
    }

    this.memo.put(ix, numDecodings);
    return numDecodings;
  }

}
