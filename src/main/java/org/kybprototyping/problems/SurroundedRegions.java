package org.kybprototyping.problems;

import java.util.ArrayList;

final class SurroundedRegions {

  private SurroundedRegions() {}

  public void solve(char[][] board) {
    ArrayList<Pair> cellsInBorders = new ArrayList<>();
    for (int i = 0; i < board.length; i++) {
      if (board[i][0] == 'O') {
        cellsInBorders.add(new Pair(i, 0));
      }
      if (board[i][board[0].length - 1] == 'O') {
        cellsInBorders.add(new Pair(i, board[0].length - 1));
      }
    }
    for (int i = 1; i < board[0].length - 1; i++) {
      if (board[0][i] == 'O') {
        cellsInBorders.add(new Pair(0, i));
      }
      if (board[board.length - 1][i] == 'O') {
        cellsInBorders.add(new Pair(board.length - 1, i));
      }
    }

    for (Pair border : cellsInBorders)
      dfs(board, border.left, border.right);

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] != 'C') {
          board[i][j] = 'X';
        } else {
          board[i][j] = 'O';
        }
      }
    }
  }

  private static void dfs(char[][] board, int i, int j) {
    if (board[i][j] != 'O')
      return;

    board[i][j] = 'C';
    if (i - 1 >= 0)
      dfs(board, i - 1, j);
    if (i + 1 < board.length)
      dfs(board, i + 1, j);
    if (j - 1 >= 0)
      dfs(board, i, j - 1);
    if (j + 1 < board[0].length)
      dfs(board, i, j + 1);
  }

  private record Pair(int left, int right) {
  }

}
