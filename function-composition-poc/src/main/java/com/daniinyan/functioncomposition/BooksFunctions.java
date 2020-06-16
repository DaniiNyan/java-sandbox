package com.daniinyan.functioncomposition;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BooksFunctions {

  public static void main(String[] args) {
    // setup
    Book donQuixote = new Book("Don Quixote", "Miguel de Cervantes", 1612);
    Book oAlquimista = new Book("O Alquimista", "Paulo Coelho", 1988);
    Book theLordOfTheRings = new Book("The Lord of The Rings", "J. R. R. Tolkien", 1954);
    Book harryPotterFirst = new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997);
    Book harryPotterSecond = new Book(" Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998);
    Book theHobbit = new Book("The Hobbit", "J. R. R. Tolkien", 1937);
    List<Book> bookList = Arrays
        .asList(donQuixote, oAlquimista, theLordOfTheRings, harryPotterFirst, harryPotterSecond, theHobbit);

    // simple functions
    Function<List<Book>, Optional<Book>> first =
        books -> books.stream().findFirst();

    Function<List<Book>, Optional<Book>> last =
        books -> books.stream().min((x, y) -> y.getReleaseYear().compareTo(x.getReleaseYear()));

    Function<List<Book>, List<Book>> sortByReleaseYear =
        books -> books.stream()
            .sorted(Comparator.comparing(Book::getReleaseYear))
            .collect(Collectors.toList());
    System.out.println("Sorted by release year: " + sortByReleaseYear.apply(bookList));

    BiFunction<String, List<Book>, List<Book>> filterByAuthor =
        (authorName, books) -> books.stream()
            .filter(book -> book.getAuthor().equals(authorName))
            .collect(Collectors.toList());
    System.out.println("Filtered by J. R. R. Tolkien: " + filterByAuthor.apply("J. R. R. Tolkien", bookList));

    // composed functions
    Function<List<Book>, Optional<Book>> firstBookReleased = sortByReleaseYear.andThen(first);
    System.out.println("First book released: " + firstBookReleased.apply(bookList).get());

    Function<List<Book>, Optional<Book>> lastBookReleased = sortByReleaseYear.andThen(last);
    System.out.println("Last book released: " + lastBookReleased.apply(bookList).get());

    BiFunction<String, List<Book>, Optional<Book>> lastReleaseByAuthor = filterByAuthor.andThen(lastBookReleased);
    System.out.println("Last release by J. K. Rowling: " + lastReleaseByAuthor.apply("J. K. Rowling", bookList).get());

  }

}
