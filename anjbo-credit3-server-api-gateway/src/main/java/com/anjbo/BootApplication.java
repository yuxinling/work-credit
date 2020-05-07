package com.anjbo;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableFeignClients
@EnableZuulProxy
@SpringBootApplication
public class BootApplication {

	//设置时区
	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+08:00"));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}
}
