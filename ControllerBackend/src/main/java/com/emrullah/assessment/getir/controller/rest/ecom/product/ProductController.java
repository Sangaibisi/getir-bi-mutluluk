package com.emrullah.assessment.getir.controller.rest.ecom.product;

import com.emrullah.assessment.getir.base.dto.product.CreateProductRequest;
import com.emrullah.assessment.getir.base.dto.product.UpdateProductRequest;
import com.emrullah.assessment.getir.base.entity.product.Product;
import com.emrullah.assessment.getir.base.framework.GenericResponse;
import com.emrullah.assessment.getir.base.framework.OperationResult;
import com.emrullah.assessment.getir.base.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<GenericResponse<Product>> updateExistProduct(@RequestBody UpdateProductRequest updateProductRequest) {
        GenericResponse<Product> genericResponse = new GenericResponse<>();
        genericResponse.setData(productService.updateProductStock(updateProductRequest));
        return ResponseEntity.ok(genericResponse);
    }
}
