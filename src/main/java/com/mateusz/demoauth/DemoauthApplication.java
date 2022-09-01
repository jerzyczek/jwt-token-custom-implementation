package com.mateusz.demoauth;

import com.mateusz.demoauth.domain.Role;
import com.mateusz.demoauth.domain.User;
import com.mateusz.demoauth.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class DemoauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoauthApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveUser(new User(null, "Andrzej", "andrzej", "1234", new ArrayList<>()));
			userService.addRoleToUser("andrzej", "ROLE_USER");
		};
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


}
