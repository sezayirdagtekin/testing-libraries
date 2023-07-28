package com.sezo.demo.delete;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;

import constants.Token;
import io.restassured.RestAssured;;

@SpringBootTest
public class CreateRepoTes {

	private static final String DELETE_URL = "https://api.github.com/repos/sezayirdagtekin/updated-demo";

	@Test
	@Description("Delete a repo")
	public void deleteRepoTest() {
		
		RestAssured.given()
					.header("authorization", "bearer " + Token.GITHUB_TOKEN)
					.when()
					.delete(DELETE_URL)
					.then()
					.statusCode(204);
	}
}
