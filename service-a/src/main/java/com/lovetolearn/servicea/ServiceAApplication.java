package com.lovetolearn.servicea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lovetolearn.servicea.config.ConfigService;

@SpringBootApplication
@RestController
@EnableFeignClients
@EnableDiscoveryClient
public class ServiceAApplication {

	@Autowired
	ConfigService configService;
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceAApplication.class, args);
	}

	@GetMapping("service-a/{name}")
	public String getResponse(@PathVariable String name) {

		System.out.println("Inside service-a");

		return configService.getResponse(name);
	}
}
