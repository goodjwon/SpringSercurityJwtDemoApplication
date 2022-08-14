package com.example;

import com.example.security.jwt.domain.Role;
import com.example.security.jwt.domain.User;
import com.example.security.jwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityJwtDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));


			userService.saveUser(new User("Jung Park", "1234",new ArrayList<>() ));
			userService.saveUser(new User("John Lee", "1234",new ArrayList<>() ));
			userService.saveUser(new User("Eli Jung", "1234",new ArrayList<>() ));

			userService.addRoleToUser("Jung Park", "ROLE_USER");
			userService.addRoleToUser("Jung Park", "ROLE_MANAGER");
			userService.addRoleToUser("John Lee", "ROLE_ADMIN");
			userService.addRoleToUser("John Lee", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("Eli Jung", "ROLE_MANAGER");
			userService.addRoleToUser("Eli Jung", "ROLE_ADMIN");
		};
	}

}
