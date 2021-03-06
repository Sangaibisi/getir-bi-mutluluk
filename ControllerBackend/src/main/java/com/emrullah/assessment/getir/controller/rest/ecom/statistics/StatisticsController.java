package com.emrullah.assessment.getir.controller.rest.ecom.statistics;

import com.emrullah.assessment.getir.base.dto.order.MonthlyStaticRequest;
import com.emrullah.assessment.getir.base.dto.order.MonthlyStaticResponse;
import com.emrullah.assessment.getir.base.entity.order.Order;
import com.emrullah.assessment.getir.base.framework.GenericResponse;
import com.emrullah.assessment.getir.base.framework.constants.GeneralEnumerationDefinitions;
import com.emrullah.assessment.getir.base.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ecom/statistics")
public class StatisticsController {

    private final IOrderService orderService;

    @Autowired
    public StatisticsController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<?>> inquireMonthlyStatistics(@RequestBody MonthlyStaticRequest request) {
        GenericResponse<List<MonthlyStaticResponse>> genericResponse = new GenericResponse<>();
        genericResponse.setData(orderService.inquireMonthlyStatistics(request));
        return ResponseEntity.ok(genericResponse);
    }

    @RequestMapping(value = "/orders/{orderStatus}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<Page<Order>>> inquireOrdersByOrderStatus(@PathVariable GeneralEnumerationDefinitions.OrderStatusType orderStatus) {
        GenericResponse<Page<Order>> genericResponse = new GenericResponse<>();
        genericResponse.setData(orderService.inquireOrdersByOrderStatus(orderStatus));
        return ResponseEntity.ok(genericResponse);
    }
}
