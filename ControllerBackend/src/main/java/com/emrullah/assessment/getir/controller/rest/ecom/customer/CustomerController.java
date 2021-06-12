package com.emrullah.assessment.getir.controller.rest.ecom.customer;

import com.emrullah.assessment.getir.base.framework.GenericResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ecom/customer")
public class CustomerController {

    @RequestMapping(value = "/status", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> status() {
        return ResponseEntity.ok(new GenericResponse<>("Everything is okay"));
    }
}
