package com.sezo.demo.patch;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;

import com.sezo.demo.constant.Token;

import io.restassured.RestAssured;;

@SpringBootTest
public class CreateRepoTes {

	private static final String PATCH_URL = "https://api.github.com/repos/sezayirdagtekin/demo";

	
	
	@Test
	@Description("Update a repo")
	public void patchRepoTest() {

		String body = """
				{
				   	"name":"updated-demo"
				}""";

		RestAssured.given()
					.body(body)
					.header("authorization", "bearer " + Token.GITHUB_TOKEN)
					.when()
					.patch(PATCH_URL)
					.then()
					.statusCode(200);
	}
	
	

}
