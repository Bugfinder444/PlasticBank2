package alchemy_Pages;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Utilities.BaseClass;
import Utilities.Data;
import io.qameta.allure.Allure;

import static org.testng.Assert.*;


public class Branches extends BaseClass {

public Branches(WebDriver alcDriver) {
		
		PageFactory.initElements(alcDriver, this);
		}
@FindBy(xpath = "//div[@class='container-fluid']/div[2]")
private WebElement addNewBranch_btn;

@FindBy(xpath="//div[@class='body']/div/div/div[text()=' Branches ']")
private WebElement branches_TAB;

@FindBy(xpath = "//div[@class='tag-search']/label[text()='INCLUDE TAGS']/parent::div/div/div/input")
private WebElement searchInclude_tag;

@FindBy(xpath = "//datatable//input[@placeholder='Name']")
private WebElement name_SearchBox;

@FindBy(xpath = "//datatable//input[@placeholder='Phone']")
private WebElement phone_SearchBox;

@FindBy(xpath = "//div[@class='container-fluid']//datatable//table/tbody/tr[1]/td[1]/div/div")
private WebElement tableData_FirstRow;

@FindBy(xpath = "//div[@role='tabpanel']/div[2]/div/span")
private WebElement edit_Branch;

@FindBy(xpath = "//input[@name='city']")
private WebElement edit_city;

@FindBy(xpath = "//div[contains(@class, 'pb-button') and text()= 'Save ']")
private WebElement save_btn;

@FindBy(xpath ="//div[contains(@class, 'pb-button') and text()= 'Cancel']")
private WebElement cancel_btn;

@FindBy(xpath ="//ul[@role='tablist']/li[3]/a")
private WebElement invantory_tabBranch;

@FindBy(xpath = "//div[@role='tabpanel']//table/tbody/tr")
private WebElement totalRowsInventory_tabel;

@FindBy(xpath = "//div[@role='tabpanel']//table/tbody/tr/td[2]//div/mdl-checkbox/span[2]")
private WebElement invertoryView_checkBox;

@FindBy(xpath = "//*[text()=' Suspend Account ']")
private WebElement suspendAccount_checkbox;

@FindBy(xpath = "//div[@role='document']/div")
private WebElement popUp_alert;

@FindBy(xpath="//div[@class='partner-info name']")
@CacheLookup private WebElement verifyNameText;

@FindBy(xpath="//input[@name='name']")
@CacheLookup private WebElement editNameTextFeild;


@FindBy(xpath = "//div/button[text()='OK']")
private WebElement okBtn_alertBox;

@FindBy(xpath = "//a[text()='Exchange History']")
private WebElement exchangeHistory;

@FindBy(xpath = "//a[text()='Exchange History']")
private WebElement exchangeHistoryTab;
@FindBy(xpath = "//div[text()='Exchange History ']")
private WebElement exchangeHistoryTabInBonusOrder;

@FindBy(xpath = "//div[text()='KG Recycled']/following::div[5]")
public WebElement kgRecycledInBranchText;
@FindBy(xpath = "//div[text()='KG Recycled']")
private WebElement kgRecycledInBranch;


@FindBy(xpath = "//loader/div//table") 
WebElement pageLoader;
@FindBy(xpath = "//label[text()='Tokens Active']/parent::div/div")
WebElement tokensActive;
@FindBy(xpath = "//label[text()='Split Mode']/parent::div/div")
WebElement splitModeToggle;
@FindBy(xpath = "//label[text()='Upload Buy Receipts']/parent::div/div")
WebElement uploadBuyReceiptsToggle;
@FindBy(xpath = "//label[text()='Show Token/Market Rate']/parent::div/div")
WebElement tokenMarketToggle;

@FindBy(xpath = "//label[text()='Show Token/Market Rate']/parent::div/div")
WebElement fraudToggle;
@FindBy(xpath = "//label[text()='Show Token/Market Rate']/parent::div/div")
WebElement errorsToggle;
@FindBy(xpath = "//label[text()='Show Token/Market Rate']/parent::div/div")
WebElement bonusToggle;
@FindBy(xpath = "//div[@class='disable-btn approve-true-state']")
WebElement approveButton;

@FindBy(xpath = "//*[text()='Plastik-HDPE-Clean-Clear']/parent::div/div[2]")
WebElement hdpeKgAlcText;
@FindBy(xpath = "//*[text()='Plastik-PET-Raw-Transparent']/parent::div/div[2]")
WebElement petKgAlcText;
@FindBy(xpath = "//div[text()='TOTAL']/following-sibling::div")
WebElement totalKgAlcText;

@FindBy(xpath = "//div[@class='card-header']/div/button")
List<WebElement> transactions;

@FindBy(xpath = "//span[text()='Plastic Chain']")
WebElement plasticChain;
@FindBy(xpath = "//div[@class='card-body']//div/span[1]/span[1]")
List<WebElement> hdpePetPlasticChain;
@FindBy(xpath = "//div[@class='card-body']//div/span[1]/span[1]")
List<WebElement> branchProcessorTransactionPlasticChain;
@FindBy(xpath = "//i[@class='fa fa-arrow-right pointer fs15 text-green']")
List<WebElement> greenArrow;
@FindBy(xpath = "//i[@class='fa fa-arrow-right pointer fs15 text-orange']")
List<WebElement> orangeArrow;

@FindBy(xpath = "//div[@class='card-header']/div/div/div[contains(@class, 'row')]/div/div[1]")
List<WebElement> noFraudNoErrorsToggle;

@FindBy(xpath = "//div[@class='text-natural-green']")
WebElement branchBonusTextInAlchmeyVerify; ///////

@FindBy(xpath = "//span[text()='(transferred)']")
WebElement transferedTextDisplay;

@FindBy(xpath = "//div[@class='card-header']/div/div/button[text()='Approved']")
List<WebElement> approvedConfirm;

@FindBy(xpath = "//div[contains(@class,'col pl')]/div")
List<WebElement> branchDetailsTagTexts;

@FindBy(xpath = "//*[text()='Branch Bonus']/following::div[2]")
WebElement bonusInExchangeHistorytext;

@FindBy(xpath = "//*[text()='Branch Bonus']")
WebElement bonusInBranchExchangeHistory;


@FindBy(xpath = "//label[text()='Branch Bonus']/following-sibling::div/div[contains(@class,'text')]")
List<WebElement> branchbonustext;
@FindBy(xpath = "//label[text()='Member Bonus']/following-sibling::div/div[contains(@class,'text')]")
WebElement memberbonustext;
@FindBy(xpath = "//a[text()='Details']")
WebElement details;
@FindBy(xpath = "//label[text()='Branch Bonus']/following-sibling::div/div[contains(@class,'text')]")
WebElement branchBonustext;
	@FindBy(xpath = "//label[text()='ASSOCIATED BONUS']/following::label/following::label/following-sibling::div/div[contains(@class,'text')]")
	WebElement bonustext;
	@FindBy(xpath = "//label[text()='Branch Bonus']")
	WebElement branchBonus;

@FindBy(xpath = "//div[text()='KG Recycled']/following-sibling::div/div/following-sibling::div/div")
WebElement kgrecycled;
@FindBy(xpath = "//div[@class='card-header']/div/button")
List<WebElement> cardheaders;
@FindBy(xpath = "//li[contains(@class,'page-item')]")
WebElement lastItemOnPage;
@FindBy(xpath = "//div[text()='TOTAL']")
WebElement total;
@FindBy(xpath = "//div[@class='switch bonus-checked']")
WebElement bonustoggle;
@FindBy(xpath = "//textarea")
WebElement textarea;
@FindBy(xpath = "//label[@class='item-name offset-border']")
WebElement associatedbonus;
@FindBy(xpath = "//div[@class='switch bonus-locked']")
List<WebElement> lockedbonus;
@FindBy(xpath = "//span[text()=' Disable ']")
WebElement disable;
@FindBy(xpath = "//button[text()='Close']")
WebElement close;
@FindBy(xpath = "//div[text()='Tokens in Wallet']/following::div[5]")
WebElement tokenInWalletText;
@FindBy(xpath = "//button[text()='Void Transaction']")
WebElement voidTransactionButton;
@FindBy(xpath = "//span[text()=' Void ']" )
WebElement voidButton;
@FindBy(xpath = "//button[text()='Close']" )
WebElement closeButton;

@FindBy(xpath = "//button[@aria-label='Close']" )
WebElement crossButton;
@FindBy(xpath = "//button[@aria-label='Close']" )
WebElement voidedButton;
@FindBy(xpath = "//button[text()='Reclaim Tokens']" )
WebElement reclaimTokenButton;
@FindBy(xpath = "//textarea[@placeholder='Describe information about the reclamation.']" )
WebElement textAreaReclaimToken;
@FindBy(xpath = "//span[text()=' Reclaim ']" )
WebElement reclaimButton;
@FindBy(xpath = "//input[@id='smsCode']")
WebElement authCode;
@FindBy(xpath = "//button[text()='Submit']" )
WebElement submitButton;
@FindBy(xpath = "//button[text()='Cancel']" )
WebElement cancelButton;
@FindBy(xpath = "//*[text()='Success']" )
WebElement success;
	@FindBy(xpath = "//span[text()=' 16 ']" )
	WebElement date16;
	@FindBy(xpath = "//span[text()=' 13 ']" )
	WebElement date13;
	@FindBy(xpath = "(//i[@class=\"calendar-icon\"])[1]" )
	WebElement calenderIcon;
	@FindBy(xpath = "//select[@title=\"Select year\"]" )
	WebElement selectYear;
	@FindBy(xpath = "//select[@title=\"Select month\"]" )
	WebElement selectMonth;
	@FindBy(xpath = "//a[text()=' 2 ']" )
	WebElement page2;
	@FindBy(xpath = "//div[text()=' Sold 618 KG to TOPLUN ']/parent::*//parent::*/parent::*" )
	WebElement branchToplun;
	@FindBy(xpath = "//div[text()=' Sold 756 KG to TOPLUN ']/parent::*/parent::*/parent::*" )
	WebElement branchRiezaToplun;
	@FindBy(xpath = "//div[text()='TOTAL']/following::div" )
	WebElement totalKg;
	@FindBy(xpath = "(//div[@class='card-header']/div/button)[1]" )
	WebElement cardHeader;
	@FindBy(xpath = "//div[@class=\"loader circle-loader\"]")
	public static WebElement loader;

