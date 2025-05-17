package sliding_window;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LongestSubstringWithoutRepeatingCharactersTest {

  private final LongestSubstringWithoutRepeatingCharacters solution =
      new LongestSubstringWithoutRepeatingCharacters();

  @ParameterizedTest
  @MethodSource("testLengthOfLongestSubstringInputs")
  void testLengthOfLongestSubstring(String input, int expected) {
    Assertions.assertEquals(expected, solution.lengthOfLongestSubstring(input));
  }

  private static Stream<Arguments> testLengthOfLongestSubstringInputs() {
    return Stream.of(
        Arguments.of("geeksforgeeks", 7),
        Arguments.of("abcabcbb", 3),
        Arguments.of("bbbbb", 1),
        Arguments.of("pwwkew", 3),
        Arguments.of("abcdbea", 5),
        Arguments.of("abccabcabcc", 3),
        Arguments.of("abcdefabcbb", 6));
  }
}
