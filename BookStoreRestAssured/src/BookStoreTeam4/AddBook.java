package BookStoreTeam4;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class AddBook 
{
	@Test
	public void addBook()
	{
		String userID = "fb6d8c9f-f11b-4098-9a92-dbefc0553a84"; 
		//String userName = "TestMona2020"; 
		//String password = "TestMona@2020"; 
		String baseUrl = "https://bookstore.toolsqa.com"; 
		String isbn = "9781449325862";
		String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IlRlc3RVc2VyMjAyMCIsInBhc3N3b3JkIjoiVGVzdFBhc3N3b3JkQDIwMjAiLCJpYXQiOjE2NTY3NjA4NzZ9.yr4RwnVPCvf8k5XdVOyxhIM4KMsKSEUWITOTHuGSAGk";
		RestAssured.baseURI = baseUrl; 
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer " + token) .header("Content-Type", "application/json"); 
		Response response = request.body("{ \"userId\": \"" + userID + "\", " + "\"collectionOfIsbns\": [ { \"isbn\": \"" + isbn + "\" } ]}") .post("/BookStore/v1/Books"); 
		Assert.assertEquals( 201, response.getStatusCode()); 
	}
}
