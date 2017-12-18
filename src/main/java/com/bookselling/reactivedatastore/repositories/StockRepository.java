package com.bookselling.reactivedatastore.repositories;

/*
 * @author santoshsindham
 * @date 18/12/17, 10:47 PM
 */

import com.bookselling.reactivedatastore.models.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends ReactiveCrudRepository<Stock, String> {
}
