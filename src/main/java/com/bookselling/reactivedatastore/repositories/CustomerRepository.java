package com.bookselling.reactivedatastore.repositories;

/*
 * @author santoshsindham
 * @date 18/12/17, 10:45 PM
 */

import com.bookselling.reactivedatastore.models.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CustomerRepository extends ReactiveCrudRepository<Customer, String> {

    Mono<Customer> findByFirstName(String firstName);

    Mono<Customer> findByLastName(String lastName);

    Mono<Customer> findByEmailId(String emailId);

    Mono<Customer> findByMobileNumber(String mobileNumber);
}
