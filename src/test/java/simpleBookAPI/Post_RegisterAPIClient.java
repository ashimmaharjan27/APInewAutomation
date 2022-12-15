package simpleBookAPI;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_RegisterAPIClient {
	
	@Test
	void postRegisterAPI() {
		
		RestAssured.baseURI = "https://simple-books-api.glitch.me";
		
		RequestSpecification httprequest = RestAssured.given();
			
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("clientName","Newusers101");
		requestParams.put("clientEmail","newuser3@example.com");
		
		httprequest.header("Content-Type","application/json");
		httprequest.body(requestParams.toJSONString());
		
		Response response = httprequest.request(Method.POST,"/api-clients/");
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		

		
	}

}
