package org.kybprototyping.problems;

import java.util.ArrayList;
import java.util.List;

final class GuessTheWord {

  private GuessTheWord() {}

  public void findSecretWord(String[] words, Master master) {
    List<String> wordList = new ArrayList<>();
    for (String word : words) {
      wordList.add(word);
    }

    String curWord = wordList.get(0);
    int curSimilarity = master.guess(curWord);
    while (curSimilarity != 6) {
      final String _curWord = curWord;
      final int _curSimilarity = curSimilarity;
      wordList = wordList.stream()
          .filter(w -> !w.equals(_curWord) && countSameChars(w, _curWord) == _curSimilarity)
          .toList();
      curWord = wordList.get((int) (Math.random() * (wordList.size() - 1)));
      curSimilarity = master.guess(curWord);
    }
  }

  private static int countSameChars(String s1, String s2) {
    int count = 0;
    for (int i = 0; i < 6; i++) {
      if (s1.charAt(i) == s2.charAt(i)) {
        count++;
      }
    }
    return count;
  }

  interface Master {
    public int guess(String word);
  }
}
