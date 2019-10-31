package com.prestadak.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prestadak.springdemo.dao.CustomerDao;
import com.prestadak.springdemo.entity.Customer;
import com.prestadak.springdemo.service.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String customersList(Model theModel) {
		
		List<Customer> customers = customerService.getCustomers();
		theModel.addAttribute("customers", customers);
		
		return "customers-list";
	}
	
	@GetMapping("/showFormForAdd")
	public String customerShowFormForAdd(Model theModel) {
		Customer customer = new Customer();
		theModel.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String customerShowFormUpdate(@RequestParam("customerId") int id, Model theModel) {
	
		Customer customer = customerService.getCustomer(id);
		theModel.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		Customer customer = customerService.getCustomer(id);
		customerService.deleteCustomer(customer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/searchCustomer")
	public String searchCustomer(@RequestParam("theSearchName") String searchName, Model theModel) {
		
		List<Customer> customers = customerService.searchCustomer(searchName);
		theModel.addAttribute("customers", customers);
		
		return "customers-list";
	}
}










