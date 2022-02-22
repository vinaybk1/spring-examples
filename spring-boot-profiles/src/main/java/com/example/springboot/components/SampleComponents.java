package com.example.springboot.components;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

//@Component
@Slf4j
public class SampleComponents {
	
	private List<String> list;
	
	public SampleComponents() {
		list = new ArrayList<>();
		init();
	}

	private void init() {
		log.info("Inside the init methid ::");
		list.add("Tom");
		list.add("Harry");
		list.add("Michael");
		list.add("John");
		list.add("Marco");
	}

}
