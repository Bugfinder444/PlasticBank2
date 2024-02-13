package cms_Pages;

import Utilities.BaseClass;
import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class cms_Dashboard extends BaseClass {

    public cms_Dashboard(WebDriver alcDriver){
        PageFactory.initElements(alcDriver,this);

    }
    @FindBy(xpath = "//input[@name='email']")
    WebElement emailTextField;
    @FindBy(xpath = "//tbody/tr/td[3]")
    public List<WebElement> dateCreated;
    @FindBy(xpath = "//tbody/tr/td[4]")
    public List<WebElement> dateModified;
    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> title;
    @FindBy(xpath = "//tbody/tr/td[5]")
    public List<WebElement> status;
    @FindBy(xpath = "//tbody/tr/td/button")
    public List<WebElement> threeDots;
    @FindBy(xpath = "//button[normalize-space()='+ Add']")
    public WebElement addButton;
    @FindBy(xpath = "//button[normalize-space()='Partnership Milestone']")
    public WebElement partnershipMilestoneTab;
    @FindBy(xpath = "//button[normalize-space()='Material Credits']")
    public WebElement materialCreditsTab;
    @FindBy(xpath = "//button[normalize-space()='Partnership Engagement']")
    public WebElement partnershipEngagementTab;
    @FindBy(xpath = "//button[normalize-space()='Social Benefit']")
    public WebElement socialBenefitTab;
    @FindBy(xpath = "//button[normalize-space()='Marketing Calendar']")
    public WebElement marketingCalendarTab;
    @FindBy(xpath = "//span[text()='Content Type']")
    public WebElement contentType;
    @FindBy(xpath = "//button[@type='button']//div[contains(@class,\"MuiAvatar-root MuiAvatar-circular\")]")
    public WebElement profileButton;
    @FindBy(xpath = "//li[@role='menuitem']")
    public WebElement logOutButton;
    @FindBy(xpath = "//li[text()='Edit']")
    public WebElement editButton;
    @FindBy(xpath = "//input[@name=\"title\"]")
    public WebElement titleTextField;
    @FindBy(xpath = "//label[text()='Date *']/following::button")
    public WebElement dateCalender;
    @FindBy(xpath = "//textarea[@name=\"blurb\"]")
    public WebElement blurbTextField;
    @FindBy(xpath = "//textarea[@name=\"description\"]")
    public WebElement descriptionTextField;
    @FindBy(xpath = "//h6[text()='Image']/following::img")
    public WebElement imageUploadButton;
    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall css-6w8594']//*[name()='svg']")
    public WebElement crossImageDeleteButton;
    @FindBy(xpath = "//span[normalize-space()='browse']")
    public WebElement browseButton;
    @FindBy(xpath = "//span[text()='Apply to all customers']/parent::label/span/span")
    public WebElement applyToAllCustomerToggle;
    @FindBy(xpath = "//input[@name=\"applyToAllCustomers\"]")
    public WebElement applyToAllCustomerToggleValue;
    @FindBy(xpath = "//h6[text()='Select Client']/following::div/input")
    public WebElement selectClient;
    @FindBy(xpath = "//span[@class='MuiChip-label MuiChip-labelMedium css-14vsv3w']")
    public WebElement qa_forPostProdOnlyPresent;
    @FindBy(xpath = "//li[text()='QA_ForPostProductionOnly']")
    public WebElement qa_forPostProdOnly;
    @FindBy(xpath = "//input[@name=\"status\"]")
    public WebElement publishToggle;
    @FindBy(xpath = "//button[text()='Save Changes']")
    public WebElement saveChangesButton;
    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement cancelButton;
    @FindBy(xpath = "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium MuiChip-deleteIcon MuiChip-deleteIconMedium MuiChip-deleteIconColorDefault MuiChip-deleteIconFilledColorDefault css-10dohqv'])[1]")
    public WebElement crossbuttonApplyCx;



    public static ArrayList<String> dates = new ArrayList<String>();
    public static ArrayList<String> titles = new ArrayList<String>();
    public static String editedday;
    public static String dynamicDateXpath="//button[normalize-space()='param']";
    public static String title_Random = "Fleek Title : "+RandomStringUtils.randomAlphabetic(5);
    public static String blurb_Random = "Fleek Blurb : "+RandomStringUtils.randomAlphabetic(84);
    public static String description_Random = "Fleek Description : "+RandomStringUtils.randomAlphabetic(70);
    public static boolean dateOrderCheck(List<String> dates){

        SimpleDateFormat format = new SimpleDateFormat("MMMM d yyyy, h:mm:ss a");
        format.setLenient(false); // Disable leniency to enforce strict parsing

        Date previousDate = null;

        for (String dateString : dates) {
            if (dateString.isEmpty()) {
                // Skip empty strings
                continue;
            }
            try {
                // Adjusting date string to handle different suffixes ("st", "nd", "rd", "th")
                dateString = dateString.replaceAll("(?<=\\d)(st|nd|rd|th)\\b", "");

                Date currentDate = format.parse(dateString);
                if (previousDate != null && currentDate.after(previousDate)) {
                    // If the current date is after the previous date, return false
                    return false;
                }
                previousDate = currentDate;
            } catch (ParseException e) {
                e.printStackTrace();
                // If parsing fails, return false
                return false;
            }
        }
        // If all dates are in descending order or there's only one date, return true
        return true;
    }

    public void dateCreatedOrderCheck() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(dateCreated.get(0)));

        Thread.sleep(3000);

        for(WebElement date:dateCreated){
            dates.add(date.getText());

        }
        Thread.sleep(3000);
        System.out.println(dates);

        boolean isDescending = dateOrderCheck(dates);
        System.out.println("Are the dates in descending order? " + isDescending);
    }



    public void verifyContentPresent() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(dateCreated.get(0)));

        Thread.sleep(3000);

        for(WebElement t:title){
            titles.add(t.getText());

        }
        Thread.sleep(3000);
        System.out.println(titles);

        if (titles.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("The list is not empty.");
        }

    }

    public void modifyContent() throws InterruptedException, AWTException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(threeDots.get(0)));
        threeDots.get(0).click();
        wait.until(ExpectedConditions.elementToBeClickable(editButton));
        editButton.click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(titleTextField));
        titleTextField.clear();
        titleTextField.sendKeys(title_Random);
        dateCalender.click();

        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        String day = sdf.format(today);
        if(String.valueOf(day.charAt(0)).equals("0")) {
            editedday=day.replace(String.valueOf(day.charAt(0)), "");
        }
        else {
            editedday=day;
        }
        String newxpath=dynamicDateXpath.replace("param", editedday);
        alcDriver.findElement(By.xpath(newxpath)).click();
        alcDriver.findElement(By.xpath(newxpath)).click();


        blurbTextField.clear();
        blurbTextField.sendKeys(blurb_Random);
        descriptionTextField.clear();
        descriptionTextField.sendKeys(description_Random);
        Thread.sleep(2000);
