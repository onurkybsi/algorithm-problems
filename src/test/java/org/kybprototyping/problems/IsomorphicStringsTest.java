package org.kybprototyping.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IsomorphicStringsTest {

  @ParameterizedTest
  @MethodSource("provideTestInputsAndActualOutputs")
  void isIsomorphic_Should_Return_(String s, String t, boolean expectedResult) {
    // given

    // when
    var actualResult = IsomorphicStrings.isIsomorphic(s, t);

    // then
    assertEquals(expectedResult, actualResult);
  }

  private static Stream<Arguments> provideTestInputsAndActualOutputs() {
    return Stream.of(Arguments.of("egg", "add", true), Arguments.of("foo", "bar", false),
        Arguments.of("paper", "title", true), Arguments.of("badc", "baba", false));
  }

}
