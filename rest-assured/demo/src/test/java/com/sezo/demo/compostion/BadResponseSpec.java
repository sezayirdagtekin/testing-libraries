package com.sezo.demo.compostion;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class BadResponseSpec {
	
	  public static ResponseSpecification  endpointSpec() {
		  return  new ResponseSpecBuilder()
				  .expectStatusCode(404)
				  .expectContentType(ContentType.JSON).build();
	  }


}
