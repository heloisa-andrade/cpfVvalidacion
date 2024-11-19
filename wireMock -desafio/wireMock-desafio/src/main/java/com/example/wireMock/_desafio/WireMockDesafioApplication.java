package com.example.wireMock._desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.wireMock._desafio.repositroy")
public class WireMockDesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(WireMockDesafioApplication.class, args);
	}

}
