package woodspring.springz.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import woodspring.springz.dto.Customer;
import woodspring.springz.repository.CustomerRepository;

@Service
public class CustomerService implements CustomerServiceIntf{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CustomerRepository customerRepo;

	@Override
	public List<Customer> listCustomers() {
		List<Customer> customerList = (List<Customer>) customerRepo.findAll(); //.findAll();
		return customerList;
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer theCustomer = customerRepo.findOne( id); //..getOne( id);
		return theCustomer;
	}

	@Override
	public Customer getCustomerByFirstname(String firstname) {
		Customer theCustomer = customerRepo.findByFirstname(firstname);
		return theCustomer;
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		Customer theCustomer = customerRepo.findByEmail(email);
		return theCustomer;
	}

	@Override
	public Customer save(Customer customer) {
		return customerRepo.save( customer);
	}

	@Override
	public Customer updateCustomer(int id, Customer customer) {
		Customer theCustomer = customerRepo.findOne( id);
		if ( theCustomer == null) {
			return null;
		} 
		theCustomer.setFirstname( customer.getFirstname() == null ? theCustomer.getFirstname() : customer.getFirstname());
		theCustomer.setLastname( customer.getFirstname() == null ? theCustomer.getLastname() : customer.getLastname());
		theCustomer.setEmail( customer.getEmail() == null ? theCustomer.getEmail() : customer.getEmail());
		theCustomer = customerRepo.save(theCustomer); //.saveAndFlush(theCustomer);
		return theCustomer;
	}
	
	

}
