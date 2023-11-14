package org.kybprototyping.problems;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FindFirstAndLastPositionOfElementInSortedArrayTest {

  @ParameterizedTest
  @MethodSource("provideTestInputsAndActualOutputs")
  void searchRange_Should_Find_First_Last_Positions_Of_Given_Target(int[] nums, int target,
      int[] expectedResult) {
    // given

    // when
    var actualResult = FindFirstAndLastPositionOfElementInSortedArray.searchRange(nums, target);

    // then
    assertArrayEquals(expectedResult, actualResult);
  }

  private static Stream<Arguments> provideTestInputsAndActualOutputs() {
    return Stream.of(Arguments.of(new int[] {5, 7, 7, 8, 8, 10}, 8, new int[] {3, 4}),
        Arguments.of(new int[] {5, 7, 7, 8, 8, 10}, 6, new int[] {-1, -1}),
        Arguments.of(new int[] {}, 0, new int[] {-1, -1}),
        Arguments.of(new int[] {1}, 1, new int[] {0, 0}),
        Arguments.of(new int[] {2, 2}, 3, new int[] {-1, -1}),
        Arguments.of(new int[] {2, 2}, 2, new int[] {0, 1}),
        Arguments.of(new int[] {1, 2, 3}, 3, new int[] {2, 2}),
        Arguments.of(new int[] {0, 0, 1, 1, 1, 4, 5, 5}, 2, new int[] {-1, -1}));
  }

}
