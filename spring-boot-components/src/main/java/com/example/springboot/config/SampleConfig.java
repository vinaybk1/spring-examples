package com.example.springboot.config;

import javax.xml.xpath.XPathException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.springboot.beans.SampleBean;
import com.example.springboot.components.SampleComponents;

import ch.qos.logback.core.joran.spi.XMLUtil;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@ComponentScan(basePackages = {"com.example.components"})
public class SampleConfig {
	
	@Bean
	public SampleBean getBean() {
		return new SampleBean();
	}
	
	@Bean
	public XPathException getXMLUnitException() {
		log.info("Inside getXMLUnitException");
		return new XPathException("sample XPath exception message");
	}

}
