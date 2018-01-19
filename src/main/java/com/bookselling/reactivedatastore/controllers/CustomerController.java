package com.bookselling.reactivedatastore.controllers;

/*
 * @author sindham
 * @date 21/12/17, 11:40 AM
 */

import com.bookselling.reactivedatastore.models.Customer;
import com.bookselling.reactivedatastore.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public Flux<Customer> getAllCustomers() {

        return customerService.findAllCustomers();
    }

    @GetMapping(value = "/customers/search/{firstName}")
    public  Iterable<Customer> getCustomerByFirstName(@PathVariable("firstName") String firstName) {

        return customerService.findByFirstName(firstName);
    }

    @PostMapping("/customers")
    public Mono<Customer> createCustomer(@Valid @RequestBody Customer customer) {

        return customerService.createCustomer(customer);
    }

    @GetMapping(value = "/customers/{id}")
    public Mono<ResponseEntity<Customer>> getCustomerById(@PathVariable("id") String id) {

        return customerService.findById(id);
    }

    @PutMapping(value = "/customers/{id}")
    public Mono<ResponseEntity<Customer>> updateCustomer(@PathVariable("id") String id, @Valid @RequestBody Customer customer) {

        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping(value = "/customers/{id}")
    public Mono<ResponseEntity<Void>> deleteCustomer(@PathVariable("id") String id) {

        return customerService.deleteCustomer(id);
    }
}
