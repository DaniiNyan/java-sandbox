package com.daniinyan.functioncomposition;

public class FunctionalInterfaces {

  @FunctionalInterface
  public interface Square {
    int calculate(int number);
  }

  @FunctionalInterface
  public interface BookDisplay {
    void print(Book book);
  }

  public static void main(String[] args) {
    Book myBook = new Book("My Book", "Me", 2020);

    BookDisplay bookName = book -> System.out.println(book.getName());
    bookName.print(myBook);

    BookDisplay bookAuthor = book -> System.out.println(book.getAuthor());
    bookAuthor.print(myBook);

    Square square = (int number) -> number * number;
    System.out.println("Result: " + square.calculate(4));
  }

}
