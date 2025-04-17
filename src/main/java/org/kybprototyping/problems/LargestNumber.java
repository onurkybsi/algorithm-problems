package org.kybprototyping.problems;

import java.util.Arrays;

final class LargestNumber {

  private LargestNumber() {}

  public String largestNumber(int[] nums) {
    StringBuilder largestNumber = new StringBuilder();
    Arrays.stream(nums).mapToObj(i -> Integer.toString(i))
        .sorted((i1, i2) -> (i2 + i1).compareTo(i1 + i2)).forEach(str -> largestNumber.append(str));
    if (largestNumber.charAt(0) == '0') {
      return "0";
    }
    return largestNumber.toString();
  }

}
