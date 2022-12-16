import java.lang.reflect.Array;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Get_Request_path {

	@Test
	void getWeatherDetails() {
		// Specity base URI
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

		// Request object
		RequestSpecification httprequest = RestAssured.given();

		// Response object
		Response response = httprequest.request(Method.GET, "/users/1");

		// Print response in console
		String responsebody = response.getBody().asString();
		System.out.println("Respose Body is" + responsebody);
//
//		Headers allheader = response.headers();// capture all the header
//
//		for (Header header : allheader) {
//
//			System.out.println(header.getName() + " : " + header.getValue());
//		}
		
		JsonPath jsonpath = response.jsonPath();
		String name = jsonpath.get("name");
		System.out.println("name: " + name);
		
			
		}
		
		
	}


