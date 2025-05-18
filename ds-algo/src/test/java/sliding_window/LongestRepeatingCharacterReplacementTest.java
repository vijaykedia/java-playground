package sliding_window;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LongestRepeatingCharacterReplacementTest {

  private final LongestRepeatingCharacterReplacement solution =
      new LongestRepeatingCharacterReplacement();

  @ParameterizedTest
  @MethodSource("characterReplacementInputs")
  void testCharacterReplacement(String input, int noOfOperation, int expected) {
    Assertions.assertEquals(expected, solution.characterReplacement(input, noOfOperation));
  }

  private static Stream<Arguments> characterReplacementInputs() {
    return Stream.of(
        Arguments.of("ABAB", 0, 1),
        Arguments.of("ABAB", 2, 4),
        Arguments.of("AABABBA", 1, 4),
        Arguments.of("AAAA", 2, 4));
  }
}
