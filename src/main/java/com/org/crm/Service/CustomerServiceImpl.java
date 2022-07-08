package com.org.crm.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.crm.dao.ICustomerDao;
import com.org.crm.entity.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService {	
	
	@Autowired
	private ICustomerDao custDao;
	
	
	@Override
	public Customer insert(Customer cust) {
		return custDao.insertCustomer(cust);
	}

	@Override
	public Customer update(Customer cust) {
		return custDao.updateCustomer(cust);
	}

	@Override
	public Customer getCustomer(int custId) {
		
		return custDao.findCustomer(custId);
	}

	@Override
	public boolean delete(int custId) {
		if(custDao.deleteCustomer(custId)) {
			return true;
		}
		return false;
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return custDao.retrieveAllCustomer();
	}

}
