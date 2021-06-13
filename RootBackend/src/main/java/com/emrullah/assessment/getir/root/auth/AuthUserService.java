package com.emrullah.assessment.getir.root.auth;

import com.emrullah.assessment.getir.base.entity.customer.Customer;
import com.emrullah.assessment.getir.base.framework.exceptions.OperationResultException;
import com.emrullah.assessment.getir.base.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public final class AuthUserService implements UserDetailsService {

    @Autowired
    private ICustomerService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException, OperationResultException {
        Customer customer =  userService.getByEmail(email);
        return new User(customer.getEmail(), customer.getPassword(), new ArrayList<>());
    }
}
