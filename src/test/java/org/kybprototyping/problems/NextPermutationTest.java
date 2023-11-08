package org.kybprototyping.problems;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NextPermutationTest {

  @ParameterizedTest
  @MethodSource("provideTestInputsAndActualOutputs")
  void nextPermutation_Should_Set_Given_Nums_As_Its_Next_Lexicographically_Greater_Permutation(
      int[] nums, int[] expectedResult) {
    // given

    // when
    NextPermutation.nextPermutation(nums);

    // then
    assertArrayEquals(expectedResult, nums);
  }

  private static Stream<Arguments> provideTestInputsAndActualOutputs() {
    return Stream.of(Arguments.of(new int[] {2, 9, 0, 8}, new int[] {2, 9, 8, 0}),
        Arguments.of(new int[] {1, 2, 3}, new int[] {1, 3, 2}),
        Arguments.of(new int[] {3, 2, 1}, new int[] {1, 2, 3}),
        Arguments.of(new int[] {1, 1, 5}, new int[] {1, 5, 1}),
        Arguments.of(new int[] {1, 3, 2}, new int[] {2, 1, 3}),
        Arguments.of(new int[] {4, 2, 0, 2, 3, 2, 0}, new int[] {4, 2, 0, 3, 0, 2, 2}));
    // return Stream.of(Arguments.of(new int[] {6, 7, 5, 3, 5, 6, 2, 9, 1, 2, 7, 0, 9},
    // new int[] {6, 7, 5, 3, 5, 6, 2, 9, 1, 2, 7, 9, 0}));
  }

}
