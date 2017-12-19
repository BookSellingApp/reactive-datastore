package com.bookselling.reactivedatastore.controllers;

/*
 * @author santoshsindham
 * @date 15/12/17, 9:45 PM
 */

import com.bookselling.reactivedatastore.models.Book;
import com.bookselling.reactivedatastore.repositories.BookRepository;
import com.bookselling.reactivedatastore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping ("/api")
@CrossOrigin ("*")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public Flux<Book> getAllBooks(){

        return bookService.findAllBooks();
    }

    @PostMapping("/books")
    public Mono<Book> createBook(@Valid @RequestBody Book book){

        return bookService.createBook(book);
    }

    @GetMapping(value = "/books/{id}")
    public Mono<ResponseEntity<Book>> getBookById(@PathVariable("id") String id){

        return bookService.findById(id);
    }

    @PutMapping(value = "/books/{id}")
    public Mono<ResponseEntity<Book>> updateBook(@PathVariable("id") String id, @Valid @RequestBody Book book){

        return bookService.updateBook(id, book);
    }

    @DeleteMapping(value = "/books/{id}")
    public Mono<ResponseEntity<Void>> deleteBook(@PathVariable("id") String id){

        return bookService.deleteBook(id);
    }
}
