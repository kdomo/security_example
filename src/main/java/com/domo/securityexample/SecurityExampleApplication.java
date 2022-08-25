package com.domo.securityexample;

import com.domo.securityexample.domain.Role;
import com.domo.securityexample.domain.User;
import com.domo.securityexample.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SecurityExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityExampleApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "John Travolta", "john", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Will Smith", "will", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Jim Carry", "jim", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Kim Dongho", "kim", "1234", new ArrayList<>()));

			userService.addRoleToUser("john","ROLE_USER");
			userService.addRoleToUser("will","ROLE_ADMIN");
			userService.addRoleToUser("jim","ROLE_SUPER_ADMIN");

			userService.addRoleToUser("kim","ROLE_USER");
			userService.addRoleToUser("kim","ROLE_ADMIN");
			userService.addRoleToUser("kim","ROLE_SUPER_ADMIN");

		};
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
