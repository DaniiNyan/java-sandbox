package com.daniinyan.functioncomposition;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BooksPredicates {

  public static void main(String[] args) {
    Book theLordOfTheRings = new Book("The Lord of The Rings", "J. R. R. Tolkien", 1954);
    Book harryPotterFirst = new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997);
    Book memoirsOfAGeisha = new Book("Memoirs of a Geisha", "Arthur Golden", 1997);
    Book tuesdaysWithMorrie = new Book("Tuesdays with Morrie", "Mitch Albom", 1997);
    Book harryPotterSecond = new Book(" Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998);
    List<Book> bookList = Arrays
        .asList(theLordOfTheRings, harryPotterFirst, memoirsOfAGeisha, tuesdaysWithMorrie, harryPotterSecond);

    Predicate<Book> isByJKRowling = book -> book.getAuthor().equals("J. K. Rowling");
    List<Book> rowlingBooks = bookList.stream()
        .filter(isByJKRowling)
        .collect(Collectors.toList());
    System.out.println(rowlingBooks);

    Predicate<Book> isFrom1997 = book -> book.getReleaseYear().equals(1997);
    List<Book> rowlingBooksFrom1997 = bookList.stream()
        .filter(isByJKRowling)
        .filter(isFrom1997)
        .collect(Collectors.toList());
    System.out.println(rowlingBooksFrom1997);
  }

}
