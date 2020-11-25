package test;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Bookshelf;

public class Bookshelf_RemoveFrom_Tests {

  @DisplayName("adding then removing a single book doesnt change free space")
  @Test
  public void adding_then_removing_a_single_book_doesnt_change_free_space() {
    int someShelfWidth = 100;
    Bookshelf shelf = new Bookshelf(someShelfWidth);

    int someBookWidth = 20;
    shelf.placeBookOfWidth(someBookWidth);
    shelf.removeBookOfWidth(someBookWidth);

    assertThat(shelf.emptySpaceAvailable()).isEqualTo(someShelfWidth);
  }

  @DisplayName("adding then removing a single book doesnt change book count by one")
  @Test
  public void adding_then_removing_a_single_book_doesnt_change_book_count() {
    int someShelfWidth = 43;
    Bookshelf shelf = new Bookshelf(someShelfWidth);

    int someBookWidth = 13;
    shelf.placeBookOfWidth(someBookWidth);
    shelf.removeBookOfWidth(someBookWidth);

    assertThat(shelf.numBooksPresent()).isEqualTo(0);
  }

  @DisplayName("removing multiple books increases free space")
  @Test
  public void removing_multiple_books_increases_free_space() {
    int someShelfWidth = 200;
    Bookshelf shelf = new Bookshelf(someShelfWidth);

    shelf.placeBookOfWidth(40); // down to 160
    shelf.placeBookOfWidth(50); // down to 110
    shelf.placeBookOfWidth(60); // down to 50

    shelf.removeBookOfWidth(50);
    assertThat(shelf.emptySpaceAvailable()).isEqualTo(100);

    shelf.removeBookOfWidth(40);
    assertThat(shelf.emptySpaceAvailable()).isEqualTo(140);
  }

  @DisplayName("removing multiple books decreases number of books present")
  @Test
  public void removing_multiple_books_decreases_number_of_books_present() {
    int someShelfWidth = 98;
    Bookshelf shelf = new Bookshelf(someShelfWidth);

    int someBookWidth = 12;
    shelf.placeBookOfWidth(someBookWidth);
    shelf.placeBookOfWidth(someBookWidth);
    shelf.placeBookOfWidth(someBookWidth);

    shelf.removeBookOfWidth(someBookWidth);
    assertThat(shelf.numBooksPresent()).isEqualTo(2);

    shelf.removeBookOfWidth(someBookWidth);
    assertThat(shelf.numBooksPresent()).isEqualTo(1);
  }

  @DisplayName(
      "attempting to remove a book that brings free space under 0 doesn't change free space")
  @Test
  public void attempting_to_remove_book_that_brings_free_space_under_0_doesnt_change_free_space() {
    int someShelfWidth = 18;
    Bookshelf shelf = new Bookshelf(someShelfWidth);

    shelf.placeBookOfWidth(2);
    assertThat(shelf.emptySpaceAvailable()).isEqualTo(16);

    shelf.removeBookOfWidth(3);
    assertThat(shelf.emptySpaceAvailable()).isEqualTo(16);
  }

  @DisplayName("attempting to remove a book that brings free space under 0 doesn't change count")
  @Test
  public void attempting_to_remove_book_that_brings_free_space_under_0_doesnt_change_count() {
    int someShelfWidth = 18;
    Bookshelf shelf = new Bookshelf(someShelfWidth);

    shelf.placeBookOfWidth(2);
    assertThat(shelf.numBooksPresent()).isEqualTo(1);

    shelf.removeBookOfWidth(3);
    assertThat(shelf.numBooksPresent()).isEqualTo(1);
  }

  @DisplayName("removing last book still increases free space and decreases the count")
  @Test
  public void removing_last_book_still_increases_free_space_and_decreases_the_count() {
    int someShelfWidth = 43;
    Bookshelf shelf = new Bookshelf(someShelfWidth);

    int someBookWidth = 33;
    shelf.placeBookOfWidth(someBookWidth);
    shelf.removeBookOfWidth(someBookWidth);

    assertThat(shelf.emptySpaceAvailable()).isEqualTo(someShelfWidth);
    assertThat(shelf.numBooksPresent()).isEqualTo(0);
  }
}
