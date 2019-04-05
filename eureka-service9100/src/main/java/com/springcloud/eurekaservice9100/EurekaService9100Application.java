package com.springcloud.eurekaservice9100;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaService9100Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaService9100Application.class, args);
	}

}
