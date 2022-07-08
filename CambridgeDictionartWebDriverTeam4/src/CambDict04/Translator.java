package CambDict04;

import java.io.IOException;

public class Translator 
{
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Public\\SeleniumJars\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	String baseUrl = "https://dictionary.cambridge.org/";
	driver.get(baseUrl);
	
	driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
	driver.manage().window().maximize();
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//span[contains(text(),'Translate')]")).click();
	
    FileInputStream fis = new FileInputStream("C:\\Users\\Public\\SeleniumJars\\Datasource\\language.xlsx");
	XSSFWorkbook workbook =new XSSFWorkbook(fis);
	XSSFSheet ws = workbook.getSheetAt(0);	
	int rownum = ws.getLastRowNum();
	int colnum =ws.getRow(0).getPhysicalNumberOfCells();
	System.out.println(rownum);
	System.out.println(colnum);
	XSSFCell searchkey = null;
	
	//iterations to get meaning and translation
	for(int i=1; i<=rownum;i++) { 	
		//driver.navigate().to("url");
		Select drplan = new Select(driver.findElement(By.xpath("//body/div[2]/div[1]/div[2]/div[4]/form[1]/div[1]/div[1]/div[1]")));
		for(int j=1; j<=colnum;j++) { 
	    drplan.selectByVisibleText("english");
	    drplan.selectByVisibleText("Japanese");
	    drplan.selectByVisibleText("searchkey");
	    
	    driver.findElement(By.xpath("//button[@id='button-submit']")).click();
	    WebElement Translate=driver.findElement(By.xpath("//body/div[2]/div[1]/div[2]/div[4]/form[1]/div[3]/div[2]/div[1]"));
	    System.out.println("Translation of the "+ searchkey +"is"+Translate.getText());
	
	  //Display Grammar Page
	    driver.findElement(By.name("//header/div[1]/div[1]/nav[1]/ul[1]/li[3]/a[1]")).click();
	    
	    //Display Description Of the Adjectives and adverb
	    driver.findElement(By.xpath("Adjectives and adverbs")).click();
	    //driver.findElement(By.xpath("//header/div[1]/div[1]/nav[1]/ul[1]/li[3]/a[1]\")).sendKeys("/a[contains(text(),'Adjectives and adverbs']"));
	    System.out.println("The Description of Adjectives and adverbs is- "+driver.findElement(By.xpath("//*[@id=\"page-content\"]/div[2]/span/p[2]")).getText());
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.navigate().back();
	    
	    //Display Description Of the Easily confused words
	    driver.findElement(By.xpath("/a[contains(text(),'Easily confused words']")).click();
	    driver.findElement(By.xpath("//header/div[1]/div[1]/nav[1]/ul[1]/li[3]/a[1]")).sendKeys("/a[contains(text(),'Easily confused words']");
	    System.out.println("The Description of Easily confused words is- "+driver.findElement(By.xpath("/*[@id=\"page-content\"]/div[2]/span/p[1]")).getText());
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.navigate().back();
	    
	    //Display Description Of the Nouns, pronouns and determiners
	    driver.findElement(By.xpath("/a[contains(text(),'Nouns, pronouns and determiners'")).click();
	    driver.findElement(By.xpath("//header/div[1]/div[1]/nav[1]/ul[1]/li[3]/a[1]")).sendKeys("/a[contains(text(),'Nouns, pronouns and determiners'");
	    System.out.println("The Description of Nouns, pronouns and determiners is- "+driver.findElement(By.xpath("//*[@id=\"page-content\"]/div[2]/span/p[2]")).getText());
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.navigate().back();
	    
	   //Display Description Of the Prepositions and particles
	    driver.findElement(By.xpath("/a[contains(text(),'Prepositions and particles")).click();
	    driver.findElement(By.xpath("//header/div[1]/div[1]/nav[1]/ul[1]/li[3]/a[1]")).sendKeys("/a[contains(text(),'Prepositions and particles");
	    System.out.println("The Description of Prepositions and particles is- "+driver.findElement(By.xpath("/*[@id=\"page-content\"]/div[2]/span/p[1]")).getText());
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.navigate().back();
	    
	    //Display Description Of the Using English
	    driver.findElement(By.name(document.selectSingleNode("/a[contains(text(),'Using English'").getText())).click();
	    driver.findElement(By.xpath("//header/div[1]/div[1]/nav[1]/ul[1]/li[3]/a[1]")).sendKeys("/a[contains(text(),'Using English'");
	    System.out.println("The Description of Using English is- "+driver.findElement(By.xpath("/*[@id=\"page-content\"]/div[2]/span/p[1]")).getText());
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.navigate().back();
	    
	  //Display Description Of the Verbs
	    driver.findElement(By.xpath(document.selectSingleNode("/a[contains(text(),'Verbs'").getText())).click();
	    driver.findElement(By.xpath("//header/div[1]/div[1]/nav[1]/ul[1]/li[3]/a[1]")).sendKeys("/a[contains(text(),'Verbs'");
	    System.out.println("The Description of Verbs is- "+driver.findElement(By.xpath("/*[@id=\"page-content\"]/div[2]/span/p[1]")).getText());
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.navigate().back();
	    
	  //Display Description Of the Words, sentences and clauses
	    driver.findElement(By.xpath("/a[contains(text(),'Words, sentences and clauses'")).click();
	    driver.findElement(By.xpath("//header/div[1]/div[1]/nav[1]/ul[1]/li[3]/a[1]")).sendKeys("/a[contains(text(),'Words, sentences and clauses'");
	    System.out.println("The Description of Words, sentences and clauses is- "+driver.findElement(By.xpath("/*[@id=\"page-content\]div[2]/span/p[1]")).getText());
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.navigate().back();

	    driver.close();
	}
    
    
	}}
}