package com.prestadak.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prestadak.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = session.createQuery("from Customer order by lastName",
				Customer.class);
		
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		
		return customer;
	}

	@Override
	public void deleteCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(customer);
	}

	@Override
	public List<Customer> searchCustomer(String searchName) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = null;
		if (searchName != null && searchName.trim().length() > 0) {
			 query = session.createQuery("from Customer where lower(lastName) like :searchName or lower(firstName) like :searchName",
					Customer.class);
			query.setParameter("searchName", "%"+searchName.toLowerCase()+"%");
		} else {
			query = session.createQuery("from Customer", Customer.class);
		}
			
		
		List<Customer> customers = query.getResultList();
		
		return customers;
	}
	

	
	
	

}
