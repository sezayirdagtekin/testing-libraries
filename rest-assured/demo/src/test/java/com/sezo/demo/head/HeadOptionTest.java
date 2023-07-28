package com.sezo.demo.head;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;

@SpringBootTest
public class HeadOptionTest {

	
	private static final String URL = "https://api.github.com/";

	@Test
	public void headTes() {
		
		RestAssured.head(URL)
					.then()
					.statusCode(200)
					.body(Matchers.emptyOrNullString());

	}
		
	
}
