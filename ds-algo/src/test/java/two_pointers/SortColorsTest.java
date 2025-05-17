package two_pointers;

import base.AbstractBaseTest;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SortColorsTest extends AbstractBaseTest {

  private final SortColors sortColors = new SortColors();

  @ParameterizedTest
  @MethodSource("sortColorsInput")
  void testSortColors(int[] input, String expected) {
    sortColors.sortColors(input);
    Assertions.assertEquals(expected, getOutputStreamCaptor().toString().trim());
  }

  private static Stream<Arguments> sortColorsInput() {
    return Stream.of(
        Arguments.of(new int[] {0, 1, 0}, "[0, 0, 1]"),
        Arguments.of(new int[] {1}, "[1]"),
        Arguments.of(new int[] {2, 2}, "[2, 2]"),
        Arguments.of(new int[] {1, 1, 0, 2}, "[0, 1, 1, 2]"),
        Arguments.of(new int[] {2, 1, 1, 0, 0}, "[0, 0, 1, 1, 2]"),
        Arguments.of(new int[] {2, 0, 2, 1, 1, 0}, "[0, 0, 1, 1, 2, 2]"),
        Arguments.of(new int[] {2, 0, 1}, "[0, 1, 2]"));
  }
}
