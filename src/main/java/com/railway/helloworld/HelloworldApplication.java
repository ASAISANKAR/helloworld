package com.railway.helloworld;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@RestController
public class HelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
		System.out.println("The Spring Boot Project has Started");
	}

//	@GetMapping("/")
//    public String hello() {
//      return String.format("Hello this is SS......!!!!!!!");
//    }

}
