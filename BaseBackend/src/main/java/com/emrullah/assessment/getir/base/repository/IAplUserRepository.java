package com.emrullah.assessment.getir.base.repository;

import com.emrullah.assessment.getir.base.entity.user.AplUserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IAplUserRepository extends MongoRepository<AplUserEntity, Long> {
    Optional<AplUserEntity> getByEmail(String email);
}
