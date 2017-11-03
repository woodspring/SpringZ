package woodspring.springz.service;

import java.util.List;

import woodspring.springz.dto.Customer;

public interface CustomerServiceIntf {
	
	//CRU without Delete
	
	public List<Customer> listCustomers();
	public Customer getCustomerById(int id);
	public Customer getCustomerByFirstname(String firstname);
	public Customer getCustomerByEmail(String email);
	public Customer save(Customer customer);
	public Customer updateCustomer(int id, Customer customer);
	

}
