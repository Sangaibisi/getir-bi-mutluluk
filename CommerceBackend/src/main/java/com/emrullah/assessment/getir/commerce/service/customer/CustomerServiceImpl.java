package com.emrullah.assessment.getir.commerce.service.customer;

import com.emrullah.assessment.getir.base.dto.user.CreateUserRequest;
import com.emrullah.assessment.getir.base.entity.customer.Customer;
import com.emrullah.assessment.getir.base.entity.order.Order;
import com.emrullah.assessment.getir.base.framework.OperationResult;
import com.emrullah.assessment.getir.base.framework.exceptions.OperationResultException;
import com.emrullah.assessment.getir.base.repository.ICustomerRepository;
import com.emrullah.assessment.getir.base.repository.IOrderRepository;
import com.emrullah.assessment.getir.base.service.ICustomerService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceImpl implements ICustomerService {

    private final PasswordEncoder passwordEncoder;
    private final ICustomerRepository customerRepository;
    private final IOrderRepository orderRepository;

    @Autowired
    public CustomerServiceImpl(PasswordEncoder passwordEncoder, ICustomerRepository customerRepository, IOrderRepository orderRepository) {
        this.passwordEncoder = passwordEncoder;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Customer getByEmail(String email) throws OperationResultException {
        return customerRepository.getByEmail(email).orElseThrow(() -> new OperationResultException(OperationResult.createErrorResult(HttpStatus.NOT_ACCEPTABLE, "No valid request.")));
    }

    @Override
    public void createCustomer(CreateUserRequest createUserRequest) throws OperationResultException {
        processRequestPreValidations(createUserRequest);
        try {
            // We could perform dto mapping with dozzer
            Customer newCustomer = new Customer(createUserRequest.getName(), createUserRequest.getSurname());
            newCustomer.setEmail(createUserRequest.getEmail());
            newCustomer.setPassword(passwordEncoder.encode(createUserRequest.getPwd()));
            newCustomer.setAddresses(createUserRequest.getAddresses());

            customerRepository.save(newCustomer);
        } catch (DuplicateKeyException e) {
            throw new OperationResultException(OperationResult.createErrorResult(HttpStatus.CONFLICT, "There is a already user with same email : " + createUserRequest.getEmail()));
        }
    }

    @Override
    public List<Order> retrieveCustomerOrdersByEmail(String email) throws OperationResultException {
        Customer customer = this.getByEmail(email);
        return orderRepository.findByCustomer(customer);
    }

    private void processRequestPreValidations(CreateUserRequest createUserRequest) throws OperationResultException {
        if (Objects.isNull(createUserRequest) || StringUtils.isEmpty(createUserRequest.getName()) || StringUtils.isEmpty(createUserRequest.getSurname()))
            throw new OperationResultException(OperationResult.createErrorResult(HttpStatus.NOT_ACCEPTABLE, "No valid request."));
    }
}
