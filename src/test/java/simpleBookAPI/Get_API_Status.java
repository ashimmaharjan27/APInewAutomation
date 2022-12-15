package simpleBookAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_API_Status {
	
	@Test
	void getAPIStatus() {
		
		RestAssured.baseURI="https://simple-books-api.glitch.me";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/status");
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);
		
		String status = response.jsonPath().get("status");
		Assert.assertEquals(status, "OK");
				
	}
	

}
