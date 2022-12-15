package postmanAPItesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
//import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GetWeatherAPI {

	@Test
	void getWeatherDetail() {

		RestAssured.baseURI = "https://simple-books-api.glitch.me";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "/status");

		String responseBody = response.getBody().asString();
		System.out.println(responseBody);

		Headers allheader = response.headers();// capture all the header

		for (Header header : allheader) {

			System.out.println(header.getName() + " : " + header.getValue());
		}

	}
}
