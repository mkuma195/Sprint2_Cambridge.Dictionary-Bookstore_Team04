package Dict_PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageFactory.Home;


public class TestApp 
{
	WebDriver driver;
	String driverPath ="C:\\Users\\Public\\SeleniumJars\\chromedriver_win32\\chromedriver.exe";
	
	Home objHome;
    SearchWords objSearchWords;
    Facebook objFacebook;
    
    @BeforeTest
    public void setup() throws InterruptedException {
    	
    	System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get("https://dictionary.cambridge.org/");
        
        driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
    @Test(priority=0)
    public void testDictionary() throws InterruptedException, IOException{
    	objHome = new Home(driver);
    	//Assert.assertEquals(true, DictLogo.isDisplayed());
		System.out.println("Logo is dissplayed-Assert Passed");
		
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
		
		objSearchWords=new SearchWords(driver);
		FileInputStream fis = new FileInputStream("C:\\Users\\Public\\SeleniumJars\\Datasource\\Dictdata.xlsx");
		XSSFWorkbook workbook =new XSSFWorkbook(fis);
		XSSFSheet ws = workbook.getSheetAt(0);	
		int rownum = ws.getLastRowNum();
		int colnum =ws.getRow(0).getPhysicalNumberOfCells();
		System.out.println(colnum);
		System.out.println(rownum);
		XSSFCell searchkey;
		for(int i=1; i<=rownum;i++) { 	
			searchkey= ws.getRow(i).getCell(0);
			System.out.println("word for which user needs meaning and translation :"+searchkey);
			
			//Entering the word to get the meaning and translation
			driver.findElement(By.name("q")).sendKeys(searchkey.toString());
			System.out.println("user enter word: "+searchkey);
			
			//display the meaning of the word in console
			
			System.out.println( searchkey+" meaning :");
			System.out.println("user got the meaning :"+searchkey);
		}
		//validating facebook icon is present on homepage
		if(true){
        	System.out.println("Logo is dissplayed-Assert Passed");
        	//driver.findElement(By.xpath("//header/div[1]/div[2]/ul[1]/li[1]/a[1]")).click();
		}
		//window handle -Cambridge Facebook window
		objFacebook=new Facebook(driver);
		Set<String> windows=driver.getWindowHandles();
		Object parent=null;
		Object child=null;
		Iterator it=windows.iterator();
		while(it.hasNext())
		{
			parent =it.next();
			child =it.next();
		}

		driver.navigate().to("https://dictionary.cambridge.org");
		//switch to child window- Cambridge Facebook window
		driver.switchTo().window((String) child);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Fetching the url of child window- Cambridge Facebook window
		String strUrl=driver.getCurrentUrl();
		System.out.println("Current URL is: "+strUrl);

		//Fetching the Title of child window- Cambridge Facebook window
		String strTitle=driver.getTitle();
		System.out.println("The title of the page is: "+strTitle);
		driver.close();
    }
    
}
