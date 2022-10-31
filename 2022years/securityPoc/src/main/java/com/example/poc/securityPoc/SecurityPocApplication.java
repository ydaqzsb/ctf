package com.example.poc.securityPoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class
})
public class SecurityPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityPocApplication.class, args);
	}

}
