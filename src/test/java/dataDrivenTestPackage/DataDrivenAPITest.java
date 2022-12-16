package dataDrivenTestPackage;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenAPITest {

	@Test(dataProvider = "empdataprovider")
	void postNewEmployee(String ename, String eage, String esalary) {

		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";

		RequestSpecification httprequest = RestAssured.given();

		JSONObject requestParam = new JSONObject();

		requestParam.put("name", ename);
		requestParam.put("salary", eage);
		requestParam.put("age", esalary);

		httprequest.header("Content-Type", "application/json");
		httprequest.body(requestParam.toJSONString());

		Response response = httprequest.request(Method.POST, "/create");

		String responseBody = response.getBody().asString();
		System.out.println("Response Body : " + responseBody);

		Assert.assertEquals(responseBody.contains(ename), true);
		Assert.assertEquals(responseBody.contains(eage), true);
		Assert.assertEquals(responseBody.contains(esalary), true);

	}
	
	@DataProvider(name = "empdataprovider")
	String[][] getEmpData() {
		String empData[][] = { { "abc123", "30000", "40" }, { "xyz123", "20000", "45" }, { "asd123", "40000", "30" }};
		return (empData);
	}
}
