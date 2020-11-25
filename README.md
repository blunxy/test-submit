# Bookshelf

## Preamble

You've seen one of these before:

![Alt text](doc-images/bookshelf.png)

This particular **bookcase** has a number of **bookshelves**. You're going to make a **Bookshelf** class, because such a thing is obviously _exceedingly_ useful.


### Things Our Bookshelf Will "Understand"

Here is some code that illustrates the public methods that our Bookshelf objects will have - that is, the _messages_ our Bookshelves will be able to respond to:

```java
Bookshelf mySelfTheShelf = new Bookshelf(100); // make a Bookshelf with 100cm of space

System.out.println(mySelfTheShelf.emptySpaceAvailable()); // displays 100

int numBooksOnShelf = mySelfTheShelf.numBooksPresent();   // numBooksOnShelf = 0

boolean fits = mySelfTheShelf.willFit(99);  // fits holds a value of true (big book btw)

mySelfTheShelf.placeBookOfWidth(30); // on goes a book of width 30

numBooksOnShelf = mySelfTheShelf.numBooksPresent();  // numBooksOnShelf = 1 now

mySelfTheShelf.removeBookOfWidth(30);  // off goes the book of width 30

System.out.println(mySelfTheShelf.emptySpaceAvailable()); // displays 100
```

## Instructions

1. Complete the `Bookshelf` class provided, using the documentation to guide you, then
1. Use your erudite `Bookshelf` class in the `main` and complete the TODO items there. If you've followed the instructions, a user would see something like the following happening in the console when they run your code:

```json
How wide should the shelf be? 87
Let's place a book!
Width of book to place? 37
There is 1 book on the shelf and 50 cm of free space left.

Let's place another book!
Width of book to place? 51
There is 1 book on the shelf and 50 cm of free space left.
```

## Hints & Suggestions

- it's useful to have a helper method that how much space is used currently; if you make one, remember that it should be private ('cause it's a helper, not part of your public API)
- when placing a book, you might want to use one of your public methods to help you figure out when there's enough room

## Tests

Your code is being tested in two ways:

1. Does your `Bookshelf` have methods that behave as expected? We'll test that using a variety of tests found in the test folder, like `Bookshelf_AddTo_Tests` and `Bookshelf_RemoveFrom_Tests`. These tests will call your class' methods with a variety of inputs.
1. Can you figure out how to use your class? We'll find out using `MainTest`, which makes sure that what appears in the console is what is expected.
