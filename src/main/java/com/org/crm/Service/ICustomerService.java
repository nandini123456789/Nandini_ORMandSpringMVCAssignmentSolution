package com.org.crm.Service;

import java.util.List;

import com.org.crm.entity.Customer;

public interface ICustomerService {

	public Customer insert(Customer cust);
	
	public Customer update(Customer cust);
	
	public Customer getCustomer(int custId);
	
	public boolean delete(int custId);
	
    public List<Customer> getAllCustomer();
	
}
