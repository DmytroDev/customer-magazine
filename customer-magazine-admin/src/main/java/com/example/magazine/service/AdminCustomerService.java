package com.example.magazine.service;

import com.example.magazine.domain.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminCustomerService {

    private CustomerService customerService;

    @Autowired
    public AdminCustomerService(CustomerService customerService){
        this.customerService = customerService;
    }

    public Customer getCustomer(Long id) {
        return customerService.getCustomerById(id);
    }
}
