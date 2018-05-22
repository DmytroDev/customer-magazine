package com.example.magazine.controller;

import com.example.magazine.domain.Customer;
import com.example.magazine.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ApiOperation("Get customer by id")
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@ApiParam(required = true) @PathVariable Long id) {
        return ResponseEntity.status(OK).body(customerService.getCustomerById(id));
    }
}