	@FindBy(xpath = "//span[text()='Export']")
	public static WebElement exportButton;


	WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(50));

	public static String totalKgMaryGraceBranch;
	public static String totalKgRiezaBranch;
	public static String totalKgBranch;

	public static String downloadPath = "C:/Users/Fleek/Downloads";

public void verifybranchDetailsTagTexts() {
	
}
public void searchAddedBranch(String Name) {
	WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(50));
	wait.until(ExpectedConditions.elementToBeClickable(name_SearchBox));
	name_SearchBox.sendKeys(Name);
}

public void clickBranchesTab() throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(50));
	wait.until(ExpectedConditions.elementToBeClickable(branches_TAB));
	branches_TAB.click();
}

public void clickSpecificBranch() throws InterruptedException {
	Thread.sleep(15000);
	WebDriverWait wait = new WebDriverWait(alcDriver,Duration.ofSeconds(300));
	wait.until(ExpectedConditions.invisibilityOf(pageLoader));
	tableData_FirstRow.click();
	
}

public void editBranch() {
	WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='tabpanel']/div[2]/div/span")));
	edit_Branch.click();
}

public void editUserCity(String cityName) {
	edit_city.sendKeys(cityName);
}

public void saveUserDetails() {
	save_btn.click();
}

public void suspendAccount() {
	/*
	 * WebDriverWait wait = new WebDriverWait(alcDriver,Duration.ofSeconds(300));
	 * wait.until(ExpectedConditions.elementToBeClickable(suspendAccount_checkbox));
	 */
	/*
	 * JavascriptExecutor executor = (JavascriptExecutor) alcDriver;
	 * executor.executeScript("arguments[0].click();", suspendAccount_checkbox);
	 */
	suspendAccount_checkbox.click();
}

