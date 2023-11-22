package org.kybprototyping.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FirstUniqueCharacterInAStringTest {

  @ParameterizedTest
  @MethodSource("provideTestInputsAndActualOutputs")
  void firstUniqChar_Should_Return_First_Unique_Char_In_Given_String(String s, int expectedResult) {
    // given

    // when
    int actualResult = FirstUniqueCharacterInAString.firstUniqChar(s);

    // then
    assertEquals(expectedResult, actualResult);
  }

  private static Stream<Arguments> provideTestInputsAndActualOutputs() {
    return Stream.of(Arguments.of("leetcode", 0), Arguments.of("loveleetcode", 2),
        Arguments.of("aabb", -1));
  }

}
