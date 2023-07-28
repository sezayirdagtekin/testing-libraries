package com.sezo.configuration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.AfterTestClass;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;;

public class ResponseSpecTest {
	
	 final static  String BASE_URI="https://api.github.com/";
	 
	  RequestSpecification spec=null; 

	 @BeforeEach
	 public void setUp() {
		RestAssured.responseSpecification= new ResponseSpecBuilder()
				                          .expectStatusCode(404)
				                          .expectContentType(ContentType.JSON)
				                          .build(); 
	 }

	 @AfterTestClass
	 public void cleanup() {
		 RestAssured.responseSpecification=null;
	 }
	 
	 
	@Test
	public void test1() {

		RestAssured.get(BASE_URI+"notexist");
	   //.then()
		//.statusCode(404)
		//.contentType(ContentType.JSON);
	}
		
	
	@Test
	public void test2() {

		RestAssured.get(BASE_URI+"wrongurl");
		//.then()
		//.statusCode(404)
		//.contentType(ContentType.JSON);
	}
	

}