public Boolean verfiyAlertBox() {
	Boolean verify = popUp_alert.isDisplayed();	
	return verify;
}

public void clickAlertBoxBtnOK() {
	okBtn_alertBox.click();
}
public void searchSpecificBranch(String pNum) throws InterruptedException {
	Thread.sleep(5000);
	WebDriverWait wait = new WebDriverWait(alcDriver,Duration.ofSeconds(300));
	wait.until(ExpectedConditions.invisibilityOf(pageLoader));
	//wait.until(ExpectedConditions.elementToBeClickable(phone_SearchBox));
	phone_SearchBox.clear();
	phone_SearchBox.sendKeys(pNum);
}
public void editBranchCityDetails(String pNum) throws InterruptedException {
	clickBranchesTab();
	searchSpecificBranch(pNum);
	clickSpecificBranch();
	editBranch();
	editUserCity("Dehradun");
	saveUserDetails();
	
}

public void editBranchNameDetails(String pNum) throws InterruptedException {
	clickBranchesTab();
	Thread.sleep(5000);
	searchSpecificBranch(pNum);
	clickSpecificBranch();
	editBranch();
	editNameTextFeild.clear();
	editNameTextFeild.sendKeys("Ashish "+randomLastName);
	Thread.sleep(2000);
    TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
    Thread.sleep(2000);
	saveUserDetails();
}

public void suspendBranchAccount(String pNum) throws InterruptedException {
	clickBranchesTab();
	Thread.sleep(2000);
	WebDriverWait wait = new WebDriverWait(alcDriver,Duration.ofSeconds(300));
	wait.until(ExpectedConditions.invisibilityOf(pageLoader));
	wait.until(ExpectedConditions.elementToBeClickable(phone_SearchBox));
	phone_SearchBox.clear();
	phone_SearchBox.sendKeys(pNum);
	wait.until(ExpectedConditions.invisibilityOf(pageLoader));
	clickSpecificBranch();
	suspendAccount();
	Boolean verify = verfiyAlertBox();
	assert verify.equals(true);
	clickAlertBoxBtnOK();
	Thread.sleep(2000);
    TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
    Thread.sleep(2000);
}

public void clickTokensActiveToggle(){
	tokensActive.click();
}

public void clickSplitModeToggle(){
	splitModeToggle.click();
}

public void clickUploadBuyReceiptsToggle(){
	uploadBuyReceiptsToggle.click();
}

public void clickTokenMarketToggle(){
	tokenMarketToggle.click();
}

public void clickTogglesInBranches(String pNum) throws InterruptedException {
	clickBranchesTab();
	searchSpecificBranch(pNum);
	clickSpecificBranch();
	editBranch();
	//clickTokenMarketToggle();
	//clickSplitModeToggle();
	clickUploadBuyReceiptsToggle();
}
public void clickExchangeHistoryButton() {
	WebDriverWait wait = new WebDriverWait(alcDriver,Duration.ofSeconds(300));
	wait.until(ExpectedConditions.elementToBeClickable(exchangeHistory));
	exchangeHistory.click();
}
public void clickExchangeHistoryTab() {
	WebDriverWait wait = new WebDriverWait(alcDriver,Duration.ofSeconds(300));
	wait.until(ExpectedConditions.elementToBeClickable(exchangeHistoryTab));
	exchangeHistoryTab.click();
}


