package com.revature.whatamidoing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.revature.models")
@EnableJpaRepositories("com.revature.daos")
@ComponentScan("com.revature")
public class WhatamidoingApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhatamidoingApplication.class, args);
	}

}
