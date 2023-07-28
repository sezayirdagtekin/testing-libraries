package com.sezo.demo.custome;

import static org.hamcrest.CoreMatchers.containsString;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import io.restassured.RestAssured;
import io.restassured.http.Method;;


public class CustomeRequestTest {

	private static final String BASE_URL = "https://api.github.com/";


	@Test
	public void customeRequestTest() {

           RestAssured.request(Method.GET, BASE_URL)
           .then()
           .statusCode(200)
           .body(containsString("current_user_url"));
	}	

	
	@Test
	@Description("same as above test")
	public void customeRequestTest2() {

           RestAssured.request("Get", BASE_URL)
           .then()
           .statusCode(200)
           .body(containsString("current_user_url"));
	}	

	


	@Test
	@Description("The TRACE method should be disabled on production web servers.The HTTP TRACE method is designed for diagnostic purposes."
			+ " If enabled, the web server will respond to requests that use the TRACE method by echoing in its response the exact request that was received.")
	public void traceTest() {

           RestAssured.request(Method.TRACE, BASE_URL)
           .then()
           .statusCode(405); //Method not allowed
        
	}	

}
