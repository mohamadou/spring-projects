package com.prestadak.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prestadak.springdemo.dao.CustomerDao;
import com.prestadak.springdemo.entity.Customer;

@Repository
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		return customerDao.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		
		return customerDao.getCustomer(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(Customer customer) {
		customerDao.deleteCustomer(customer);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomer(String searchName) {
		return customerDao.searchCustomer(searchName);
	}
	
	
	
	
	
	
	
	

}
