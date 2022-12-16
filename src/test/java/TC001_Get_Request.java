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

public class TC001_Get_Request {

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
		System.out.println("contentType : " + contentType);

		String contentEncoding = response.header("Content-Encoding");
		System.out.println("contentEncoding : " + contentEncoding);

		Headers allheader = response.headers();// capture all the header

		for (Header header : allheader) {

			System.out.println(header.getName() + " : " + header.getValue());
		}
	}

}
