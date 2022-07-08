package Dict_PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchWords 
{
	WebDriver driver;
	@FindBy(xpath="//body[1]/div[3]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]")
	WebElement CrossBtn;
	
	@FindBy(name="q")
	WebElement Searchbox;
	
	@FindBy(xpath="//body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/span[1]/button[3]/i[1]")
	WebElement Searchbtn;
	
	@FindBy(xpath="/body[1]/div[2]/div[1]/div[1]/div[2]/article[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]")
	WebElement getMeaning;
	
	@FindBy(xpath="//span[contains(@class,'uk dpron-i')]//span[@class='daud']//div[@class='i i-volume-up c_aud htc hdib hp hv-1 fon tcu tc-bd lmr-10 lpt-3']")
	WebElement ClickSpeaker;
	
	public SearchWords(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
	
	public void ClickCrossBtn(){
		CrossBtn.click();
	}
	public void SearchWords() {
		Searchbox.sendKeys("searchkey");
	}
	public void ClickSearchBtn() {
		Searchbtn.click();
	}
	public void getWordMeaning(){
		getMeaning.getText();
	}
	public void clickSpeakerBtn() {
		ClickSpeaker.click();
	}
}
