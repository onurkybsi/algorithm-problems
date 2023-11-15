package org.kybprototyping.problems;

import java.util.HashSet;

final class ValidSudoku {

  private ValidSudoku() {}

  public static boolean isValidSudoku(char[][] board) {
    HashSet<Character> cache = new HashSet<>(9);
    for (int i = 0; i < 9; i++) {
      cache.clear();
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') {
          continue;
        }

        if (cache.contains(board[i][j])) {
          return false;
        } else {
          cache.add(board[i][j]);
        }
      }

      cache.clear();
      for (int j = 0; j < 9; j++) {
        if (board[j][i] == '.') {
          continue;
        }

        if (cache.contains(board[j][i])) {
          return false;
        } else {
          cache.add(board[j][i]);
        }
      }
    }

    int i = 0;
    int j = 0;
    while (j <= 6) {
      if (!isRectangeValid(i, j, board)) {
        return false;
      }

      if (i >= 6) {
        i = 0;
        j += 3;
      } else {
        i += 3;
      }
    }

    return true;
  }

  private static boolean isRectangeValid(int startX, int startY, char[][] board) {
    int i = startX;
    int j = startY;
    HashSet<Character> cache = new HashSet<>(9);

    while (j < startY + 3) {
      if (board[i][j] != '.') {
        if (cache.contains(board[i][j])) {
          return false;
        } else {
          cache.add(board[i][j]);
        }
      }

      if (i + 1 == startX + 3) {
        i = startX;
        j++;
      } else {
        i++;
      }
    }

    return true;
  }

}
