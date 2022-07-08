package Dict_PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Home 
{
	WebDriver driver;
	@FindBy(xpath="//body/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/amp-img[1]/img[1]")
	WebElement DictLogo;
	@FindBy(xpath="//p[@class='fs12 tcu lmb-0']")
	WebElement WordoftheDay;
	@FindBy(xpath="//div[contains(@class='def ddef_d db')]")
	WebElement word;
	@FindBy(xpath="//span[contains(@class,'uk dpron-i')]//span[@class='daud']//div[@class='i i-volume-up c_aud htc hdib hp hv-1 fon tcu tc-bd lmr-10 lpt-3']")
	WebElement speaker;
	
	public Home(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
	public void validateLogo() {
		Assert.assertEquals(true, DictLogo.isDisplayed());
    }
	public void validateWordofDay() {
		Assert.assertEquals(true, WordoftheDay.isDisplayed());
    }
	
	public void ClickWordofTheDay() {
		WordoftheDay.click();
	}
	public void getMeaning() {
		word.getText();
	}
	public void validateSpeaker() {
		Assert.assertEquals(true, speaker.isDisplayed());
	}
	public void clickSpeaker() {
		speaker.click();
	}
}
