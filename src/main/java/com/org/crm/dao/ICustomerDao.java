package com.org.crm.dao;

import java.util.List;

import com.org.crm.entity.Customer;

public interface ICustomerDao {
	

	public Customer insertCustomer(Customer cust);
	
	public Customer updateCustomer(Customer cust);
	
	public boolean deleteCustomer(int custId);
	
	public Customer findCustomer(int custId);
	
	public List<Customer> retrieveAllCustomer ();
	
	
}
