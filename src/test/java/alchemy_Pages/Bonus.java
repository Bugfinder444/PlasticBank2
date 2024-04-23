package alchemy_Pages;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.BaseClass;
import Utilities.Data;
import io.qameta.allure.Allure;

public class Bonus extends BaseClass {
	
	public Bonus(WebDriver alcDriver){
        PageFactory.initElements(alcDriver, this);
    }

@FindBy(xpath="//div[text()=\"Bonus Approval \"]")
public WebElement 	bonusApprovalButton ;

@FindBy(xpath="//div[@class='card-header']//button")
public List<WebElement> branchButton;

@FindBy(xpath="(//div[contains(@class,\"section-white-container\")])[3]//div/span")
public List<WebElement> totalBonusValues;

@FindBy(xpath="//transaction-item//div[@class=\"row\"]/div[3]//div[contains(translate(text(),'kg','KG'),'KG')]")
public List<WebElement> kgTransactions;

@FindBy(xpath="//transaction-item//div[@class=\"row\"]/div[3]//span")
public List<WebElement> bonusBuyTransactions;


@FindBy(xpath="//a[contains(text(),\"Sell Transactions\")]")
public WebElement  sellTransactionsButton ;

@FindBy(xpath="//div[contains(text(),\"Sell Transactions\")]")
public WebElement  sellTransactionsTagAuditTrail ;


@FindBy(xpath="//div[text()=\" Total Bonus \"]")
public WebElement totalBonusTitle ;

@FindBy(xpath="//button/span[text()=\"View Audit Trail\"]")
public WebElement viewAuditTrail ;

@FindBy(xpath="//span[contains(text(),\"Verify Receipts\")]")
public WebElement verifyReceiptsButton ;
@FindBy(xpath="//div[text()=\"Approve\"]")
public List<WebElement> approveRecipt;

@FindBy(xpath="//button[text()=\"Cancel\"]")
public WebElement cancelButton ;

@FindBy(xpath="//button[text()=\"OK\"]")
public WebElement okButton ;

@FindBy(xpath="//button[text()=\"Confirm\"]")
public WebElement confirmButton ;

@FindBy(xpath="//div[text() = \" Total Branch Bonus \"]")
public WebElement totalBranchBonus ;

@FindBy(xpath="//label[text()=\"Bonuses Paid\"]")
public WebElement bonusPaidText ;

@FindBy(xpath="//button[@aria-label=\"Close\"]/span")
public WebElement closeButton ;

@FindBy(xpath="//button/span[text()=\"Start Approval\"]")
public WebElement startApprovalButton ;

@FindBy(xpath="//div[@class='card-header']/descendant::input[@type='checkbox']/following-sibling::span")
public List<WebElement> checkMarkButton ;

@FindBy(xpath="//span[text()=\"Pay Bonuses\"]")
public WebElement payBonusButton ;

@FindBy(xpath="//li/a[contains(text(),\"Buy Transactions\")]")
public WebElement buyTransactionsButton;

//
@FindBy(xpath="//div[contains(text(),' Total Bonus')]/following-sibling::div/div/span")
public List<WebElement> bonusApprovalTotalBonusAssertion;

@FindBy(xpath="//div[contains(text(),' Needing Approval')]/following-sibling::div/div/span")
public List<WebElement> bonusApprovalNeedingApprovalAssertion;

@FindBy(xpath = "//div[text()='Exchange History ']") 
WebElement excHisHdpeKG;
//HDPE-Clean-Clear / 10.00 kg
@FindBy(xpath = "//div[text()='PET-Raw-Transparent / 9.00 kg']") 
WebElement excHisPetKG;
//PET-Raw-Transparent / 9.00 kg

@FindBy(xpath = "//div[text()='HDPE-Clean-Clear / 10.00 kg']/following-sibling::div/span") 
WebElement excHisHdpeBonus;
//Bonus 70
@FindBy(xpath = "//div[text()='PET-Raw-Transparent / 9.00 kg']/following-sibling::div/span") 
WebElement excHisPetBonus;
//Bonus 63

@FindBy(xpath = "(//div[contains(text(),'Total Weight')])") 
WebElement excHisTotalKg;
//Total Weight: 19.00 KG
@FindBy(xpath = "//div[text()='Bonus']") 
WebElement excHisTotalBonus;

@FindBy(xpath="//transaction-item//div[contains(@class,\"row\")]//div[contains(text(),'HDPE')or(contains(text(),'PET'))or(contains(text(),'Total Weight'))]")
public List<WebElement> kgVerifyUnverifiedReciept;

@FindBy(xpath="//span[contains(@class,'text-green')]")
public List<WebElement> bonusVerifyUnverifiedReciept;

@FindBy(xpath="//div[text()=\"Bonus\"]/following-sibling::div")
public List<WebElement> bonusBuyTotalValue ;

@FindBy(xpath="(//div[contains(@class,\"section-white-container\")])[3]/div[contains(text(),\"kg\")]")
public List<WebElement> sellTransactionsWeight ;

@FindBy(xpath="(//div[contains(@class,\"section-white-container\")])[4]/div/div/parent::div")
public List<WebElement> sellTransactionsBonus ;
@FindBy(xpath = "//button[text()=' Bonus & Impact Program']/following-sibling::button[1]") 
WebElement bonusNameLink;
@FindBy(xpath = "//loader/div//table")
WebElement pageLoader;
@FindBy(xpath = "//div[@class='container-fluid']//datatable//table/tbody/tr[1]/td[1]/div/div")
WebElement tableData_FirstRow;
@FindBy(xpath = "//datatable//input[@placeholder='Name']")
WebElement name_SearchBox;
@FindBy(xpath = "//div[@class='body']/div/div/div[text()=' Orders ']")
WebElement orders_tab;
@FindBy(xpath = "//a[@role='tab' and text()='Bonus']")
WebElement ordersTab_bonus;
@FindBy(xpath = "//a[text()='Buy Transactions (0)']")
WebElement buyTransactionTag;
@FindBy(xpath = "//label[text()=' Select Equivalent ']/input")
WebElement selectEquivalentCheckBox;
@FindBy(xpath="//button[text()='Approved']")
public List<WebElement> approvedTextInBonusApproval ;
@FindBy(xpath = "//div[text()='Exchange History ']")
WebElement exchangeHistoryTab;
@FindBy(xpath = "//button[text()='Data Transfer']")
WebElement dataTransferButton;
@FindBy(xpath="//span[@class='checkmark']")
public List<WebElement> checkMark ;

@FindBy(xpath="//div[text()='PET-Clean-Clear / 50.00 kg']/preceding::input[@type='checkbox'][1]/following::span[1]")
public WebElement checkMark50 ;
@FindBy(xpath="//div[text()='PET-Clean-Clear / 33.80 kg']/preceding::input[@type='checkbox'][1]/following::span[1]")
public WebElement checkMark33 ;
@FindBy(xpath = "//div[text()=' Bonus Progress ']/following-sibling::div[1]")
WebElement bonusProgress;
@FindBy(xpath = "//button[text()='Confirm Data Transfer']")
WebElement confirmDataTransferButton;
@FindBy(xpath = "//button[text()='Confirm Data Transfer']")
WebElement yesCheckBox;
@FindBy(xpath = "//span[text()='No']")
WebElement noCheckBox;
@FindBy(xpath = "//input[@placeholder=\"Offset search\"]")
WebElement searchOffsetFeild;
@FindBy(xpath = "//input[@placeholder=\"Offset Name\"]")
WebElement searchOffsetNameFeild;
@FindBy(xpath = "//div[@class=\"search-icon\"]")
WebElement searchButton;
@FindBy(xpath = "//div[contains(@class,\"offset-result \")]")
WebElement offsetResult;
@FindBy(xpath = "//div[text()='Summary']")
WebElement summaryTab;
@FindBy(xpath = "//span[contains(text(),\"Exclude Members' Pending Bonuses\")]/following::span")
WebElement excludeMemPenBonus;
@FindBy(xpath = "//label[text()='Include Processor']/following-sibling::input")
WebElement includeProcessorTextField;
@FindBy(xpath = "//label[text()='Include Branch']/following-sibling::input")
WebElement includeBranchTextField;
@FindBy(xpath = "//div[text()='Total Weight: 40.00 KG']")
WebElement totalWeight40;
@FindBy(xpath = "//li[contains(@class,'page-item')]")
WebElement lastItemOnPage;
@FindBy(xpath = "//div[contains(text(),' Total Bonus')]/following-sibling::div[2]/div/span")
public List<WebElement> totalKgCollectedAndSold;
@FindBy(xpath="//a[text()='Exchange History']")
public WebElement exchangeHistoryTabInBranches;
@FindBy(xpath = "//div[@class='card-header']/div/button")
List<WebElement> transactions;
@FindBy(xpath="//label[text()='ASSOCIATED BONUS']/following::label")
public WebElement associatedBonus;
@FindBy(xpath="//label[text()='ASSOCIATED BONUS']/following::label[@class=\"item-name offset-border\"]")
public List<WebElement> associatedBonusName;
@FindBy(xpath = "//div[text()='Total Weight: 22.60 KG']")
WebElement totalWeight22;
@FindBy(xpath = "//div[text()='Total Weight: 33.80 KG']")
WebElement totalWeight33;
@FindBy(xpath = "//div[text()='Total Weight: 50.00 KG']")
WebElement totalWeight50;
@FindBy(xpath = "//div[text()='Total Weight: 70.00 KG']")
WebElement totalWeight70;
@FindBy(xpath = "//div[text()=' Dashboard ']")
WebElement dashBoard;
@FindBy(xpath = "//div[text()='Members by Country']/following::span[@class='total-price'][1]")
WebElement membersByCountry;
@FindBy(xpath = "//label[text()='Category']/following-sibling::select")
WebElement categoryDropdown;
@FindBy(xpath = "//label[text()='Type']/following-sibling::select")
WebElement typeDropdown;
@FindBy(xpath = "//label[text()='KG Limit']/following-sibling::input")
WebElement kgLimitTextField;
@FindBy(xpath = "//div[contains(text(),'Total Weight: ')]")
WebElement totalWeight;
@FindBy(xpath = "//span[text()='Plastic Chain']")
List<WebElement> plasticChainDropdown;
@FindBy(xpath = "//span[contains(text(),'PET')]")
WebElement petTransaction;
@FindBy(xpath = "//div[text()='Bonus']/following::div")
List<WebElement> bonusExcHis;
@FindBy(xpath = "//div[text()='Export ']")
public static WebElement exportButton;
@FindBy(xpath = "//a[text()='Bonus']")
public static WebElement bonus_Tab;
@FindBy(xpath = "//span[text()='Impact Claim Report']")
public static WebElement impactClaimReport;
	@FindBy(xpath = "//a[text()='Transfers']")
	public static WebElement transfersTab;



