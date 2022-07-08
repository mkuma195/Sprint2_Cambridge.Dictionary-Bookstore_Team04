package BookStoreTeam4;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class DeleteBook 
{
	String userId= "c64c3149-fee3-41c1-aaaa-d6556a4789b9";
	String baseUrl="https://bookstore.toolsqa.com";
	String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IlRlc3RVc2VyMjAyMCIsInBhc3N3b3JkIjoiVGVzdFBhc3N3b3JkQDIwMjAiLCJpYXQiOjE2NTY4MjU2MzJ9.1WOO0MKV7NQDxn1u0q7DA2hi6t2WIZEBA2AGs5GwdbU";
	//String isbn ="9781449325862";

	@BeforeTest
	@AfterTest
	public void getUserData() 
	{ 
		RestAssured.baseURI = baseUrl;
		RequestSpecification httpRequest =
		RestAssured.given().header("Authorization", "Bearer " + token)
			.header("Content-Type", "application/json");
		Response res = httpRequest.get("/Account/v1/User/"+userId);
		ResponseBody body = res.body(); 
		//Converting the response body to string
		String rbdy = body.asString(); 
		System.out.println("Data from the GET API- "+rbdy); 
	}
	@Test
	public void deleteBook() {
	RestAssured.baseURI = baseUrl;
	RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + token)
			.header("Content-Type", "application/json");
		 
	//Calling the Delete API with request body
	Response res = httpRequest.body("{\"userId\": \"" + userId + "\"}").delete("/BookStore/v1/Books/"+userId);
	 
	//Fetching the response code from the request and validating the same
	System.out.println("The response code is - " +res.getStatusCode());
	Assert.assertEquals(res.getStatusCode(),204);
     
	  }
	
}
