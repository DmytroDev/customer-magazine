package com.example.magazine.service;

import com.example.magazine.domain.dto.CustomerUpdateRequest;
import com.example.magazine.domain.entity.Customer;
import com.example.magazine.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Transactional
    public void updateCustomer(CustomerUpdateRequest request) {
        Customer customer = getCustomerById(request.getId());
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        customerRepository.save(customer);
    }

    @Transactional
    public void deleteCustomer(Long id) {
        customerRepository.delete(id);
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }
}
