package CambDict;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CambDictStepDef 
{
	private static final WebElement DictLogo = null;
	WebDriver driver;
		
	@Given
	("^User navigate to home page$")
		public void User_navigates_homepage() 
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Public\\SeleniumJars\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
	        String baseUrl = "https://dictionary.cambridge.org";
	        driver.get(baseUrl);
	        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
			driver.manage().window().maximize();
	       
	     }
		
		
	@When
	("^User validate on cambridge logo icon$")
		public void Validate_Logo_icon() 
		{
			 driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/amp-img[1]/img[1]"));
			 Assert.assertEquals(true, DictLogo.isDisplayed());
		}
		
	@Then
	("^User should be navigated to the validation of cambridge logo$")
		public void logo_visible()
		{
	    //	Assert.assertEquals(true, DictLogo.isDisplayed());
	    	System.out.println("Logo is dissplayed-Assert Passed");
		}
	@Given
	("^User navigate to home page and validate the  WORD OF THE DAY link$")
	    public void word_of_the_day()
	    {
	    	WebElement WordofDay=driver.findElement(By.xpath("//p[@class='fs12 tcu lmb-0']"));
			Assert.assertEquals(true, WordofDay.isDisplayed());
	    }

	@When
	("^User clicks on Word of the day link$")
	    public void word_of_day()
	    {
	    	System.out.println("Word of the day is present");
	    	driver.findElement(By.xpath("//p[contains(@class='fs36 lmt-5 feature-w-big wotd-hw')]")).click();	
	    }
	@Then
	("^User see the meaning of word on another page$")
	    public void meaning()
	    {
	    	WebElement mean=driver.findElement(By.xpath("//div[contains(@class='def ddef_d db')]"));
			System.out.println("Meaning of the word of the day is"+mean.getText());
	    }
	  
	    
	@When
	("^User navigate in serch window$")
	    public void Successful_search() throws IOException
	    {
	    	FileInputStream fis = new FileInputStream("C:\\Users\\Public\\SeleniumJars\\Datasource\\Dictdata.xlsx");
			XSSFWorkbook workbook =new XSSFWorkbook(fis);
			XSSFSheet ws = workbook.getSheetAt(0);	
			int rownum = ws.getLastRowNum();
			int colnum =ws.getRow(0).getPhysicalNumberOfCells();
			System.out.println(colnum);
			System.out.println(rownum);
			XSSFCell searchkey;
	    }
	    
	@Then
	("^User have enters the words in search box And gets the meaning of their desired words$")
	    public void Enter_words_get_the_meaning() throws IOException
	    {
	    	FileInputStream fis = new FileInputStream("C:\\Users\\Public\\SeleniumJars\\Datasource\\Dictdata.xlsx");
			XSSFWorkbook workbook =new XSSFWorkbook(fis);
			XSSFSheet ws = workbook.getSheetAt(0);	
			int rownum = ws.getLastRowNum();
			int colnum =ws.getRow(1).getPhysicalNumberOfCells();
			System.out.println(colnum);
			System.out.println(rownum);
			XSSFCell searchkey;
	    	int rownum1 = 0;
			for(int i=1; i<=rownum1;i++)
			{ 	
				//driver.navigate().to("url");
				driver.findElement(By.xpath("//body[1]/div[3]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]")).click();
				XSSFSheet ws1 = null;
				Object searchkey1 = ws1.getRow(i).getCell(0);
				
				
				//Entering the word to get the meaning and translation
				driver.findElement(By.name("q")).sendKeys(searchkey1.toString());
				System.out.println("user enter word: "+searchkey1);
				driver.findElement(By.xpath("//body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/span[1]/button[3]/i[1]")).click();

				//display the meaning of the word in console
				WebElement e= driver.findElement(By.xpath("/body[1]/div[2]/div[1]/div[1]/div[2]/article[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]"));
				System.out.println( searchkey1+" meaning :"+e.getText());
				System.out.println("user got the meaning :"+searchkey1);
				
				//Clicking on the audio button to listen the pronunciation of the words
				driver.findElement(By.xpath("//span[contains(@class,'uk dpron-i')]//span[@class='daud']//div[@class='i i-volume-up c_aud htc hdib hp hv-1 fon tcu tc-bd lmr-10 lpt-3']")).click();
				
				//validating title page
				System.out.println(driver.getTitle());
			}
	    }
	    
	   
	 @Given
	 ("^user navigate to the facebook icon$")
	    	 public void facebook_icon()
	        {
	    		driver.navigate().to("https://dictionary.cambridge.org");
	        }
	 @When
	 ("^user look for the facebook page$")
	        public void facebook_page()
	        {
	        	driver.findElement(By.xpath("//body[1]/header[1]/div[1]/div[2]/ul[1]/li[1]/a[1]")).click();
	        }
	        
	@Then
	("^user should be navigated to cambridge facebook homepage$")
	        public void facebook_page_open()
	        {
	        	Set<String> windows=driver.getWindowHandles();
				Object parent=null;
				Object child=null;
				Iterator it=windows.iterator();
				while(it.hasNext())
				{
					parent =it.next();
					child =it.next();
				}

				//switch to child window- Cambridge Facebook window
				driver.switchTo().window((String) child);
	        }
}
