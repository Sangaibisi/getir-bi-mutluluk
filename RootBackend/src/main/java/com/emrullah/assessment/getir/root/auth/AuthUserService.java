package com.emrullah.assessment.getir.root.auth;

import com.emrullah.assessment.getir.base.entity.user.AplUserEntity;
import com.emrullah.assessment.getir.base.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public final class AuthUserService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<AplUserEntity> user =  userService.getByEmail(email);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        AplUserEntity userDetail = user.get();
        return new User(userDetail.getEmail(), userDetail.getPassword(), new ArrayList<>());
    }
}
