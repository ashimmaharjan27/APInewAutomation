package postmanAPItesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC1_GetRequest {

	
	@Test
	void getRequest() {
		
		RestAssured.baseURI = "https://dummy.restapiexample.com";
		
		RequestSpecification httpRequest = RestAssured.given(); //objectrequest
		
		Response response = httpRequest.request(Method.GET,"/api/v1/employees");//object response
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		
		String name = response.jsonPath().get("data[2].employee_name");
		System.out.println("name is : " + name);
		Assert.assertEquals(name, "Ashton Cox");
		
		
	}
}
