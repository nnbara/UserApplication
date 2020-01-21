package com.wd.userApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {

		System.out.println("Working!!!!!!!!!!!!!!!!!!!!!!");
		SpringApplication.run(UserApplication.class, args);
	}
}
