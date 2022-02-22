package com.example.components;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ExampleComponent {
	
	public ExampleComponent() {
		log.info("Inside ExampleComponent");
	}

}
