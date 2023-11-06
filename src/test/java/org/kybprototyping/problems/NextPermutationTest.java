package org.kybprototyping.problems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NextPermutationTest {

  @ParameterizedTest
  @MethodSource("provideTestInputsAndActualOutputs")
  void nextPermutation_Should_Set_Given_Nums_As_Its_Next_Lexicographically_Greater_Permutation() {

  }

  private static Stream<Arguments> provideTestInputsAndActualOutputs() {
    return Stream.of(Arguments.of());
  }

}
