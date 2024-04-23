package alchemy_Pages;

	import static org.testng.Assert.assertEquals;

import java.io.ByteArrayInputStream;
	import java.io.File;
	import java.time.Duration;
import java.util.List;
	import java.util.concurrent.TimeUnit;

	import static org.testng.Assert.assertTrue;
	import Utilities.Data;
	import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
    import Utilities.BaseClass;
import io.qameta.allure.Allure;
	import org.testng.Assert;


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
	@FindBy(xpath="//span[text()='Edit']") 
	@CacheLookup public WebElement edit;
	@FindBy(xpath ="//input[@name='name']")
	public WebElement editNameField;
	@FindBy(xpath="//div[contains(text(),'Save')]")
	public WebElement save;
	@FindBy(xpath="//div[contains(text(),'Gayas')]")
	public WebElement latestProcessorAdded;
	@FindBy(xpath = "//div[@class='container-fluid']//datatable//table/tbody/tr[1]/td[1]/div/div")
	private WebElement tableData_FirstRow;
	@FindBy(xpath = "//a[text()='Exchange History']")
	private WebElement exchangeHistory;
	@FindBy(xpath = "//div[@class='card-header']/div/button")
	List<WebElement> transactions;//div[@class='card-header']
	
	@FindBy(xpath = "//div[@class='text-natural-green']")
	WebElement branchBonusTextInAlchmeyVerify;
	
	@FindBy(xpath = "//*[text()='Plastik-HDPE-Clean-Clear']/parent::div/div[2]")
	WebElement hdpeKgAlcText;
	@FindBy(xpath = "//*[text()='Plastik-PET-Raw-Transparent']/parent::div/div[2]")
	WebElement petKgAlcText;
	@FindBy(xpath = "//div[text()='TOTAL']/following-sibling::div")
	WebElement totalKgAlcText;
	@FindBy(xpath = "//div[@class='disable-btn approve-true-state']")
	WebElement approveButton;

	@FindBy(xpath = "//div[@class='card-header']/div/div[1]/button")
	List<WebElement> approvedConfirm;

	@FindBy(xpath = "//li[contains(@class,'page-item')]")
	WebElement lastItemOnPage;
		@FindBy(xpath = "//a[text()='Exchange History']")
		private WebElement exchangeHistoryTab;

		@FindBy(xpath = "//div[@class='card-header']")
		List<WebElement> cardheaders;

		@FindBy(xpath = "//label[text()='Branch Bonus']/following-sibling::div/div[contains(@class,'text')]")
		List<WebElement> branchbonustext;

	@FindBy(xpath = "//span[text()='Export']")
	public static WebElement exportButton;


	public static String downloadPath = "C:/Users/Fleek/Downloads";

		WebDriverWait wait = new WebDriverWait(pbDriver,Duration.ofSeconds(40));
	public void waitforloader() {
		WebDriverWait wait = new WebDriverWait(alcDriver,Duration.ofSeconds(300));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOf(circleLoader)));
	}
	

public void clickSpecificProcessor() throws InterruptedException {
	Thread.sleep(15000);
	tableData_FirstRow.click();
	
}
public void clickExchangeHistoryButton() {
	exchangeHistory.click();
}
	public void SearchAndEditProcessorInAlchemy(String numberToBeEdited) throws InterruptedException {
		processors_TAB.click();
		waitforloader();
		phoneSearch.clear();
		phoneSearch.sendKeys(numberToBeEdited);
		waitforloader();
		latestProcessorAdded.click();
		edit.click();
		editNameField.clear();
		editNameField.sendKeys("Gayas Processor "+randomLastName);
		Thread.sleep(2000);
	    TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
	    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
	    Thread.sleep(2000);
		save.click();
	}
	
	public void transactionApproveExcHisP1(String pNum) throws InterruptedException {
		processors_TAB.click();
		Thread.sleep(2000);
		waitforloader();
		phoneSearch.clear();
		phoneSearch.sendKeys(pNum);
		clickSpecificProcessor();
		clickExchangeHistoryButton();
		Thread.sleep(2000);
		for (int p=0; p<=1; p++) {		
			transactions.get(p).click();
			Thread.sleep(1000);
		
			String actualAlcBonus= branchBonusTextInAlchmeyVerify.getText();
			String actualAlcKgList[] = {hdpeKgAlcText.getText(),petKgAlcText.getText(),totalKgAlcText.getText()};
			
		
		
		if(p==0) { 
			assertEquals(alc_P_ExngHisBonusVerify[0],actualAlcBonus );
			assertEquals(alc_B3_P_ExngHisKgVerify,actualAlcKgList);
		}
		else if(p==1) {
			assertEquals(alc_P_ExngHisBonusVerify[1],actualAlcBonus );
			assertEquals(alc_B2_P_ExngHisKgVerify,actualAlcKgList);
		}
		transactions.get(p).click();
		Thread.sleep(3000);
		}	
		
		for(int i=0;i<approvedConfirm.size();i++) {
			
			String ac=approvedConfirm.get(i).getText();
			assertEquals(ac, "Approved");	
		}
		  Thread.sleep(2000);
		  Actions actions1 =new Actions(alcDriver);
			actions1.scrollToElement(lastItemOnPage).build().perform();
			Thread.sleep(2000);
		    TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
		    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
		    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
		    Thread.sleep(2000);
	}
		public void processordelayedbonusverify() throws InterruptedException {
			alcDriver.get("https://"+actual+"/#/admin/recyclingcenter/"+ Data.pid4360);
			exchangeHistoryTab.click();
			cardheaders.get(0).click();
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.textToBePresentInElement(branchbonustext.get(0), "14")));
			assertTrue(branchbonustext.get(0).getText().equals("14"));
			Thread.sleep(2000);
			TakesScreenshot ts112 = (TakesScreenshot) alcDriver;
			byte[] screenshot112 = ts112.getScreenshotAs(OutputType.BYTES);
			Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot112));
			Thread.sleep(2000);
			System.out.println("pass 5");
		}

	public void reportDownload(String fileName) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));

		wait.until(ExpectedConditions.elementToBeClickable(processors_TAB));
		processors_TAB.click();

		wait.until(ExpectedConditions.elementToBeClickable(tableData_FirstRow));
		tableData_FirstRow.click();
		Thread.sleep(4000);

		wait.until(ExpectedConditions.elementToBeClickable(exchangeHistoryTab));
		exchangeHistoryTab.click();

		Thread.sleep(7000);

		exportButton.click();

		Thread.sleep(3000);

		while (true) {
			String downloadPath1 = "C:\\Users\\Fleek\\Downloads";
			File directory1 = new File(downloadPath1);
			File[] files1 = directory1.listFiles((dir, name) -> name.contains(fileName));

			if (files1 != null && files1.length > 0) {

				Assert.assertTrue(1>0);
				System.out.println("File is been Downloaded");
				// Open the first file that matches the criteria
				// openFile(files1[0]);
				//isNamePresent(files1[0],searchName);
				break; // Exit the loop once a file is found and opened
			}

			try {
				TimeUnit.SECONDS.sleep(1); // Wait for 1 second before checking again
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		File directory = new File(downloadPath);

		// List all files in the directory
		File[] files = directory.listFiles();

		if (files != null) {
			for (File file : files) {
				// Check if the file name contains the specified string
				if (file.getName().contains(fileName)) {
					// Delete the file
					boolean isDeleted = file.delete();
					if (isDeleted) {
						System.out.println("File deleted: " + file.getName());
					} else {
						System.out.println("Failed to delete file: " + file.getName());
					}
				}
			}
		} else {
			System.out.println("No files found in the directory.");
		}

	}

}
