package two_pointers;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ReverseWordsTest {

  private final ReverseWords reverseWords = new ReverseWords();

  @ParameterizedTest
  @MethodSource("testReverseWordsInputs")
  void testReverseWords(String input, String expected) {
    Assertions.assertEquals(expected, reverseWords.reverseWords(input));
  }

  private static Stream<Arguments> testReverseWordsInputs() {
    return Stream.of(
        Arguments.of("We love Python ", "Python love We"),
        Arguments.of("1234 abc XYZ", "XYZ abc 1234"),
        Arguments.of("You are amazing", "amazing are You"),
        Arguments.of("Hello     World", "World Hello"),
        Arguments.of("   Greeting123   ", "Greeting123"),
        Arguments.of("the sky is blue", "blue is sky the"),
        Arguments.of(" hello world ", "world hello"),
        Arguments.of("a good   example", "example good a"));
  }
}
