package alchemy_Pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.BaseClass;
import Utilities.Data;
import io.qameta.allure.Allure;

public class Benefits extends BaseClass{
    public Benefits(WebDriver alcDriver){
        PageFactory.initElements(alcDriver, this);
    }

    @FindBy(xpath="//div[@class='body']/div/div/div[text()=' Benefits ']")
    public WebElement benefits_TAB;
    @FindBy(xpath="//button[text()='Record new benefit ']")
    public WebElement recordnewbenefit;
    @FindBy(xpath="//div[text()='Record new benefit ']")
    public WebElement recordnewbenefitpage;
    @FindBy(xpath="//input[@placeholder='Search members']")
    public WebElement searchmembers;
    @FindBy(xpath="//button[text()='Get started ']")
    public WebElement getstarted;
    @FindBy(xpath="//div[contains(text(),'Philippines')]")
    public WebElement check;
    @FindBy(xpath="//tr/following::div/div")
    public WebElement benefitordernameorderpage;
    @FindBy(xpath="//label[text()='Dependents*']/following-sibling::select/option")
    public List<WebElement> dependents;

    @FindBy(xpath="//select[@formcontrolname='dependent']")
    public WebElement dependent;
    @FindBy(xpath="//input[@formcontrolname='benefitCostUsd']")
    public WebElement benefitcostusd;


    @FindBy(xpath="//select[@formcontrolname='gender']")
    public List<WebElement> gender;
    @FindBy(xpath="//select[@formcontrolname='birthYear']")
    public List<WebElement> birthYear;
    @FindBy(xpath="//input[@formcontrolname='benefitName']")
    public WebElement benefitName;
    @FindBy(xpath="//select[@formcontrolname='benefitCategory']")
    public WebElement benefitCategory;
    @FindBy(xpath="//select[@formcontrolname='benefitCategory']/option")
    public List<WebElement> benefitCategoryops;
    @FindBy(xpath="//select[@formcontrolname='benefitType']")
    public WebElement benefitType;
    @FindBy(xpath="//select[@formcontrolname='benefitType']/option")
    public List<WebElement> benefitTypeops;
    @FindBy(xpath="//input[@formcontrolname='benefitCost']")
    public WebElement benefitCost;
    @FindBy(xpath="//label[@title='36.85 USD']")
    public WebElement benefitCostus;
    @FindBy(xpath="//input[@title='36.85']")
    public WebElement benefitCostusinput;
    @FindBy(xpath="//label[text()='Benefit order name']/following-sibling::input")
    public WebElement benefitordernamenewrecordpage;
    @FindBy(xpath="//input[@formcontrolname='benefitOrderFunder']")
    public WebElement benefitorderfunder;
    @FindBy(xpath="(//i[@class='calendar-icon-new-grey'])[1]")
    public WebElement calendar;
    @FindBy(xpath="//span[contains(@class,'custom-day')]")
    public List<WebElement> dates;
    @FindBy(xpath="//label[text()='Benefit category']/following-sibling::label")
    public WebElement bencat;
    @FindBy(xpath="//label[text()='Benefit type']/following-sibling::label")
    public WebElement bentype;
    @FindBy(xpath="//textarea")
    public WebElement notes;
    @FindBy(xpath="//input[@id='file-upload']")
    public WebElement uploadfile;
    @FindBy(xpath = "//loader/div//table")
    WebElement pageLoader;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement save;
    @FindBy(xpath = "//input[@placeholder='Benefit name']")
    WebElement benefitnamesearchbox;
    @FindBy(xpath = "//label[contains(text(),'Education Programs')]")
    WebElement benefitcategory;

    @FindBy(xpath = "//label[contains(text(),'Education Support')]")
    WebElement benefittype;

