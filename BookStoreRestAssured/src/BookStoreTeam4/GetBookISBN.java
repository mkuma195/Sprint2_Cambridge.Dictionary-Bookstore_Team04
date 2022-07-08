package BookStoreTeam4;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GetBookISBN 
{
	@Test
	public void getBookIsbn()
	{
		RestAssured.baseURI="https://bookstore.toolsqa.com";
		RequestSpecification request=RestAssured.given();
		request.header("Authorization","VGVzdHN1cmFqMjAyMDpUZXN0c3VyYWpAMjAyMA==")
			.header("Content-Type","application/json");
		String replacementDetails="{\r\n"
				+ "  \"userId\": \"de1710dd-b160-4e98-8473-5b4cb9721c98\",\r\n"
				+ "  \"isbn\": \"9781593275846\"\r\n"
				+ "}";
		Response replaceBooksResponse=request.body(replacementDetails).put("BookStore/v1/Books/9781449337711");
		Assert.assertEquals(200,replaceBooksResponse.getStatusCode());
		replaceBooksResponse.prettyPrint();
		
	}
}
