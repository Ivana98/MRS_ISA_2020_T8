package com.team08.CCSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class })
@EnableScheduling
public class CcSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CcSystemApplication.class, args); //
	}

}
