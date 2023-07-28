package com.sezo.demo.compostion;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.AfterTestClass;

import io.restassured.RestAssured;;

public class BadEnPointTest {
	
	 final static  String BASE_URI="https://api.github.com/non/existing/url";


	 @AfterTestClass
	 public void cleanup() {
		 RestAssured.responseSpecification=null;
	 }
	 
	 
	@Test
	public void test1() {

		RestAssured.get(BASE_URI)
		.then()
		.spec(BadResponseSpec.endpointSpec())
		.body("message", equalTo("Not Found"));
	}
		
	
	@Test
	public void test2() {

		RestAssured.get(BASE_URI)
		.then()
		.spec(BadResponseSpec.endpointSpec())
		.body("documentation_url", equalTo("https://docs.github.com/rest"));
	}
	

}
