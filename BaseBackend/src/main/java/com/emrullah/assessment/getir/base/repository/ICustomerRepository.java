package com.emrullah.assessment.getir.base.repository;

import com.emrullah.assessment.getir.base.entity.customer.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICustomerRepository extends MongoRepository<Customer, Long> {
    Optional<Customer> getByEmail(String email);
}
