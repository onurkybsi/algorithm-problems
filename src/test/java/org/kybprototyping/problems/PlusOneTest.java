package org.kybprototyping.problems;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

class PlusOneTest {

  @Test
  void plusOne_Should_Increate_Arr_Representetive_Number_By_One() {
    // given
    int[] digits = new int[] {9};

    // when
    var actualResult = PlusOne.plusOne(digits);

    // then
    assertArrayEquals(new int[] {1, 0}, actualResult);
  }

}
