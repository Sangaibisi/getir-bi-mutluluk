package com.emrullah.assessment.getir.base.service;

import com.emrullah.assessment.getir.base.dto.product.CreateProductRequest;
import com.emrullah.assessment.getir.base.dto.product.UpdateProductRequest;
import com.emrullah.assessment.getir.base.entity.product.Product;
import com.emrullah.assessment.getir.base.framework.OperationResult;
import com.emrullah.assessment.getir.base.framework.exceptions.OperationResultException;

public interface IProductService {
    OperationResult createProduct(CreateProductRequest createProductRequest);
    Product updateProduct(UpdateProductRequest createProductRequest) throws OperationResultException;
    Product inquireProductById(String productId);
    Product inquireProductByName(String name);
}
