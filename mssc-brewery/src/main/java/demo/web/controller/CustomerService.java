package demo.web.controller;

import java.util.UUID;

import demo.web.model.CustomerPojo;

public interface CustomerService {

	CustomerPojo getCustomerById(UUID customerId);

	CustomerPojo saveNewCustomer(CustomerPojo newcustomer);

	void deleteCustomerById(UUID customerId);

	CustomerPojo updateCustomer(UUID customerId, CustomerPojo newcustomer);

}