	public static String downloadPath = "C:/Users/Fleek/Downloads";

	public static String expectedexcHisHdpeKG="HDPE-Clean-Clear / 10.00 kg";
public static String expectedexcHisPetKG="PET-Raw-Transparent / 9.00 kg";
public static String expectedexcHisHdpeBonus="Bonus 70";
public static String expectedexcHisPetBonus="Bonus 63";
public static String expectedexcHisTotalKg="Total Weight: 19.00 KG";
public static String expectedexcHisTotalBonus="133";
public static String bonusName1134="RandomBonus_"+ RandomStringUtils.randomAlphabetic(5);
public static String actualBonusProgressBeforeTransfer;
public static ArrayList<String> actualTotalKgCollectedAndSoldBeforeTransfer = new ArrayList<String>();
public static String actualTotalWeightBeforeTransfer;

public static String actualBonusProgressAfterTransfer;
public static ArrayList<String> actualTotalKgCollectedAndSoldAfterTransfer = new ArrayList<String>();
public static String actualTotalWeightAfterTransfer;
public static String referenceId="Ref_"+ RandomStringUtils.randomAlphabetic(5);





private void clickOrdersTab() throws InterruptedException {
    Thread.sleep(4000);
    WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(50));
    wait.until(ExpectedConditions.elementToBeClickable(orders_tab));
    orders_tab.click();
}
private void clickBounsTab() throws InterruptedException {
    Thread.sleep(2000);
	WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(50));
	wait.until(ExpectedConditions.elementToBeClickable(ordersTab_bonus));
    ordersTab_bonus.click();
}
private void search_byName(String name) throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
    wait.until(ExpectedConditions.invisibilityOf(pageLoader));
    wait.until(ExpectedConditions.elementToBeClickable(name_SearchBox));
    name_SearchBox.click();
    name_SearchBox.clear();
    name_SearchBox.sendKeys(name);
    Thread.sleep(8000);
}
private void clickSpecificOrdersBonus() {
    WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(50));
    wait.until(ExpectedConditions.elementToBeClickable(tableData_FirstRow));
    tableData_FirstRow.click();
}

public void bounusTransaction1ValueVerify() throws InterruptedException {
	
	/*clickOrdersTab();
	clickBounsTab();
	search_byName(bonusName);
	clickSpecificOrdersBonus();*/
	
	WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
	Orders.clickBonusApprovalTab();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(branchButton.get(0)));
	branchButton.get(0).click();
	
	
	ArrayList<String>expectedBonusApprovalTotalBonusArray =new ArrayList<>();
	expectedBonusApprovalTotalBonusArray.add("0 %");
	expectedBonusApprovalTotalBonusArray.add("1");
	expectedBonusApprovalTotalBonusArray.add("0 KG");
	expectedBonusApprovalTotalBonusArray.add("0 KG");
	expectedBonusApprovalTotalBonusArray.add("0 = $0.00");
	expectedBonusApprovalTotalBonusArray.add("0 = $0.00");
	
	
	ArrayList<String>expectedBonusApprovalNeedingApprovalArray =new ArrayList<>();
	expectedBonusApprovalNeedingApprovalArray.add("0%");
	expectedBonusApprovalNeedingApprovalArray.add("1");
	expectedBonusApprovalNeedingApprovalArray.add("19 KG");//////////76-38
	expectedBonusApprovalNeedingApprovalArray.add("0 KG");
	expectedBonusApprovalNeedingApprovalArray.add("133 = $1.33");
	expectedBonusApprovalNeedingApprovalArray.add("0 = $0.00");
	
	
	ArrayList<String> actualBonusApprovalTotalBonusArray = new ArrayList<>(); // branch one all 6 bonus values
	ArrayList<String> actualBonusApprovalNeedingApprovalArray = new ArrayList<>();
	
	for (WebElement element1 :bonusApprovalTotalBonusAssertion) {
		actualBonusApprovalTotalBonusArray.add(element1.getText());
	}
	Assert.assertEquals(actualBonusApprovalTotalBonusArray, expectedBonusApprovalTotalBonusArray);
	
	for (WebElement element2 :bonusApprovalNeedingApprovalAssertion) {
		actualBonusApprovalNeedingApprovalArray.add(element2.getText());
	}
	Assert.assertEquals(actualBonusApprovalNeedingApprovalArray, expectedBonusApprovalNeedingApprovalArray);
	  Thread.sleep(2000);
	    TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
	    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
	    Thread.sleep(2000);
}


public void bonusBranch1Verification() throws InterruptedException {
	
	clickOrdersTab();
	clickBounsTab();
	search_byName(Data.bonusName);
	clickSpecificOrdersBonus();
	
	WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
	wait.until(ExpectedConditions.elementToBeClickable(bonusApprovalButton));
	bonusApprovalButton.click();
	wait.until(ExpectedConditions.elementToBeClickable(branchButton.get(0)));
	branchButton.get(0).click();
	

	wait.until(ExpectedConditions.elementToBeClickable(verifyReceiptsButton));
	verifyReceiptsButton.click();
	Thread.sleep(3000);
	//wait.until(ExpectedConditions.elementToBeClickable(approveRecipt.get(0)));
	
	Set<String>expectedBranchOneRecieptKgB1 = new HashSet<>(Arrays.asList("PET- / 5.00 kg", "HDPE- / 6.00 kg",  "Total Weight: 11.00 KG","PET- / 7.00 kg","HDPE- / 8.00 kg","Total Weight: 15.00 KG","PET- / 9.00 kg","HDPE- / 10.00 kg","Total Weight: 19.00 KG"));
	Set<String>expectedBranchOneReciptBonusB1 = new HashSet<>(Arrays.asList("Bonus 4", "Bonus 4","Bonus 16","Bonus 14","Bonus 63","Bonus 70"));
	ArrayList<String>expectedBranchOneReciptTotalBonusB1 = new ArrayList<>(Arrays.asList("8", "30", "133"));

	
	Set<String> actualBranchOneRecieptKgB1 = new HashSet<>();   // branch one all 9 kg values
	Set<String> actualBranchOneRecieptBonusB1 = new HashSet<>(); 
	ArrayList<String> actualBranchOneRecieptTotalBonusB1 = new ArrayList<>(); 
	
	
	for (WebElement element : kgVerifyUnverifiedReciept) {
		actualBranchOneRecieptKgB1.add(element.getText());
	}

	for (WebElement element : bonusVerifyUnverifiedReciept) {
		actualBranchOneRecieptBonusB1.add(element.getText());
	}
	
	for (WebElement element : bonusBuyTotalValue) {
		actualBranchOneRecieptTotalBonusB1.add(element.getText());
	}
	
	Assert.assertEquals(actualBranchOneRecieptKgB1, expectedBranchOneRecieptKgB1);
	Assert.assertEquals(actualBranchOneRecieptBonusB1, expectedBranchOneReciptBonusB1);
	Assert.assertEquals(actualBranchOneRecieptTotalBonusB1, expectedBranchOneReciptTotalBonusB1);
	  Thread.sleep(2000);
	
	    TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
	    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
	    Thread.sleep(2000);
	
	

	// for all receipts
	try {
		for (int i = 1; i <= 3; i++) {
			approveRecipt.get(0).click();
			Thread.sleep(2000);
			okButton.click();
			Thread.sleep(2000);
		}
	} catch (Exception e) {
		System.out.println("Exception caught: " + e.getMessage());
	}


	wait.until(ExpectedConditions.elementToBeClickable(closeButton));
	closeButton.click();

	
	ArrayList<String>expectedBranchOnesellTransactionsWeightB1 = new ArrayList<>(Arrays.asList("0 kg", "19 kg"));
	ArrayList<String>expectedBranchOnesellTransactionsBonusB1 = new ArrayList<>(Arrays.asList("0", "38", "38"));
	ArrayList<String>expectedOneBuyTransactionsWeightB1 = new ArrayList<>(Arrays.asList("19 kg", "19 kg"));
	ArrayList<String>expectedOneBuyTransactionsBonusB1 = new ArrayList<>(Arrays.asList("133", "38", "171"));
	
	ArrayList<String> actualBranchOnesellTransactionsWeightB1 = new ArrayList<>(); 
	ArrayList<String> actualBranchOnesellTransactionsBonusB1 = new ArrayList<>(); 
	
	ArrayList<String> actualBranchOneBuyTransactionsWeightB1 = new ArrayList<>(); 
	ArrayList<String> actualBranchOneBuyTransactionsBonusB1 = new ArrayList<>(); 

	
	wait.until(ExpectedConditions.elementToBeClickable(startApprovalButton));
	startApprovalButton.click();
	
	Thread.sleep(3000);
	wait.until(ExpectedConditions.elementToBeClickable(buyTransactionsButton));
	buyTransactionsButton.click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(sellTransactionsButton));
	sellTransactionsButton.click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOfAllElements(checkMarkButton));
	for(WebElement checkMarkButtons :checkMarkButton ) {
		 Actions actions = new Actions(alcDriver);
	     actions.moveToElement(checkMarkButtons).click().build().perform();	
	}
	
	Thread.sleep(3000);
	
