package fast_slow_pointer;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FindDuplicateTest {

  private final FindDuplicate findDuplicate = new FindDuplicate();

  @ParameterizedTest
  @MethodSource("testFindDuplicateInputs")
  void testFindDuplicate(int[] input, int expected) {
    Assertions.assertEquals(expected, findDuplicate.findDuplicate(input));
  }

  private static Stream<Arguments> testFindDuplicateInputs() {
    return Stream.of(
        Arguments.of(new int[] {1, 2, 2}, 2),
        Arguments.of(new int[] {1, 1}, 1),
        Arguments.of(new int[] {1, 3, 4, 2, 2}, 2),
        Arguments.of(new int[] {1, 3, 6, 2, 7, 3, 5, 4}, 3),
        Arguments.of(new int[] {3, 4, 4, 4, 2}, 4));
  }
}
