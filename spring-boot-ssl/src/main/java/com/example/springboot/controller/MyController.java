package com.example.springboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MyController {

	@RequestMapping(value = "/products")
	public ResponseEntity<List<String>> getProduct() {
		log.info("Entry point to getProduct");
			List<String> list = Arrays.asList("hello","world");
	      return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