public void firstTransactionApproveExcHisB1(String pNum) throws InterruptedException {
	clickBranchesTab();
	searchSpecificBranch(pNum);
	clickSpecificBranch();
	List<String>actualbranchDetailsText=new ArrayList<>();//left for Assertion
	for(WebElement branchDetails: branchDetailsTagTexts)
	actualbranchDetailsText.add(branchDetails.getText());
	Assert.assertEquals(actualbranchDetailsText, Arrays.asList("19","0","1","0"));
	Thread.sleep(3000);
	clickExchangeHistoryTab();
		
		transactions.get(0).click();
		Thread.sleep(2000);
		String alcBonus= branchBonusTextInAlchmeyVerify.getText();
		assertEquals(total_bonus_M_B1,alcBonus);
		String kgArr[] = {hdpeKgAlcText.getText(),petKgAlcText.getText(),totalKgAlcText.getText()};
		assertEquals(kgArr,alc_M_B1_ExngHisKgVerify);
		  Thread.sleep(2000);
		    TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
		    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
		    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
		    Thread.sleep(2000);
	 
}
public void transactionApproveExcHisB1(String pNum) throws InterruptedException {
	clickBranchesTab();
	searchSpecificBranch(pNum);
	clickSpecificBranch();
	List<String> actualBr1TagsDetails = new ArrayList<>();
	for(WebElement branchDetails: branchDetailsTagTexts)
		actualBr1TagsDetails.add(branchDetails.getText()) ;
	System.out.println("B1="+actualBr1TagsDetails);
	Thread.sleep(2000);
	List<String> expectedBr1TagsDetails = new ArrayList<>();
	expectedBr1TagsDetails.addAll(Arrays.asList("19","0","1","0"));
	Assert.assertEquals(actualBr1TagsDetails, expectedBr1TagsDetails);
	Thread.sleep(2000);
	TakesScreenshot ts = (TakesScreenshot) pbDriver;
    byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
    Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));
    Thread.sleep(4000);
    
	clickExchangeHistoryButton();
	
	for (int p=0; p<3; p++) {
	
		
		
	transactions.get(p).click();
	Thread.sleep(2000);
	
	Actions actions =new Actions(alcDriver);
	actions.scrollToElement(lastItemOnPage).build().perform();
	Thread.sleep(2000);
	    TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
	    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
	    Thread.sleep(2000);
	
	for (int i=0;i<2;i++)
	{	
		
		noFraudNoErrorsToggle.get(i).click();
		Thread.sleep(5000);
	}
		
	String actualAlcBonus= branchBonusTextInAlchmeyVerify.getText();
	String actualAlcKgList[] = {hdpeKgAlcText.getText(),petKgAlcText.getText(),totalKgAlcText.getText()};
	
	if(p==0) {
		assertEquals(actualAlcBonus,alc_B1_ExngHisBonusVerify[0] );
		assertEquals(actualAlcKgList,alc_B1_B3_ExngHisKgVerify);
	}
	else if(p==1) {
		assertEquals(actualAlcBonus,alc_B1_ExngHisBonusVerify[1]);
		assertEquals(actualAlcKgList,alc_B1_B2_ExngHisKgVerify);
	}
	else if(p==2) {
		assertEquals(actualAlcBonus,alc_B1_ExngHisBonusVerify[2]);
		assertEquals(actualAlcKgList,alc_M_B1_ExngHisKgVerify);
	}
	WebDriverWait wait = new WebDriverWait(alcDriver,Duration.ofSeconds(300));
	wait.until(ExpectedConditions.elementToBeClickable(approveButton));
	approveButton.click();
	Thread.sleep(4000);
	}
	
	for(int i=0;i<approvedConfirm.size();i++) {
		String ac=approvedConfirm.get(i).getText();
		assertEquals(ac, "Approved");	
}
	  Thread.sleep(2000);
	    TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
	    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
	    Thread.sleep(2000);
}
public void transactionApproveExcHisB2(String pNum) throws InterruptedException {

	clickBranchesTab();
	searchSpecificBranch(pNum);
	clickSpecificBranch();
	List<String> actualBr2TagsDetails = new ArrayList<>();
	for(WebElement branchDetails: branchDetailsTagTexts)
		actualBr2TagsDetails.add(branchDetails.getText()) ;
	System.out.println("B2="+actualBr2TagsDetails);
	Thread.sleep(2000);
	List<String> expectedBr2TagsDetails = new ArrayList<>();
	expectedBr2TagsDetails.addAll(Arrays.asList("0","0","0","0"));
	Assert.assertEquals(actualBr2TagsDetails, expectedBr2TagsDetails);
	Thread.sleep(2000);
	TakesScreenshot ts = (TakesScreenshot) pbDriver;
    byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
    Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));
    Thread.sleep(4000);
	
	clickExchangeHistoryButton();
	
	for (int p=0; p<=1; p++) {
		
		
	transactions.get(p).click();
	Thread.sleep(2000);
	
	Actions actions1 =new Actions(alcDriver);
	actions1.scrollToElement(lastItemOnPage).build().perform();
	Thread.sleep(2000);
	    TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
	    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
	    Thread.sleep(2000);
		
	String actualAlcBonus= branchBonusTextInAlchmeyVerify.getText();
	String actualAlcKgList[] = {hdpeKgAlcText.getText(),petKgAlcText.getText(),totalKgAlcText.getText()};
	
	if(p==0) {
		
		assertEquals(actualAlcBonus,alc_B2_ExngHisBonusVerify[0] );
		assertEquals(actualAlcKgList,alc_B2_P_ExngHisKgVerify);
		
		for (int i=0;i<2;i++)
		{	
			noFraudNoErrorsToggle.get(i).click();
			Thread.sleep(5000);
		}
	
		WebDriverWait wait = new WebDriverWait(alcDriver,Duration.ofSeconds(300));
		wait.until(ExpectedConditions.elementToBeClickable(approveButton));
		approveButton.click();
		Thread.sleep(4000);
	}
	
	else if(p==1) {
		
		assertEquals(actualAlcBonus,alc_B2_ExngHisBonusVerify[1]);
		assertEquals(actualAlcKgList,alc_B1_B2_ExngHisKgVerify);
		transactions.get(p).click();
		Thread.sleep(2000);	
	}
	}
	
	for(int i=0;i<approvedConfirm.size();i++) {
		String ac=approvedConfirm.get(i).getText();
		assertEquals(ac, "Approved");	
}
	  Thread.sleep(2000);
	    TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
	    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
	    Thread.sleep(2000);
}

