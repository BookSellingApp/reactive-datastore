package com.bookselling.reactivedatastore.repositories;

import com.bookselling.reactivedatastore.models.Address;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/*
 * @author sindham
 * @date 18/12/17, 10:44 PM
 */

@Repository
public interface AddressRepository extends ReactiveCrudRepository<Address, String> {

    Flux<Address> findByPostalCode(String postalCode);
}

