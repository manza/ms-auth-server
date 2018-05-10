package com.manzano.msauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAuthServerApplication.class, args);
	}
}
