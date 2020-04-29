package com.team08.CCSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class })
public class CcSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CcSystemApplication.class, args); //
	}

}
