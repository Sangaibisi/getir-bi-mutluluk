package com.emrullah.assessment.getir.base.service.impl.user;

import com.emrullah.assessment.getir.base.dto.user.CreateUserRequest;
import com.emrullah.assessment.getir.base.entity.user.AplUserEntity;
import com.emrullah.assessment.getir.base.framework.OperationResult;
import com.emrullah.assessment.getir.base.framework.exceptions.OperationResultException;
import com.emrullah.assessment.getir.base.repository.IAplUserRepository;
import com.emrullah.assessment.getir.base.service.IUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IAplUserRepository aplUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Optional<AplUserEntity> getByEmail(String email) {
        return aplUserRepository.getByEmail(email);
    }

    @Override
    public void createUser(CreateUserRequest createUserRequest) throws OperationResultException {
        processRequestPreValidations(createUserRequest);
        // We could perform dto mapping with dozzer
        AplUserEntity aplUser = new AplUserEntity();
        aplUser.setEmail(createUserRequest.getEmail());
        aplUser.setPassword(passwordEncoder.encode(createUserRequest.getPwd()));
        aplUser.setName(createUserRequest.getName());
        aplUser.setSurname(createUserRequest.getSurname());

        aplUserRepository.save(aplUser);
    }

    private void processRequestPreValidations(CreateUserRequest createUserRequest) throws OperationResultException {
        if (Objects.isNull(createUserRequest) || StringUtils.isEmpty(createUserRequest.getName()) || StringUtils.isEmpty(createUserRequest.getSurname()))
            throw new OperationResultException(OperationResult.createErrorResult(HttpStatus.NOT_ACCEPTABLE, "No valid request."));
    }
}
