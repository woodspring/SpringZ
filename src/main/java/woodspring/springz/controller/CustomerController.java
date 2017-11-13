package woodspring.springz.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.google.gson.Gson;

import woodspring.springz.dto.Customer;
import woodspring.springz.service.CustomerService;

@RestController
//@RequestMapping("AB")

public class CustomerController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CustomerService customerService;

//	//@GetMapping(value = "list")
//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<String> listCustomer() {
//		List<Customer> customerList = customerService.listCustomers();
//		String custmersStr = new Gson().toJson(customerList);
//		ResponseEntity<String> responseEntity = new ResponseEntity<>(custmersStr, HttpStatus.OK);
//		return responseEntity;
//	}
	@GetMapping("/list")
	@CrossOrigin(origins = { "http://localhost:8484", "http://localhost:4200" }, maxAge = 6000)
	//@RequestMapping(method = RequestMethod.GET)
	public String listCustomer() {
		List<Customer> customerList = customerService.listCustomers();
		String custmersStr = new Gson().toJson(customerList);
		//ResponseEntity<String> responseEntity = new ResponseEntity<>(custmersStr, HttpStatus.OK);
		logger.info("List<Customer>:["+customerList.size()+"]");
		return custmersStr;
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<String> getCustomerById(@PathVariable String idStr) {
		Customer theCustomer = customerService.getCustomerById( Integer.valueOf( idStr));
		String custmersStr = new Gson().toJson(theCustomer);
		ResponseEntity<String> responseEntity = new ResponseEntity<>(custmersStr, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(value = "/getbyfirstname/{firstname}")
	public ResponseEntity<String> getCustomerByFirstname(@PathVariable String firstname) {
		Customer theCustomer = customerService.getCustomerByFirstname( firstname);
		String custmersStr = new Gson().toJson(theCustomer);
		ResponseEntity<String> responseEntity = new ResponseEntity<>(custmersStr, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(value = "/getbyemail/{email}")
	public ResponseEntity<String> getCustomerByemail(@PathVariable String email) {
		Customer theCustomer = customerService.getCustomerByEmail(email);
		String custmersStr = new Gson().toJson(theCustomer);
		ResponseEntity<String> responseEntity = new ResponseEntity<>(custmersStr, HttpStatus.OK);
		return responseEntity;
	}
	
	@PostMapping(value="new")
	public ResponseEntity<Customer> newCustomer(@RequestBody Customer aCustomer ) {
		Customer theCustomer = customerService.save( aCustomer);
		String customerStr = (theCustomer == null) ? "" : new Gson().toJson(theCustomer);
		ResponseEntity<Customer> responseEntity = new ResponseEntity<Customer>(theCustomer, HttpStatus.OK);
		return responseEntity;
	}

}
