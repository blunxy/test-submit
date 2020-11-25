package main;

/**
 * Simulates a Bookshelf in a very simple way. As this is meant to be an introductory-level class,
 * there are no Book objects involved - instead, we just deal with widths to represent books. This
 * creates some oddness with placing/removing "books" (for example, you can "remove" a "book" by
 * supplying a width that was never used previously!), but such is life in introductory-land.
 *
 * @author jpratt
 */
public class Bookshelf {

  private int emptySpaceAvailable;
  private int numBooksPresent;
  private int width;

  /**
   * Creates a Bookshelf with a width in whole cm that has no books on it.
   *
   * <p>ASSUMPTIONS:
   *
   * <ul>
   *   <li>the width is >= 0
   * </ul>
   *
   * @param widthInWholeCm the width of this shelf in whole cm
   */
  public Bookshelf(int widthInWholeCm) {
    this.width = widthInWholeCm;
    this.emptySpaceAvailable = widthInWholeCm;
    this.numBooksPresent = 0;
  }

  /**
   * Returns the number of books currently on this Bookshelf.
   *
   * @return the number of books currently on this Bookshelf
   */
  public int numBooksPresent() {
    return numBooksPresent;
  }

  /**
   * Returns the amount of empty space in whole cm left on this Bookshelf.
   *
   * @return the amount of empty space in whole cm left on this Bookshelf
   */
  public int emptySpaceAvailable() {
    return emptySpaceAvailable;
  }

  /**
   * Returns true iff there is enough room on this Bookshelf to fit a book of the given width.
   *
   * @param widthInCm the width, in whole cm, of the book to fit
   * @return true iff a book of the given width can fit on this Bookshelf
   */
  public boolean willFit(int widthInCm) {
    return emptySpaceAvailable() >= widthInCm;
  }

  /**
   * Places a book of a given width on this Bookshelf, increasing the number of books on this shelf
   * and decreasing the amount of empty space available.
   *
   * <p>ASSUMPTIONS:
   *
   * <ul>
   *   <li>if the width of the book is greater than the available empty space, the book is **not**
   *       placed; no error message is given
   * </ul>
   *
   * @param widthInCm the width of the book to place on this Bookshelf
   */
  public void placeBookOfWidth(int widthInCm) {
    if (willFit(widthInCm)) {
      emptySpaceAvailable -= widthInCm;
      numBooksPresent++;
    }
  }

  /**
   * Removes a book of a given width from this Bookshelf, decreasing the number of books on this
   * shelf and increasing the amount of empty space available.
   *
   * <p>ASSUMPTIONS:
   *
   * <ul>
   *   <li>if the width of the book is less than the available empty space, the book is **not**
   *       removed; no error message is given
   * </ul>
   *
   * @param widthInCm the width of the book to remove from this Bookshelf
   */
  public void removeBookOfWidth(int widthInCm) {
    if (usedSpace() >= widthInCm) {
      emptySpaceAvailable += widthInCm;
      numBooksPresent--;
    }
  }

  private int usedSpace() {
    return width - emptySpaceAvailable();
  }
}
