package Trans_PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Translator 
{
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"onetrust-accept-btn-handler\"]")
	WebElement handlePopup;
	
	@FindBy(xpath="//span[contains(text(),'Translate')]")
	WebElement Translate;
	
	@FindBy(xpath="//body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/span[1]/button[2]/span[1]")
	WebElement dropDownBtn;
	
	@FindBy(xpath="//body/div[2]/div[1]/div[2]/div[4]/form[1]/div[1]/div[1]/div[1]")
	WebElement drpDown;
	
	@FindBy(xpath="//body/div[2]/div[1]/div[2]/div[4]/form[1]/div[3]/div[1]/div[1]/span[1]")
	WebElement English;
	
	@FindBy(id="//button[@id='button-submit")
	WebElement EnterWord;
	
	@FindBy(id="button-submit")
	WebElement SubmitBtn;
	
	public Translator(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
	
	public void hanlingPopup() {
		handlePopup.click();
	}
	
	public void TranslateWord(){
		Translate.click();
	}
	
	public void clickDropDown() {
		dropDownBtn.click();
	}
	
	public void selectLanguage() {
		drpDown.click();
	}
	public void selectEnglish() {
		English.click();
	}
	 public void enterWord() {
		 EnterWord.sendKeys("searchkey");
	 }
	 
	 public void clickSubmitBtn() {
		 SubmitBtn.click();
	 }
	
}

