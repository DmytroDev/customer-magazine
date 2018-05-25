package com.example.magazine;

import com.example.magazine.domain.entity.Customer;
import com.example.magazine.service.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CustomerMagazineServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CustomerMagazineServiceApplication.class, args);
		CustomerService customerService = context.getBean(CustomerService.class);
		Customer customer = customerService.getCustomerById(1L);
		System.out.println("Customer: " + customer);
	}
}
