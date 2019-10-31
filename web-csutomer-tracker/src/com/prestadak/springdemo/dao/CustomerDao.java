package com.prestadak.springdemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.prestadak.springdemo.entity.Customer;

public interface CustomerDao {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(Customer customer);

	public List<Customer> searchCustomer(String searchName);
}
