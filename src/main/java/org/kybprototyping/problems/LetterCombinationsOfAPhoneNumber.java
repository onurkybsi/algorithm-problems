package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class LetterCombinationsOfAPhoneNumber {

  private LetterCombinationsOfAPhoneNumber() {}

  private static final Map<Character, List<Character>> map =
      Map.of('2', Arrays.asList('a', 'b', 'c'), '3', Arrays.asList('d', 'e', 'f'), '4',
          Arrays.asList('g', 'h', 'i'), '5', Arrays.asList('j', 'k', 'l'), '6',
          Arrays.asList('m', 'n', 'o'), '7', Arrays.asList('p', 'q', 'r', 's'), '8',
          Arrays.asList('t', 'u', 'v'), '9', Arrays.asList('w', 'x', 'y', 'z'));

  private String digits;

  public List<String> letterCombinations(String digits) {
    if (digits.length() == 0) {
      return Collections.emptyList();
    }

    this.digits = digits;

    List<String> letterCombinations = new ArrayList<>();
    add(new StringBuilder(), 0, letterCombinations);
    return letterCombinations;
  }

  private void add(StringBuilder b, int curIx, List<String> letterCombinations) {
    if (b.length() == this.digits.length()) {
      letterCombinations.add(b.toString());
      return;
    }

    for (char c : map.get(this.digits.charAt(curIx))) {
      add(new StringBuilder(b).append(c), curIx + 1, letterCombinations);
    }
  }
}
