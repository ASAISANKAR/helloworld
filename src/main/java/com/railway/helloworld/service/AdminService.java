package com.railway.helloworld.service;

import java.util.List;

import com.railway.helloworld.model.Admin;
import com.railway.helloworld.model.Customer;




public interface AdminService {
	public List<Customer> viewAllCustomers();
	public Admin checkAdminLogin(String username,String password);
	public long customercount();

}
