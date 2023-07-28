package com.sezo.demo.option;

import static org.hamcrest.CoreMatchers.equalTo;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;

@SpringBootTest
public class HeadOptionTest {

	
	private static final String URL = "https://api.github.com/";
	
	
	@Test
	public void OptionTest() {
		
		RestAssured.options(URL)
					.then()
					.statusCode(204)
					.header("access-control-allow-methods", equalTo("GET, POST, PATCH, PUT, DELETE"))					
					.body(Matchers.emptyOrNullString());

	}
		
}