public void transactionApproveExcHisB3(String pNum) throws InterruptedException {
	
	clickBranchesTab();
	searchSpecificBranch(pNum);
	clickSpecificBranch();
	List<String> actualBr3TagsDetails = new ArrayList<>();
	for(WebElement branchDetails: branchDetailsTagTexts)
		actualBr3TagsDetails.add(branchDetails.getText()) ;
	System.out.println("B3="+actualBr3TagsDetails);
	Thread.sleep(2000);
	List<String> expectedBr3TagsDetails = new ArrayList<>();
	expectedBr3TagsDetails.addAll(Arrays.asList("0","0","0","0"));
	Assert.assertEquals(actualBr3TagsDetails, expectedBr3TagsDetails);
	Thread.sleep(2000);
	TakesScreenshot ts = (TakesScreenshot) pbDriver;
    byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
    Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));
    Thread.sleep(4000);
	
	clickExchangeHistoryButton();
	
	for (int p=0; p<=1; p++) {	
		
	transactions.get(p).click();
	
	Thread.sleep(2000);
	Actions actions1 =new Actions(alcDriver);
	actions1.scrollToElement(lastItemOnPage).build().perform();
	Thread.sleep(2000);
	    TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
	    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
	    Thread.sleep(2000);
	
		
	String actualAlcBonus= branchBonusTextInAlchmeyVerify.getText();
	String actualAlcKgList[] = {hdpeKgAlcText.getText(),petKgAlcText.getText(),totalKgAlcText.getText()};
	
	if(p==0) {
		
		assertEquals(alc_B3_ExngHisBonusVerify[0],actualAlcBonus );
		assertEquals(alc_B3_P_ExngHisKgVerify,actualAlcKgList);
		
		for (int i=0;i<2;i++)
		{	
			noFraudNoErrorsToggle.get(i).click();
			Thread.sleep(5000);
		}
	
		WebDriverWait wait = new WebDriverWait(alcDriver,Duration.ofSeconds(300));
		wait.until(ExpectedConditions.elementToBeClickable(approveButton));
		approveButton.click();
		Thread.sleep(4000);
	}
	
	else if(p==1) {
	
		assertEquals(actualAlcBonus,alc_B3_ExngHisBonusVerify[1]);
		assertEquals(actualAlcKgList,alc_B1_B3_ExngHisKgVerify);
		transactions.get(p).click();
		Thread.sleep(2000);
		
	}
	}
	
	for(int i=0;i<approvedConfirm.size();i++) {
		String ac=approvedConfirm.get(i).getText();
		assertEquals(ac, "Approved");	
	}
	  Thread.sleep(2000);
	    TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
	    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
	    Thread.sleep(2000);
}

public void verifyBonusTransfered(String pNum) throws InterruptedException {
	
	clickBranchesTab();
	searchSpecificBranch(pNum);
	clickSpecificBranch();
	clickExchangeHistoryButton();
	Thread.sleep(2000);
	for (WebElement transaction:transactions) {

	
		transaction.click();
		Thread.sleep(2000);
		Actions action =new Actions(alcDriver);
		action.scrollToElement(lastItemOnPage).build().perform();
		Thread.sleep(4000);
		
		assertTrue(transferedTextDisplay.isDisplayed());
		Thread.sleep(2000);
			TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
		    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
		    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
		    Thread.sleep(3000);
		    transaction.click();
		    Thread.sleep(2000);
		}
	}

public void transactionApproveInBranch(String pNum) throws InterruptedException {
	clickBranchesTab();
	searchSpecificBranch(pNum);
	clickSpecificBranch();
	Thread.sleep(2000);
    
	clickExchangeHistoryButton();
	for (int p=0; p<3; p++) {
		
	transactions.get(p).click();
	Thread.sleep(1000);
	for (int i=0;i<2;i++)
	{	
		
		noFraudNoErrorsToggle.get(i).click();
		Thread.sleep(5000);
	}
		
	WebDriverWait wait = new WebDriverWait(alcDriver,Duration.ofSeconds(300));
	wait.until(ExpectedConditions.elementToBeClickable(approveButton));
	approveButton.click();
	Thread.sleep(4000);
	}
	    TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
	    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
	    Thread.sleep(2000);
	
}
public void verifyBonusInBranchExcHistory(String pNum) throws InterruptedException {
	
	clickBranchesTab();
	searchSpecificBranch(pNum);
	clickSpecificBranch();
	clickExchangeHistoryButton();
	Thread.sleep(2000);
	for (WebElement transaction:transactions) {

		transaction.click();
		Thread.sleep(3000);
		assertTrue(transferedTextDisplay.isDisplayed());
		Thread.sleep(2000);
			TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
		    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
		    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
		    Thread.sleep(3000);
		    transaction.click();
		    Thread.sleep(2000);
		}
}
public void kgRecycledInBranch(String branchId,String kgRecycled) throws InterruptedException {
	
	alcDriver.get("https://"+BaseClass.actual+"/#/admin/collectionpoint/"+branchId);
	alcDriver.navigate().refresh();
	WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(80));
    wait.until(ExpectedConditions.visibilityOfAllElements(kgRecycledInBranch));
	Thread.sleep(2000);
	String kgRecycledBranch=kgRecycledInBranchText.getText();
	Thread.sleep(2000);
	Assert.assertEquals(kgRecycledBranch,kgRecycled);
	Thread.sleep(2000);
	 TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
	    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("KG Recycled In Branch", new ByteArrayInputStream(screenshot1));
		Thread.sleep(2000);
	System.out.println(kgRecycledBranch);

}
	private void enterAuthCode(String code) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(authCode));
		authCode.sendKeys(code);
		Thread.sleep(2000);
	}
public void bonusExchangeHistoryBranch(String branchId) throws InterruptedException {
	alcDriver.get("https://"+BaseClass.actual+"/#/admin/collectionpoint/"+branchId);
	alcDriver.navigate().refresh();
	WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(50));
	wait.until(ExpectedConditions.visibilityOfAllElements(exchangeHistoryTab));
	exchangeHistoryTab.click();
	Thread.sleep(3000);
	for(WebElement transaction : transactions){
		Thread.sleep(2000);
		transaction.click();
		Thread.sleep(2000);

		Actions action = new Actions(alcDriver);
		action.scrollToElement(lastItemOnPage).build().perform();
		Thread.sleep(2000);
		TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
		byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
		Allure.addAttachment("Branch Exchange History Screenshot", new ByteArrayInputStream(screenshot1));
		Thread.sleep(2000);
		assertTrue(bonustext.isDisplayed());
		Thread.sleep(2000);
		transaction.click();
		Thread.sleep(2000);
	}
}
	public void bonusExchangeHistoryBranchAfterVoid(String branchId) throws InterruptedException {
		alcDriver.get("https://"+BaseClass.actual+"/#/admin/collectionpoint/"+branchId);
		alcDriver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(exchangeHistoryTab));
		exchangeHistoryTab.click();
		Thread.sleep(3000);
		for(WebElement transaction : transactions){
			Thread.sleep(2000);
			transaction.click();
			Thread.sleep(3000);
			Actions action = new Actions(alcDriver);
			action.scrollToElement(lastItemOnPage).build().perform();
			Thread.sleep(2000);
			TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
			byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
			Allure.addAttachment("Bonus In Branch Exchange History", new ByteArrayInputStream(screenshot1));
			System.out.println("Bonus is Not present");
//			assertFalse(bonustext.isDisplayed());
			Thread.sleep(2000);
			transaction.click();
			Thread.sleep(2000);
		}
	}

