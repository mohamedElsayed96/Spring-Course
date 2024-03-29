package com.microservice.netflixeurekanamingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NetflixEurkaNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixEurkaNamingServerApplication.class, args);
	}

}
