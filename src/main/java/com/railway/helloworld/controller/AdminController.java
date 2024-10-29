package com.railway.helloworld.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.railway.helloworld.model.Admin;
import com.railway.helloworld.model.Customer;
import com.railway.helloworld.service.AdminService;
import com.railway.helloworld.service.CustomerService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("adminlogin")
	public ModelAndView adminlogin()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("adminlogin");
		return mv;
	}
	
	@GetMapping("adminhome")
	public ModelAndView adminhome()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("adminhome");
		long count=adminService.customercount();
		mv.addObject("count",count);
		return mv;
	}
	
	@GetMapping("addcustomers")
	public ModelAndView addcustomers()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("addcustomers");
		return mv;
	}
	
	@GetMapping("viewallcustomers")
	public ModelAndView viewAllCustomers()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("viewallcustomers");
		
		long count=adminService.customercount();
		mv.addObject("count",count);
		
		List<Customer> customers=adminService.viewAllCustomers();
		mv.addObject("customerlist",customers);
		return mv;
	}
	
	@PostMapping("checkadminlogin")
	public ModelAndView chechadminlogin(HttpServletRequest request)
	{
		
		ModelAndView mv=new ModelAndView();
		
		String uname=request.getParameter("auname");
		String apwd=request.getParameter("apwd");
		Admin admin=adminService.checkAdminLogin(uname, apwd);
		
		if(admin!=null)
		{
			mv.setViewName("adminhome");
			long count=adminService.customercount();
			mv.addObject("count",count);
		}
		else
		{
			mv.setViewName("adminloginfail");
			mv.addObject("message","Login Failed");
		}
		return mv;
	}
	
	

	@PostMapping("insertcustomerbyadmin")
	public ModelAndView insertcustomerbyadmin(HttpServletRequest request)
	{
		String name = request.getParameter("cname");
		String gender = request.getParameter("cgender");
		String dob= request.getParameter("cdob");
		String email= request.getParameter("cemail");
		String location= request.getParameter("clocation");
		String contact = request.getParameter("ccontact");
		String password= request.getParameter("cpassword");
		
		
		Customer customer =new Customer();
		customer.setName(name);
		customer.setGender(gender);
		customer.setDateofbirth(dob);
		customer.setEmail(email);
		customer.setLocation(location);
		customer.setContact(contact);
		customer.setPassword(password);
		
		String msg=customerService.customerRegistration(customer);
		ModelAndView mv=new ModelAndView();
		mv.addObject("message",msg);
		long count=adminService.customercount();
		mv.addObject("count",count);
		
		List<Customer> customers=adminService.viewAllCustomers();
		mv.addObject("customerlist",customers);
		mv.setViewName("viewallcustomers");
		
		return mv;
		
		
	}
	
	

}
