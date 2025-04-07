package org.kybprototyping.problems;

final class ArmstrongNumber {

  private ArmstrongNumber() {}

  public boolean isArmstrong(int n) {
    int copyN = n;
    int numOfDigits = 0;
    while (copyN != 0) {
      numOfDigits++;
      copyN = copyN / 10;
    }

    copyN = n;
    int sum = 0;
    while (n != 0) {
      sum += Math.pow(n % 10, numOfDigits);
      n = n / 10;
    }
    return sum == copyN;
  }

}
