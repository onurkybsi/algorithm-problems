package org.kybprototyping.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CountHillsAndValleysInAnArrayTest {

  @ParameterizedTest
  @MethodSource("provideTestInputsAndActualOutputs")
  void countHillValley_Should_Return_Count_Of_Hill_And_Valleys(int[] nums, int expectedResult) {
    // given

    // when
    var actualResult = CountHillsAndValleysInAnArray.countHillValley(nums);

    // then
    assertEquals(expectedResult, actualResult);
  }

  private static Stream<Arguments> provideTestInputsAndActualOutputs() {
    return Stream.of(Arguments.of(new int[] {2, 4, 1, 1, 6, 5}, 3),
        Arguments.of(new int[] {6, 6, 5, 5, 4, 1}, 0), Arguments.of(new int[] {5, 7, 7, 1, 7}, 2));
  }

}
