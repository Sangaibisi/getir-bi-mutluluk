package com.emrullah.assessment.getir.base.service;

import com.emrullah.assessment.getir.base.dto.user.CreateUserRequest;
import com.emrullah.assessment.getir.base.entity.customer.Customer;
import com.emrullah.assessment.getir.base.entity.order.Order;
import com.emrullah.assessment.getir.base.framework.exceptions.OperationResultException;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Customer getByEmail(String email) throws OperationResultException;
    void createCustomer(CreateUserRequest createUserRequest) throws OperationResultException;
    List<Order> retrieveCustomerOrdersByEmail(String email) throws OperationResultException;
}
