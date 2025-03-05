package com.example.auth;

import org.springframework.boot.SpringApplication;

public class TestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.from(AuthServiceApp::main).with(TestcontainersConfiguration.class).run(args);
	}

}
