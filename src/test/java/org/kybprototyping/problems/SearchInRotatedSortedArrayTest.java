package org.kybprototyping.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SearchInRotatedSortedArrayTest {

  @ParameterizedTest
  @MethodSource("provideTestInputsAndActualOutputs")
  void search_Should_Return_Ix_Of_Target(int[] nums, int target, int expectedResult) {
    // given

    // when
    int actualResult = SearchInRotatedSortedArray.search(nums, target);

    // then
    assertEquals(expectedResult, actualResult);
  }

  private static Stream<Arguments> provideTestInputsAndActualOutputs() {
    return Stream.of(Arguments.of(new int[] {4, 5, 6, 7, 0, 1, 2}, 0, 4));
  }

}