//	sellTransactionsWeight

	for (WebElement element : sellTransactionsWeight) {
		actualBranchOnesellTransactionsWeightB1.add(element.getText());
	}
	
	for (WebElement element : sellTransactionsBonus) {
		actualBranchOnesellTransactionsBonusB1.add(element.getText());
	}
	
	Assert.assertEquals(actualBranchOnesellTransactionsWeightB1, expectedBranchOnesellTransactionsWeightB1);
	Assert.assertEquals(actualBranchOnesellTransactionsBonusB1, expectedBranchOnesellTransactionsBonusB1);
	
	  Thread.sleep(2000);
	    TakesScreenshot ts2 = (TakesScreenshot) alcDriver;
	    byte[] screenshot2 = ts2.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot2));
	    Thread.sleep(2000);
	    
    buyTransactionsButton.click();
    Thread.sleep(2000);
    Actions actions1 = new Actions(alcDriver);
    actions1.moveToElement(selectEquivalentCheckBox).click().build().perform();
   	 
    Thread.sleep(3000);
	
	for (WebElement element3 : sellTransactionsWeight) {
		actualBranchOneBuyTransactionsWeightB1.add(element3.getText());
	}
	
	for (WebElement element4 : sellTransactionsBonus) {
		actualBranchOneBuyTransactionsBonusB1.add(element4.getText());
	}
	
	Assert.assertEquals(actualBranchOneBuyTransactionsWeightB1, expectedOneBuyTransactionsWeightB1);
	Assert.assertEquals(actualBranchOneBuyTransactionsBonusB1, expectedOneBuyTransactionsBonusB1);

	 Actions actions2 = new Actions(alcDriver);
	 actions2.scrollToElement(payBonusButton).build().perform();
	   	 
	  Thread.sleep(2000);
	    TakesScreenshot ts3 = (TakesScreenshot) alcDriver;
	    byte[] screenshot3 = ts3.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot3", new ByteArrayInputStream(screenshot3));
	    Thread.sleep(2000);
	    
	wait.until(ExpectedConditions.elementToBeClickable(payBonusButton));
	payBonusButton.click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(confirmButton));
	confirmButton.click();
	
	wait.until(ExpectedConditions.visibilityOf(bonusPaidText));
	Actions actions = new Actions(alcDriver);
    actions.moveToElement(bonusNameLink).click().build().perform();	
	Thread.sleep(2000);
	bonusNameLink.click();
	
	wait.until(ExpectedConditions.visibilityOf(bonusApprovalButton));
	bonusApprovalButton.click();

}

public void bonusBranch2Verification() throws InterruptedException {
	
	WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));

	wait.until(ExpectedConditions.elementToBeClickable(branchButton.get(1)));
	branchButton.get(1).click();
	
	wait.until(ExpectedConditions.elementToBeClickable(verifyReceiptsButton));

	verifyReceiptsButton.click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(approveRecipt.get(0)));
	
	Set<String>expectedBranchTwoReciptKgB2 = new HashSet<>(Arrays.asList("PET- / 3.00 kg", "HDPE- / 4.00 kg", "Total Weight: 7.00 KG"));
	Set<String>expectedBranchTwoReciptBonusB2 = new HashSet<>(Arrays.asList("Bonus 6", "Bonus 8"));
	ArrayList<String>expectedBranchTwoReciptTotalBonusB2 = new ArrayList<>(Arrays.asList("14"));
	ArrayList<String>expectedBranchTwosellTransactionsWeightB2 = new ArrayList<>(Arrays.asList("0 kg", "7 kg"));
	ArrayList<String>expectedBranchTwosellTransactionsBonusB2 = new ArrayList<>(Arrays.asList("0", "14", "14"));
	
	Set<String> actualBranchTwoReciptKgB2 = new HashSet<>();   // branch Two all 3 kg values
	Set<String> actualBranchTwoReciptBonusB2 = new HashSet<>(); 
	ArrayList<String> actualBranchTwoReciptTotalBonusB2 = new ArrayList<>(); //1 value
	
	ArrayList<String> actualBranchTwosellTransactionsWeightB2 = new ArrayList<>(); 
	ArrayList<String> actualBranchTwosellTransactionsBonusB2 = new ArrayList<>(); 

	
	for (WebElement element11 : kgVerifyUnverifiedReciept) {
		actualBranchTwoReciptKgB2.add(element11.getText());
	}

	for (WebElement element22 : bonusVerifyUnverifiedReciept) {
		actualBranchTwoReciptBonusB2.add(element22.getText());
	}
	
	for (WebElement element : bonusBuyTotalValue) {
		actualBranchTwoReciptTotalBonusB2.add(element.getText());
	}
	Thread.sleep(2000);
	Assert.assertEquals(actualBranchTwoReciptKgB2, expectedBranchTwoReciptKgB2);
	Assert.assertEquals(actualBranchTwoReciptBonusB2, expectedBranchTwoReciptBonusB2);
	Assert.assertEquals(actualBranchTwoReciptTotalBonusB2, expectedBranchTwoReciptTotalBonusB2);
	  Thread.sleep(2000);
	    TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
	    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
	    Thread.sleep(2000);
	
	try {
			approveRecipt.get(0).click();
			Thread.sleep(2000);
			okButton.click();
			Thread.sleep(2000);
			
	} catch (Exception e) {
		System.out.println("Exception caught: " + e.getMessage());
	}


	wait.until(ExpectedConditions.elementToBeClickable(closeButton));
	closeButton.click();
	
	wait.until(ExpectedConditions.elementToBeClickable(startApprovalButton));
	startApprovalButton.click();
	
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOfAllElements(checkMarkButton));
	for(WebElement checkMarkButtons :checkMarkButton ) {
		 Actions actions = new Actions(alcDriver);
	     actions.moveToElement(checkMarkButtons).click().build().perform();		
	}
	
	for (WebElement element5 : sellTransactionsWeight) {
		actualBranchTwosellTransactionsWeightB2.add(element5.getText());
	}
	
	for (WebElement element6 : sellTransactionsBonus) {
		actualBranchTwosellTransactionsBonusB2.add(element6.getText());
	}
	Thread.sleep(2000);
	
	Assert.assertEquals(actualBranchTwosellTransactionsWeightB2, expectedBranchTwosellTransactionsWeightB2);
	Assert.assertEquals(actualBranchTwosellTransactionsBonusB2, expectedBranchTwosellTransactionsBonusB2);

	Actions actions2 = new Actions(alcDriver);
	 actions2.scrollToElement(payBonusButton).build().perform();
	   	 
	  Thread.sleep(2000);
	    TakesScreenshot ts2 = (TakesScreenshot) alcDriver;
	    byte[] screenshot2 = ts2.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot2", new ByteArrayInputStream(screenshot2));
	    Thread.sleep(2000);
	    
	wait.until(ExpectedConditions.elementToBeClickable(payBonusButton));
	payBonusButton.click();

	wait.until(ExpectedConditions.elementToBeClickable(confirmButton));
	confirmButton.click();


	wait.until(ExpectedConditions.visibilityOf(bonusPaidText));
	Actions actions = new Actions(alcDriver);
    actions.moveToElement(bonusNameLink).click().build().perform();	
	Thread.sleep(2000);
	bonusNameLink.click();
	Thread.sleep(4000);
	//wait.until(ExpectedConditions.invisibilityOf(pageLoader));
	bonusApprovalButton.click();

}
public void bonusBranch3Verification() throws InterruptedException {
	
	
	WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
	
	wait.until(ExpectedConditions.elementToBeClickable(branchButton.get(2)));
	branchButton.get(2).click();
	
	wait.until(ExpectedConditions.elementToBeClickable(verifyReceiptsButton));

	verifyReceiptsButton.click();
	Thread.sleep(3000);
	wait.until(ExpectedConditions.elementToBeClickable(approveRecipt.get(0)));
	
	Set<String>expectedBranchThreeReciptKgB3 = new HashSet<>(Arrays.asList("PET- / 1.00 kg", "HDPE- / 1.00 kg", "Total Weight: 2.00 KG"));
	ArrayList<String>expectedBranchThreeReciptBonusB3 = new ArrayList<>(Arrays.asList("Bonus 2", "Bonus 2"));
	ArrayList<String>expectedBranchThreeReciptTotalBonusB3 = new ArrayList<>(Arrays.asList("4"));
	ArrayList<String>expectedBranchThreesellTransactionsWeightB3 = new ArrayList<>(Arrays.asList("0 kg", "2 kg"));
	ArrayList<String>expectedBranchThreesellTransactionsBonusB3 = new ArrayList<>(Arrays.asList("0", "4", "4"));
	
	Set<String> actualBranchThreeReciptKgB3 = new HashSet<>();   // branch Two all 3 kg values
	ArrayList<String> actualBranchThreeReciptBonusB3 = new ArrayList<>(); 
	ArrayList<String> actualBranchThreeReciptTotalBonusB3 = new ArrayList<>(); //1 value
	
	ArrayList<String> actualBranchThreesellTransactionsWeightB3 = new ArrayList<>(); 
	ArrayList<String> actualBranchThreesellTransactionsBonusB3 = new ArrayList<>();  

	Thread.sleep(2000);
	for (WebElement element111 : kgVerifyUnverifiedReciept) {
		actualBranchThreeReciptKgB3.add(element111.getText());
}

	for (WebElement element222 : bonusVerifyUnverifiedReciept) {
		actualBranchThreeReciptBonusB3.add(element222.getText());
	}
	
	for (WebElement element : bonusBuyTotalValue) {
	actualBranchThreeReciptTotalBonusB3.add(element.getText());
	}
	Thread.sleep(2000);
	Assert.assertEquals(actualBranchThreeReciptKgB3, expectedBranchThreeReciptKgB3);
	Assert.assertEquals(actualBranchThreeReciptBonusB3, expectedBranchThreeReciptBonusB3);
	Assert.assertEquals(actualBranchThreeReciptTotalBonusB3, expectedBranchThreeReciptTotalBonusB3);
	  Thread.sleep(2000);
	    TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
	    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
	    Thread.sleep(2000);
	
		approveRecipt.get(0).click();
		Thread.sleep(2000);
		okButton.click();
		Thread.sleep(2000);
		

	wait.until(ExpectedConditions.elementToBeClickable(closeButton));
	closeButton.click();
	
	wait.until(ExpectedConditions.elementToBeClickable(startApprovalButton));
	startApprovalButton.click();
	Thread.sleep(3000);
	wait.until(ExpectedConditions.elementToBeClickable(buyTransactionsButton));
	buyTransactionsButton.click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(sellTransactionsButton));
	sellTransactionsButton.click();
	
	wait.until(ExpectedConditions.visibilityOfAllElements(checkMarkButton));
	
	for(WebElement checkMarkButtons :checkMarkButton ) {
	 Actions actions = new Actions(alcDriver);
     actions.moveToElement(checkMarkButtons).click().build().perform();	
	}
	
	for (WebElement element7 : sellTransactionsWeight) {
		actualBranchThreesellTransactionsWeightB3.add(element7.getText());
	}
	
	for (WebElement element8 : sellTransactionsBonus) {
		actualBranchThreesellTransactionsBonusB3.add(element8.getText());
	}
	Thread.sleep(2000);
	Assert.assertEquals(actualBranchThreesellTransactionsWeightB3, expectedBranchThreesellTransactionsWeightB3);
	Assert.assertEquals(actualBranchThreesellTransactionsBonusB3, expectedBranchThreesellTransactionsBonusB3);

	  Thread.sleep(2000);
	    TakesScreenshot ts2 = (TakesScreenshot) alcDriver;
	    byte[] screenshot2 = ts2.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot2));
	    Thread.sleep(2000);

	wait.until(ExpectedConditions.elementToBeClickable(payBonusButton));
	payBonusButton.click();

	wait.until(ExpectedConditions.elementToBeClickable(confirmButton));
	confirmButton.click();


	wait.until(ExpectedConditions.visibilityOf(bonusPaidText));
	Actions actions = new Actions(alcDriver);
    actions.moveToElement(bonusNameLink).click().build().perform();	
	Thread.sleep(2000);
	//wait.until(ExpectedConditions.visibilityOf(bonusNameLink));
	bonusNameLink.click();
	Thread.sleep(4000);
	
}



