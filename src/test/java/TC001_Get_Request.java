import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_Get_Request {
	
	@Test
	void getWeatherDetails() {
		//Specity base URI
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		//Request object
		RequestSpecification httprequest = RestAssured.given();
	
		//Response object
		Response response = httprequest.request(Method.GET,"/users/1");
	
		//Print response in console 
		String responsebody = response.getBody().asString();
		System.out.println("Respose Body is" + responsebody);
		
		//status code Validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is : " + statusCode);
		Assert.assertEquals(statusCode, 200);
		
		
		//Status line verification
		String statusLine =  response.getStatusLine();
		System.out.println("Status Line is : " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
				
		
	}

}
