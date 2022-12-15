import org.apache.http.HttpRequest;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_Post_Request {

	@Test
	void postRequest() {
		
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		
		RequestSpecification httprequest = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
			
			requestParams.put("id", 11);
			requestParams.put("name","Krishna Rungta");
			requestParams.put("username", "Bret");
			requestParams.put("email","Sincere@april.biz");
		   	requestParams.put("phone","1-770-736-8031 x56442");
            requestParams.put("website","hildegard.org");
            
            httprequest.header("Content-Type","application/json");
            httprequest.body(requestParams.toJSONString());
           
            Response response=httprequest.request(Method.POST,"/users");
       
        	//Print response in console 
    		String responsebody = response.getBody().asString();
    		System.out.println("Respose Body is" + responsebody);
    		
    		//status code Validation
    		int statusCode = response.getStatusCode();
    		System.out.println("Status code is : " + statusCode);
    		Assert.assertEquals(statusCode, 201);
    		
    		//Name verification
    		String name =  response.jsonPath().get("name");
    		System.out.println("name is : " + name);
    		Assert.assertEquals(name, "Krishna Rungta");
    		
    		//username verification
    		String username =  response.jsonPath().get("username");
    		System.out.println("Username is : " + name);
    		Assert.assertEquals(username, "Bret");
		
	}

}
