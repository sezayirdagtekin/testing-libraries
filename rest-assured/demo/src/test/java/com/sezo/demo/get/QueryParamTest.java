package com.sezo.demo.get;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;;

@SpringBootTest
public class QueryParamTest {

	//Main api : https://api.github.com/
	private static final String URL = "https://api.github.com/search/repositories";
	

	@Test
	public void repoSearchTest1() {

	     RestAssured.get(URL+"?q=java&per_page=2") //ugly
	      .prettyPeek()
	      .then()
	      .statusCode(200);		
	}
	
	
	@Test
	public void repoSearchTest2() {

	    RestAssured.given()
	    .param("q", "java")  //better
	    .param("per_page", 2)
	    .get(URL)	     
	    .prettyPeek()
	    .then()
	    .statusCode(200);		
	}
	
	
	@Test
	public void repoSearchTest3() {

	    Map<String, String> paramMap= Map.of("q", "java", "per_page", "2");
	    
		RestAssured.given()
	    .params(paramMap)  //better
	    .get(URL)	     
	    .prettyPeek()
	    .then()
	    .statusCode(200);		
	}

}
