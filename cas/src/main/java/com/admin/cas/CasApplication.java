package com.admin.cas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.admin.cas.service"})
public class CasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasApplication.class, args);
	}

}
