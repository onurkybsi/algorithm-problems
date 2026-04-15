package org.kybprototyping.problems;

import java.util.HashMap;

final class DesignTicTacToe {
  private DesignTicTacToe() {}

  static class TicTacToe {
    private int n;
    private HashMap<Integer, State> rows;
    private HashMap<Integer, State> cols;
    private State leftDiagonal;
    private State rightDiagonal;

    public TicTacToe(int n) {
      this.n = n;
      this.rows = new HashMap<>();
      this.cols = new HashMap<>();
      this.leftDiagonal = new State(0, 0);
      this.rightDiagonal = new State(0, 0);
    }

    public int move(int row, int col, int player) {
      int ans = 0;

      State rowState = rows.getOrDefault(row, new State(0, 0));
      State newRowState = rowState.move(player);
      rows.put(row, newRowState);
      ans = newRowState.winner(n);

      State colState = cols.getOrDefault(col, new State(0, 0));
      State newColState = colState.move(player);
      cols.put(col, newColState);
      ans = Math.max(ans, newColState.winner(n));

      if (isLeftDiagonal(row, col)) {
        leftDiagonal = leftDiagonal.move(player);
        ans = Math.max(ans, leftDiagonal.winner(n));
      }
      if (isRightDiagonal(row, col)) {
        rightDiagonal = rightDiagonal.move(player);
        ans = Math.max(ans, rightDiagonal.winner(n));
      }

      return ans;
    }

    private boolean isLeftDiagonal(int row, int col) {
      return row == col;
    }

    private boolean isRightDiagonal(int row, int col) {
      return (row + col + 1) == n;
    }

    private record State(int ones, int twos) {
      State move(int player) {
        if (player == 1) {
          return new State(ones + 1, twos);
        } else {
          return new State(ones, twos + 1);
        }
      }

      int winner(int n) {
        if (ones == n) {
          return 1;
        } else if (twos == n) {
          return 2;
        } else {
          return 0;
        }
      }
    }
  }
}
