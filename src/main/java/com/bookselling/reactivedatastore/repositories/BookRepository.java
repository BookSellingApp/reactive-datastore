package com.bookselling.reactivedatastore.repositories;

/*
 * @author sindham
 * @date 15/12/17, 9:43 PM
 */

import com.bookselling.reactivedatastore.models.Book;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface BookRepository extends ReactiveCrudRepository<Book, String> {

//    Iterable<Book> findByBookTitle(String title);

    Mono<Book> findByTitle(String title);

    Flux<Book> findByAuthor(String author);
}