public void verifykgrecycled() throws InterruptedException {
	alcDriver.get("https://"+BaseClass.actual+"/#/admin/collectionpoint/"+Data.b1id4360);
	Thread.sleep(2000);
	kgrecycled.isDisplayed();
	System.out.println("-----"+kgrecycled.getText()+"-----");
	wait.until(ExpectedConditions.textToBePresentInElement(kgrecycled, "19"));
	assertTrue(kgrecycled.getText().equals("19"));
	Thread.sleep(2000);
	 TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
	    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Verify Kg Recycled", new ByteArrayInputStream(screenshot1));
		Thread.sleep(2000);

}

public void verifyDelayedBonus() throws InterruptedException {
	exchangeHistoryTab.click();
	
	cardheaders.get(0).click();
	wait.until(ExpectedConditions.textToBePresentInElement(branchbonustext.get(0), "30"));
	assertTrue(branchbonustext.get(0).getText().equals("30"));
	Thread.sleep(2000);

	 TakesScreenshot ts13 = (TakesScreenshot) alcDriver;
	    byte[] screenshot13 = ts13.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot13));
		Thread.sleep(2000);

	System.out.println("pass 1");
	
	cardheaders.get(1).click();
	wait.until(ExpectedConditions.textToBePresentInElement(memberbonustext, "133"));
	assertTrue(memberbonustext.getText().equals("133"));
	Actions action = new Actions(alcDriver);
	action.moveToElement(lastItemOnPage).build().perform();
	Thread.sleep(2000);

	 TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
	    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
		Thread.sleep(2000);

	System.out.println("pass 2");
	
	alcDriver.get("https://"+BaseClass.actual+"/#/admin/collectionpoint/"+Data.b2id4360);
	alcDriver.navigate().refresh();
	
	exchangeHistoryTab.click();
	
	cardheaders.get(0).click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.textToBePresentInElement(branchbonustext.get(0), "14")));
	assertTrue(branchbonustext.get(0).getText().equals("14"));
	Thread.sleep(2000);

	 TakesScreenshot ts112 = (TakesScreenshot) alcDriver;
	    byte[] screenshot112 = ts112.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot112));
		Thread.sleep(2000);
	System.out.println("pass 3");
	
	cardheaders.get(1).click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.textToBePresentInElement(branchbonustext.get(1), "30")));
	assertTrue(branchbonustext.get(1).getText().equals("30"));
	action.moveToElement(lastItemOnPage).build().perform();
	Thread.sleep(2000);

	 TakesScreenshot ts11 = (TakesScreenshot) alcDriver;
	    byte[] screenshot11 = ts11.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot11));
		Thread.sleep(2000);

	System.out.println("pass 4");
}

@SuppressWarnings("deprecation")
public void disablebonus() throws InterruptedException {
	
	alcDriver.get("https://"+BaseClass.actual+"/#/admin/collectionpoint/"+Data.b1id4360);
	exchangeHistoryTab.click();
	transactions.get(1).click();
	bonustoggle.click();
	textarea.sendKeys("Test");
	disable.click();
	close.click();
	transactions.get(0).click();
	for(WebElement lb: lockedbonus) {
		lb.isDisplayed();
	}
	alcDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

	try {
		 WebDriverWait waitab = new WebDriverWait(alcDriver,Duration.ofSeconds(2));
		waitab.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(associatedbonus)));
	}catch(Exception e) {
		System.out.println("associated bonus not present after disabling bonus");
	}
	try {
		 WebDriverWait waitmb = new WebDriverWait(alcDriver,Duration.ofSeconds(2));
		waitmb.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(memberbonustext)));
	}catch(Exception e) {
		System.out.println("member bonus not present after disabling bonus");
	}
	try {
		 WebDriverWait waitbb = new WebDriverWait(alcDriver,Duration.ofSeconds(2));
		waitbb.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(branchbonustext.get(0))));
	}catch(Exception e) {
		System.out.println("branch bonus not present after disabling bonus");
	}
	
	Actions action = new Actions(alcDriver);
	action.moveToElement(lastItemOnPage).build().perform();
	Thread.sleep(2000);

	 TakesScreenshot ts11 = (TakesScreenshot) alcDriver;
	    byte[] screenshot11 = ts11.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot11));
		Thread.sleep(2000);
    
	    
	 alcDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	details.click();
	kgrecycled.isDisplayed();
	wait.until(ExpectedConditions.textToBePresentInElement(kgrecycled, "19"));
	alcDriver.get("https://"+BaseClass.actual+"/#/admin/collectionpoint/"+Data.b2id4360);
	alcDriver.navigate().refresh();
	exchangeHistoryTab.click();
	Thread.sleep(2000);
	for(WebElement t: transactions) {
		Thread.sleep(2000);
		t.click();
	}
	total.isDisplayed();
	alcDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

	try {
		 WebDriverWait waitbb = new WebDriverWait(alcDriver,Duration.ofSeconds(2));
		waitbb.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(branchbonustext.get(0))));
	}catch(Exception e) {
		System.out.println("branch bonus not present after disabling bonus");
	}
	try {
		 WebDriverWait waitab = new WebDriverWait(alcDriver,Duration.ofSeconds(2));
		waitab.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(associatedbonus)));
	}catch(Exception e) {
		System.out.println("associated bonus not present after disabling bonus");
	}
	
	
	action.moveToElement(lastItemOnPage).build().perform();
	Thread.sleep(2000);

	 TakesScreenshot ts111 = (TakesScreenshot) alcDriver;
	    byte[] screenshot111 = ts111.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot111));
		Thread.sleep(2000);
  
	    
	 alcDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	
}