public void bonusBranch1ValueVerification() throws InterruptedException {
	
	WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(50));
	wait.until(ExpectedConditions.elementToBeClickable(bonusApprovalButton));
	bonusApprovalButton.click();
	wait.until(ExpectedConditions.elementToBeClickable(branchButton.get(0)));
	branchButton.get(0).click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(totalBonusTitle));
	
	ArrayList<String>expectedBonusApprovalTotalBonusArrayB1 =new ArrayList<>();
	expectedBonusApprovalTotalBonusArrayB1.add("100 %");
	expectedBonusApprovalTotalBonusArrayB1.add("1");
	expectedBonusApprovalTotalBonusArrayB1.add("19 KG");
	expectedBonusApprovalTotalBonusArrayB1.add("19 KG");
	expectedBonusApprovalTotalBonusArrayB1.add("133 = $1.33");
	expectedBonusApprovalTotalBonusArrayB1.add("38 = $0.38");
	
	
	ArrayList<String>expectedBonusApprovalNeedingApprovalArrayB1 =new ArrayList<>();
	expectedBonusApprovalNeedingApprovalArrayB1.add("0%");
	expectedBonusApprovalNeedingApprovalArrayB1.add("0");
	expectedBonusApprovalNeedingApprovalArrayB1.add("0 KG");//////////76-38
	expectedBonusApprovalNeedingApprovalArrayB1.add("0 KG");
	expectedBonusApprovalNeedingApprovalArrayB1.add("0 = $0.00");
	expectedBonusApprovalNeedingApprovalArrayB1.add("0 = $0.00");
	
	
	ArrayList<String> actualBonusApprovalTotalBonusArrayB1 = new ArrayList<>(); // branch one all 6 bonus values
	ArrayList<String> actualBonusApprovalNeedingApprovalArrayB1 = new ArrayList<>();
	
	for (WebElement element1 :bonusApprovalTotalBonusAssertion) {
		actualBonusApprovalTotalBonusArrayB1.add(element1.getText());
	}
	Assert.assertEquals(actualBonusApprovalTotalBonusArrayB1, expectedBonusApprovalTotalBonusArrayB1);
	
	for (WebElement element2 :bonusApprovalNeedingApprovalAssertion) {
		actualBonusApprovalNeedingApprovalArrayB1.add(element2.getText());
	}
	Assert.assertEquals(actualBonusApprovalNeedingApprovalArrayB1, expectedBonusApprovalNeedingApprovalArrayB1);
	
	  Thread.sleep(2000);
	    TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
	    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
	    Thread.sleep(2000);
	
	Set<String>expectedBranchOneAuditTrailBuyKgB1 = new HashSet<>(Arrays.asList("PET-Raw-Transparent / 9.00 kg", "HDPE-Clean-Clear / 10.00 kg", "Total Weight: 19.00 KG"));
	Set<String>expectedBranchOneAuditTrailBuyBonusB1 = new HashSet<>(Arrays.asList("Bonus 63", "Bonus 70"));
	ArrayList<String>expectedBranchOneAuditTrailBuyTotalBonusB1 = new ArrayList<>(Arrays.asList("133"));
	
	Set<String>expectedBranchOneAuditTrailSellKgB1 = new HashSet<>(Arrays.asList("HDPE-Clean-Clear / 6.00 kg", "PET-Raw-Transparent / 5.00 kg","Total Weight: 11.00 KG","PET-Raw-Transparent / 7.00 kg","HDPE-Clean-Clear / 8.00 kg","Total Weight: 15.00 KG"));
	Set<String>expectedBranchOneAuditTrailSellBonusB1 = new HashSet<>(Arrays.asList("Bonus 4", "Bonus 4","Bonus 14", "Bonus 16"));
	Set<String>expectedBranchOneAuditTrailSellTotalBonusB1 = new HashSet<>(Arrays.asList("8", "30"));
	
	
	Set<String> actualBranchOneAuditTrailBuyKgB1 = new HashSet<>();   // branch one all 6 bonus values
	Set<String> actualBranchOneAuditTrailBuyBonusB1 = new HashSet<>(); // view audit Buy Transactions all Kg values
	ArrayList<String> actualBranchOneAuditTrailBuyTotalBonusB1 = new ArrayList<>(); // view audit Buy Transactions bonus

	Set<String> actualBranchOneAuditTrailSellKgB1 = new HashSet<>(); //Sell Transactions all Kg value
	Set<String> actualBranchOneAuditTrailSellBonusB1 = new HashSet<>(); // view audit Buy Transactions bonus
	Set<String> actualBranchOneAuditTrailSellTotalBonusB1 = new HashSet<>(); // view audit Buy Transactions bonus


	viewAuditTrail.click();
	
	//Buy Transaction
	
	wait.until(ExpectedConditions.visibilityOf(kgTransactions.get(0)));
	for (WebElement ele : kgTransactions) {
		actualBranchOneAuditTrailBuyKgB1.add(ele.getText());
	}

	for (WebElement element : bonusBuyTransactions) {
		actualBranchOneAuditTrailBuyBonusB1.add(element.getText());
	}
	for (WebElement element : bonusBuyTotalValue) {
		actualBranchOneAuditTrailBuyTotalBonusB1.add(element.getText());
	}
	  Thread.sleep(2000);
	    TakesScreenshot ts2 = (TakesScreenshot) alcDriver;
	    byte[] screenshot2 = ts2.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot2", new ByteArrayInputStream(screenshot2));
	    Thread.sleep(2000);
	Assert.assertEquals(actualBranchOneAuditTrailBuyKgB1, expectedBranchOneAuditTrailBuyKgB1);
	Assert.assertEquals(actualBranchOneAuditTrailBuyBonusB1, expectedBranchOneAuditTrailBuyBonusB1);
	Assert.assertEquals(actualBranchOneAuditTrailBuyTotalBonusB1, expectedBranchOneAuditTrailBuyTotalBonusB1);
	
	wait.until(ExpectedConditions.elementToBeClickable(sellTransactionsTagAuditTrail));
	
	sellTransactionsTagAuditTrail.click();
	Thread.sleep(2000);
	
	wait.until(ExpectedConditions.visibilityOf(kgTransactions.get(0)));
	for (WebElement ele : kgTransactions) {
		actualBranchOneAuditTrailSellKgB1.add(ele.getText());
	}

	for (WebElement element : bonusBuyTransactions) {
		actualBranchOneAuditTrailSellBonusB1.add(element.getText());
	}
	for (WebElement element : bonusBuyTotalValue) {
		actualBranchOneAuditTrailSellTotalBonusB1.add(element.getText());
	}
	  Thread.sleep(2000);
	    TakesScreenshot ts3 = (TakesScreenshot) alcDriver;
	    byte[] screenshot3 = ts3.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot3", new ByteArrayInputStream(screenshot3));
	    Thread.sleep(2000);
	Assert.assertEquals(actualBranchOneAuditTrailSellKgB1, expectedBranchOneAuditTrailSellKgB1);
	Assert.assertEquals(actualBranchOneAuditTrailSellBonusB1, expectedBranchOneAuditTrailSellBonusB1);
	Assert.assertEquals(actualBranchOneAuditTrailSellTotalBonusB1, expectedBranchOneAuditTrailSellTotalBonusB1);
	
	Thread.sleep(1000);
	wait.until(ExpectedConditions.elementToBeClickable(closeButton));
	closeButton.click();
	wait.until(ExpectedConditions.elementToBeClickable(branchButton.get(0)));
	branchButton.get(0).click();
	Thread.sleep(1000);
	
}

