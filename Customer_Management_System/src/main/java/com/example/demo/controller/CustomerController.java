package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@Controller
public class CustomerController {
	private CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService=customerService;
	}
	
		
	@GetMapping("/customer")
	public ModelAndView getCustomerDetails() {
		List<Customer> customers=customerService.getAllEmployees();
		ModelAndView mv=new ModelAndView();
		mv.addObject("customer",customers);
		mv.setViewName("customer");
		return mv;	
	}
	
	@GetMapping("/addCustomer")
	public String showRegistrationForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "addCustomer";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customer";
	}
	
}
