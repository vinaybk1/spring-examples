package com.example.springboot.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URL;

import javax.annotation.Resource;
import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;
import java.nio.charset.StandardCharsets;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MyApplicationSanityTest {
	
	@LocalServerPort
	private int port;
	
	
	RestTemplate restTemplate() throws Exception {
		SSLContext sslContext = new SSLContextBuilder()
                .loadTrustMaterial(new URL("file:src/test/resources/keystore/mycert.p12"), "mycert123$".toCharArray()).build();
        SSLConnectionSocketFactory sslConFactory = new SSLConnectionSocketFactory(sslContext);
 
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslConFactory).build();
        ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
 
        return restTemplate;
        
	}
	
	HttpHeaders createHeaders(String username, String password) {
        return new HttpHeaders() {{
            final String basicAuth = HttpHeaders.encodeBasicAuth("testrest", "testrest", StandardCharsets.US_ASCII);
            setBasicAuth(basicAuth);
        }};
    }

	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		ResponseEntity<String> result = restTemplate().exchange("https://localhost:"+port+"/products", HttpMethod.GET, new HttpEntity<Void>(createHeaders("admin", "password")), String.class);
		
		        assertEquals(HttpStatus.OK, result.getStatusCode());
	}

}
