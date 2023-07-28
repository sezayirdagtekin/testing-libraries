package com.sezo.demo.get;

import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;;

@SpringBootTest
public class PathParamTest {

	private static final String URL = "https://api.github.com";
	
	
	
	@Test
	public void repoTest1() {


		 RestAssured.given()
		 .pathParam("user", "sezayirdagtekin")
	     .pathParam("repo", "golang")
		 .get(URL + "/repos/{user}/{repo}").then()
         .statusCode(200)
         .body("id", Matchers.equalTo(648223111));

	}
	

	@Test
	public void repoTest2() {

		Map<String, String> mapRarams = Map.of("user", "sezayirdagtekin", "repo", "golang");
		
		RestAssured.given()
		.pathParams(mapRarams)
		.get(URL + "/repos/{user}/{repo}")
	    .then()
        .statusCode(200)
        .body("owner.id", Matchers.equalTo(6317282));

	}

}
