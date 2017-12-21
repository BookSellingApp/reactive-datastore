package com.bookselling.reactivedatastore.repositories;

/*
 * @author santoshsindham
 * @date 18/12/17, 10:46 PM
 */

import com.bookselling.reactivedatastore.models.Order;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends ReactiveCrudRepository<Order, String> {
}
