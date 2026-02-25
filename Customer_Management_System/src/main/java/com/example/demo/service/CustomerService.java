package com.example.demo.service;

import com.example.demo.repository.*;
import com.example.demo.model.*;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	private CustomerRepository customerRepository;
	
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository=customerRepository;
	}
	
	public List<Customer> getAllEmployees(){
		return customerRepository.findAll();
	}
	
	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	
	public void updateCustomer(Integer id,Customer customer) {
		Customer existing=customerRepository.findById(id).orElseThrow(()-> new RuntimeException("Customer not Found"));
		customerRepository.save(customer);
	}
	
	public void deleteCustomer(Integer  id) {
		customerRepository.deleteById(id);
	}
	
}
