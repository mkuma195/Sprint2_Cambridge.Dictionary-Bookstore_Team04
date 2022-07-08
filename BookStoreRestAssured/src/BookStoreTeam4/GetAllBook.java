package BookStoreTeam4;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllBook 
{

	@Test
	public void getAllBook()
	{
		//String userID = "4c5e5dd1-63f8-4da8-8b6c-ceb96c52fe37"; 
		//String userName = "TestUser2020"; 
		//String password = "TestPassword@2020"; 
		String baseUrl = "https://bookstore.toolsqa.com"; 
		RestAssured.baseURI = baseUrl; 
		RequestSpecification request = RestAssured.given(); 
		Response response = request.get("/BookStore/v1/Books"); 
		Assert.assertEquals(response.getStatusCode(), 200); 
		String jsonString = response.asString(); 
		List<Map<String, String>> books = JsonPath.from(jsonString).get("books"); 
		Assert.assertTrue(books.size() > 0); 
		//This bookId will be used in later requests, to add the book with respective isbn 
		String bookId  = books.get(0).get("isbn");
		System.out.println(bookId );
		
	}
}