    @FindBy(xpath = "//label[contains(text(),'1,000')]")
    WebElement benefitcost;
    @FindBy(xpath = "//label[text()=' (18.43 USD) ']")
    WebElement benefitcostus;
    @FindBy(xpath = "//label[contains(text(),'1,001')]")
    WebElement updatedbenefitcost;
    @FindBy(xpath = "//button[text()='Benefits']")
    WebElement backtobenefits;
    @FindBy(xpath = "//button[text()='Export table ']")
    WebElement exportTable;
    @FindBy(xpath = "//td/div/div[contains(text(),'fleek')]")
    WebElement firstres;
    @FindBy(xpath = "//button[text()='Edit Benefit ']")
    WebElement edit;
    @FindBy(xpath = "//button[text()='Edit details ']")
    WebElement editbenord;
    @FindBy(xpath = "//button[text()='Cancel ']")
    WebElement cancel;
    @FindBy(xpath = "//button[text()='Go back ']")
    WebElement goback;
    @FindBy(xpath = "//p[text()='Are you sure you want to cancel editing this benefit? Once cancelled, your changes will be deleted. ']")
    WebElement cancelConfirmationMessage;
    @FindBy(xpath = "//p[text()='Are you sure you want to cancel editing this benefit order? Once cancelled, your changes will be deleted. ']")
    WebElement cancelConfirmationMessage2;
    @FindBy(xpath = "//button[text()='Delete ']")
    WebElement delete;
    @FindBy(xpath = "//button[contains(text(),'Void Benefit')]")
    WebElement voidbenefit;
    @FindBy(xpath = "//button[contains(text(),'Confirm and Void')]")
    WebElement confirmandvoid;
    @FindBy(xpath = "//input[@type='radio']/following-sibling::div[contains(@class,'active')]")
    WebElement radiobuttonactive;
    @FindBy(xpath = "//input[@placeholder='Name']")
    WebElement benordname;
    @FindBy(xpath = "//button[contains(text(),'Benefit orders ')]")
    WebElement benefitorderbutton;
    @FindBy(xpath = "//p[text()='Are you sure you want to void  ']")
    WebElement voidbenefitconfirmation;
    @FindBy(xpath = "//p[text()='? You will not be able to undo this action. ']")
    WebElement voidbenefitconfirmation2;
    @FindBy(xpath = "//ngb-modal-window[@role='dialog']")
    WebElement dialogwindow;
    @FindBy(xpath = "//button[contains(text(),'All benefits')]")
    WebElement allbenefits;
    @FindBy(xpath = "//input[@placeholder='Benefit Order Name']")
    WebElement benefitordernamesearchbox;
    @FindBy(xpath = "//input[@placeholder='Search for funders']")
    WebElement benordfunder;
    @FindBy(xpath = "//div[text()='Set as new default Master Order for ']")
    WebElement philirbutton;
    @FindBy(xpath = "//div[@class='loader circle-loader']")
    WebElement loader;
    @FindBy(xpath = "//button[contains(text(),'Assigned Benefits')]")
    WebElement assignedbenefits;
    @FindBy(xpath = "//button[contains(text(),'Order details')]")
    WebElement orderdetails;
    @FindBy(xpath = "//button[contains(text(),'OK')]")
    WebElement ok;
    @FindBy(xpath = "//button[text()='Create new order ']")
    WebElement createneworderbutton;
    @FindBy(xpath = "//select[@formcontrolname='benefitOrderType']")
    WebElement benefitordertypoedropdown2;
    @FindBy(xpath = "//option[text()='Master Order ']")
    WebElement masterorderoption;
    @FindBy(xpath = "//option[text()='Partner Order ']")
    WebElement partnerorderoption;
    @FindBy(xpath = "//input[@formcontrolname='defaultMasterOrder']")
    WebElement setasdefaultmasterorder;
    @FindBy(xpath = "//select[@formcontrolname='orderType']")
    WebElement benefitordertypoedropdown;