public void bonusBranchExcHistoryVerification(String branchId) throws InterruptedException {

	alcDriver.get("https://"+BaseClass.actual+"/#/admin/collectionpoint/"+branchId);
	alcDriver.navigate().refresh();
	exchangeHistoryTab.click();
	Thread.sleep(1000);

	for(WebElement cardHeaders:cardheaders) {

		cardHeaders.click();
		Actions action = new Actions(alcDriver);
		action.scrollToElement(lastItemOnPage).build().perform();

		Thread.sleep(1000);

		TakesScreenshot ts13 = (TakesScreenshot) alcDriver;
		byte[] screenshot13 = ts13.getScreenshotAs(OutputType.BYTES);
		Allure.addAttachment("Token in Branch Exchange History Before Void Screenshot", new ByteArrayInputStream(screenshot13));
		Thread.sleep(3000);
		try {
			assertTrue(bonustext.isDisplayed());
			System.out.println("Bonus is present");
		}
		catch(Exception e){
			System.out.println("Bonus is Not Present");
		}

		wait.until(ExpectedConditions.elementToBeClickable(cardHeaders));
		cardHeaders.click();
		Thread.sleep(2000);

	}
	
}
	public void bonusBranchExcHistoryAfterVoidVerification(String branchId) throws InterruptedException {

		alcDriver.get("https://"+BaseClass.actual+"/#/admin/collectionpoint/"+branchId);
		alcDriver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(exchangeHistoryTab));
		exchangeHistoryTab.click();
		Thread.sleep(1000);

		for(WebElement cardHeaders:cardheaders) {

			cardHeaders.click();
			Actions action = new Actions(alcDriver);
			action.scrollToElement(lastItemOnPage).build().perform();

			Thread.sleep(1000);

			TakesScreenshot ts13 = (TakesScreenshot) alcDriver;
			byte[] screenshot13 = ts13.getScreenshotAs(OutputType.BYTES);
			Allure.addAttachment("Token in Branch Exchange History After Void", new ByteArrayInputStream(screenshot13));
			Thread.sleep(3000);
			alcDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			try{

				bonustext.isDisplayed();

			}
			catch(Exception e){

				System.out.println("Bonus is Not Present");
			}
			alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			wait.until(ExpectedConditions.elementToBeClickable(cardHeaders));
			cardHeaders.click();
			Thread.sleep(2000);

		}

	}

	public void bonusProcessorExcHistoryVerification(String processorId) throws InterruptedException {

		alcDriver.get("https://"+BaseClass.actual+"/#/admin/recyclingcenter/"+processorId);

		exchangeHistoryTab.click();
		for(WebElement cardHeaders:cardheaders)
			cardHeaders.click();
		Actions action = new Actions(alcDriver);
		action.moveToElement(lastItemOnPage).build().perform();
		Thread.sleep(2000);

		TakesScreenshot ts13 = (TakesScreenshot) alcDriver;
		byte[] screenshot13 = ts13.getScreenshotAs(OutputType.BYTES);
		Allure.addAttachment("Bonus in Processor Exchange History Screenshot", new ByteArrayInputStream(screenshot13));
		Thread.sleep(3000);
		alcDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		try {
			assertTrue(branchBonus.isDisplayed());
		}
		catch(Exception e){
			//assertFalse(branchBonus.isDisplayed());
			System.out.println("No Bonus is Present");
		}
		alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}
