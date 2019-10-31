package com.prestadak.springdemo.service;

import java.util.List;

import com.prestadak.springdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(Customer customer);

	public List<Customer> searchCustomer(String searchName);
}
