package com.emrullah.assessment.getir.controller.rest.ecom.statistics;

import com.emrullah.assessment.getir.base.entity.order.Order;
import com.emrullah.assessment.getir.base.entity.product.Product;
import com.emrullah.assessment.getir.base.framework.GenericResponse;
import com.emrullah.assessment.getir.base.framework.constants.GeneralEnumerationDefinitions;
import com.emrullah.assessment.getir.base.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/ecom/statistics")
public class StatisticsController {

    private final IOrderService orderService;

    @Autowired
    public StatisticsController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<?>> inquireMonthlyStatistics() {
        GenericResponse<Product> genericResponse = new GenericResponse<>();
        //genericResponse.setData(orderService.inquireMonthlyStatistics());
        return ResponseEntity.ok(genericResponse);
    }

    @RequestMapping(value = "/orders/{orderStatus}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<List<Order>>> inquireOrdersByOrderStatus(@PathVariable GeneralEnumerationDefinitions.OrderStatusType orderStatus) {
        GenericResponse<List<Order>> genericResponse = new GenericResponse<>();
        genericResponse.setData(orderService.inquireOrdersByOrderStatus(orderStatus));
        return ResponseEntity.ok(genericResponse);
    }
}
