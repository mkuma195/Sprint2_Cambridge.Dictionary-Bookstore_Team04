package CambDict04;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TranslatorXML 
{
	public static void main(String[] args) throws InterruptedException, DocumentException, IOException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Public\\SeleniumJars\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		File src = new File("./CambridgeDictionartWebDriverTeam4/TestResource/Translator.xml");
		FileInputStream fis = new FileInputStream(src);
		SAXReader saxReader =new SAXReader();
		org.dom4j.Document document = saxReader.read(fis);
		
		String baseUrl = "https://dictionary.cambridge.org/";
		driver.get(baseUrl);
		driver.findElement(By.xpath(document.selectSingleNode("//*[@id=\"onetrust-accept-btn-handler\"]").getText())).click();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		 String Title=driver.getTitle();
	     System.out.println("The title of the page is "+Title);
	     String url=driver.getCurrentUrl();
	     System.out.println("The URL of the page is "+url);
	     
	     driver.findElement(By.xpath(document.selectSingleNode("Translate").getText())).click();
	 	
	     FileInputStream fis1 = new FileInputStream("C:\\Users\\Public\\SeleniumJars\\Datasource\\language.xlsx");
	 	XSSFWorkbook workbook =new XSSFWorkbook(fis1);
	 	XSSFSheet ws = workbook.getSheetAt(0);	
	 	int rownum = ws.getLastRowNum();
	 	int colnum =ws.getRow(0).getPhysicalNumberOfCells();
	 	System.out.println(rownum);
	 	System.out.println(colnum);
	 	XSSFCell searchkey = null;
	 	
	 	//iterations to get meaning and translation
	 	for(int i=1; i<=rownum;i++) { 	
	 		//driver.navigate().to("url");
	 		Select drplan = new Select(driver.findElement(By.xpath(document.selectSingleNode("Auto-detect").getText())));
	 		for(int j=1; j<=colnum;j++) { 
	 	    drplan.selectByVisibleText("english");
	 	    drplan.selectByVisibleText("Japanese");
	 	    drplan.selectByVisibleText("searchkey");
	 	    
	 	    driver.findElement(By.xpath(document.selectSingleNode("Enter_text_here").getText())).click();
	 	    WebElement Translate=driver.findElement(By.xpath(document.selectSingleNode("Translator").getText()));
	 	    System.out.println("Translation of the "+ searchkey +"is"+Translate.getText());
	  
	        //Display Grammar Page
	        driver.findElement(By.name(document.selectSingleNode("Grammar").getText())).click();
	        
	        //Display Description Of the Adjectives and adverb
	        driver.findElement(By.name(document.selectSingleNode("Adjectives and adverbs").getText())).click();
	        driver.findElement(By.name("Grammar")).sendKeys("Adjectives and adverbs");
	        System.out.println("The Description of Adjectives and adverbs is- "+driver.findElement(By.xpath("//*[@id=\"page-content\"]/div[2]/span/p[2]")).getText());
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        driver.navigate().back();
	        
	        //Display Description Of the Easily confused words
	        driver.findElement(By.name(document.selectSingleNode("Easily confused words").getText())).click();
	        driver.findElement(By.name("Grammar")).sendKeys("Easily confused words");
	        System.out.println("The Description of Easily confused words is- "+driver.findElement(By.xpath("content")).getText());
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        driver.navigate().back();
	        
	        //Display Description Of the Nouns, pronouns and determiners
	        driver.findElement(By.name(document.selectSingleNode("Nouns, pronouns and determiners").getText())).click();
	        driver.findElement(By.name("Grammar")).sendKeys("Nouns, pronouns and determiners");
	        System.out.println("The Description of Nouns, pronouns and determiners is- "+driver.findElement(By.xpath("content")).getText());
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        driver.navigate().back();
	        
	       //Display Description Of the Prepositions and particles
	        driver.findElement(By.name(document.selectSingleNode("Prepositions and particles").getText())).click();
	        driver.findElement(By.name("Grammar")).sendKeys("Prepositions and particles");
	        System.out.println("The Description of Prepositions and particles is- "+driver.findElement(By.xpath("content")).getText());
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        driver.navigate().back();
	        
	      //Display Description Of the Using English
	        driver.findElement(By.name(document.selectSingleNode("Using English").getText())).click();
	        driver.findElement(By.name("Grammar")).sendKeys("Using English");
	        System.out.println("The Description of Using English is- "+driver.findElement(By.xpath("content")).getText());
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        driver.navigate().back();
	        
	      //Display Description Of the Verbs
	        driver.findElement(By.name(document.selectSingleNode("Verbs").getText())).click();
	        driver.findElement(By.name("Grammar")).sendKeys("Verbs");
	        System.out.println("The Description of Verbs is- "+driver.findElement(By.xpath("content")).getText());
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        driver.navigate().back();
	        
	      //Display Description Of the Words, sentences and clauses
	        driver.findElement(By.name(document.selectSingleNode("Words, sentences and clauses").getText())).click();
	        driver.findElement(By.name("Grammar")).sendKeys("Words, sentences and clauses");
	        System.out.println("The Description of Words, sentences and clauses is- "+driver.findElement(By.xpath("content")).getText());
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        driver.navigate().back();

	        driver.close();
		}

       }
	}
}
