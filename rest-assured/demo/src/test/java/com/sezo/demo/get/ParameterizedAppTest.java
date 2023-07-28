package com.sezo.demo.get;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;


@SpringBootTest

public class ParameterizedAppTest {

	//Main api : https://api.github.com/
	private static final String URL = "https://api.github.com/search/repositories";
	

	//Method should be static  other wise  error:  
	//ParameterizedAppTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration
	private static  Object[][] testData() {
		return new Object[][] {
				                { Map.of("q", "java", "per_page", "2"), 2 },
					            { Map.of("q", "python", "per_page", "5"), 5 }
			                  };
	}
	
	
	@ParameterizedTest
	@MethodSource("testData")
	void checkExplicitMethodSource(Map<String, String> params,int expectedRepoCount) {
		
		var json=RestAssured.given().params(params).get(URL).jsonPath();
		assertEquals(json.getInt("items.size()"),expectedRepoCount); 
		
		// Groovy  size method. Because  RestAssured has written in Groovy
		//For sample json :https://api.github.com/search/repositories?q=java
	  
	}



   
 
}
