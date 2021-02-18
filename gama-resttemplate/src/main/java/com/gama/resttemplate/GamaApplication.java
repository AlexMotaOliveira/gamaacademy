package com.gama.resttemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GamaApplication {


 	public static void main(String[] args) {
		SpringApplication.run(GamaApplication.class, args);
	}

}