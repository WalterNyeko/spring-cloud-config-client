package com.application.config.client.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/api/v1/")
public class ConfigurationsController {

	@Value("${spring.datasource.url}")
	private String databaseURL;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Value("${spring.datasource.driver-class-name}")
	private String driverName;
	
	@Value("${server.port}")
	private String serverPort;
	
	
	@GetMapping("/dev")
	public String getConfigs() {
		String config = "URL: "+this.databaseURL+ ", Username: "+this.username+ ", "
				+ "Password: "+this.password+ ", Driver: "+this.driverName+ ", Server Port: "+this.serverPort;
		return config;
	}
}
