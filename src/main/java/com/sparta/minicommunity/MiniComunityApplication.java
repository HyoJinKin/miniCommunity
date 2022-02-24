package com.sparta.minicommunity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MiniComunityApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniComunityApplication.class, args);
	}

}
