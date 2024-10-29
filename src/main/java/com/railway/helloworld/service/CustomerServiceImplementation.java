package com.railway.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.railway.helloworld.model.Customer;
import com.railway.helloworld.repository.CustomerRepository;


@Service
public class CustomerServiceImplementation implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public String customerRegistration(Customer customer) {
		customerRepository.save(customer);
		return "Customer Registered Successfully";
	}

	@Override
	public Customer checkCustomerLogin(String email, String password) {
		return customerRepository.checkCustomerLogin(email, password);
	}

	

}
