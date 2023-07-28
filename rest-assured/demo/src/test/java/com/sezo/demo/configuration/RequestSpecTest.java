package com.sezo.demo.configuration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;;

public class RequestSpecTest {
	
	 final static  String BASE_URI="https://reqres.in/";
	 
	  RequestSpecification spec=null; 

	 @BeforeEach
	 public void setUp() {
		 spec=  new  RequestSpecBuilder().setBaseUri(BASE_URI).build();	 
	 }

	@Test
	public void test1() {

		RestAssured.given()
		.spec(spec)
		.when()
		
		.get()
		
		.then()
		
		.statusCode(200);
	

	}
	

}