//        Actions action = new Actions(alcDriver);
//        action.scrollToElement(crossImageDeleteButton).click().build().perform();
        crossImageDeleteButton.click();
        Thread.sleep(2000);
        browseButton.click();
        Thread.sleep(2000);

        Robot rb = new Robot();
        rb.delay(2000);
        StringSelection ss = new StringSelection("C:\\Users\\Fleek\\Downloads\\fleek_it_solutions_logo.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        rb.keyPress(KeyEvent.VK_ENTER);

        rb.delay(2000);


        String valueApplyToAllCxTogVal =applyToAllCustomerToggleValue.getAttribute("value");
        try{
            alcDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Assert.assertEquals(valueApplyToAllCxTogVal, "true");
            applyToAllCustomerToggle.click();
            alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
        catch(Exception e){
            alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
        try{
            alcDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            qa_forPostProdOnlyPresent.isDisplayed();
            crossbuttonApplyCx.click();
            alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
        catch(Exception e){

            alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            selectClient.click();
            selectClient.sendKeys("QA_ForPostProductionOnly");
            qa_forPostProdOnly.click();

        }

        Thread.sleep(2000);
        String valuePublish =publishToggle.getAttribute("value");
        Thread.sleep(2000);

        try{
            Assert.assertEquals(valuePublish,"true");
            saveChangesButton.click();
        }

        catch(Exception e) {
            publishToggle.click();
            saveChangesButton.click();
        }

    }

}
