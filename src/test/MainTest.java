package test;

import static org.assertj.core.api.Assertions.*;
import static com.github.stefanbirkner.systemlambda.SystemLambda.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Main;

public class MainTest {

  @Test
  @DisplayName("Expected statements should appear in the console.")
  public void console_displays_expected_text() throws Exception {
    withTextFromSystemIn("100", "12", "89")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "How wide should the shelf be?",
                      "Let's place a book!",
                      "Width of book to place?",
                      "There is 1 book on the shelf and 88 cm of free space left.",
                      "Let's place another book!",
                      "Width of book to place?",
                      "There is 1 book on the shelf and 88 cm of free space left.");

              String whatIsOutput = tapSystemOutNormalized(() -> Main.main(new String[0])).trim();

              assertThat(whatIsOutput).containsSubsequence(expectedOutputParts);
            });
  }
}
