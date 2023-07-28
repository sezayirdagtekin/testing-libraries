package com.sezo.configuration;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;;

public class GlobalVariableTest {

	@BeforeEach
	public void SetUp() {

		RestAssured.baseURI = "https://reqres.in/";
		RestAssured.basePath = "api/users/";
	   //RestAssured.rootPath="data"; // It is better  to define here
	}

	@Test
	public void test1() {

		RestAssured.get().
		then()
		.rootPath("data")
		.body("first_name[0]", equalTo("George"));

	}
	
	@Test
	public void test2() {

		RestAssured.get().then()
		.rootPath("data")
		.body("last_name[2]", equalTo("Wong"));

	}

}
