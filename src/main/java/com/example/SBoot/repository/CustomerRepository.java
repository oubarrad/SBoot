package com.example.SBoot.repository;

import com.example.SBoot.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer save(Customer c);
    Customer findById(long id);

    Iterable<Customer> findByFirstName(String firstName);
    Iterable<Customer> findByLastName(String lastName);
}