public void bonusBranch2ValueVerification() throws InterruptedException {
		
	WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.elementToBeClickable(branchButton.get(1)));
	branchButton.get(1).click();
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOf(totalBonusTitle));
	
	ArrayList<String>expectedBonusApprovalTotalBonusArrayB2 =new ArrayList<>();
	expectedBonusApprovalTotalBonusArrayB2.add("214.29 %");
	expectedBonusApprovalTotalBonusArrayB2.add("0");
	expectedBonusApprovalTotalBonusArrayB2.add("15 KG");
	expectedBonusApprovalTotalBonusArrayB2.add("7 KG");
	expectedBonusApprovalTotalBonusArrayB2.add("0 = $0.00");
	expectedBonusApprovalTotalBonusArrayB2.add("14 = $0.14");
	
	
	ArrayList<String>expectedBonusApprovalNeedingApprovalArrayB2 =new ArrayList<>();
	expectedBonusApprovalNeedingApprovalArrayB2.add("0%");
	expectedBonusApprovalNeedingApprovalArrayB2.add("0");
	expectedBonusApprovalNeedingApprovalArrayB2.add("0 KG");
	expectedBonusApprovalNeedingApprovalArrayB2.add("0 KG");
	expectedBonusApprovalNeedingApprovalArrayB2.add("0 = $0.00");
	expectedBonusApprovalNeedingApprovalArrayB2.add("0 = $0.00");
	
	
	ArrayList<String> actualBonusApprovalTotalBonusArrayB2 = new ArrayList<>(); // branch one all 6 bonus values
	ArrayList<String> actualBonusApprovalNeedingApprovalArrayB2 = new ArrayList<>();
	for (WebElement element1 :bonusApprovalTotalBonusAssertion) {
		actualBonusApprovalTotalBonusArrayB2.add(element1.getText());
	}
	Assert.assertEquals(actualBonusApprovalTotalBonusArrayB2, expectedBonusApprovalTotalBonusArrayB2);
	
	for (WebElement element2 :bonusApprovalNeedingApprovalAssertion) {
		actualBonusApprovalNeedingApprovalArrayB2.add(element2.getText());
	}
	Thread.sleep(2000);
	Assert.assertEquals(actualBonusApprovalNeedingApprovalArrayB2, expectedBonusApprovalNeedingApprovalArrayB2);
	    Thread.sleep(2000);
	    TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
	    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
	    Thread.sleep(2000);

	Set<String>expectedBranchOneAuditTrailSellKgB2 = new HashSet<>(Arrays.asList("PET-Raw-Transparent / 3.00 kg", "HDPE-Clean-Clear / 4.00 kg","Total Weight: 7.00 KG"));
	Set<String>expectedBranchOneAuditTrailSellBonusB2 = new HashSet<>(Arrays.asList("Bonus 6", "Bonus 8"));
	ArrayList<String>expectedBranchOneAuditTrailSellTotalBonusB2 = new ArrayList<>(Arrays.asList("14"));
	

	Set<String> actualBranchOneAuditTrailSellKgB2 = new HashSet<>(); //Sell Transactions all Kg value
	Set<String> actualBranchOneAuditTrailSellBonusB2 = new HashSet<>(); // view audit Buy Transactions bonus
	ArrayList<String> actualBranchOneAuditTrailSellTotalBonusB2 = new ArrayList<>(); // view audit Buy Transactions bonus


	viewAuditTrail.click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(sellTransactionsTagAuditTrail));
	sellTransactionsTagAuditTrail.click();
	
	wait.until(ExpectedConditions.visibilityOf(kgTransactions.get(0)));
	for (WebElement ele : kgTransactions) {
		actualBranchOneAuditTrailSellKgB2.add(ele.getText());
	}

	for (WebElement element : bonusBuyTransactions) {
		actualBranchOneAuditTrailSellBonusB2.add(element.getText());
	}
	for (WebElement element : bonusBuyTotalValue) {
		actualBranchOneAuditTrailSellTotalBonusB2.add(element.getText());
	}
	Thread.sleep(2000);
	
	Assert.assertEquals(actualBranchOneAuditTrailSellKgB2, expectedBranchOneAuditTrailSellKgB2);
	Assert.assertEquals(actualBranchOneAuditTrailSellBonusB2, expectedBranchOneAuditTrailSellBonusB2);
	Assert.assertEquals(actualBranchOneAuditTrailSellTotalBonusB2, expectedBranchOneAuditTrailSellTotalBonusB2);
	  Thread.sleep(2000);
	    TakesScreenshot ts2 = (TakesScreenshot) alcDriver;
	    byte[] screenshot2 = ts2.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot2", new ByteArrayInputStream(screenshot2));
	    Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(closeButton));
	closeButton.click();
	wait.until(ExpectedConditions.elementToBeClickable(branchButton.get(1)));
	branchButton.get(1).click();
	Thread.sleep(1000);

}

public void bonusBranch3ValueVerification() throws InterruptedException {
	

	WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));

	wait.until(ExpectedConditions.elementToBeClickable(branchButton.get(0)));
	branchButton.get(2).click();
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOf(totalBonusTitle));
	
	ArrayList<String>expectedBonusApprovalTotalBonusArrayB3 =new ArrayList<>();
	expectedBonusApprovalTotalBonusArrayB3.add("200 %");
	expectedBonusApprovalTotalBonusArrayB3.add("0");
	expectedBonusApprovalTotalBonusArrayB3.add("4 KG");
	expectedBonusApprovalTotalBonusArrayB3.add("2 KG");
	expectedBonusApprovalTotalBonusArrayB3.add("0 = $0.00");
	expectedBonusApprovalTotalBonusArrayB3.add("4 = $0.04");
	
	
	ArrayList<String>expectedBonusApprovalNeedingApprovalArrayB3 =new ArrayList<>();
	expectedBonusApprovalNeedingApprovalArrayB3.add("0%");
	expectedBonusApprovalNeedingApprovalArrayB3.add("0");
	expectedBonusApprovalNeedingApprovalArrayB3.add("0 KG");
	expectedBonusApprovalNeedingApprovalArrayB3.add("0 KG");
	expectedBonusApprovalNeedingApprovalArrayB3.add("0 = $0.00");
	expectedBonusApprovalNeedingApprovalArrayB3.add("0 = $0.00");
	
	
	ArrayList<String> actualBonusApprovalTotalBonusArrayB3 = new ArrayList<>(); // branch one all 6 bonus values
	ArrayList<String> actualBonusApprovalNeedingApprovalArrayB3 = new ArrayList<>();
	
	for (WebElement element1 :bonusApprovalTotalBonusAssertion) {
		actualBonusApprovalTotalBonusArrayB3.add(element1.getText());
	}
	Assert.assertEquals(actualBonusApprovalTotalBonusArrayB3, expectedBonusApprovalTotalBonusArrayB3);
	
	for (WebElement element2 :bonusApprovalNeedingApprovalAssertion) {
		actualBonusApprovalNeedingApprovalArrayB3.add(element2.getText());
	}
	Thread.sleep(2000);
	Assert.assertEquals(actualBonusApprovalNeedingApprovalArrayB3, expectedBonusApprovalNeedingApprovalArrayB3);
	
	  Thread.sleep(2000);
	    TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
	    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
	    Thread.sleep(2000);
	
	Set<String>expectedBranchOneAuditTrailSellKgB3 = new HashSet<>(Arrays.asList("PET-Raw-Transparent / 1.00 kg", "HDPE-Clean-Clear / 1.00 kg","Total Weight: 2.00 KG"));
	ArrayList<String>expectedBranchOneAuditTrailSellBonusB3 = new ArrayList<>(Arrays.asList("Bonus 2", "Bonus 2"));
	ArrayList<String>expectedBranchOneAuditTrailSellTotalBonusB3 = new ArrayList<>(Arrays.asList("4"));
	
	Set<String> actualBranchOneAuditTrailSellKgB3 = new HashSet<>(); //Sell Transactions all Kg value
	ArrayList<String> actualBranchOneAuditTrailSellBonusB3 = new ArrayList<>(); // view audit Buy Transactions bonus
	ArrayList<String> actualBranchOneAuditTrailSellTotalBonusB3 = new ArrayList<>(); // view audit Buy Transactions bonus


	viewAuditTrail.click();
	
	Thread.sleep(2000);
	
	sellTransactionsTagAuditTrail.click();
	
	wait.until(ExpectedConditions.visibilityOf(kgTransactions.get(0)));
	for (WebElement ele : kgTransactions) {
		actualBranchOneAuditTrailSellKgB3.add(ele.getText());
	}

	for (WebElement element : bonusBuyTransactions) {
		actualBranchOneAuditTrailSellBonusB3.add(element.getText());
	}
	for (WebElement element : bonusBuyTotalValue) {
		actualBranchOneAuditTrailSellTotalBonusB3.add(element.getText());
	}
	  Thread.sleep(2000);
	    TakesScreenshot ts2 = (TakesScreenshot) alcDriver;
	    byte[] screenshot2 = ts2.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot2", new ByteArrayInputStream(screenshot2));
	    Thread.sleep(2000);
	
	Assert.assertEquals(actualBranchOneAuditTrailSellKgB3, expectedBranchOneAuditTrailSellKgB3);
	Assert.assertEquals(actualBranchOneAuditTrailSellBonusB3, expectedBranchOneAuditTrailSellBonusB3);
	Assert.assertEquals(actualBranchOneAuditTrailSellTotalBonusB3, expectedBranchOneAuditTrailSellTotalBonusB3);
	
	Thread.sleep(1000);
	wait.until(ExpectedConditions.elementToBeClickable(closeButton));
	closeButton.click();
	wait.until(ExpectedConditions.elementToBeClickable(branchButton.get(2)));
	branchButton.get(2).click();
	Thread.sleep(1000);
	
}

public void processor1ValueVerification() throws InterruptedException {
	
	
	WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.elementToBeClickable(branchButton.get(3)));
	branchButton.get(3).click();
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOf(totalBonusTitle));
	
	ArrayList<String>expectedBonusApprovalTotalBonusArrayP1 =new ArrayList<>();
	expectedBonusApprovalTotalBonusArrayP1.add("0 %");
	expectedBonusApprovalTotalBonusArrayP1.add("0");
	expectedBonusApprovalTotalBonusArrayP1.add("9 KG");
	expectedBonusApprovalTotalBonusArrayP1.add("0 KG");
	expectedBonusApprovalTotalBonusArrayP1.add("0 = $0.00");
	expectedBonusApprovalTotalBonusArrayP1.add("0 = $0.00");
	
	
	ArrayList<String>expectedBonusApprovalNeedingApprovalArrayP1 =new ArrayList<>();
	expectedBonusApprovalNeedingApprovalArrayP1.add("0%");
	expectedBonusApprovalNeedingApprovalArrayP1.add("0");
	expectedBonusApprovalNeedingApprovalArrayP1.add("0 KG");
	expectedBonusApprovalNeedingApprovalArrayP1.add("0 KG");
	expectedBonusApprovalNeedingApprovalArrayP1.add("0 = $0.00");
	expectedBonusApprovalNeedingApprovalArrayP1.add("0 = $0.00");
	
	
	ArrayList<String> actualBonusApprovalTotalBonusArrayP1 = new ArrayList<>(); // branch one all 6 bonus values
	ArrayList<String> actualBonusApprovalNeedingApprovalArrayP1 = new ArrayList<>();
	
	for (WebElement element1 :bonusApprovalTotalBonusAssertion) {
		actualBonusApprovalTotalBonusArrayP1.add(element1.getText());
	}
	Assert.assertEquals(actualBonusApprovalTotalBonusArrayP1, expectedBonusApprovalTotalBonusArrayP1);
	
	for (WebElement element2 :bonusApprovalNeedingApprovalAssertion) {
		actualBonusApprovalNeedingApprovalArrayP1.add(element2.getText());
	}
	Thread.sleep(2000);
	Assert.assertEquals(actualBonusApprovalNeedingApprovalArrayP1, expectedBonusApprovalNeedingApprovalArrayP1);
	  Thread.sleep(2000);
	    TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
	    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
	    Thread.sleep(2000);
	
	wait.until(ExpectedConditions.elementToBeClickable(branchButton.get(3)));
	branchButton.get(3).click();
	Thread.sleep(3000);

}

