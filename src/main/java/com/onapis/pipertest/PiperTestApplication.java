package com.onapis.pipertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.onapis.pipertest")
public class PiperTestApplication {

	public static void main(String[] args) {

		System.out.println("Entered main class");
		SpringApplication.run(PiperTestApplication.class, args);
	}

}
