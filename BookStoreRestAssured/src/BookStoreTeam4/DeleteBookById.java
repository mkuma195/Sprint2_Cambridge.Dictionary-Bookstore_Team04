package BookStoreTeam4;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DeleteBookById 
{
		@Test
		public void deleteUserById()
		{
			String userId= "c64c3149-fee3-41c1-aaaa-d6556a4789b9";
			String baseUrl="https://bookstore.toolsqa.com";
			String isbn ="9781449325862";
			RequestSpecification requestSpecification = RestAssured.given();
			Response response= requestSpecification.delete("/BookStore/v1/Book");
			String resString = response.prettyPrint();
			ValidatableResponse validatableResponse= response.then();
			validatableResponse.statusCode(204);
			//validatableResponse.statusLine("HTTP/1.1 200 OK");
			//validatableResponse.body("message", equals("Successfully! Record has been deleted"));
			 
		}
		

}