public void bonusVerifyInBonusApproval(String Name) throws InterruptedException {
	
	clickOrdersTab();
	clickBounsTab();
	search_byName(Name);
	clickSpecificOrdersBonus();
	
	WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
	wait.until(ExpectedConditions.elementToBeClickable(bonusApprovalButton));
	bonusApprovalButton.click();
	wait.until(ExpectedConditions.elementToBeClickable(branchButton.get(0)));
	branchButton.get(0).click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(startApprovalButton));
	startApprovalButton.click();
	
	  Thread.sleep(3000);
	    TakesScreenshot ts2 = (TakesScreenshot) alcDriver;
	    byte[] screenshot2 = ts2.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot2));
	    Thread.sleep(2000);
	    ArrayList<String> approvedText = new ArrayList<>(); // branch one all 6 bonus values
		ArrayList<String>expectedApproved = new ArrayList<>(Arrays.asList("Approved", "Approved"));

	for (WebElement element : approvedTextInBonusApproval) {
		approvedText.add(element.getText());
	}
	
	Assert.assertEquals(approvedText, expectedApproved);
	
}

public void bonusApproval(String Name) throws InterruptedException {

	clickOrdersTab();
	clickBounsTab();
	search_byName(Name);
	clickSpecificOrdersBonus();
	
	WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
	wait.until(ExpectedConditions.elementToBeClickable(bonusApprovalButton));
	bonusApprovalButton.click();
	wait.until(ExpectedConditions.elementToBeClickable(branchButton.get(0)));
	branchButton.get(0).click();
	

	wait.until(ExpectedConditions.elementToBeClickable(verifyReceiptsButton));
	verifyReceiptsButton.click();

	// for all receipts
	try {
		for (int i = 1; i <= 3; i++) {
			approveRecipt.get(0).click();
			Thread.sleep(2000);
			okButton.click();
			Thread.sleep(2000);
		}
	} catch (Exception e) {
		System.out.println("Exception caught: " + e.getMessage());
	}


	wait.until(ExpectedConditions.elementToBeClickable(closeButton));
	closeButton.click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(startApprovalButton));
	startApprovalButton.click();

	Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(buyTransactionsButton));
	buyTransactionsButton.click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(sellTransactionsButton));
	sellTransactionsButton.click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOfAllElements(checkMarkButton));
	for(WebElement checkMarkButtons :checkMarkButton ) {
		 Actions actions = new Actions(alcDriver);
	     actions.moveToElement(checkMarkButtons).click().build().perform();	
	}
	
	Thread.sleep(2000);
	    
    buyTransactionsButton.click();
    Thread.sleep(2000);
    Actions actions1 = new Actions(alcDriver);
    actions1.moveToElement(selectEquivalentCheckBox).click().build().perform();
   	 
	  Thread.sleep(1000);
	  
	    
	wait.until(ExpectedConditions.elementToBeClickable(payBonusButton));
	payBonusButton.click();

	wait.until(ExpectedConditions.elementToBeClickable(confirmButton));
	confirmButton.click();

	Thread.sleep(2000);
    TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
    Thread.sleep(2000);

	wait.until(ExpectedConditions.visibilityOf(bonusPaidText));
	Actions actions = new Actions(alcDriver);
    actions.moveToElement(bonusNameLink).click().build().perform();	
	Thread.sleep(2000);
	
}
public void payBonus1711() throws InterruptedException {
	
	alcDriver.get("https://"+actual+"/#/admin/ordersoffsets/offset/"+Data.bonusOrderId1711);
	
	
	
	WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
	wait.until(ExpectedConditions.elementToBeClickable(bonusApprovalButton));
	bonusApprovalButton.click();
	wait.until(ExpectedConditions.elementToBeClickable(branchButton.get(0)));
	branchButton.get(0).click();
	
	Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(startApprovalButton));
	startApprovalButton.click();

	Thread.sleep(3000);
	wait.until(ExpectedConditions.elementToBeClickable(buyTransactionsButton));
	buyTransactionsButton.click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(sellTransactionsButton));
	sellTransactionsButton.click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOfAllElements(checkMarkButton));
	for(WebElement checkMarkButtons :checkMarkButton ) {
		 Actions actions = new Actions(alcDriver);
	     actions.moveToElement(checkMarkButtons).click().build().perform();	
	}
	
	Thread.sleep(2000);
	    
    buyTransactionsButton.click();
    Thread.sleep(2000);
    for(WebElement checkMarkButtons :checkMarkButton ) {
		 Actions actions = new Actions(alcDriver);
	     actions.moveToElement(checkMarkButtons).click().build().perform();	
	}
	  Thread.sleep(1000);
	  
	    
	wait.until(ExpectedConditions.elementToBeClickable(payBonusButton));
	payBonusButton.click();

	wait.until(ExpectedConditions.elementToBeClickable(confirmButton));
	confirmButton.click();

	Thread.sleep(2000);
    TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
    Allure.addAttachment("Bonus Paid Screenshot", new ByteArrayInputStream(screenshot1));
    Thread.sleep(2000);

	wait.until(ExpectedConditions.visibilityOf(bonusPaidText));
	Actions actions = new Actions(alcDriver);
    actions.moveToElement(bonusNameLink).click().build().perform();	
	Thread.sleep(2000);
	bonusNameLink.click();
	Thread.sleep(3000);
	bonusApprovalButton.click();
	
	
	wait.until(ExpectedConditions.elementToBeClickable(bonusApprovalButton));
	bonusApprovalButton.click();
	wait.until(ExpectedConditions.elementToBeClickable(branchButton.get(0)));
	branchButton.get(1).click();
	
	Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(startApprovalButton));
	startApprovalButton.click();
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOfAllElements(checkMarkButton));
	for(WebElement checkMarkButtons :checkMarkButton ) {
		 Actions actions2 = new Actions(alcDriver);
	     actions2.moveToElement(checkMarkButtons).click().build().perform();	
	}
	
	Thread.sleep(2000);
	    
	wait.until(ExpectedConditions.elementToBeClickable(payBonusButton));
	payBonusButton.click();
	Thread.sleep(1000);
	wait.until(ExpectedConditions.elementToBeClickable(confirmButton));
	confirmButton.click();

	wait.until(ExpectedConditions.visibilityOf(bonusPaidText));
	Actions actions3 = new Actions(alcDriver);
    actions3.moveToElement(bonusNameLink).click().build().perform();	
	Thread.sleep(2000);
	bonusNameLink.click();

//
//
//	wait.until(ExpectedConditions.elementToBeClickable(bonusApprovalButton));
//	bonusApprovalButton.click();

	
}

public void verifyBonusApprovalData(int n,String kgCollected, String kgSold) throws InterruptedException {

	WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.elementToBeClickable(branchButton.get(n)));
	branchButton.get(n).click();
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOf(totalBonusTitle));

	ArrayList<String>expectedKgCollectedAndSold =new ArrayList<>();

	expectedKgCollectedAndSold.add(kgCollected);
	expectedKgCollectedAndSold.add(kgSold);


	ArrayList<String> actualKgCollectedAndSold = new ArrayList<>(); // branch one all 6 bonus values

	for (WebElement element1 :totalKgCollectedAndSold) {
		actualKgCollectedAndSold.add(element1.getText());
	}
	Assert.assertEquals(actualKgCollectedAndSold, expectedKgCollectedAndSold);

	Thread.sleep(2000);

	Actions action =new Actions(alcDriver);
	action.scrollToElement(viewAuditTrail).build().perform();
	Thread.sleep(1000);
	TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
	byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
	Allure.addAttachment("Bonus In Bonus Approval", new ByteArrayInputStream(screenshot1));
	Thread.sleep(2000);

	wait.until(ExpectedConditions.elementToBeClickable(branchButton.get(n)));
	branchButton.get(n).click();
	Thread.sleep(3000);



}


