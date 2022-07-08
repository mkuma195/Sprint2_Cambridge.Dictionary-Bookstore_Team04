package Dict_PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Facebook 
{
	WebDriver driver;
	@FindBy(xpath="//body[1]/header[1]/div[1]/div[2]/ul[1]/li[1]/a[1]")
	WebElement ClickFacebook;
	
	public Facebook(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
	
	public void validateFacebook() {
		Assert.assertEquals(true, ClickFacebook.isDisplayed());
	}
	
	public void ClickFacebook() {
		ClickFacebook.click();
	}
}
