package Trans_PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Grammar 
{
	WebDriver driver;
	@FindBy(name="//header/div[1]/div[1]/nav[1]/ul[1]/li[3]/a[1]")
	WebElement GrammarBtn;
	
	@FindBy(name="//a[contains(text(),'Adjectives and adverbs'")
	WebElement AdjAdv;
	
	@FindBy(name="//a[contains(text(),'Easily confused words'")
	WebElement ConfusedWord;
	
	@FindBy(name="//a[contains(text(),'Nouns, pronouns and determiners'")
	WebElement Nouns;
	
	@FindBy(name="//a[contains(text(),'Prepositions and particles'")
	WebElement Preposition;
	
	@FindBy(name="//a[contains(text(),'Using English'")
	WebElement UseEnglish;
	
	@FindBy(name="//a[contains(text(),'Verbs'")
	WebElement Verbs;
	
	@FindBy(name="//a[contains(text(),'Words, sentences and clauses'")
	WebElement Clauses;
	
	public Grammar(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
	
	public void clickGrammarBtn() {
		GrammarBtn.click();
	}
	
	public void getAdjAdv() {
		AdjAdv.getText();
	}
	
	public void getConfusedWords() {
		ConfusedWord.getText();
	}
	
	public void getNoun() {
		Nouns.getText();
	}
	 public void getUseEnglish() {
		 UseEnglish.getText();
	 }
	 
	 public void getVerbs() {
		 Verbs.getText();
	 }
	 
	 public void getClauses() {
		 Clauses.getText();
	 }
	 
	 public void getPreposition() {
		 Preposition.getText();
	 }
	
}
