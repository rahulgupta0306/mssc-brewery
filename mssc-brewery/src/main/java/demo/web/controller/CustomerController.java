package demo.web.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import demo.web.model.CustomerPojo;

@RequestMapping("api/v1/customer")
@RestController
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/{customerId}")
	public CustomerPojo getCustomer(@PathVariable UUID customerId) {
		// return new ResponseEntity<>(customerService.getCustomerById(customerId),
		// HttpStatus.OK);
		return customerService.getCustomerById(customerId);
	}

	@PostMapping
	public ResponseEntity<Object> handlePost(@RequestBody CustomerPojo newcustomer) {

		CustomerPojo savePojo = customerService.saveNewCustomer(newcustomer);
		HttpHeaders httpheader = new HttpHeaders();
		httpheader.add("Location", "http://localhost:8080/api/v1/customer" + savePojo.getId().toString());
		return new ResponseEntity<>(httpheader, HttpStatus.CREATED);

	}

	@PutMapping("/{customerId}")
	public ResponseEntity<Object> handlePost(@RequestBody CustomerPojo newcustomer, @PathVariable UUID customerId) {
		HttpHeaders httpheader = new HttpHeaders();
		httpheader.add("Location", "http://localhost:8080/api/v1/customer"
				+ customerService.updateCustomer(customerId, newcustomer).getId().toString());
		return new ResponseEntity<>(httpheader, HttpStatus.NO_CONTENT);
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomerById(@PathVariable UUID customerId) {
		customerService.deleteCustomerById(customerId);
	}

}