    @FindBy(xpath = "//input[@formcontrolname='orderName']")
    WebElement benefitordernamebox;
    @FindBy(xpath = "//input")
    List<WebElement> inputs;
    @FindBy(xpath = "//input[@formcontrolname='purchaseOrderNumber']")
    WebElement benefitordernumberbox;
    @FindBy(xpath = "//input[@formcontrolname='funder']")
    WebElement funderbox;
    @FindBy(xpath = "//li[contains(text(),'Plastic Bank')]")
    WebElement pboptionfunder;
    @FindBy(xpath = "//li[contains(text(),'Social Plastic Foundation')]")
    WebElement socialplasticfoundation;
    @FindBy(xpath = "//select[@formcontrolname='country']")
    WebElement countrydropdown;
    @FindBy(xpath = "//option[text()='Philippines ']")
    WebElement philippinesoption;
    @FindBy(xpath = "//option[text()='Brazil ']")
    WebElement braziloption;
    @FindBy(xpath = "//input[@formcontrolname='costLimit']")
    WebElement costlimitbox;
    @FindBy(xpath = "//select[@formcontrolname='benefitCategory']")
    WebElement benefitcategorydropdown;
    @FindBy(xpath = "//select[@formcontrolname='benefitCategory']/option")
    List<WebElement> benefitcategoryoptions;
    @FindBy(xpath = "//select[@formcontrolname='benefitType']")
    WebElement benefittypedropdown;
    @FindBy(xpath = "//select[@formcontrolname='benefitType']/option")
    List<WebElement> benefittypeoptions;
    @FindBy(xpath = "//textarea")
    WebElement notesarea;
    @FindBy(xpath = "//button[text()='Confirm ']")
    WebElement confirm;
    @FindBy(xpath = "//button[@type='submit' and @disabled]")
    WebElement disabledsave;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement enabledsave;
    @FindBy(xpath = "//button[contains(@class,'active') and text()='Benefit orders ']")
    WebElement activebenefitordersbutton;
    @FindBy(xpath = "//input[@formcontrolname='costLeftToFill' and @disabled and contains(@title,'USD')]")
    WebElement costleftofillgreyout;
    @FindBy(xpath = "//label[@title='Purchase order number']/following-sibling::label")
    WebElement verifypon;
    @FindBy(xpath = "//label[@title='Country']/following-sibling::label")
    WebElement verifycountry;
    @FindBy(xpath = "//label[@title='Cost limit']/following-sibling::label")
    WebElement verifycostlimit;
    @FindBy(xpath = "//label[@title='Benefit name']/following-sibling::label")
    WebElement verifybenefitname;
    @FindBy(xpath = "//label[@title='Benefit order type']/following-sibling::label")
    WebElement verifybenefitordertype;
    @FindBy(xpath = "//label[@title='Benefit category']/following-sibling::label")
    WebElement verifybenefitcategory;
    @FindBy(xpath = "//label[@title='Benefit type']/following-sibling::label")
    WebElement verifybenefittype;
    @FindBy(xpath = "//button[contains(text(),'Edit')]")
    WebElement edituniversal;


    String dynamicresult="//div[@title='param']";
    String dynaresult ="//td/div/div[contains(text(),'param')]";
    String dynaresult1 ="//td/div/div[contains(text(),'param')]";
    String result="(//div[contains(text(),'param')])[2]";
    public static String bencatlater;
    public static String decimal1;
    public static String decimal2;
    public static String bentypelater;
    public static String benefitcostUsd;
    public static String purchaseordernumber;
    public static String costlimit;
    public static String benefitordertype;
    public static String benefitcategoryord;
    public static String benefittypeord;
    public static String country;
    public static String s;
    public static String t;
    public static String tbt1;
    public static String tbt2;
    public static String bon;
    String bof;
    String benefitnameres;
    String benefitnameres1;
    String changingmembername="//div[contains(text(),'param')]";
    String changingbenefitname="//label[contains(text(),'param')]";
    String rtbenefitname;
    String rtmembername;

    WebDriverWait wait300 = new WebDriverWait(alcDriver,Duration.ofSeconds(300));
    public static String benefitordername ="Fleek"+RandomStringUtils.randomAlphabetic(6);
    public static String androidbenefitname;
    public static String randomBenefitName = "fleekBenefit1_"+ RandomStringUtils.randomAlphabetic(6);
    public static String randomBenefitName2 = "fleekBenefit2_"+ RandomStringUtils.randomAlphabetic(6);

    public void verifyUserDirectedToRNBForm() throws InterruptedException {
        benefits_TAB.click();
        jsclick(recordnewbenefit);
        System.out.println(Data.member_Name_4352);
        searchmembers.sendKeys(Data.member_Name_4352);
        String rtsresult = dynamicresult.replace("param", Data.member_Name_4352);

        alcDriver.findElement(By.xpath(rtsresult)).click();
        getstarted.click();
        dependent.isDisplayed();
        recordnewbenefitpage.isDisplayed();
    }


    public void fillForm(String randomBenefitName) throws InterruptedException {
        benefitName.sendKeys(randomBenefitName);
        benefitCategory.click();
        Thread.sleep(2000);
        benefitCategoryops.get(1).click();
        benefitType.click();
        Thread.sleep(2000);
        benefitTypeops.get(1).click();
        benefitCost.sendKeys("1000");
        calendar.click();
        dates.get(0).click();
        bof=benefitorderfunder.getAttribute("title");
        System.out.println(bof+" on form fill up page.");
        bon=benefitordernamenewrecordpage.getAttribute("title");
        System.out.println(bon+" on form fill up page.");
        notes.sendKeys("notes");
        File file = new File("C:\\Users\\Fleek\\Downloads\\gray-wolf.jpg");
        uploadfile.sendKeys(file.getAbsolutePath());
        save.click();
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Benefit Transaction Created ", new ByteArrayInputStream(screenshot1));
        Thread.sleep(3000);
        waitforloader();
    }


