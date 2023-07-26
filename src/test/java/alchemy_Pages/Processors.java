package alchemy_Pages;

	import java.time.Duration;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.CacheLookup;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
    import Utilities.BaseClass;


	public class Processors  extends BaseClass{
		
	public Processors(WebDriver alcDriver) {
	
		PageFactory.initElements(alcDriver, this);
	}
	@FindBy(xpath ="//div[@class ='loader circle-loader']")
	public WebElement circleLoader;
	@FindBy(xpath="//div[@class='sidebar p-4']/div[contains(text(),'Processors')]")
	public WebElement processors_TAB;
	@FindBy(xpath ="//input[@placeholder='Phone']")
	public WebElement phoneSearch;
	@FindBy(xpath="//span[text()='Edit']") @CacheLookup public WebElement edit;
	@FindBy(xpath ="//input[@name='name']")
	public WebElement editNameField;
	@FindBy(xpath="//div[contains(text(),'Save')]")
	public WebElement save;
	@FindBy(xpath="//div[contains(text(),'Gayas')]")
	public WebElement latestProcessorAdded;


	public void waitforloader() {
		WebDriverWait wait = new WebDriverWait(alcDriver,Duration.ofSeconds(300));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOf(circleLoader)));
	}
	public void SearchAndEditProcessorInAlchemy(String numberToBeEdited) {
		processors_TAB.click();
		waitforloader();
		phoneSearch.clear();
		phoneSearch.sendKeys(numberToBeEdited);
		waitforloader();
		latestProcessorAdded.click();
		edit.click();
		editNameField.clear();
		editNameField.sendKeys("Gayas Processor "+randomLastName);
		save.click();
	}
	}
