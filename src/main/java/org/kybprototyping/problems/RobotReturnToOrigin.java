package org.kybprototyping.problems;

final class RobotReturnToOrigin {

  private RobotReturnToOrigin() {}

  public boolean judgeCircle(String moves) {
    int verticalPosition = 0;
    int horizontalPosition = 0;
    for (int i = 0; i < moves.length(); i++) {
      switch (moves.charAt(i)) {
        case 'U' -> {
          verticalPosition++;
        }
        case 'D' -> {
          verticalPosition--;
        }
        case 'R' -> {
          horizontalPosition++;
        }
        case 'L' -> {
          horizontalPosition--;
        }
        default -> throw new IllegalStateException();
      }
    }
    return verticalPosition == 0 && horizontalPosition == 0;
  }

}