    public void openSavedBenefit() {
        benefitnameres=result.replace("param",randomBenefitName);
        alcDriver.findElement(By.xpath(benefitnameres)).click();
    }

    public void checkIfBenefitIsEditable() throws InterruptedException {
        System.out.println("benefit edit start");
        benefitnamesearchbox.clear();
        benefitnamesearchbox.sendKeys(randomBenefitName);
        waitforloader();
        System.out.println(dynaresult1);
        benefitnameres1=dynaresult1.replace("param",randomBenefitName);
        System.out.println(benefitnameres1);
        alcDriver.findElement(By.xpath(benefitnameres1)).click();
        waitforloader();
        edit.click();
        benefitName.clear();
        benefitName.sendKeys(randomBenefitName+"Update");
        benefitCategory.click();
        benefitCategoryops.get(2).click();
        benefitType.click();
        benefitTypeops.get(2).click();
        benefitCost.clear();
        benefitCost.sendKeys("1001");
        calendar.click();
        dates.get(1).click();
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("User is able to edit benefit", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);
        notes.clear();
        notes.sendKeys("edited notes");
        File file = new File("C:\\Users\\Fleek\\Downloads\\gray-wolf.jpg");
        uploadfile.sendKeys(file.getAbsolutePath());
        save.click();
        waitforloader();

    }
    public void click_cancel_and_confirm_message() throws InterruptedException {
        cancel.click();
        cancelConfirmationMessage.isDisplayed();
        takescreenshotof(cancelConfirmationMessage,"A confirmation modal window is displayed.");
        delete.click();
    }

    public void confirm_and_void_benefit() throws InterruptedException {

        benefits_TAB.click();
        benefitnamesearchbox.clear();
        benefitnamesearchbox.sendKeys(randomBenefitName);
        waitforloader();
        System.out.println(dynaresult1);
        benefitnameres1=dynaresult1.replace("param",randomBenefitName);
        System.out.println(benefitnameres1);
        alcDriver.findElement(By.xpath(benefitnameres1)).click();

        voidbenefit.click();
        confirmandvoid.click();

        Thread.sleep(1000);
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Voiding Benefit 1.", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);
        ok.click();
        //allbenefits.isDisplayed();

    }

    public void findAndClickElementWithXpath(String string) {
        WebElement el = alcDriver.findElement(By.xpath(string));
        el.click();
    }

    public void jsclick(WebElement el) {
        JavascriptExecutor executor = (JavascriptExecutor) alcDriver;
        executor.executeScript("arguments[0].click();", el);
    }

    public static void sendKeysUsingJS(WebElement element, String text) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) alcDriver;
        jsExecutor.executeScript("arguments[0].value = arguments[1];", element, text);
    }

    public void clickanyways(WebElement el) {
        try {
            el.click();
        }catch(Exception e) {
            clickanyways(el);
        }
    }


    @SuppressWarnings("deprecation")
    public void t1() throws InterruptedException {
        benefits_TAB.click();
        jsclick(benefitorderbutton);
        check.click();
        waitforloader();
        waitforloader();
        editbenord.click();
        Thread.sleep(20000);
    }

    @SuppressWarnings("deprecation")
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

    public void createMasterBenefitOrder() throws InterruptedException {

        benefits_TAB.click();
        Thread.sleep(5000);
        benefitorderbutton.click();
        jsclick(createneworderbutton);
        waitforloader();
        waitforloader();
        Thread.sleep(2000);
        benefitordernamebox.sendKeys(benefitordername);
        benefitordernumberbox.sendKeys("12345");
        funderbox.sendKeys("Plastic Bank");
        pboptionfunder.click();
        countrydropdown.click();
        philippinesoption.click();
        alcDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        try {
            confirm.click();
        }catch(Exception e) {

        }
        alcDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

        costlimitbox.sendKeys("1000");
        benefitcategorydropdown.click();
        benefitcategoryoptions.get(3).click();
        benefittypedropdown.click();
        benefittypeoptions.get(1).click();

        benefitordertypoedropdown.click();
        masterorderoption.click();
        JavascriptExecutor executor = (JavascriptExecutor) alcDriver;
        executor.executeScript("arguments[0].click();", setasdefaultmasterorder);

        Thread.sleep(2000);
        confirm.click();

        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Create new benefit order screen .", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);

        save.click();

    }



}








