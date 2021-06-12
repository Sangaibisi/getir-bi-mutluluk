package com.emrullah.assessment.getir.base.service.impl.user;

import com.emrullah.assessment.getir.base.entity.user.AplUserEntity;
import com.emrullah.assessment.getir.base.repository.IAplUserRepository;
import com.emrullah.assessment.getir.base.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IAplUserRepository aplUserRepository;

    @Override
    public Optional<AplUserEntity> getByEmail(String email) {
        return aplUserRepository.getByEmail(email);
    }
}