public void bonusTransfer(String bonusId,String transferBonusName,String processorName) throws InterruptedException {

	alcDriver.get("https://"+actual+"/#/admin/ordersoffsets/offset/"+bonusId);
	alcDriver.navigate().refresh();

	WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));

	wait.until(ExpectedConditions.visibilityOf(bonusProgress));
	Thread.sleep(3000);
	String bonusProgressText1=bonusProgress.getText();
	Thread.sleep(2000);

	TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
	byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
	Allure.addAttachment("Bonus In Summary Before Data Transfer ", new ByteArrayInputStream(screenshot1));
	Thread.sleep(2000);

	String[] numericValue1 = bonusProgressText1.split(" ");
	int bonusProgressInSummary1 = Integer.parseInt(numericValue1[0]);
	System.out.println(bonusProgressInSummary1);


	bonusApprovalButton.click();
	verifyBonusApprovalData(0,"40 KG","40 KG");
	verifyBonusApprovalData(1,"40 KG","40 KG");


	wait.until(ExpectedConditions.elementToBeClickable(exchangeHistoryTab));
	exchangeHistoryTab.click();
	wait.until(ExpectedConditions.elementToBeClickable(dataTransferButton));
	dataTransferButton.click();
	Thread.sleep(3000);
	Actions action= new Actions(alcDriver);
	action.moveToElement(excludeMemPenBonus).click().build().perform();
	Thread.sleep(2000);
	includeProcessorTextField.sendKeys(processorName);
	Thread.sleep(2000);
	//Actions action= new Actions(alcDriver);
	action.moveToElement(checkMark.get(0)).click().build().perform();
	//checkMark.get(1).click();
	Thread.sleep(2000);
	confirmDataTransferButton.click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(noCheckBox));
	Actions action1= new Actions(alcDriver);
	action1.moveToElement(noCheckBox).click().build().perform();
	//noCheckBox.click();
	searchOffsetFeild.sendKeys(transferBonusName);
	searchButton.click();
	wait.until(ExpectedConditions.elementToBeClickable(offsetResult));
	offsetResult.click();
	confirmButton.click();
	wait.until(ExpectedConditions.elementToBeClickable(okButton));
	okButton.click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(closeButton));
	closeButton.click();

	Thread.sleep(3000);

	action.moveToElement(excludeMemPenBonus).click().build().perform();

	//action.scrollToElement(lastItemOnPage).build().perform();

	try{
		alcDriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

		totalWeight40.isDisplayed();

	}catch (Exception e){
		System.out.println("Transfered transaction is not Present ");
		alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}


	summaryTab.click();

	wait.until(ExpectedConditions.visibilityOf(bonusProgress));
	Thread.sleep(3000);
	String bonusProgressText2=bonusProgress.getText();
	Thread.sleep(2000);

	TakesScreenshot ts2 = (TakesScreenshot) alcDriver;
	byte[] screenshot2 = ts2.getScreenshotAs(OutputType.BYTES);
	Allure.addAttachment("Bonus In Summary After Data Transfer ", new ByteArrayInputStream(screenshot2));
	Thread.sleep(2000);

	String[] numericValue2 = bonusProgressText2.split(" ");
	int bonusProgressInSummary2 = Integer.parseInt(numericValue2[0]);

	System.out.println(bonusProgressInSummary2);

	alcDriver.navigate().refresh();
	bonusApprovalButton.click();

	verifyBonusApprovalData(0,"0 KG","0 KG");
	verifyBonusApprovalData(1,"0 KG","0 KG");


}
public void bonusTransferVerify(String bonusId) throws InterruptedException {

	alcDriver.get("https://"+actual+"/#/admin/ordersoffsets/offset/"+bonusId);
	alcDriver.navigate().refresh();

	WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));

	wait.until(ExpectedConditions.visibilityOf(bonusProgress));
	Thread.sleep(3000);
	String bonusProgressText1=bonusProgress.getText();
	Thread.sleep(2000);

	TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
	byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
	Allure.addAttachment("Bonus In Summary", new ByteArrayInputStream(screenshot1));
	Thread.sleep(2000);

	String[] numericValue1 = bonusProgressText1.split(" ");
	int bonusProgressInSummary1 = Integer.parseInt(numericValue1[0]);
	System.out.println(bonusProgressInSummary1);

	wait.until(ExpectedConditions.elementToBeClickable(exchangeHistoryTab));
	exchangeHistoryTab.click();

	try{
		WebDriverWait wait2 = new WebDriverWait(alcDriver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.visibilityOf(totalWeight40));
		System.out.println("Transfered transaction is Present ");

	}catch (Exception e){
		System.out.println("Transfered transaction is not Present ");
	}

	bonusApprovalButton.click();
	verifyBonusApprovalData(0,"40 KG","40 KG");
	verifyBonusApprovalData(1,"40 KG","40 KG");


}

public void branchExchangeBonusTransfer(String branchId,int transactionNumber,String expectedBonus) throws InterruptedException {

	alcDriver.get("https://" + actual + "/#/admin/collectionpoint/" + branchId);
	alcDriver.navigate().refresh();

	exchangeHistoryTabInBranches.click();
	Thread.sleep(3000);

	Actions action = new Actions(alcDriver);
	action.scrollToElement(lastItemOnPage).build().perform();

	TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
	byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
	Allure.addAttachment("ScreenShot of Transactions in Branch Exchange History", new ByteArrayInputStream(screenshot1));
	Thread.sleep(2000);

	for (int i = transactionNumber; i <= transactionNumber + 1; i++) {

		transactions.get(i).click();
		Thread.sleep(3000);
		String actualBonus = associatedBonus.getText();
		Thread.sleep(2000);

		Assert.assertEquals(actualBonus, expectedBonus);

		transactions.get(transactionNumber).click();
	}
}

	public void processorExchangeBonusTransfer(String processorId,int transactionNumber,String expectedBonus) throws InterruptedException {

		alcDriver.get("https://" + actual + "/#/admin/recyclingcenter/" + processorId);

		alcDriver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));

		wait.until(ExpectedConditions.visibilityOf(exchangeHistoryTabInBranches));

		exchangeHistoryTabInBranches.click();

		Thread.sleep(3000);

		Actions action = new Actions(alcDriver);
		action.scrollToElement(lastItemOnPage).build().perform();
		Thread.sleep(2000);

		TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
		byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
		Allure.addAttachment("Transactions In Processor Exchange History", new ByteArrayInputStream(screenshot1));
		Thread.sleep(2000);



		for (int i = 0; i < 1; i++) {

			transactions.get(i).click();
			Thread.sleep(3000);
			String actualBonus = associatedBonus.getText();

			Thread.sleep(2000);

			Assert.assertEquals(actualBonus, expectedBonus);

			transactions.get(i).click();
		}
	}

	public void bonusTransfer2(String bonusId, String processorName) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));

