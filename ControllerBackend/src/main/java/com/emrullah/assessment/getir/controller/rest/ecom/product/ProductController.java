package com.emrullah.assessment.getir.controller.rest.ecom.product;

import com.emrullah.assessment.getir.base.dto.product.CreateProductRequest;
import com.emrullah.assessment.getir.base.dto.product.UpdateProductRequest;
import com.emrullah.assessment.getir.base.entity.product.Product;
import com.emrullah.assessment.getir.base.framework.GenericResponse;
import com.emrullah.assessment.getir.base.framework.OperationResult;
import com.emrullah.assessment.getir.base.framework.exceptions.OperationResultException;
import com.emrullah.assessment.getir.base.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/ecom/product")
public class ProductController {

    private final IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<OperationResult>> createNewProduct(@RequestBody CreateProductRequest createProductRequest) {
        GenericResponse<OperationResult> genericResponse = new GenericResponse<>();

        OperationResult product = productService.createProduct(createProductRequest);
        genericResponse.setData(product);
        genericResponse.setCode(product.getResultCode().value());
        return ResponseEntity.ok(genericResponse);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<?>> updateExistProduct(@RequestBody UpdateProductRequest updateProductRequest) {
        try {
            GenericResponse<Product> genericResponse = new GenericResponse<>();
            genericResponse.setData(productService.updateProduct(updateProductRequest));
            return ResponseEntity.ok(genericResponse);
        } catch (OperationResultException ore) {
            return ResponseEntity.status(ore.getOperationResult().getResultCode()).body(new GenericResponse<>(ore.getOperationResult().getResultCode().value(), ore.getOperationResult()));
        }
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<?>> inquireProduct(@PathVariable String productId) {
        try {
            GenericResponse<Product> genericResponse = new GenericResponse<>();
            genericResponse.setData(productService.inquireProductById(productId));
            return ResponseEntity.ok(genericResponse);
        } catch (OperationResultException ore) {
            return ResponseEntity.status(ore.getOperationResult().getResultCode()).body(new GenericResponse<>(ore.getOperationResult().getResultCode().value(), ore.getOperationResult()));
        }
    }
}
