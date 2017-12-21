package com.bookselling.reactivedatastore.services;

/*
 * @author santoshsindham
 * @date 21/12/17, 11:40 AM
 */

import com.bookselling.reactivedatastore.models.Customer;
import com.bookselling.reactivedatastore.repositories.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Flux<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public Mono<Customer> createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Mono<ResponseEntity<Customer>> findById(String id) {
        return customerRepository.findById(id)
                .map(fetchedCustomer -> ResponseEntity.ok(fetchedCustomer))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    public Mono<ResponseEntity<Customer>> updateCustomer(String id, Customer customer) {

        return customerRepository.findById(id)
                .flatMap(existingCustomer -> {
                    existingCustomer.setEmailId(customer.getEmailId());
//                    existingCustomer.setAddress(customer.getAddress());
                    existingCustomer.setFirstName(customer.getFirstName());
                    existingCustomer.setLastName(customer.getLastName());
                    existingCustomer.setMobileNumber(customer.getMobileNumber());
//                    existingCustomer.setOrders(customer.getOrders());

                    return customerRepository.save(existingCustomer);
                })
                .map(updatedCustomer -> new ResponseEntity<>(updatedCustomer, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public Mono<ResponseEntity<Void>> deleteCustomer(String id) {

        return customerRepository.findById(id)
                .flatMap(existingCustomer ->
                        customerRepository.delete(existingCustomer)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
