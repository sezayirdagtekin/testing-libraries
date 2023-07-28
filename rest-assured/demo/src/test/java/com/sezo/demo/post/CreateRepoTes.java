package com.sezo.demo.post;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;

import com.sezo.demo.constant.Token;

import io.restassured.RestAssured;;

@SpringBootTest
public class CreateRepoTes  {

	private static final String URL = "https://api.github.com/user/repos";

	@Test
	@Description("Create a repo with authorization header")
	public void createRepoTest() {

		String body = """
				{
				   	"name":"demo"
				}""";

		RestAssured.given()
					.body(body)
					.header("authorization", "bearer " + Token.GITHUB_TOKEN)
					.when()
					.post(URL)
					.then()
					.statusCode(201);
	}
	
	
	@Test
	@Description("Create a repo with oauth2 token ")
    @Disabled("Disabled  . First test creates same repo!")
	public void createRepoWithAuth2Test() {

		String body = """
				{
				   	"name":"demo"
				}""";
		

		RestAssured.given()
					.body(body)
					.auth()
					.oauth2( Token.GITHUB_TOKEN)
					.when()
					.post(URL)
					.then()
					.statusCode(201);
	}
	


}
