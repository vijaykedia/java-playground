package base;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;

@Getter
public abstract class AbstractBaseTest {

  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }
}
