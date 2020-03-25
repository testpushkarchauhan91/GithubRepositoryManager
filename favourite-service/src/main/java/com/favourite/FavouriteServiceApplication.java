package com.favourite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

//import brave.sampler.Sampler;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@EnableFeignClients
public class FavouriteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FavouriteServiceApplication.class, args);
	}
	
//	@Bean
//	public Sampler alwaysSampler() {
//		return Sampler.ALWAYS_SAMPLE;
//	}

}
