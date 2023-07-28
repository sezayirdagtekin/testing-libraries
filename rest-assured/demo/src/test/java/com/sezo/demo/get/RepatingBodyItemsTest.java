package com.sezo.demo.get;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;;

@SpringBootTest
public class RepatingBodyItemsTest {

	private static final String URL = "https://reqres.in/api/users?page=1";

	
	@Test
	public void repeatItemsTest() {
	
		RestAssured.get(URL)
		.then()
		.statusCode(200)
		.body("data[0].id",Matchers.equalTo(1))
		.body("data[2].first_name",Matchers.equalTo("Emma"))
		.body("data[1].first_name",Matchers.equalTo("Janet"));

	}
	
	
	
	@Test
	public void repeatItemsTest2() {
	
		RestAssured.get(URL)
		.then()
		.statusCode(200)
		.body("data.last_name",Matchers.hasItems("Bluth","Wong"))
		.body("data.first_name",Matchers.hasItem("Janet"));

	}
	

	@Test
	public void  parserTypeFailTest() {
		//This test will fail.
		RestAssured.get(URL)
		.then()
		.statusCode(200)
		.using()
		.defaultParser(Parser.XML)  //Wrong parser
		.body("data.last_name",Matchers.hasItems("Bluth","Wong"))
		.body("data.first_name",Matchers.hasItem("Janet"));

	}
	

}
