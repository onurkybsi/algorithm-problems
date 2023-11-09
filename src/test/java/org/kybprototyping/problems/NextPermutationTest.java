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
        Arguments.of(new int[] {4, 2, 0, 2, 3, 2, 0}, new int[] {4, 2, 0, 3, 0, 2, 2}),
        Arguments.of(new int[] {6, 7, 5, 3, 5, 6, 2, 9, 1, 2, 7, 0, 9},
            new int[] {6, 7, 5, 3, 5, 6, 2, 9, 1, 2, 7, 9, 0}),
        Arguments.of(
            new int[] {16, 27, 25, 23, 25, 16, 12, 9, 1, 2, 7, 20, 19, 23, 16, 0, 6, 22, 16, 11, 8,
                27, 9, 2, 20, 2, 13, 7, 25, 29, 12, 12, 18, 29, 27, 13, 16, 1, 22, 9, 3, 21, 29, 14,
                7, 8, 14, 5, 0, 23, 16, 1, 20},
            new int[] {16, 27, 25, 23, 25, 16, 12, 9, 1, 2, 7, 20, 19, 23, 16, 0, 6, 22, 16, 11, 8,
                27, 9, 2, 20, 2, 13, 7, 25, 29, 12, 12, 18, 29, 27, 13, 16, 1, 22, 9, 3, 21, 29, 14,
                7, 8, 14, 5, 0, 23, 16, 20, 1}),
        Arguments.of(new int[] {4, 8, 8, 8, 9, 7, 7, 6, 4, 3},
            new int[] {4, 8, 8, 9, 3, 4, 6, 7, 7, 8}),
        Arguments.of(new int[] {3, 0, 3, 2, 1, 7, 5, 6, 5, 4, 2},
            new int[] {3, 0, 3, 2, 1, 7, 6, 2, 4, 5, 5}),
        Arguments.of(
            new int[] {0, 5, 20, 14, 1, 7, 29, 13, 16, 12, 11, 2, 25, 23, 29, 21, 18, 8, 27, 0, 5,
                2, 7, 9, 21, 19, 26, 13, 26, 8, 24, 26, 6, 7, 2, 7, 14, 1, 20, 0, 6, 24, 24, 23, 17,
                23, 14, 27, 2, 11, 27, 29, 5, 26, 8, 19, 15, 5, 2},
            new int[] {0, 5, 20, 14, 1, 7, 29, 13, 16, 12, 11, 2, 25, 23, 29, 21, 18, 8, 27, 0, 5,
                2, 7, 9, 21, 19, 26, 13, 26, 8, 24, 26, 6, 7, 2, 7, 14, 1, 20, 0, 6, 24, 24, 23, 17,
                23, 14, 27, 2, 11, 27, 29, 5, 26, 15, 2, 5, 8, 19}),
        Arguments.of(new int[] {2, 2, 7, 5, 4, 3, 2, 2, 1}, new int[] {2, 3, 1, 2, 2, 2, 4, 5, 7}),
        Arguments.of(
            new int[] {20, 28, 29, 10, 21, 13, 24, 18, 25, 28, 12, 2, 20, 16, 13, 6, 21, 20, 25, 17,
                24, 2, 10, 0, 13, 13, 19, 10, 4, 3, 13, 24, 2, 4, 5, 23, 18, 21, 11, 13, 11, 15, 8,
                1, 23, 13, 29, 7, 25, 24, 24},
            new int[] {20, 28, 29, 10, 21, 13, 24, 18, 25, 28, 12, 2, 20, 16, 13, 6, 21, 20, 25, 17,
                24, 2, 10, 0, 13, 13, 19, 10, 4, 3, 13, 24, 2, 4, 5, 23, 18, 21, 11, 13, 11, 15, 8,
                1, 23, 13, 29, 24, 7, 24, 25}));
  }

}
