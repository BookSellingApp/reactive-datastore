package com.bookselling.reactivedatastore.services;

/*
 * @author santoshsindham
 * @date 18/12/17, 11:15 PM
 */

import com.bookselling.reactivedatastore.models.Book;
import com.bookselling.reactivedatastore.repositories.BookRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Flux<Book> findAllBooks(){
        return bookRepository.findAll()
                .log("finding all books");
    }
 }
