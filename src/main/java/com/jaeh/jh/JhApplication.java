package com.jaeh.jh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JhApplication {

	public static void main(String[] args) {
		SpringApplication.run(JhApplication.class, args);
	}
}
