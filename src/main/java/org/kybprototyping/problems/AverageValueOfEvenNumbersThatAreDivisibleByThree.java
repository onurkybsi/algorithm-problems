package org.kybprototyping.problems;

final class AverageValueOfEvenNumbersThatAreDivisibleByThree {

  private AverageValueOfEvenNumbersThatAreDivisibleByThree() {}

  public int averageValue(int[] nums) {
    int count = 0;
    int sum = 0;
    for (int num : nums) {
      if (num % 6 == 0) {
        count++;
        sum += num;
      }
    }
    return count == 0 ? 0 : sum / count;
  }

}
