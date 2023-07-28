package com.sezo.configuration;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;;

public class LogTest {
	
	
	private static final String URI="https://reqres.in/api/users/";


	@Test
	public void test() {

		RestAssured.given()
					.log().all()
					//OR
					.log().headers()
					.log().body()
					.when()
					.get(URI)
					.then()
					.log().headers()
					.log().ifValidationFails(LogDetail.ALL)
					.statusCode(200);

	}
	

}
