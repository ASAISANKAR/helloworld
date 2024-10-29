package com.railway.helloworld.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.helloworld.model.Admin;
import com.railway.helloworld.model.Customer;
import com.railway.helloworld.repository.AdminRepository;
import com.railway.helloworld.repository.CustomerRepository;



@Service
public class AdminServiceImplementation implements AdminService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public List<Customer> viewAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Admin checkAdminLogin(String username, String password) {
	  return adminRepository.checkAdminLogin(username, password);
	}

	@Override
	public long customercount() {
		return customerRepository.count();
	}

}
