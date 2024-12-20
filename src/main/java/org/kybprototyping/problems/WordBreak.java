package org.kybprototyping.problems;

import java.util.Arrays;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
final class WordBreak {

  private String s;
  private List<String> wordDict;
  private int[] memo;

  public boolean wordBreak(String s, List<String> wordDict) {
    this.memo = new int[s.length()];
    Arrays.fill(this.memo, -1);

    this.s = s;
    this.wordDict = wordDict;

    return wordBreakUpTo(s.length() - 1);
  }

  private boolean wordBreakUpTo(int i) {
    if (i < 0) {
      return true;
    }

    if (this.memo[i] == -1) {
      this.memo[i] = 0; // To not recheck

      for (String word : this.wordDict) {
        if (word.length() > i + 1) {
          continue;
        }

        if (s.substring(i - word.length() + 1, i + 1).equals(word)
            && wordBreakUpTo(i - word.length())) {
          this.memo[i] = 1;
          break;
        }
      }
    }

    return this.memo[i] == 1;
  }

}
