package test;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import main.Bookshelf;

public class Bookshelf_AddTo_Tests {

  @Nested
  @DisplayName("a nested test")
  class ANestedTest {

    @Test
    @DisplayName("this will pass")
    public void this_will_pass() {

      assertThat(true).isTrue();
    }
  }

  @Nested
  @DisplayName("nested add tests")
  class NestedAddTests {
    @DisplayName("placing a single book on that fits reduces free space")
    @Test
    public void placing_a_book_on_that_fits_reduces_free_space() {
      int someWidth = 100;
      Bookshelf shelf = new Bookshelf(someWidth);

      shelf.placeBookOfWidth(20);
      assertThat(shelf.emptySpaceAvailable()).isEqualTo(80);
    }

    @DisplayName("placing a single book that fits increases book count by one")
    @Test
    public void placing_a_book_on_that_fits_increases_book_count_by_one() {
      int someWidth = 43;
      Bookshelf shelf = new Bookshelf(someWidth);

      int someBookWidth = 13;
      shelf.placeBookOfWidth(someBookWidth);
      assertThat(shelf.numBooksPresent()).isEqualTo(1);

      int someOtherBookWidth = 20;
      shelf.placeBookOfWidth(someOtherBookWidth);
      assertThat(shelf.numBooksPresent()).isEqualTo(2);
    }

    @DisplayName("placing multiple books on that fit reduces free space")
    @Test
    public void placing_multiple_books_on_that_fit_reduces_free_space() {
      int someWidth = 200;
      Bookshelf shelf = new Bookshelf(someWidth);

      shelf.placeBookOfWidth(40);
      assertThat(shelf.emptySpaceAvailable()).isEqualTo(160);

      shelf.placeBookOfWidth(20);
      assertThat(shelf.emptySpaceAvailable()).isEqualTo(140);
    }

    @DisplayName("attempting to place a book that doesn't fit doesn't change free space")
    @Test
    public void attempting_to_put_book_that_doesnt_fit_doesnt_change_free_space() {
      int someWidth = 8;
      Bookshelf shelf = new Bookshelf(someWidth);

      shelf.placeBookOfWidth(2);
      assertThat(shelf.emptySpaceAvailable()).isEqualTo(6);

      shelf.placeBookOfWidth(7);
      assertThat(shelf.emptySpaceAvailable()).isEqualTo(6);
    }

    @DisplayName("attempting to place a book that doesn't fit doesn't change the count")
    @Test
    public void attempting_to_place_book_that_doesnt_fit_doesnt_change_the_count() {
      int someWidth = 8;
      Bookshelf shelf = new Bookshelf(someWidth);

      shelf.placeBookOfWidth(2);
      assertThat(shelf.numBooksPresent()).isEqualTo(1);

      shelf.placeBookOfWidth(7);
      assertThat(shelf.numBooksPresent()).isEqualTo(1);
    }

    @DisplayName(
        "placing a book that just barely fits still reduces free space and increases the count")
    @Test
    public void
        placing_book_that_just_barely_fits_still_reduces_free_space_and_increases_the_count() {
      int someWidth = 43;
      Bookshelf shelf = new Bookshelf(someWidth);

      shelf.placeBookOfWidth(someWidth);
      assertThat(shelf.numBooksPresent()).isEqualTo(1);
      assertThat(shelf.emptySpaceAvailable()).isEqualTo(0);
    }
  }
}
