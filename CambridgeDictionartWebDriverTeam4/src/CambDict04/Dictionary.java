package CambDict04;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Dictionary 
{
		public static void main(String[] args) throws InterruptedException, IOException 
		{

			WebDriver driver;
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Public\\SeleniumJars\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			String baseUrl = "https://dictionary.cambridge.org/";
			driver.get(baseUrl);
			
			driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
			driver.manage().window().maximize();
			Thread.sleep(3000);
			
			//find the logo
			WebElement DictLogo=driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/amp-img[1]/img[1]"));
			Assert.assertEquals(true, DictLogo.isDisplayed());
			System.out.println("Logo is dissplayed-Assert Passed");
			
			WebElement WordofDay=driver.findElement(By.xpath("//p[@class='fs12 tcu lmb-0']"));
			Assert.assertEquals(true, WordofDay.isDisplayed());
			System.out.println("Word of the day is present");
			if(driver.findElement(By.xpath("//p[@class='fs12 tcu lmb-0']")).isDisplayed()) {
				WebElement word=driver.findElement(By.xpath("//p[contains(@class='fs36 lmt-5 feature-w-big wotd-hw')]"));
				word.click();
				System.out.println("Word of the day is "+word);
			}
			else {
				System.out.println("Word of the day is not present");
			}
			WebElement mean=driver.findElement(By.xpath("//div[contains(@class='def ddef_d db')]"));
			System.out.println("Meaning of the word of the day is"+mean.getText());
			
			FileInputStream fis = new FileInputStream("C:\\Users\\Public\\SeleniumJars\\Datasource\\Dictdata.xlsx");
			XSSFWorkbook workbook =new XSSFWorkbook(fis);
			XSSFSheet ws = workbook.getSheetAt(0);	
			int rownum = ws.getLastRowNum();
			int colnum =ws.getRow(0).getPhysicalNumberOfCells();
			System.out.println(colnum);
			System.out.println(rownum);
			XSSFCell searchkey;
			
			//iterations to get meaning and translation
			for(int i=1; i<=rownum;i++) { 	
				//driver.navigate().to("url");
				driver.findElement(By.xpath("//body[1]/div[3]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]")).click();
				searchkey= ws.getRow(i).getCell(0);
				System.out.println("word for which user needs meaning and translation :"+searchkey);
				
				//Entering the word to get the meaning and translation
				driver.findElement(By.name("q")).sendKeys(searchkey.toString());
				System.out.println("user enter word: "+searchkey);
				driver.findElement(By.xpath("//body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/span[1]/button[3]/i[1]")).click();

				//display the meaning of the word in console
				WebElement e= driver.findElement(By.xpath("/body[1]/div[2]/div[1]/div[1]/div[2]/article[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]"));
				System.out.println( searchkey+" meaning :"+e.getText());
				System.out.println("user got the meaning :"+searchkey);
				
				//Clicking on the audio button to listen the pronunciation of the words
				WebElement speaker=driver.findElement(By.xpath("//span[contains(@class,'uk dpron-i')]//span[@class='daud']//div[@class='i i-volume-up c_aud htc hdib hp hv-1 fon tcu tc-bd lmr-10 lpt-3']"));
				Assert.assertEquals(true, speaker.isDisplayed());
				speaker.click();
				System.out.println("Speaker is working");
				
				//validating title page
				System.out.println(driver.getTitle());
				//assertTrue(driver.getTitle().contains(searchkey.toString()));

				//Translation from English to Spanish
				/*WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
				WebElement webElement =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/header[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/span[2]"))); 
				driver.findElement(By.xpath("//body[1]/header[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/span[2]")).click();
				driver.findElement(By.xpath("//body[1]/header[1]/div[2]/div[1]/form[1]/div[1]/div[2]/span[1]/button[3]/i[1]")).click();

				//display the translation in the console
				WebElement e1= driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/article[1]/div[2]/div[1]/div[2]/div[2]/div[1]/span[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[3]/span[1]"));
				System.out.println( searchkey+" Translation to Spanish :"+e1.getText());
				System.out.println(driver.getTitle());*/
			}
				
				//navigating to home page
				driver.navigate().to("https://dictionary.cambridge.org");
				driver.findElement(By.xpath("//body[1]/header[1]/div[1]/div[2]/ul[1]/li[1]/a[1]")).click();	
				
				//validating facebook icon on the homepage
				WebElement facebookLogo=driver.findElement(By.xpath("//header/div[1]/div[2]/ul[1]/li[1]/a[1]"));
				Assert.assertEquals(true, facebookLogo.isDisplayed());
		        if(true){
		        	System.out.println("Logo is dissplayed-Assert Passed");
		        	driver.findElement(By.xpath("//header/div[1]/div[2]/ul[1]/li[1]/a[1]")).click();
				}

				//window handle -Cambridge Facebook window
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
				//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				//Fetching the url of child window- Cambridge Facebook window
				String strUrl=driver.getCurrentUrl();
				System.out.println("Current URL is: "+strUrl);

				//Fetching the Title of child window- Cambridge Facebook window
				String strTitle=driver.getTitle();
				System.out.println("The title of the page is: "+strTitle);
				driver.close();
		}
}


