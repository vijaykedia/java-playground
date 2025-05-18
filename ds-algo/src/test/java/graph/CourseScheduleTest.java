package graph;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CourseScheduleTest {

  private final CourseSchedule solution = new CourseSchedule();

  @ParameterizedTest
  @MethodSource("testCanFinishInputs")
  void testCanFinish(int numCourses, int[][] prerequisites, boolean result) {
    if (result) {
      Assertions.assertTrue(solution.canFinish(numCourses, prerequisites));
    } else {
      Assertions.assertFalse(solution.canFinish(numCourses, prerequisites));
    }
  }

  private static Stream<Arguments> testCanFinishInputs() {
    return Stream.of(
        Arguments.of(2, new int[][] {{1, 0}}, true),
        Arguments.of(2, new int[][] {{1, 0}, {0, 1}}, false),
        Arguments.of(5, new int[][] {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {3, 4}}, true),
        Arguments.of(4, new int[][] {{0, 1}, {3, 1}, {1, 3}, {3, 2}}, false),
        Arguments.of(
            7, new int[][] {{1, 0}, {0, 3}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}}, true));
  }
}