public void verifyBonusInAlchmeyBranches_1711(String branchId,String bonus) throws InterruptedException {
	
	alcDriver.get("https://"+actual+"/#/admin/collectionpoint/"+branchId);
	alcDriver.navigate().refresh();
	Thread.sleep(2000);
	String tokenInWallet=tokenInWalletText.getText();
	System.out.println(tokenInWallet);
	assertTrue(tokenInWallet.equals(bonus));
	
	 TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
	    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Token in wallet for Branch in Alchemy", new ByteArrayInputStream(screenshot1));
		Thread.sleep(2000);
	
}
public void voidTransaction(String branchId) throws InterruptedException {

	alcDriver.get("https://"+actual+"/#/admin/collectionpoint/"+branchId);
	Thread.sleep(2000);
	exchangeHistoryTab.click();
	Thread.sleep(2000);

	cardheaders.get(1).click();

	Actions action = new Actions(alcDriver);
	action.scrollToElement(lastItemOnPage).build().perform();
	Thread.sleep(2000);

	voidTransactionButton.click();
	voidButton.click();
	closeButton.click();
	Thread.sleep(2000);
//	Actions action1 = new Actions(alcDriver);
//	action1.moveToElement(crossButton).click().build().perform();
//	//crossButton.click();

//	Actions action1 = new Actions(alcDriver);
//	action1.moveToElement(crossButton).build().perform();

//	crossButton.click();
//	Thread.sleep(3000);
//	wait.until(ExpectedConditions.elementToBeClickable(cardheaders.get(1)));
//	cardheaders.get(1).click();

	TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
	byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
	Allure.addAttachment("Void Transaction", new ByteArrayInputStream(screenshot1));
	Thread.sleep(2000);

//	Assert.assertTrue(voidedButton.isDisplayed());

}
	public void reclaimToken(String branchId) throws InterruptedException {

		alcDriver.get("https://"+actual+"/#/admin/collectionpoint/"+branchId);
		Thread.sleep(2000);
		exchangeHistoryTab.click();

		Thread.sleep(2000);

		Actions action = new Actions(alcDriver);
		action.moveToElement(lastItemOnPage).build().perform();
		Thread.sleep(2000);

		cardheaders.get(1).click();

		wait.until(ExpectedConditions.elementToBeClickable(reclaimTokenButton));
		reclaimTokenButton.click();
		textAreaReclaimToken.sendKeys("Token Reclaim for test case ALC-1711");
		reclaimButton.click();

		enterAuthCode("778899");

		submitButton.click();

		Thread.sleep(2000);

		TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
		byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
		Allure.addAttachment("Reclaim Token Screenshot", new ByteArrayInputStream(screenshot1));
		Thread.sleep(2000);
		Assert.assertTrue(success.isDisplayed());
		closeButton.click();

	}

	public String VerifyMARYGRACEPartnerBranchAlc666() throws InterruptedException {

	Actions action = new Actions(alcDriver);
/*	wait.until(ExpectedConditions.elementToBeClickable(branches_TAB));
	branches_TAB.click();
	Thread.sleep(4000);
	searchAddedBranch("MARY GRACE Partner Branch");
	clickSpecificBranch();*/

	alcDriver.get("https://"+BaseClass.actual+"/#/admin/collectionpoint/"+"64a65f12-7953-4818-a987-4f4fbad181d8");
	wait.until(ExpectedConditions.elementToBeClickable(exchangeHistoryTab));
	exchangeHistoryTab.click();

		wait.until(ExpectedConditions.elementToBeClickable(calenderIcon));
		calenderIcon.click();
		Select select_Year = new Select(selectYear);
		select_Year.selectByVisibleText("2022");
		Select select_Month = new Select(selectMonth);
		select_Month.selectByVisibleText("Nov");
		date16.click();
		Thread.sleep(1000);
		date16.click();

	Thread.sleep(6000);
	page2.click();
	wait.until(ExpectedConditions.elementToBeClickable(branchToplun));
	action.scrollToElement(branchToplun).build().perform();
	branchToplun.click();
	Thread.sleep(1000);
	action.scrollToElement(lastItemOnPage).build().perform();
		TakesScreenshot ts = (TakesScreenshot) alcDriver;
		byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
		Allure.addAttachment("Total Kg in Mary Grace Branch ", new ByteArrayInputStream(screenshot));
		Thread.sleep(2000);
	totalKgMaryGraceBranch=totalKg.getText();
	return totalKgMaryGraceBranch;

	}
	public String VerifyRIEZAPartnerBranchAlc666() throws InterruptedException {

		Actions action = new Actions(alcDriver);
//		wait.until(ExpectedConditions.elementToBeClickable(branches_TAB));
//		branches_TAB.click();
//		Thread.sleep(4000);
//		searchAddedBranch("RIEZA Partner Branch");
//		clickSpecificBranch();


		alcDriver.get("https://"+BaseClass.actual+"/#/admin/collectionpoint/"+"b7f276a6-2b5d-44cb-b583-32f0b5af8017");
		Thread.sleep(5000);
		alcDriver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(exchangeHistoryTab));
		exchangeHistoryTab.click();

		wait.until(ExpectedConditions.elementToBeClickable(calenderIcon));
		calenderIcon.click();
		Select select_Year = new Select(selectYear);
		select_Year.selectByVisibleText("2022");
		Select select_Month = new Select(selectMonth);
		select_Month.selectByVisibleText("Oct");
		date13.click();
		Thread.sleep(1000);
		date13.click();
		Thread.sleep(6000);
		wait.until(ExpectedConditions.elementToBeClickable(branchRiezaToplun));
		action.scrollToElement(branchRiezaToplun).build().perform();
		branchRiezaToplun.click();
		action.scrollToElement(lastItemOnPage).build().perform();
		TakesScreenshot ts = (TakesScreenshot) alcDriver;
		byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
		Allure.addAttachment("Total Kg in Rieza Partner Branch ", new ByteArrayInputStream(screenshot));
		Thread.sleep(2000);
		totalKgRiezaBranch=totalKg.getText();
		return totalKgRiezaBranch;

	}
	public String verifyBranchKgALC666(String branchId) throws InterruptedException {

		Actions action = new Actions(alcDriver);
//		wait.until(ExpectedConditions.elementToBeClickable(branches_TAB));
//		branches_TAB.click();
//		searchAddedBranch(branchName);
//		Thread.sleep(6000);
//		tableData_FirstRow.click();

		alcDriver.get("https://"+BaseClass.actual+"/#/admin/collectionpoint/"+branchId);

		alcDriver.navigate().refresh();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(exchangeHistoryTab));
		}catch (Exception e){
			alcDriver.navigate().refresh();
			wait.until(ExpectedConditions.elementToBeClickable(exchangeHistoryTab));
		}
		exchangeHistoryTab.click();

		wait.until(ExpectedConditions.elementToBeClickable(calenderIcon));
		wait.until(ExpectedConditions.elementToBeClickable(cardHeader));
		action.scrollToElement(cardHeader).build().perform();
		cardHeader.click();
		Thread.sleep(1000);
		action.scrollToElement(lastItemOnPage).build().perform();
		TakesScreenshot ts = (TakesScreenshot) alcDriver;
		byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
		Allure.addAttachment(" Total Kg in the current Branch Attached", new ByteArrayInputStream(screenshot));
		Thread.sleep(2000);
		totalKgBranch=totalKg.getText();
		return totalKgBranch;

	}

	public void reportDownload(String fileName) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));

		wait.until(ExpectedConditions.elementToBeClickable(branches_TAB));
		branches_TAB.click();

		wait.until(ExpectedConditions.elementToBeClickable(tableData_FirstRow));
		tableData_FirstRow.click();

		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOf(exchangeHistoryTab));
		exchangeHistoryTab.click();

		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOf(cardHeader));
		Thread.sleep(2000);

		exportButton.click();
		Thread.sleep(4000);

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

