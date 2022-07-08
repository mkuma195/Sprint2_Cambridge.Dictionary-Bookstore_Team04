package AccountTeam4;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class AccAddNewUser 
{
	@Test
	public void addNewUser()
	{

		//String userID = "22ccfbdd-37e5-40bc-96a0-b95783304976"; 
		String userName = "TestMonika2020"; 
		String password = "TestMonika@2020"; 
		String baseUrl = "https://bookstore.toolsqa.com"; 
		RestAssured.baseURI = baseUrl; 
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json"); 
		Response response = request.body("{ \"userName\":\"" + userName + "\", \"password\":\"" + password + "\"}") .post("/Account/v1/User");
		System.out.println(response.asString());
		Assert.assertEquals( 201, response.getStatusCode()); 
		JsonPath jsonPathEvaluator = response.jsonPath();
        System.out.println("The user id is:" + jsonPathEvaluator.get("userID"));
		
	}
}
