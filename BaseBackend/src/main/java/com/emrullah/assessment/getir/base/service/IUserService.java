package com.emrullah.assessment.getir.base.service;

import com.emrullah.assessment.getir.base.entity.user.AplUserEntity;

import java.util.Optional;

public interface IUserService {
    Optional<AplUserEntity> getByEmail(String email);
}
