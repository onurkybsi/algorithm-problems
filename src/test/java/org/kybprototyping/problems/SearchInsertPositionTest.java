package org.kybprototyping.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SearchInsertPositionTest {

  @ParameterizedTest
  @MethodSource("provideTestInputsAndActualOutputs")
  void searchInsert_Should_Return_Insertion_Position_Of_Given_Target(int[] nums, int target,
      int expectedResult) {
    // given

    // when
    int actualResult = SearchInsertPosition.searchInsert(nums, target);

    // then
    assertEquals(expectedResult, actualResult);
  }

  private static Stream<Arguments> provideTestInputsAndActualOutputs() {
    return Stream.of(Arguments.of(new int[] {1, 3, 5, 6}, 5, 2),
        Arguments.of(new int[] {1, 3, 5, 6}, 2, 1), Arguments.of(new int[] {1, 3, 5, 6}, 7, 4));
  }

}