//		wait.until(ExpectedConditions.visibilityOf(dashBoard));
//		dashBoard.click();
//		wait.until(ExpectedConditions.visibilityOf(membersByCountry));

		alcDriver.get("https://"+actual+"/#/admin/ordersoffsets/offset/"+bonusId);
		alcDriver.navigate().refresh();

		wait.until(ExpectedConditions.visibilityOf(bonusProgress));
		Thread.sleep(3000);
		String bonusProgressText1=bonusProgress.getText();
		Thread.sleep(2000);

		String[] numericValue1 = bonusProgressText1.split(" ");
		int bonusProgressInSummary1 = Integer.parseInt(numericValue1[0]);
		System.out.println(bonusProgressInSummary1);


		bonusApprovalButton.click();

		verifyBonusApprovalData(0,"176.4 KG","176.4 KG");
		verifyBonusApprovalData(1,"176.4 KG","110.7 KG");


		wait.until(ExpectedConditions.elementToBeClickable(exchangeHistoryTab));
		exchangeHistoryTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(dataTransferButton));
		dataTransferButton.click();
		Thread.sleep(3000);
		Actions action= new Actions(alcDriver);
		//action.moveToElement(excludeMemPenBonus).click().build().perform();
		//Thread.sleep(3000);
		//includeProcessorTextField.sendKeys(processorName);
		Thread.sleep(2000);

		//wait.until(ExpectedConditions.elementToBeClickable(checkMark50));

		action.moveToElement(checkMark50).click().build().perform();
		Thread.sleep(3000);
		action.moveToElement(checkMark33).click().build().perform();


		Thread.sleep(4000);
		confirmDataTransferButton.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(searchOffsetNameFeild));
		System.out.println(bonusName1134);
		System.out.println(bonusName1134);
		searchOffsetNameFeild.sendKeys(bonusName1134);
		Thread.sleep(3000);
		confirmButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(okButton));
		okButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(closeButton));
		closeButton.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(exchangeHistoryTab));
		alcDriver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(exchangeHistoryTab));
		exchangeHistoryTab.click();

		Thread.sleep(3000);

		action.moveToElement(excludeMemPenBonus).click().build().perform();

		//action.scrollToElement(lastItemOnPage).build().perform();

		try{
			alcDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			totalWeight50.isDisplayed();
			totalWeight33.isDisplayed();

		}catch (Exception e){

			totalWeight22.isDisplayed();
			totalWeight70.isDisplayed();
			System.out.println("Non Transfered transaction are Present ");
			System.out.println("Transfered transaction is not Present ");
			alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}


		summaryTab.click();

		wait.until(ExpectedConditions.visibilityOf(bonusProgress));
		Thread.sleep(3000);
		String bonusProgressText2=bonusProgress.getText();
		Thread.sleep(2000);

		String[] numericValue2 = bonusProgressText2.split(" ");
		int bonusProgressInSummary2 = Integer.parseInt(numericValue2[0]);

		System.out.println(bonusProgressInSummary2);

		bonusApprovalButton.click();
		verifyBonusApprovalData(0,"92.6 KG","92.6 KG");
		//verifyBonusApprovalData(1,"92.6 KG","60.7 KG");


	}

	public void bonusTransferVerify2() throws InterruptedException {


		clickOrdersTab();
		clickBounsTab();
		search_byName(bonusName1134);
		clickSpecificOrdersBonus();

		WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));

		wait.until(ExpectedConditions.visibilityOf(bonusProgress));
		Thread.sleep(3000);
		String bonusProgressText1=bonusProgress.getText();
		Thread.sleep(2000);


		TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
		byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
		Allure.addAttachment("Bonus Summary ", new ByteArrayInputStream(screenshot1));
		Thread.sleep(2000);

		String[] numericValue1 = bonusProgressText1.split(" ");
		int bonusProgressInSummary1 = Integer.parseInt(numericValue1[0]);
		System.out.println(bonusProgressInSummary1);

		wait.until(ExpectedConditions.elementToBeClickable(exchangeHistoryTab));
		exchangeHistoryTab.click();

		try{
			WebDriverWait wait2 = new WebDriverWait(alcDriver, Duration.ofSeconds(10));
			totalWeight50.isDisplayed();
			totalWeight33.isDisplayed();
			System.out.println("Transfered transaction is Present ");

		}catch (Exception e){
			System.out.println("Transfered transaction is not Present ");
		}

		bonusApprovalButton.click();
		verifyBonusApprovalData(0,"83.8 KG","83.8 KG");
		verifyBonusApprovalData(1,"83.8 KG","50 KG");


	}

	public void bonusOrdertransfer(String bonus1Id,String bonus2Name,String expectedBonusProgressBeforeTransfer,List<String>expectedTotalKgCollectedAndSoldBeforeTransfer,String expectedTotalWeightBeforeTransfer,String expectedBonusProgressAfterTransfer,List<String>expectedTotalKgCollectedAndSoldAfterTransfer,String branchName,String category,String type,String kgLimit) throws InterruptedException {


		WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));

		alcDriver.get("https://"+actual+"/#/admin/ordersoffsets/offset/"+bonus1Id);
		alcDriver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOf(bonusProgress));
		Thread.sleep(4000);
		actualBonusProgressBeforeTransfer=bonusProgress.getText();
		System.out.println("actualBonusProgressBeforeTransfer :"+actualBonusProgressBeforeTransfer );
		Assert.assertEquals(actualBonusProgressBeforeTransfer,expectedBonusProgressBeforeTransfer);

		TakesScreenshot ts2 = (TakesScreenshot) alcDriver;
		byte[] screenshot2 = ts2.getScreenshotAs(OutputType.BYTES);
		Allure.addAttachment("Bonus In Summary Before Data Transfer ", new ByteArrayInputStream(screenshot2));
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(exchangeHistoryTab));
		bonusApprovalButton.click();
		branchButton.get(0).click();
		wait.until(ExpectedConditions.visibilityOf(totalKgCollectedAndSold.get(0)));
		Actions action = new Actions(alcDriver);
		action.scrollToElement(totalKgCollectedAndSold.get(0)).build().perform();
		for(WebElement ele : totalKgCollectedAndSold){

			actualTotalKgCollectedAndSoldBeforeTransfer.add(ele.getText());
			Thread.sleep(2000);
			byte[] screenshot4 = ts2.getScreenshotAs(OutputType.BYTES);
			Allure.addAttachment("Total Kg Collected And Sold Before Transfer ", new ByteArrayInputStream(screenshot4));
			Thread.sleep(2000);
		}
		System.out.println("actualTotalKgCollectedAndSoldBeforeTransfer :"+actualTotalKgCollectedAndSoldBeforeTransfer );

		Assert.assertEquals(actualTotalKgCollectedAndSoldBeforeTransfer,expectedTotalKgCollectedAndSoldBeforeTransfer);
		Thread.sleep(2000);
		exchangeHistoryTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(dataTransferButton));
		Thread.sleep(2000);
		action.scrollToElement(plasticChainDropdown.get(0)).build().perform();
		plasticChainDropdown.get(0).click();
		Thread.sleep(2000);

		String petKgBeforeTransfer=petTransaction.getText();
		String bonusBeforeTransfer=bonusExcHis.get(0).getText();

		dataTransferButton.click();
		Thread.sleep(2000);
		includeBranchTextField.sendKeys(branchName);
		Thread.sleep(2000);
		categoryDropdown.click();
		Select select_cat = new Select(categoryDropdown);
		select_cat.selectByVisibleText(category);
		Thread.sleep(2000);
		typeDropdown.click();
		Select select_type = new Select(typeDropdown);
		select_type.selectByVisibleText(type);
		Thread.sleep(2000);
		kgLimitTextField.clear();
		kgLimitTextField.sendKeys(kgLimit);
		Thread.sleep(2000);
		action.moveToElement(checkMark.get(1)).click().build().perform();
		Thread.sleep(2000);
		actualTotalWeightBeforeTransfer=totalWeight.getText();
		System.out.println("totalWeightBeforeTransfer :"+actualTotalWeightBeforeTransfer );
		Assert.assertEquals(actualTotalWeightBeforeTransfer,expectedTotalWeightBeforeTransfer);
		Thread.sleep(2000);
		confirmDataTransferButton.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(noCheckBox));
		action.moveToElement(noCheckBox).click().build().perform();
		searchOffsetFeild.sendKeys(bonus2Name);
		searchButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(offsetResult));
		offsetResult.click();
		wait.until(ExpectedConditions.elementToBeClickable(confirmButton));
		confirmButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(okButton));
		okButton.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(closeButton));
		closeButton.click();

		Thread.sleep(2000);

		wait.until(ExpectedConditions.elementToBeClickable(summaryTab));
		summaryTab.click();

		wait.until(ExpectedConditions.visibilityOf(bonusProgress));
		Thread.sleep(3000);
		actualBonusProgressAfterTransfer=bonusProgress.getText();
		System.out.println("actualBonusProgressAfterTransfer :"+actualBonusProgressAfterTransfer );
		Assert.assertEquals(actualBonusProgressAfterTransfer,expectedBonusProgressAfterTransfer);


		Thread.sleep(2000);
		byte[] screenshot3 = ts2.getScreenshotAs(OutputType.BYTES);
		Allure.addAttachment("Bonus In Summary After Data Transfer ", new ByteArrayInputStream(screenshot3));
		Thread.sleep(2000);

		String[] numericValue2 = actualBonusProgressAfterTransfer.split(" ");
		int bonusProgressInSummary2 = Integer.parseInt(numericValue2[0]);

		System.out.println(bonusProgressInSummary2);
		Thread.sleep(2000);
		alcDriver.navigate().refresh();
		Thread.sleep(2000);
		bonusApprovalButton.click();
		branchButton.get(0).click();
		wait.until(ExpectedConditions.visibilityOf(totalKgCollectedAndSold.get(0)));

		action.scrollToElement(totalKgCollectedAndSold.get(0)).build().perform();
		for(WebElement ele : totalKgCollectedAndSold){

			actualTotalKgCollectedAndSoldAfterTransfer.add(ele.getText());
			Thread.sleep(2000);
			byte[] screenshot4 = ts2.getScreenshotAs(OutputType.BYTES);
			Allure.addAttachment("Total Kg Collected And Sold After Transfer ", new ByteArrayInputStream(screenshot4));
			Thread.sleep(2000);
		}
		System.out.println("actualTotalKgCollectedAndSoldAfterTransfer :"+actualTotalKgCollectedAndSoldAfterTransfer );


		Assert.assertEquals(actualTotalKgCollectedAndSoldAfterTransfer,expectedTotalKgCollectedAndSoldAfterTransfer);

		exchangeHistoryTab.click();
		action.scrollToElement(plasticChainDropdown.get(0)).build().perform();
		plasticChainDropdown.get(0).click();
		Thread.sleep(2000);

		String petKgAfterTransfer=petTransaction.getText();
		String bonusAfterTransfer=bonusExcHis.get(0).getText();



	}
	public void verifyTransferedBonus(String bonus2Id,String expectedBonusInTransferedBonusExcHis,String expectedTotalWeightInTransferedBonusExcHis,String expectedPetTransfered) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));

		alcDriver.get("https://"+actual+"/#/admin/ordersoffsets/offset/"+bonus2Id);
		alcDriver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOf(bonusProgress));
		Thread.sleep(4000);

		String bonusProgressText1=bonusProgress.getText();
		Thread.sleep(2000);


		TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
		byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
		Allure.addAttachment("Bonus Summary ", new ByteArrayInputStream(screenshot1));
		Thread.sleep(2000);

		String[] numericValue1 = bonusProgressText1.split(" ");
		int bonusProgressInSummary1 = Integer.parseInt(numericValue1[0]);
		System.out.println(bonusProgressInSummary1);

		Assert.assertEquals(bonusProgressInSummary1,200);

		wait.until(ExpectedConditions.elementToBeClickable(exchangeHistoryTab));
		exchangeHistoryTab.click();

		try{
			WebDriverWait wait2 = new WebDriverWait(alcDriver, Duration.ofSeconds(10));
			wait2.until(ExpectedConditions.visibilityOf(totalWeight));
			Thread.sleep(2000);
			String actualBonusInTransferedBonusExcHis=bonusBuyTotalValue.get(0).getText();
			String actualTotalWeightInTransferedBonusExcHis=totalWeight.getText();

			Assert.assertEquals(actualBonusInTransferedBonusExcHis,expectedBonusInTransferedBonusExcHis);
			Assert.assertEquals(actualTotalWeightInTransferedBonusExcHis,expectedTotalWeightInTransferedBonusExcHis);

			plasticChainDropdown.get(0).click();
			Thread.sleep(2000);
			String actualPetTransfered=petTransaction.getText();
			Thread.sleep(2000);
			Assert.assertEquals(actualPetTransfered,expectedPetTransfered);

			System.out.println("Transfered transaction is Present ");

		}catch (Exception e){
			System.out.println("Transfered transaction is not Present ");
		}

		bonusApprovalButton.click();
		verifyBonusApprovalData(0,"200 KG","200 KG");

	}
	public void branchBonustransferVerify(String branchId,int transactionNumber) throws InterruptedException {

		alcDriver.get("https://" + actual + "/#/admin/collectionpoint/" + branchId);
		alcDriver.navigate().refresh();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(exchangeHistoryTabInBranches));
		exchangeHistoryTabInBranches.click();
		Thread.sleep(3000);

		//List<String> actualBonusNames=new ArrayList<>();
		Set<String> actualBonusNames=new HashSet<>();

		for (int i =0 ; i <= transactionNumber; i++) {

			transactions.get(i).click();
			Thread.sleep(3000);
			for(WebElement ele:associatedBonusName) {

				actualBonusNames.add(ele.getText());
				Thread.sleep(2000);
			}
			Thread.sleep(2000);
			Actions action = new Actions(alcDriver);
			action.scrollToElement(lastItemOnPage).build().perform();
			Thread.sleep(1000);
			TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
			byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
			Allure.addAttachment("ScreenShot of Bonus Present in Branch Exchange History", new ByteArrayInputStream(screenshot1));
			Thread.sleep(2000);
			transactions.get(i).click();
		}
		Set<String> expectedBonusNames=new HashSet<>(Arrays.asList(Data.bonus1Name2627,Data.bonus1Name2627,Data.bonus1Name2627,Data.bonus2Name2627,Data.bonus1Name2627,Data.bonus2Name2627));

		Thread.sleep(2000);
		Assert.assertEquals(actualBonusNames, expectedBonusNames);
		Thread.sleep(2000);

	}
	public void reportDownload(String fileName) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));

		wait.until(ExpectedConditions.elementToBeClickable(orders_tab));
		orders_tab.click();

		wait.until(ExpectedConditions.elementToBeClickable(bonus_Tab));
		bonus_Tab.click();

		wait.until(ExpectedConditions.elementToBeClickable(tableData_FirstRow));
		tableData_FirstRow.click();

		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOf(exchangeHistoryTab));
		exchangeHistoryTab.click();

		Thread.sleep(3000);

		impactClaimReport.click();

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
	public void offsetsReportDownload(String fileName) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));

		wait.until(ExpectedConditions.elementToBeClickable(orders_tab));
		orders_tab.click();

		wait.until(ExpectedConditions.elementToBeClickable(bonus_Tab));
		bonus_Tab.click();

		Thread.sleep(3000);

		wait.until(ExpectedConditions.elementToBeClickable(exportButton));
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
	public void transferReportDownload(String fileName) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));

		wait.until(ExpectedConditions.elementToBeClickable(orders_tab));
		orders_tab.click();

		wait.until(ExpectedConditions.elementToBeClickable(transfersTab));
		transfersTab.click();

		Thread.sleep(4000);

		exportButton.click();

		Thread.sleep(4000);

		while (true) {
			String downloadPath1 = "C:\\Users\\Fleek\\Downloads";
			File directory1 = new File(downloadPath1);
			File[] files1 = directory1.listFiles((dir, name) -> name.contains(fileName));

			if (files1 != null && files1.length > 0) {

				Assert.assertTrue(1 > 0);
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

