package AccountTeam4;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AccGenerateToken 
{
	@Test
	public void GenerateToken()
	{
		//String userID = "4c5e5dd1-63f8-4da8-8b6c-ceb96c52fe37"; 
		String userName = "TestUser2020"; 
		String password = "TestPassword@2020"; 
		String baseUrl = "https://bookstore.toolsqa.com"; 
		RestAssured.baseURI = baseUrl; 
		RequestSpecification request = RestAssured.given(); 
		request.header("Content-Type", "application/json"); 
		Response response = request.body("{ \"userName\":\"" + userName + "\", \"password\":\"" + password + "\"}") .post("/Account/v1/GenerateToken"); 
		Assert.assertEquals(response.getStatusCode(), 200); 
		String jsonString = response.asString(); 
		Assert.assertTrue(jsonString.contains("token")); 
		//This token will be used in later requests 
		String token = JsonPath.from(jsonString).get("token");
		System.out.println(token);
	}
}
