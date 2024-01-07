package com.svarto.sitespringredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SiteSpringRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiteSpringRedisApplication.class, args);
	}

}
