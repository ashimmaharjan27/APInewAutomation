package dataDrivenTestPackage;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenAPITestFromExcel {

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
	String[][] getEmpData() throws IOException {
		
		String path = System.getProperty("user.dir")+"/src/test/java/dataDrivenTestPackage/empdata.xlsx";
		
		int rownum = XLUtils.getRowCount(path,"Sheet1");
		int colcount = XLUtils.getCellCount(path,"Sheet1",1);
		
		String empdata[][]=new String[rownum][colcount];
		
		for(int i = 1 ; i <= rownum; i++) {
			for(int j = 0; j < colcount;j++) {
				empdata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i, j);
			}
		}
		
		return (empdata);
		
	}
}
