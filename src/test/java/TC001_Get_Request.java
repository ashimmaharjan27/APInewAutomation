import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TC001_Get_Request {

	@Test
	void getWeatherDetails() {
		// Specity base URI
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

		// Request object
		RequestSpecification httprequest = RestAssured.given();

		// Response object
		Response response = httprequest.request(Method.GET, "/users");

		// Print response in console
		String responsebody = response.getBody().asString();
		System.out.println("Respose Body is" + responsebody);
		
		 responsebody.contains("name");
		 
		   		  
		// status code Validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is : " + statusCode);
		Assert.assertEquals(statusCode, 200);

		// Status line verification
		String statusLine = response.getStatusLine();
		System.out.println("Status Line is : " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

		// Name verification
		String name = response.jsonPath().get("name");
		System.out.println("name is : " + name);
		Assert.assertEquals(name, "Leanne Graham");
		
		String contentType = response.header("Content-Type");
		System.out.println(contentType);
		
		String contentEncoding = response.header("Content-Encoding");
		System.out.println(contentEncoding);
		

	}

}
