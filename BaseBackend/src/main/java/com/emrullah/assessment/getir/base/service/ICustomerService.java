package com.emrullah.assessment.getir.base.service;

import com.emrullah.assessment.getir.base.dto.user.CreateUserRequest;
import com.emrullah.assessment.getir.base.entity.customer.Customer;
import com.emrullah.assessment.getir.base.framework.exceptions.OperationResultException;

import java.util.Optional;

public interface ICustomerService {
    Optional<Customer> getByEmail(String email);
    void createUser(CreateUserRequest createUserRequest) throws OperationResultException;
}
