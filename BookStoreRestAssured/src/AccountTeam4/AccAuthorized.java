package AccountTeam4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class AccAuthorized 
{
	@Test
	public void Authirized() throws IOException
	{
		 FileInputStream fis = new FileInputStream("C:\\Users\\Public\\SeleniumJars\\Selenium_Study_material\\AuthBookStore.xlsx");
	        XSSFWorkbook workbook = new XSSFWorkbook(fis);
	            XSSFSheet ws = workbook.getSheetAt(0);
	            int rownum  = ws.getLastRowNum();
	            int colnum = ws.getRow(0).getPhysicalNumberOfCells();
	            System.out.println(colnum);
	            System.out.println(rownum);
	            XSSFCell userName;
	            XSSFCell password;

	            for(int i = 0; i <= rownum ; i++) {

	                
	                userName = ws.getRow(i).getCell(0);
	                password = ws.getRow(i).getCell(1);


	                RestAssured.baseURI = "https://bookstore.toolsqa.com";

	                System.out.println(userName.toString());
	                System.out.println(password.toString());

	                RequestSpecification request = RestAssured.given();
	                Response response = request.body("{\"userName\":\"" + userName +"\", \"password\":\"" + password +"\"}").post("/Account/v1/Authorized");
	                ResponseBody body = response.getBody();
	                System.out.println(body.asString());
	            }
	}
}
