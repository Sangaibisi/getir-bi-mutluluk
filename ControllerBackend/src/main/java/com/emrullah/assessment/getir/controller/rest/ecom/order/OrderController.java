package com.emrullah.assessment.getir.controller.rest.ecom.order;

import com.emrullah.assessment.getir.base.dto.order.OrderRequest;
import com.emrullah.assessment.getir.base.entity.order.Order;
import com.emrullah.assessment.getir.base.framework.GenericResponse;
import com.emrullah.assessment.getir.base.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ecom/order")
public class OrderController {

    private final IOrderService orderService;

    @Autowired
    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/purchase", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<Order>> retrieveCustomerOrders(@RequestBody OrderRequest request) {
        GenericResponse<Order> genericResponse = new GenericResponse<>();
        genericResponse.setData(orderService.processNewOrder(request));
        return ResponseEntity.ok(genericResponse);
    }
}
