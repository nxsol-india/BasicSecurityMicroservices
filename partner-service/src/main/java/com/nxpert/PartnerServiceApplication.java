package com.nxpert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PartnerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartnerServiceApplication.class, args);
	}

}
