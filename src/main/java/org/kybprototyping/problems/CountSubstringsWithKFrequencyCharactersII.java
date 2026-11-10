package org.kybprototyping.problems;

final class CountSubstringsWithKFrequencyCharactersII {
  private CountSubstringsWithKFrequencyCharactersII() {
  }

  public long numberOfSubstrings(String s, int k) {
    long ans = 0;
    int[] memo = new int[26];
    int validChars = 0;
    int left = 0;
    int right = 0;
    int movement = 1;
    while (right < s.length()) {
      if (movement == 1) { // right
        char c = s.charAt(right);
        memo[c % 26] += 1;

        if (memo[c % 26] == k) {
          validChars++;
          ans += (s.length() - right);

          if (right == left) {
            movement = 3;
            right++;
            left++;
          } else {
            movement = 2;
            left++;
          }
        } else {
          right++;
        }
      } else if (movement == 2) { // left
        char c = s.charAt(left - 1);
        memo[c % 26] -= 1;

        if (memo[c % 26] == k - 1) {
          validChars--;

          if (validChars > 0) {
            ans += (s.length() - right);
            left++;
            right = Math.max(right, left);
          } else {
            movement = 1;
            right++;
          }
        } else {
          ans += (s.length() - right);
          left++;
        }
      } else { // both sides
        char c = s.charAt(left - 1);
        memo[c % 26] -= 1;

        validChars--;
        movement = 1;
      }
    }
    return ans;
  }
}
