package com.railway.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.railway.helloworld.model.Customer;
import com.railway.helloworld.service.CustomerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@SpringBootApplication
@RestController
public class HelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
		System.out.println("The Spring Boot Project has Started");
	}

//	@GetMapping("/")
//    public String hello() {
//      return String.format("Hello this is SS......!!!!!!!");
//    }

	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/")
	public ModelAndView home()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	@GetMapping("customerreg")
	public ModelAndView customerreg()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("customerreg");
		return mv;
	}
	
	@GetMapping("customerprofile")
	public ModelAndView customerprofile()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("customerprofile");
		return mv;
	}
	
	@GetMapping("customerhome")
	public ModelAndView customerhome()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("customerhome");
		return mv;
	}
	@GetMapping("customerlogin")
	public ModelAndView customerlogin()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("customerlogin");
		return mv;
	}
	
	@GetMapping("customerlogout")
	public ModelAndView customerlogout()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("customerlogin");
		return mv;
	}
	
	
	@PostMapping("insertcustomer")
	public ModelAndView insertcustomer(HttpServletRequest request)
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
		mv.setViewName("regsuccess");
		mv.addObject("message",msg);
		
		return mv;
		
		
	}
	
	
	@PostMapping("checkcustomerlogin")
	public ModelAndView checkcustomerlogin(HttpServletRequest request)
	{
		
		ModelAndView mv=new ModelAndView();
		
		String cemail=request.getParameter("cemail");
		String cpwd=request.getParameter("cpwd");
		Customer customer=customerService.checkCustomerLogin(cemail, cpwd);
		if(customer!=null)
		{
			HttpSession session=request.getSession();
			session.setAttribute("customer", customer);
			mv.setViewName("customerhome");
		}
		else
		{
			mv.setViewName("customerlogin");
			mv.addObject("message","Login Failed");
		}
		return mv;
	}
}
