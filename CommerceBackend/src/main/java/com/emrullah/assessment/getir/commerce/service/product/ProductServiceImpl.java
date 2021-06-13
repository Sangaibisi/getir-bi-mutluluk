package com.emrullah.assessment.getir.commerce.service.product;

import com.emrullah.assessment.getir.base.dto.product.CreateProductRequest;
import com.emrullah.assessment.getir.base.dto.product.UpdateProductRequest;
import com.emrullah.assessment.getir.base.entity.product.Product;
import com.emrullah.assessment.getir.base.framework.OperationResult;
import com.emrullah.assessment.getir.base.framework.exceptions.OperationResultException;
import com.emrullah.assessment.getir.base.repository.IProductRepository;
import com.emrullah.assessment.getir.base.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    private final IProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public OperationResult createProduct(CreateProductRequest createProductRequest) {
        Product newProductEntity = new Product(createProductRequest.getName(), createProductRequest.getPrice(), createProductRequest.getDescription(), createProductRequest.getStockCount());
        productRepository.save(newProductEntity);
        OperationResult operationResult = OperationResult.newInstance(HttpStatus.ACCEPTED, newProductEntity.getName());
        operationResult.setResultCode(HttpStatus.ACCEPTED);
        operationResult.setVersion(newProductEntity.getId().longValue());

        return operationResult;
    }

    @Override
    public Product updateProductStock(UpdateProductRequest updateProductRequest) throws OperationResultException {
        Optional<Product> optionalProduct = productRepository.getByName(updateProductRequest.getName());

        if(optionalProduct.isEmpty()){
            throw new OperationResultException(OperationResult.createErrorResult(HttpStatus.BAD_REQUEST, "Given product name does not exist in database."));
        }

        Product updatedProduct = optionalProduct.get();

        updatedProduct.setDescription(updateProductRequest.getDescription());
        updatedProduct.setName(updateProductRequest.getName());
        updatedProduct.setPrice(updateProductRequest.getPrice());
        updatedProduct.setStockCount(updateProductRequest.getCurrentStockCount());

        productRepository.save(updatedProduct);

        return updatedProduct;
    }
}
