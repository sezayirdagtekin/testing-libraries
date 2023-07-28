package com.sezo.demo.get;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.notNull;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;;

@SpringBootTest
public class ResponseBodyTest {

	private static final String URL = "https://api.github.com/rate_limit";

	@Test
	public void bodyTest() {

		Response response = RestAssured.get(URL);
		var jsonPath = response.jsonPath();

		assertEquals("60", jsonPath.get("resources.core.limit").toString());

	}
	
	@Test
	public void bodyChainTest() {
	
		RestAssured.get(URL)
		.then()
		.body("resources", notNullValue())
		.body("resource.core",not(Matchers.anEmptyMap()))
		.body("resources.core.limit", Matchers.equalTo(60));

	}
	
	
	@Test
	public void bodyRootPathTest() {
		
	  //Good feature but test should be small ,focused and self-contained
		RestAssured.get(URL)
		.then()
		.rootPath("resources.core")
			.body("limit", Matchers.equalTo(60))
			.body("resource", Matchers.equalTo("core"))
		.rootPath("resources.search")
		    .body("limit", Matchers.lessThanOrEqualTo(10))
		    .body("resource",not(Matchers.empty()))
	     .noRootPath()
		 .body("resources.graphql.limit", Matchers.greaterThanOrEqualTo(0));
		
	
	
	}
}
