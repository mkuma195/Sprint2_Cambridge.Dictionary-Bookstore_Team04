package Trans_PageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import Dict_PageFactory.Grammar;
//import Dict_PageFactory.Translator;

public class TestApp2 
{
	String driverPath = "C:\\Users\\Public\\SeleniumJars\\chromedriver_win32\\chromedriver.exe";
    WebDriver driver;
    
    Translator objTranslator;
    Grammar objGrammar;
    
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
    public void testApp2() throws IOException {
    	objTranslator=new Translator(driver);
    	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    	FileInputStream fis1 = new FileInputStream("\"C:\\Users\\Harisankar Panda\\Desktop\\language.xlsx\"");
	 	XSSFWorkbook workbook =new XSSFWorkbook(fis1);
	 	XSSFSheet ws = workbook.getSheetAt(0);	
	 	int rownum = ws.getLastRowNum();
	 	int colnum =ws.getRow(0).getPhysicalNumberOfCells();
	 	System.out.println(rownum);
	 	System.out.println(colnum);
	 	XSSFCell searchkey = null;
	 	
	 	//iterations to get meaning and translation
	 	for(int i=1; i<=rownum;i++) {
	 		Select drplan = null;
	 		for(int j=1; j<=colnum;j++) { 
		 	    drplan.selectByVisibleText("english");
		 	    drplan.selectByVisibleText("Japanese");
		 	    drplan.selectByVisibleText("searchkey");
		 	    WebElement Translate = null;
		 	    System.out.println("Translation of the "+ searchkey +"is"+Translate.getText());
		 	}
	 	}
    	objGrammar=new Grammar(driver);
        //Display Description Of the Adjectives and adverb
        System.out.println("The Description of Adjectives and adverbs is- "+driver.findElement(By.xpath("//*[@id=\"page-content\"]/div[2]/span/p[2]")).getText());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.navigate().back();
        
        //Display Description Of the Easily confused words
        System.out.println("The Description of Easily confused words is- "+driver.findElement(By.xpath("//*[@id=\\\"page-content\\\"]/div[2]/span/p[1]")).getText());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.navigate().back();
        //Display Description Of the Nouns, pronouns and determiners
        System.out.println("The Description of Nouns, pronouns and determiners is- "+driver.findElement(By.xpath("//*[@id=\\\"page-content\\\"]/div[2]/span/p[1]")).getText());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.navigate().back();
        
        //Display Description Of the Prepositions and particles
        System.out.println("The Description of Prepositions and particles is- "+driver.findElement(By.xpath("//*[@id=\\\"page-content\\\"]/div[2]/span/p[1]")).getText());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.navigate().back();
        //Display Description Of the Using English
        System.out.println("The Description of Using English is- "+driver.findElement(By.xpath("//*[@id=\\\"page-content\\\"]/div[2]/span/p[1]")).getText());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.navigate().back();
        
      //Display Description Of the Verbs
        System.out.println("The Description of Verbs is- "+driver.findElement(By.xpath("//*[@id=\\\"page-content\\\"]/div[2]/span/p[1]")).getText());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.navigate().back();
        
      //Display Description Of the Words, sentences and clauses
        System.out.println("The Description of Words, sentences and clauses is- "+driver.findElement(By.xpath("//*[@id=\\\"page-content\\\"]/div[2]/span/p[1]")).getText());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.navigate().back();

        driver.close();
    }


}

