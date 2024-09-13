package com.kr.kopoctc.planningBridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class PlanningBridgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanningBridgeApplication.class, args);
	}

}
