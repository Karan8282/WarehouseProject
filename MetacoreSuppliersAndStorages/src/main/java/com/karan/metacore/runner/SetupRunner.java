package com.karan.metacore.runner;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.karan.metacore.model.User;
import com.karan.metacore.service.IUserService;

@Component
public class SetupRunner 
	implements CommandLineRunner
{
	@Autowired
	private IUserService service;
	
	public void run(String... args) throws Exception {
		if(service.findByEmail("gauravraje.khedkar@gmail.com").isEmpty()) {
			User user = new User();
			user.setUname("Warehouse admin");
			user.setEmail("gauravraje.khedkar@gmail.com");
			user.setPwd("12345");
			//user.setOtp("1234");
			user.setActive(true);
			Set<String> roles = new HashSet<>();
			roles.add("ADMIN");
			roles.add("APPUSER");
			user.setRoles(roles);
			service.saveUser(user);
		}
		
	}

}
