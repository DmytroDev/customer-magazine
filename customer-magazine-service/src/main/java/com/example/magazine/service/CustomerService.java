package com.example.magazine.service;

import com.example.magazine.domain.Customer;
import com.example.magazine.domain.dto.CustomerRequest;
import com.example.magazine.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Transactional
    public void updateCustomer(Customer customer, CustomerRequest request) {
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
    }

    @Transactional
    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer.getId());
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(NullPointerException::new);
    }

}
