package com.projetos.anderson.Rest_Spring_Postgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RestSpringPostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestSpringPostgresApplication.class, args);
	}
}
