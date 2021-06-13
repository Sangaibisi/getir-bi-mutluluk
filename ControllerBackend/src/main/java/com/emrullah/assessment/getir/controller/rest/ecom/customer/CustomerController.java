package com.emrullah.assessment.getir.controller.rest.ecom.customer;

import com.emrullah.assessment.getir.base.entity.order.Order;
import com.emrullah.assessment.getir.base.framework.GenericResponse;
import com.emrullah.assessment.getir.base.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/ecom/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @RequestMapping(value = "/orders/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<List<Order>>> retrieveCustomerOrders(@PathVariable String email) {
        GenericResponse<List<Order>> genericResponse = new GenericResponse<>();
        genericResponse.setData(customerService.retrieveCustomerOrdersByEmail(email));
        return ResponseEntity.ok(genericResponse);
    }
}
