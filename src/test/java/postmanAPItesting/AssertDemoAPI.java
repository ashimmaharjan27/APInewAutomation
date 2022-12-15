package postmanAPItesting;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
//import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class AssertDemoAPI {

	@Test
	void getWeatherDetail() {

		RestAssured.baseURI = "https://reqres.in";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "api/users/1");

		String responseBody = response.getBody().asString();
		System.out.println("Response body is : " + responseBody);

		Assert.assertEquals(responseBody.contains("George"), true);

		JsonPath jsonpath = response.jsonPath();
		System.out.println(jsonpath.get("data.id"));
		
		//Response time Assertion
		long responsetime = response.time();
		System.out.println(responsetime);

		response.then().time(Matchers.both(Matchers.greaterThan(1000L)).and(Matchers.lessThan(3000L)));

	}
}
