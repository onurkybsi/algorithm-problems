package org.kybprototyping.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
final class CountVowelsPermutation {

  private static final List<Character> chars = Arrays.asList('a', 'e', 'i', 'o', 'u');
  private static final Map<Character, List<Character>> followingChars =
      Map.of('a', Arrays.asList('e'), 'e', Arrays.asList('a', 'i'), 'i',
          Arrays.asList('a', 'e', 'o', 'u'), 'o', Arrays.asList('i', 'u'), 'u', Arrays.asList('a'));

  private HashMap<Pair, Integer> memo;

  public int countVowelPermutation(int n) {
    this.memo = new HashMap<>();

    int count = 0;
    for (Character c : chars)
      count = (count + countVowelPermutation(c, n - 1)) % 1_000_000_007;
    return count;
  }

  private int countVowelPermutation(Character previousChar, int length) {
    if (length == 0) {
      return 1;
    }

    var pair = new Pair(previousChar, length);
    if (this.memo.containsKey(pair)) {
      return this.memo.get(pair);
    }

    int count = 0;
    var followings = followingChars.get(previousChar);
    for (Character following : followings) {
      count = (count + countVowelPermutation(following, length - 1)) % 1_000_000_007;
    }

    this.memo.put(pair, count);
    return count;
  }

  private record Pair(Character first, int second) {
  }

}
