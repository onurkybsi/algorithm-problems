package org.kybprototyping.problems;

import java.util.Arrays;

final class GameOfLife {

  private GameOfLife() {}

  public static void gameOfLife(int[][] board) {
    int[][] boardInitialState = copy(board);

    for (int i = 0; i < boardInitialState.length; i++) {
      for (int j = 0; j < boardInitialState[0].length; j++) {
        int liveNeighborsCount = findLiveNeighborsCount(boardInitialState, i, j);

        if (boardInitialState[i][j] == 1) {
          board[i][j] = liveNeighborsCount >= 2 && liveNeighborsCount <= 3 ? 1 : 0;
        } else {
          board[i][j] = liveNeighborsCount == 3 ? 1 : 0;
        }
      }
    }
  }

  private static int[][] copy(int[][] board) {
    int[][] copy = new int[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      copy[i] = Arrays.copyOf(board[i], board[i].length);
    }
    return copy;
  }

  private static int findLiveNeighborsCount(int[][] boardInitialState, int i, int j) {
    int liveNeighborsCount = 0;

    int k = i - 1;
    while (k <= i + 1) {
      int l = j - 1;

      while (l <= j + 1) {
        if (k >= 0 && k < boardInitialState.length && l >= 0 && l < boardInitialState[0].length
            && !(k == i && l == j) && boardInitialState[k][l] == 1) {
          liveNeighborsCount++;
        }

        l++;
      }

      k++;
    }

    return liveNeighborsCount;
  }

}
