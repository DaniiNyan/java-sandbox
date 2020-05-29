package com.daniinyan.webfluxpoc;

import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/hello")
    @ResponseBody
    public Publisher<String> helloWorld() {
        return Mono.just("Hello WebFlux testing world!");
    }

    @GetMapping("/books")
    @ResponseBody
    public Flux<Book> getAllBooks() {
        logger.info("Getting books...");
        return bookRepository.findAll();
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Book> saveBook(@RequestBody Book book) {
        logger.info("Saving book: " + book.getName());
        return bookRepository.save(book);
    }

    @DeleteMapping("/books")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<Void> deleteAllBooks() {
        logger.info("Deleting all books...");
        return bookRepository.deleteAll();
    }

    @PostMapping("/books/init")
    @ResponseStatus(HttpStatus.CREATED)
    public Flux<Book> insertInitialData() {
        List<Book> books = Arrays.asList(
                new Book("1984", "George Orwell"),
                new Book("Harry Potter", "J. K. Rolling"),
                new Book("Lord of the Rings", "J. R. R. Tolkien")
        );

        logger.info("Inserting initial data...");
        return bookRepository.saveAll(books);
    }

    @PatchMapping("/books/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Book> updateBook(@PathVariable String bookId, @RequestBody Book book) {
        return bookRepository.findById(bookId)
                .map(b -> {book.setId(bookId); return book;})
                .flatMap(updatedBook -> bookRepository.save(updatedBook));
    }
}
