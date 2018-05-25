package com.example.magazine.controller;

import com.example.magazine.domain.dto.CustomerUpdateRequest;
import com.example.magazine.domain.entity.Customer;
import com.example.magazine.domain.dto.CustomerRequest;
import com.example.magazine.domain.dto.SuccessResponse;
import com.example.magazine.service.CustomerService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping(value = "/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ApiOperation("Get customer by id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getCustomer(@ApiParam(required = true) @PathVariable Long id) {
        return status(OK).body(customerService.getCustomerById(id));
    }

    @ApiOperation("Get list of customers")
    @GetMapping(value = "/all", produces = APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). E.g. 'email,asc' or 'username,desc'. "
                            + "Default sort order is ascending. "
                            + "Multiple sort criteria are supported.")
    })
    public ResponseEntity<Page<Customer>> getListOfCustomers(Pageable pageable) {
        return status(OK).body(customerService.findAll(pageable));
    }

    @ApiOperation("Create a new customer")
    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createCustomer(@ApiParam(required = true) @RequestBody @Valid CustomerRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .build();
        customerService.createCustomer(customer);
        return status(CREATED).body(new SuccessResponse(CREATED.toString()));
    }

    @ApiOperation("Update customer")
    @PostMapping(value = "/update", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateCustomer(@ApiParam(required = true) @RequestBody @Valid CustomerUpdateRequest updateRequest) {
        customerService.updateCustomer(updateRequest);
        return status(OK).body(new SuccessResponse(OK.toString()));
    }

    @ApiOperation("Delete customer by id")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCustomer(@ApiParam(required = true) @PathVariable Long id) {
        customerService.deleteCustomer(id);
        return status(OK).body(new SuccessResponse(OK.toString()));
    }

}
