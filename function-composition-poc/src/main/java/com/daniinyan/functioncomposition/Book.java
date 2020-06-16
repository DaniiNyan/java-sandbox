package com.daniinyan.functioncomposition;

public class Book {

  private String name;
  private String author;
  private Integer releaseYear;

  public Book(String name, String author, Integer releaseYear) {
    this.name = name;
    this.author = author;
    this.releaseYear = releaseYear;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Integer getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(Integer releaseYear) {
    this.releaseYear = releaseYear;
  }

  @Override
  public String toString() {
    return "Book: { " +
        "name = '" + name + '\'' +
        ", author = '" + author + '\'' +
        ", releaseYear = " + releaseYear +
        " }";
  }
}
