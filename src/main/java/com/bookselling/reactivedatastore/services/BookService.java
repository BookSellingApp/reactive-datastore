package com.bookselling.reactivedatastore.services;

/*
 * @author santoshsindham
 * @date 18/12/17, 11:15 PM
 */

import com.bookselling.reactivedatastore.models.Book;
import com.bookselling.reactivedatastore.repositories.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Flux<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Book> findByTitle(String title) {
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(bookRepository.findByTitle(title).block());
        return bookList;
    }

    public Mono<Book> createBook(Book book) {
        return bookRepository.save(book);
    }

    public Mono<ResponseEntity<Book>> findById(String id) {
        return bookRepository.findById(id)
                .map(book -> ResponseEntity.ok(book))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    public Mono<ResponseEntity<Book>> updateBook(String id, Book book) {

        return bookRepository.findById(id)
                .flatMap(existingBook -> {
                    existingBook.setUpdatedAt(new Date());
                    existingBook.setImageUrl(book.getImageUrl());
                    existingBook.setDescription(book.getDescription());
                    existingBook.setCost(book.getCost());
                    existingBook.setAuthor(book.getAuthor());
                    existingBook.setTitle(book.getTitle());

                    return bookRepository.save(existingBook);
                })
                .map(updatedBook -> new ResponseEntity<>(updatedBook, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public Mono<ResponseEntity<Void>> deleteBook(String id) {

        return bookRepository.findById(id)
                .flatMap(existingBook ->
                        bookRepository.delete(existingBook)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
