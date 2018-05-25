package com.example.magazine;

import com.example.magazine.service.AdminCustomerService;
import com.example.magazine.domain.entity.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = CustomerMagazineAdminApplication.BASE_PACKAGE)
@EnableJpaRepositories(CustomerMagazineAdminApplication.BASE_PACKAGE)
@EntityScan(CustomerMagazineAdminApplication.BASE_PACKAGE)
public class CustomerMagazineAdminApplication {

	public static final String BASE_PACKAGE = "com.example.magazine";

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CustomerMagazineAdminApplication.class, args);
		AdminCustomerService adminCustomerService = context.getBean(AdminCustomerService.class);
		Customer firstCustomer = adminCustomerService.getCustomer(1L);
		System.out.println(firstCustomer);
	}
}
