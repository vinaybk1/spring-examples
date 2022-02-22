package com.example.springboot.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Profile("dev")
@Slf4j
public class ExampleDataSourceConfig {
	
	public ExampleDataSourceConfig() {
		log.info("Inside ExampleDataSourceConfig :: Profile");
	}

}
