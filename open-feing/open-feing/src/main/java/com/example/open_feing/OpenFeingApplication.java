package com.example.open_feing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.text.Format;

@SpringBootApplication
@EnableFeignClients
public class OpenFeingApplication{

	public static void main(String[] args) {
                                                     		SpringApplication.run(OpenFeingApplication.class, args);
	}

}
