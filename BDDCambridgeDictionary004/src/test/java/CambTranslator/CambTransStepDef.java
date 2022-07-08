package CambTranslator;

import java.io.FileInputStream;
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

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CambTransStepDef 
{
	private static final String searchkey = null;
	WebDriver driver;
	
	@Given("^User is on cambridge home page$")
	public void User_navigates_homepage() 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Public\\SeleniumJars\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
        String baseUrl = "https://dictionary.cambridge.org";
        driver.get(baseUrl);
       
     }
	
     @When("^User clicks on translate icon$")
		 public void Translator_page()
		 { 
    	 driver.findElement(By.xpath("//span[contains(text(),'Translate')]")).click();
    		
		 }
		 @And("^User enters a sentence in English  to translate$")
		 public void write_enlish_sentence() throws IOException
		
		 {

			    FileInputStream fis = new FileInputStream("C:\\Users\\Public\\SeleniumJars\\Datasource\\language.xlsx");
				XSSFWorkbook workbook =new XSSFWorkbook(fis);
				XSSFSheet ws = workbook.getSheetAt(0);	
				int rownum = ws.getLastRowNum();
				int colnum =ws.getRow(0).getPhysicalNumberOfCells();
				System.out.println(rownum);
				System.out.println(colnum);
				XSSFCell searchkey ;
				
		 }
		 
	@Then("^The sentence is tranlated in the desired language$")
	public void Translation_display_successfully() {
		int rownum = 0;
		for(int i=1; i<=rownum;i++) { 	
			//driver.navigate().to("url");
			Select drplan = new Select(driver.findElement(By.xpath("//body/div[2]/div[1]/div[2]/div[4]/form[1]/div[1]/div[1]/div[1]")));
			int colnum = 0;
			for(int j=1; j<=colnum;j++) { 
		    drplan.selectByVisibleText("english");
		    drplan.selectByVisibleText("Japanese");
		    drplan.selectByVisibleText("searchkey");
		    
		    driver.findElement(By.xpath("//button[@id='button-submit']")).click();
		    WebElement Translate=driver.findElement(By.xpath("//body/div[2]/div[1]/div[2]/div[4]/form[1]/div[3]/div[2]/div[1]"));
		    System.out.println("Translation of the "+ searchkey +"is"+Translate.getText());
			
			}
	}
	}
	@When("^user clicks on Adjective and adverb$")
	 public void Grammer_page()
	 {
		 Object document;
		driver.findElement(By.name("Grammar")).click();
		driver.findElement(By.name("Adjectives and adverbs")).click();   
	 }
	 
	 @Then("^user gets the description about Adjective and adverb from of word$")
	 public void Adjectives_and_adverbsr_page() throws InterruptedException
	 {
		 driver.findElement(By.name("Grammar")).sendKeys("Adjectives and adverbs");
	     System.out.println("The Description of Adjectives and adverbs is- "+driver.findElement(By.xpath("//*[@id=\"page-content\"]/div[2]/span/p[2]")).getText());
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	      driver.navigate().back();
	 }
	 
	 @When("^user clicks on Easily confused words$")
	 public void user_navigate_back_to_Gram_page() throws InterruptedException
	 {
		 driver.findElement(By.name("Easily confused words")).click();
       
	 }
	 
	@Then("user gets the description about Easily confused words from of word")
	public void Easily_confused_words_page_inside() 
	{
		 
	     driver.findElement(By.name("Grammar")).sendKeys("Easily confused words");
	     System.out.println("The Description of Easily confused words is- "+driver.findElement(By.xpath("content")).getText());
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	     driver.navigate().back();
	}
	 @When("^user clicks on Noun,pronouns and determiners$")
	 public void user_navigate_back_to_Gram_page_from_Easily_confused_words() 
	 {
		 driver.findElement(By.name("Nouns, pronouns and determiners")).click();
	  }
	
	
	 @Then("^user gets the description about Noun,pronouns and determiners from of word$")
		public void Nouns_pronouns_page_inside() 
		{
	     driver.findElement(By.name("Grammar")).sendKeys("Nouns, pronouns and determiners");
	     System.out.println("The Description of Nouns, pronouns and determiners is- "+driver.findElement(By.xpath("content")).getText());
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));    
	     driver.navigate().back();
		
		}
	 
	 @When("^user clicks on Prepositions and particles$")
	 public void user_navigate_back_to_Gram_page_from_Nouns_pronouns_page() 
	 {
		 driver.findElement(By.name("Prepositions and particles")).click(); 
	 }
	 
	
	 @Then("^user gets the description about Prepositions and particles from of word$")
		public void Prepositions_and_particles_page_inside() 
		{
		driver.findElement(By.name("Grammar")).sendKeys("Prepositions and particles");
	     System.out.println("The Description of Prepositions and particles is- "+driver.findElement(By.xpath("content")).getText());
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
	     driver.navigate().back();
		}
	
	 @When("^user clicks on Using English$")
	 public void user_navigate_back_to_Gram_page_from_Prepositions_and_particles() 
	 {
		 driver.findElement(By.name("Using English")).click();
	 }
	
	 @Then("^user gets the description about Using English from of word$")
	  public void Using_English_page_inside() 
		{
		driver.findElement(By.name("Grammar")).sendKeys("Using English");
	    System.out.println("The Description of Using English is- "+driver.findElement(By.xpath("content")).getText());
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.navigate().back();
		}
	 
	
	 @When("^user clicks on Verbs$")
	 public void user_navigate_back_to_Gram_page_from_Using_English_page() 
	 {
		 driver.findElement(By.name("Verbs")).click();
	 }
	
	 @Then("^user gets the description about Verbs from of word$")
	 
	 public void Using_Verbs_page_inside() 
		{
	    driver.findElement(By.name("Grammar")).sendKeys("Verbs");
	     System.out.println("The Description of Verbs is- "+driver.findElement(By.xpath("content")).getText());
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));   
	     driver.navigate().back();
		}
	 
	 @When("^user clicks on Words,sentences and clauses$")
	 public void user_navigate_back_to_Gram_page_from_Verbs_page() 
	 {
		 driver.findElement(By.name("Words, sentences and clauses")).click();
	 }
    
	 
	 @Then("^user gets the description about Words,sentences and clauses from of word$")
	  public void Words_sentences_clauses_page_inside() 
		{
   	driver.findElement(By.name("Grammar")).sendKeys("Words, sentences and clauses");
	     System.out.println("The Description of Words, sentences and clauses is- "+driver.findElement(By.xpath("content")).getText());
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));  
	    }
}


