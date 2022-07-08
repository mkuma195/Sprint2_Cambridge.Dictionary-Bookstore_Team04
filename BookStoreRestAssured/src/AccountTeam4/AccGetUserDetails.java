package AccountTeam4;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AccGetUserDetails 
{
	@Test
	public void getUserDetails()
	{
		String userID = "fb6d8c9f-f11b-4098-9a92-dbefc0553a84"; 
		//String userName = "TestMona2020"; 
		//String password = "TestMona@2020"; 
		String baseUrl = "https://bookstore.toolsqa.com"; 
		RestAssured.baseURI = baseUrl; 
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		Response response = request.get("/Account/v1/User/" + userID); 
		Assert.assertEquals(200, response.getStatusCode()); 
		String jsonString = response.asString(); 
		System.out.println(response.asString());
		List<Map<String, String>> booksOfUser = JsonPath.from(jsonString).get("books");
		Assert.assertEquals(0, booksOfUser.size()); 
	}
}
