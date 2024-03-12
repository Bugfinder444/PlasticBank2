package alchemy_Pages;

import Utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Users extends BaseClass {

    public Users(WebDriver alcDriver) {

        PageFactory.initElements(alcDriver, this);
    }

    @FindBy(xpath="//div[@class='body']/div/div/div[text()=' Users ']")
    public WebElement usersTab;
    @FindBy(xpath="//a[text()='Permissions']")
    public WebElement permissionTab;
    @FindBy(xpath="//span[text()='Read Only']")
    public WebElement readOnly;
    @FindBy(xpath="//input[@placeholder='Phone']")
    private WebElement phoneBoxSearch;
    @FindBy(xpath="//div[@class='container-fluid']//datatable//table/tbody/tr[1]/td[1]/div/div")
    private WebElement tableData_FirstRow;
    @FindBy(xpath = "//div[@class='loader circle-loader']")
    WebElement loader;
    @FindBy(xpath = "//span[text()='Read Only']/parent::span/parent::mdl-checkbox")
    WebElement checkReadOnly;
    @FindBy(xpath = "//div[contains(@class,'circle-image small')]")
    WebElement profileButton;
    @FindBy(xpath = "//div[text()=' Logout ']")
    WebElement logoutButton;


    public void waitforloader() {
        boolean ispresent= true;
        alcDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        while(ispresent) {
            try {
                loader.isDisplayed();
            }catch(Exception e) {
                ispresent=false;
            }
        }
        alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }


    public void verifyClickReadOnly(String memberNumber) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(usersTab));
        usersTab.click();
        wait.until(ExpectedConditions.elementToBeClickable(phoneBoxSearch));
        phoneBoxSearch.sendKeys(memberNumber);
        Thread.sleep(2000);
        waitforloader();
        Thread.sleep(2000);
        tableData_FirstRow.click();
        wait.until(ExpectedConditions.elementToBeClickable(permissionTab));
        permissionTab.click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(readOnly));

        String readonlyStatus=checkReadOnly.getAttribute("class");

        if(readonlyStatus.contains("is-checked")){

            System.out.println("Already set to Read Only");

        }
        else{

            readOnly.click();
            System.out.println("Read Only Clickable");
            Thread.sleep(3000);
            readOnly.click();

        }
    }

    public void verifyReadOnlyDisabled() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(usersTab));
        usersTab.click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(tableData_FirstRow));
        tableData_FirstRow.click();
        wait.until(ExpectedConditions.elementToBeClickable(permissionTab));
        permissionTab.click();
        wait.until(ExpectedConditions.visibilityOf(readOnly));

        String readonlyStatusBefore=checkReadOnly.getAttribute("class");
        readOnly.click();
        String readonlyStatusAfter=checkReadOnly.getAttribute("class");

        Assert.assertEquals(readonlyStatusAfter,readonlyStatusBefore);
//        if (readonlyStatusAfter.equals(readonlyStatusBefore)) {
//            System.out.println("The ReadOnly is disabled.");
//        } else {
//            System.out.println("The ReadOnly is enabled.");
//        }
        System.out.println(" ReadOnly is disabled.");

    }
    public void logOut(){

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(profileButton));
        profileButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();


    }


}
