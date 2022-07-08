package com.org.crm.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.org.crm.entity.Customer;

@Repository
@ComponentScan
public class CustomerDaoImpl implements ICustomerDao {
		
	
	private SessionFactory sessionFactory;	
	private Session session;

	
	public CustomerDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		try {
			session=sessionFactory.getCurrentSession();
		}
		catch (HibernateException e) {
			session= sessionFactory.openSession();			
		}
	}

	@Override
	public Customer insertCustomer(Customer cust) {
		Transaction tx=session.beginTransaction();
	    session.save(cust);
	    System.out.println("Customer Info saved.....");
	    tx.commit();
		return cust;
	}

	@Override
	public Customer updateCustomer(Customer cust) {
		Customer oldCust=findCustomer(cust.getId());
		oldCust.setF_Name(cust.getF_Name());
		oldCust.setL_name(cust.getL_name());
		oldCust.setEmail(cust.getEmail());
		Transaction tx=session.beginTransaction();
		session.update(oldCust);
		System.out.println("Customer info updated...."+cust);
		tx.commit();
		return cust;
	}

	@Override
	public boolean deleteCustomer(int custId) {
		
		Customer cust=findCustomer(custId);
		Transaction tx=session.beginTransaction();
		System.out.println("customer to be deleted" + cust);
		session.delete(cust);
	    System.out.println("Customer Info Deleted.....");
	    tx.commit();
	    
	    if (cust!=null)
	    	return true;
		return false;
	}

	@Override
	public Customer findCustomer(int custId) {
		return session.find(Customer.class, custId);
	}

	@Override
	public List<Customer> retrieveAllCustomer() {
		
		return session.createQuery("Select custs from Customer custs",Customer.class).getResultList();
	}

	
}
