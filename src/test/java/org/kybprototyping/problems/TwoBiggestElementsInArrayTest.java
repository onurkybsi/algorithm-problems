package org.kybprototyping.problems;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

class TwoBiggestElementsInArrayTest {

  @Test
  void findTwoBiggestElementsInArray_V1_Should_Return_Biggest_Two_Elements() {
    // given
    int[] nums = new int[] {1, 7, 3, 5, 0, 2, 7, 8, 6, 24};

    // when
    var actualResult = TwoBiggestElementsInArray.findTwoBiggestElementsInArray(nums);

    // then
    assertArrayEquals(new int[] {24, 8}, actualResult);
  }

}
