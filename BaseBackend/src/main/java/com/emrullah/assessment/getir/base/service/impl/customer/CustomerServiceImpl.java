package com.emrullah.assessment.getir.base.service.impl.customer;

import com.emrullah.assessment.getir.base.dto.user.CreateUserRequest;
import com.emrullah.assessment.getir.base.entity.customer.Customer;
import com.emrullah.assessment.getir.base.framework.OperationResult;
import com.emrullah.assessment.getir.base.framework.exceptions.OperationResultException;
import com.emrullah.assessment.getir.base.repository.ICustomerRepository;
import com.emrullah.assessment.getir.base.service.ICustomerService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Optional<Customer> getByEmail(String email) {
        return customerRepository.getByEmail(email);
    }

    @Override
    public void createUser(CreateUserRequest createUserRequest) throws OperationResultException {
        processRequestPreValidations(createUserRequest);
        // We could perform dto mapping with dozzer
        Customer aplUser = new Customer(createUserRequest.getName(), createUserRequest.getSurname());
        aplUser.setEmail(createUserRequest.getEmail());
        aplUser.setPassword(passwordEncoder.encode(createUserRequest.getPwd()));

        customerRepository.save(aplUser);
    }

    private void processRequestPreValidations(CreateUserRequest createUserRequest) throws OperationResultException {
        if (Objects.isNull(createUserRequest) || StringUtils.isEmpty(createUserRequest.getName()) || StringUtils.isEmpty(createUserRequest.getSurname()))
            throw new OperationResultException(OperationResult.createErrorResult(HttpStatus.NOT_ACCEPTABLE, "No valid request."));
    }
}
