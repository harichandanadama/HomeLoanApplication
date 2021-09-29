package com.cg.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class CustomerMain {

		public static void main(String[] args) {
			SpringApplication.run(CustomerMain.class, args);
			System.out.println("Testing..");
		}

	}


