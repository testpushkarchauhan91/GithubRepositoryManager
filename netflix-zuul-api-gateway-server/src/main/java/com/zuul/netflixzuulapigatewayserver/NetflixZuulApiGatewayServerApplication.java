package com.zuul.netflixzuulapigatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
//import org.springframework.context.annotation.Bean;

//import brave.sampler.Sampler;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrix
@EnableSwagger2
public class NetflixZuulApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApiGatewayServerApplication.class, args);
	}
	
//	@Bean
//	public Sampler alwaysSampler() {
//		return Sampler.ALWAYS_SAMPLE;
//	}

}
