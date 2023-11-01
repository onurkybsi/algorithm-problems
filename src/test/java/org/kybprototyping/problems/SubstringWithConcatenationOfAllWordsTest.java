package org.kybprototyping.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;

class SubstringWithConcatenationOfAllWordsTest {

  @ParameterizedTest
  @MethodSource("provideTestInputsAndActualOutputs")
  void findSubstring_Should_Return_Starting_Indices_Of_All_The_Concatenated_Substrings_In_S(
      String s, String[] words, List<Integer> actualOutput) {
    assertEquals(actualOutput, SubstringWithConcatenationOfAllWords.findSubstring(s, words));
  }

  private static Stream<Arguments> provideTestInputsAndActualOutputs() {
    return Stream.of(Arguments.of("barfoothefoobarman", new String[] {"foo", "bar"}, List.of(0, 9)),
        Arguments.of("wordgoodgoodgoodbestword", new String[] {"word", "good", "best", "word"},
            List.of()),
        Arguments.of("barfoofoobarthefoobarman", new String[] {"bar", "foo", "the"},
            List.of(6, 9, 12)),
        Arguments.of("wordgoodgoodgoodbestword", new String[] {"word", "good", "best", "good"},
            List.of(8)),
        Arguments.of("a", new String[] {"a"}, List.of(0)), Arguments.of("aaaaaaaaaaaaaa",
            new String[] {"aa", "aa"}, List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
  }

}
