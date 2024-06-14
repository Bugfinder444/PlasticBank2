package alchemy_Pages;

import Utilities.BaseClass;
import io.qameta.allure.Allure;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Stores extends BaseClass {
	


	public Stores(WebDriver alcDriver){
        PageFactory.initElements(alcDriver, this);
    }
	
	 
	//public String name = " GKStore ";
	
    @FindBy(xpath = "//div[@class='body']/div/div/div[text()=' Stores ']")
    private WebElement stores_tab;
    @FindBy(xpath = "//datatable//input[@placeholder='Name']")
    private WebElement name_SearchBox;
    @FindBy(xpath = "//div[@class='container-fluid']//datatable//table/tbody/tr[1]/td[1]/div/div")
    private WebElement tableData_FirstRow;
    @FindBy(xpath = "//div[@role='tabpanel']/div/div[1]/span")
    private WebElement edit_store;
    @FindBy(xpath = "//input[@name='city']")
    private WebElement edit_city;
    @FindBy(xpath = "//div[contains(@class, 'pb-button') and text()= 'Save ']")
    private WebElement save_btn;
    @FindBy(xpath = "//input[@id='reqPin']")
    private WebElement canSeeTokenInWallet;
    @FindBy(xpath = "//label[text()='Tokens Active']/following::mdl-switch")
    private WebElement tokenActiveToggle;
    @FindBy(xpath = "//select[@id='level']/option[text()=' Plastic Bank Operated']")
    private WebElement levelToPlasticBankOperated;
    @FindBy(xpath = "//select[@id='level']")
    private WebElement levelDropDown;
    @FindBy(xpath = "//loader/div//table")
    WebElement pageLoader;
    @FindBy(xpath = "//div[text()='Tokens in Wallet']/following::div[text()][1]")
    WebElement tokenWalletValue;
    @FindBy(xpath = "//span[text()='Export']")
    public static WebElement exportButton;
    @FindBy(xpath = "//a[text()='Exchange History']")
    public static WebElement exchangeHistory;


    public static String downloadPath = "C:/Users/Fleek/Downloads";
    

    public void clickStoreTab(){
        stores_tab.click();
    }

    public void search_byName(String name) throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(tableData_FirstRow));
        name_SearchBox.click();
        name_SearchBox.sendKeys(name);
        Thread.sleep(5000);
    }

    public String verifyCreatedStoreVisble(){
        return tableData_FirstRow.getText();
    }

    public void clickCreatedStoreVisble(){
        tableData_FirstRow.click();
    }
    
    public void clickEditStore() throws InterruptedException {
       WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(120));
       wait.until(ExpectedConditions.invisibilityOf(pageLoader));
       //wait.until(ExpectedConditions.elementToBeClickable(edit_store));
       // Thread.sleep(15000);
       edit_store.click();
    }

    public void editUserCity(String cityName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(edit_city));
        edit_city.clear();
        edit_city.sendKeys(cityName);
        Thread.sleep(2000);
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);
    }

    public void saveStoreDetails() {
        save_btn.click();
    }

    public void verifyCreatedStore(String name) throws InterruptedException{
        clickStoreTab();
        search_byName(name);
        Thread.sleep(2000);
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);
        assert verifyCreatedStoreVisble().contains(name);
    }

    public void editStore_Details(String cityName) throws InterruptedException{
    	clickCreatedStoreVisble();
    	clickEditStore();
        editUserCity(cityName);
        Thread.sleep(2000);
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);
        saveStoreDetails();
        
    }
    public void canSeeTokenInWallet() {

    	 canSeeTokenInWallet.click();   	
    
    }
    public void tokenActiveToggle() {
    	 WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
    	 wait.until(ExpectedConditions.elementToBeClickable(tokenActiveToggle));
     	tokenActiveToggle.click();
    }
    public void levelDropDown() {
    	
     	levelDropDown.click();
    }
    public void levelToPlasticBankOperated() {
    	 WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
    	 wait.until(ExpectedConditions.elementToBeClickable(levelToPlasticBankOperated));
     	levelToPlasticBankOperated.click();
    }
    
    public void editStore_ALC_380(String store_name) throws InterruptedException{
    	
    	clickStoreTab();
        search_byName(store_name);
    	clickCreatedStoreVisble();
    	clickEditStore();
    	Thread.sleep(2000);
    	
    	
    	tokenActiveToggle();
    	canSeeTokenInWallet();
    	levelDropDown();
    	levelToPlasticBankOperated();
    	
    	Thread.sleep(3000);
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);
        saveStoreDetails();
    		
    }
    public void verifyTokenInAlchemy() throws InterruptedException {
    	
    	String tokenValue=tokenWalletValue.getText();
    	Thread.sleep(2000);
    	TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);
    	assertEquals(tokenValue, "9,900");
    }
    public void reportDownload(String fileName) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));

        wait.until(ExpectedConditions.elementToBeClickable(stores_tab));
        stores_tab.click();

        wait.until(ExpectedConditions.elementToBeClickable(tableData_FirstRow));
        Thread.sleep(2000);
        tableData_FirstRow.click();
        Thread.sleep(4000);

        wait.until(ExpectedConditions.invisibilityOf(pageLoader));

        exchangeHistory.click();

        Thread.sleep(10000);

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
//        File directory = new File(downloadPath);
//
//        // List all files in the directory
//        File[] files = directory.listFiles();
//
//        if (files != null) {
//            for (File file : files) {
//                // Check if the file name contains the specified string
//                if (file.getName().contains(fileName)) {
//                    // Delete the file
//                    boolean isDeleted = file.delete();
//                    if (isDeleted) {
//                        System.out.println("File deleted: " + file.getName());
//                    } else {
//                        System.out.println("Failed to delete file: " + file.getName());
//                    }
//                }
//            }
//        } else {
//            System.out.println("No files found in the directory.");
//        }

    }
	
}
