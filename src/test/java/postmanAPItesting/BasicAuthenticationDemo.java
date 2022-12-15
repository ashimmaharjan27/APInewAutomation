package postmanAPItesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasicAuthenticationDemo {

	
	@Test
	void basicAuthentication() {
		
		RestAssured.baseURI ="https://postman-echo.com";
		
		//Basic Authorization
		PreemptiveBasicAuthScheme authscheme = new PreemptiveBasicAuthScheme();
		authscheme.setUserName("postman");
		authscheme.setPassword("password");
		
		RestAssured.authentication = authscheme;
		
		RequestSpecification httprequest = RestAssured.given();
		
		Response response = httprequest.request(Method.GET,"/basic-auth");
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		
		
	}
	
}
