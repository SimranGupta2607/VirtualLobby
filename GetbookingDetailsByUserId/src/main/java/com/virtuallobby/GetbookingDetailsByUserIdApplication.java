package com.virtuallobby;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages = "com.virtuallobby")
public class GetbookingDetailsByUserIdApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetbookingDetailsByUserIdApplication.class, args);
	}

}
