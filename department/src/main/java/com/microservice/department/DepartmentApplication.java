package com.microservice.department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

//import brave.sampler.Sampler;

@SpringBootApplication
@EnableFeignClients("com.microservice.department")
//@EnableDiscoveryClient
public class DepartmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentApplication.class, args);
	}
	/*
	 * @Bean public Sampler defaultSampler(){ return Sampler.ALWAYS_SAMPLE; }
	 */

}
