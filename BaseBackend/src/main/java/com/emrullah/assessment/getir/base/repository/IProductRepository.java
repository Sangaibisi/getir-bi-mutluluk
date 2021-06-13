package com.emrullah.assessment.getir.base.repository;

import com.emrullah.assessment.getir.base.entity.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductRepository extends MongoRepository<Product, String> {
    Optional<Product> getByName(String name);
}
