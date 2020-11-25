package test;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Bookshelf;

public class Bookshelf_NewState_Tests {

  @DisplayName("a new Bookshelf has no books on it")
  @Test
  public void new_bookshelf_has_no_books_on_it() {
    int someWidth = 17;
    Bookshelf shelf = new Bookshelf(someWidth);

    assertThat(shelf.numBooksPresent()).isEqualTo(0);
  }

  @DisplayName("a new bookshelf starts with empty space equal to its width")
  @Test
  public void new_bookshelf_starts_with_empty_space_equal_to_its_width() {
    int someWidth = 209;
    Bookshelf shelf = new Bookshelf(someWidth);

    assertThat(shelf.emptySpaceAvailable()).isEqualTo(someWidth);
  }
}
