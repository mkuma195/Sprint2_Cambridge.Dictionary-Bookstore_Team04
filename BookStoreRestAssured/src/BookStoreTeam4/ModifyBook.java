package BookStoreTeam4;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ModifyBook 
{
	@Test
	public void modifyBook()
	{
		//String userID = "fb6d8c9f-f11b-4098-9a92-dbefc0553a84"; 
		//String userName = "TestMona2020"; 
		//String password = "TestMona@2020"; 
		String baseUrl = "https://bookstore.toolsqa.com"; 
		//String isbn = "9781449325862";
		RestAssured.baseURI = baseUrl; 
		RequestSpecification request = RestAssured.given(); 
		Response response = request.get("/BookStore/v1/Book?ISBN=9781449325862"); 
		Assert.assertEquals( 200, response.getStatusCode());
		System.out.println(response.asString());
		
	}
}
