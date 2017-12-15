package com.bookselling.reactivedatastore.repositories;

/*
 * @author santoshsindham
 * @date 15/12/17, 9:43 PM
 */

import com.bookselling.reactivedatastore.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

}
