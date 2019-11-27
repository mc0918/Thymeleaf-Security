package com.mikul.springsecuritythymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.mikul.springsecuritythymeleaf.dao")
@EntityScan("com.mikul.springsecuritythymeleaf.model")
@SpringBootApplication
public class SpringSecurityThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityThymeleafApplication.class, args);
	}

}
