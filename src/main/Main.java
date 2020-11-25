package main;

import java.util.Scanner;

public class Main {

  /**
   * We can use our main as a convenient place to play with our code...to see it in action.
   *
   * @param args the usual main args
   */
  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);

    System.out.print("How wide should the shelf be? ");
    int shelfWidth = kbd.nextInt();

    Bookshelf shelf = new Bookshelf(shelfWidth);

    System.out.println("Let's place a book!");

    System.out.print("Width of book to place? ");
    int bookWidth = kbd.nextInt();

    shelf.placeBookOfWidth(bookWidth);

    int numBooksOnShelf = shelf.numBooksPresent();
    int freeSpaceLeftOnShelf = shelf.emptySpaceAvailable();

    System.out.format(
        "There is %d book on the shelf and %d cm of free space left.%n",
        numBooksOnShelf, freeSpaceLeftOnShelf);

    System.out.println();

    System.out.println("Let's place another book!");

    System.out.print("Width of book to place? ");
    bookWidth = kbd.nextInt();

    shelf.placeBookOfWidth(bookWidth);

    numBooksOnShelf = shelf.numBooksPresent();
    freeSpaceLeftOnShelf = shelf.emptySpaceAvailable();

    System.out.format(
        "There is %d book on the shelf and %d cm of free space left.%n",
        numBooksOnShelf, freeSpaceLeftOnShelf);
  }
}
