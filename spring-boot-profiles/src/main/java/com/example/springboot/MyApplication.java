package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class MyApplication {

	public static void main(String[] args) {
		SpringApplication springApplication=new SpringApplication(MyApplication.class);
		String[] profiles= new String[]{"dev"};
		springApplication.setAdditionalProfiles(profiles);
		springApplication.run(args);
//		SpringApplication.run(MyApplication.class, args);
	}

}
