package com.railway.helloworld.service;

import com.railway.helloworld.model.Customer;

public interface CustomerService {
	public String customerRegistration(Customer customer);
	public Customer checkCustomerLogin(String email,String password);
	

}
