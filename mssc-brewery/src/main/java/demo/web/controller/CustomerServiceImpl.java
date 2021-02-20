package demo.web.controller;

import java.util.UUID;

import org.springframework.stereotype.Service;

import demo.web.model.CustomerPojo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerPojo getCustomerById(UUID customerId) {
		return CustomerPojo.builder().id(UUID.randomUUID()).name("Sam").build();
	}

	@Override
	public CustomerPojo saveNewCustomer(CustomerPojo newcustomer) {
		return CustomerPojo.builder().id(UUID.randomUUID()).build();
	}

	@Override
	public void deleteCustomerById(UUID customerId) {
		log.debug("Deleting a customer...");
	}

	@Override
	public CustomerPojo updateCustomer(UUID customerId, CustomerPojo newcustomer) {
		return null;
	}

}
