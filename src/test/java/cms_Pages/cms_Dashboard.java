package cms_Pages;

import Utilities.BaseClass;
import io.qameta.allure.Allure;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
    @FindBy(xpath = "//span[text()='Apply to all customers']/parent::label/span/span/input[@value='true']")
    public WebElement applyToAllCustomerToggleEnabled;
    @FindBy(xpath = "//span[text()='Apply to all customers']/parent::label/span/span/input[@value='false']")
    public WebElement applyToAllCustomerToggleDisabled;
    @FindBy(xpath = "//input[@name=\"applyToAllCustomers\"]")
    public WebElement applyToAllCustomerToggleValue;
    @FindBy(xpath = "//h6[text()='Select Client']/following::div/input")
    public WebElement selectClient;
    @FindBy(xpath = "//span[@class='MuiChip-label MuiChip-labelMedium css-14vsv3w']")
    public WebElement qa_forPostProdOnlyPresent;
    @FindBy(xpath = "//li[contains(text(),'QA_ForPostProductionOnly Branches')]")
    public WebElement qa_forPostProdOnly;
    @FindBy(xpath = "//input[@name=\"status\"]")
    public WebElement publishToggle;
    @FindBy(xpath = "//input[@name=\"status\" and @value='true'] ")
    public WebElement publishToggleTrue;
    @FindBy(xpath = "//input[@name=\"status\" and @value='false']")
    public WebElement publishToggleFalse;
    @FindBy(xpath = "//button[text()='Save Changes']")
    public WebElement saveChangesButton;
    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement cancelButton;
    @FindBy(xpath = "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium MuiChip-deleteIcon MuiChip-deleteIconMedium MuiChip-deleteIconColorDefault MuiChip-deleteIconFilledColorDefault css-10dohqv'])[1]")
    public WebElement crossbuttonApplyCx;

    @FindBy(xpath = "//img[@alt=\"file preview\"]")
    public WebElement imageNameGet;
    @FindBy(xpath = "//input[@role=\"combobox\"]")
    public WebElement sdgIconDropdown;
    @FindBy(xpath = "//li[text()='Zero Hunger']")
    public WebElement zeroHunger;
    @FindBy(xpath = "//label[text()='URL *']/following::input[1]")
    public WebElement urlTextField;
    @FindBy(xpath = "//label[text()='Contact Us URL *']/following::input[1]")
    public WebElement urlTextFieldPE;
    @FindBy(xpath = "//label[contains(text(),'Program Content ')]/following::input[1]")
    public WebElement programContent;
    @FindBy(xpath = "//button[contains(@class,\"MuiPickersDay-today\")]")
    public WebElement currentDate;



    public static ArrayList<String> dates = new ArrayList<String>();
    public static ArrayList<String> titles = new ArrayList<String>();
    public static String editedday;
    public static String dynamicDateXpath="//button[normalize-space()='param']";
    public static String title_Random = "Fleek EditedTitle : "+RandomStringUtils.randomAlphabetic(5);
    public static String blurb_Random = "Fleek EditedBlurb : "+RandomStringUtils.randomAlphabetic(84);
    public static String description_Random = "Fleek EditDescription : "+RandomStringUtils.randomAlphabetic(70);
    public static String expectedImagePM;
    public static String expectedImagePE;
    public static String expectedImagePMedited;
    public static String dateEarlier;
    public static String dateAfter;

    public static String titlePM = "Fleek Title : "+RandomStringUtils.randomAlphabetic(5);
    public static String urlPM = "https://www.google.co.in/";
    public static String urlPM_updated = "https://fleekitsolutions.com/";
    public static String blurbPM = "Fleek Blurb : "+RandomStringUtils.randomAlphabetic(84);;



    public static String titlePE = "Fleek Title : "+RandomStringUtils.randomAlphabetic(5);
    public static String urlPE = "https://fleekitsolutions.com/";
    public static String progContPE = "Fleek";
    public static String blurbPE = "Fleek Blurb : "+RandomStringUtils.randomAlphabetic(84);;
    public static String descriptionPE = "Fleek Description : "+RandomStringUtils.randomAlphabetic(70) ;


    public static String titleMC = "Fleek Material Title : "+RandomStringUtils.randomAlphabetic(5);
    public static String urlMC = "https://fleekitsolutions.com/";
    public static String progContMC = "Fleek Material Credit";
    public static String blurbMC = "Fleek Blurb Material Credit : "+RandomStringUtils.randomAlphabetic(84);;
    public static String descriptionMC = "Fleek Description Material Credit: "+RandomStringUtils.randomAlphabetic(70) ;


    public static String titleSB = "Fleek Social Title : "+RandomStringUtils.randomAlphabetic(5);
    public static String urlSB = "https://fleekitsolutions.com/";
    public static String progContSB = "Fleek Social";
    public static String blurbSB = "Fleek Social Blurb : "+RandomStringUtils.randomAlphabetic(84);;
    public static String descriptionSB = "Fleek Social Benefit Description : "+RandomStringUtils.randomAlphabetic(70) ;

    public static String titleMKC = "Fleek Marketing Calender : "+RandomStringUtils.randomAlphabetic(5);
    public static String urlMKC = "https://fleekitsolutions.com/";
    public static String expectedImageMKC;


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

        dateEarlier = dateCreated.get(0).getText();

        Thread.sleep(2000);
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(" Content Seen in List and are in Descending order according to date ", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);

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

    public void createPartnershipMilestone() throws InterruptedException, AWTException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        addButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(titleTextField));
        titleTextField.sendKeys(titlePM);
        urlTextField.sendKeys(urlPM);
        blurbTextField.sendKeys(blurbPM);

        Thread.sleep(2000);
        browseButton.click();
        Thread.sleep(2000);

        Robot rb = new Robot();
        rb.delay(2000);
        StringSelection ss = new StringSelection("C:\\Users\\Fleek\\Downloads\\gray-wolf.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        rb.keyPress(KeyEvent.VK_ENTER);

        rb.delay(2000);

        Thread.sleep(5000);

        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Partnership Milestone creation ", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);

        expectedImagePM=imageNameGet.getAttribute("src");
        System.out.println("expectedImage : "+expectedImagePM);

        saveChangesButton.click();

        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(dateCreated.get(0)));
        dateAfter = dateCreated.get(0).getText();

    }
    public void dateUpdateVerify() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(dateCreated.get(0)));
        Thread.sleep(3000);

        List<String> dateBeforeAfter = new ArrayList<>(Arrays.asList(dateAfter,dateEarlier));
        dateOrderCheck(dateBeforeAfter);

        Thread.sleep(2000);

        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Updated Date Time ", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);

    }

    public void modifyPEContent() throws InterruptedException, AWTException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(threeDots.get(0)));
        threeDots.get(0).click();
        wait.until(ExpectedConditions.elementToBeClickable(editButton));
        editButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(titleTextField));
        Thread.sleep(2000);
        titleTextField.sendKeys(Keys.CONTROL + "a");
        titleTextField.sendKeys(Keys.DELETE);
        //titleTextField.clear();
        Thread.sleep(3000);
        titleTextField.sendKeys(title_Random);

        Thread.sleep(3000);
        urlTextField.sendKeys(Keys.CONTROL + "a");
        urlTextField.sendKeys(Keys.DELETE);
        //urlTextField.clear();
        urlTextField.sendKeys(urlPM_updated);
        Thread.sleep(3000);

        blurbTextField.sendKeys(Keys.CONTROL + "a");
        blurbTextField.sendKeys(Keys.DELETE);
        //blurbTextField.clear();
        Thread.sleep(3000);
        blurbTextField.sendKeys(blurb_Random);

        Thread.sleep(2000);

        crossImageDeleteButton.click();
        Thread.sleep(3000);
        browseButton.click();
        Thread.sleep(3000);

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

        Thread.sleep(7000);

        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Modify Details in PartnerShip Milestone QaPostProduction ", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);

        expectedImagePMedited=imageNameGet.getAttribute("src");
        System.out.println("expectedImage Edited : "+expectedImagePMedited);


        String valueApplyToAllCxTogVal =applyToAllCustomerToggleValue.getAttribute("value");
        System.out.println("valueApplyToAllCxTogVal : "+valueApplyToAllCxTogVal);
        try{
            alcDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            applyToAllCustomerToggleEnabled.click();
            Thread.sleep(2000);
            selectClient.click();
            selectClient.sendKeys("QA_ForPostProductionOnly");
            qa_forPostProdOnly.click();

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
        System.out.println("valuePublish : "+valuePublish);

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

    public void addPartnershipEngagment() throws InterruptedException, AWTException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(partnershipEngagementTab));
        partnershipEngagementTab.click();
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        addButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(titleTextField));
        titleTextField.sendKeys(titlePE);
        sdgIconDropdown.click();
        zeroHunger.click();
        urlTextFieldPE.sendKeys(urlPE);
        programContent.sendKeys(progContPE);
        blurbTextField.sendKeys(blurbPE);
        descriptionTextField.sendKeys(descriptionPE);
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

        Thread.sleep(5000);

        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Add detail in PartnerShip Engagement QaPostProduction", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);

        expectedImagePE=imageNameGet.getAttribute("src");
        System.out.println("expectedImage PE : "+expectedImagePE);


        applyToAllCustomerToggleEnabled.isDisplayed();

        publishToggleTrue.isDisplayed();

        saveChangesButton.click();


    }

    public void addMaterialCredit() throws InterruptedException, AWTException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(materialCreditsTab));
        materialCreditsTab.click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        addButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(titleTextField));
        titleTextField.sendKeys(titleMC);
        sdgIconDropdown.click();
        zeroHunger.click();
        urlTextFieldPE.sendKeys(urlMC);
        programContent.sendKeys(progContMC);
        blurbTextField.sendKeys(blurbMC);
        descriptionTextField.sendKeys(descriptionMC);
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

        Thread.sleep(5000);

        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Add detail in PartnerShip Engagement QaPostProduction", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);

        expectedImagePE=imageNameGet.getAttribute("src");
        System.out.println("expectedImage MC : "+expectedImagePE);

       applyToAllCustomerToggleEnabled.click();

       Thread.sleep(2000);
       selectClient.click();
       selectClient.sendKeys("QA_ForPostProductionOnly");
       Thread.sleep(2000);
       qa_forPostProdOnly.click();


        try{
            alcDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            publishToggleTrue.isDisplayed();
            alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        }
        catch(Exception e)
        {
            publishToggleFalse.click();
            alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        }
        saveChangesButton.click();


    }

    public void addSocialBenefit() throws InterruptedException, AWTException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(socialBenefitTab));
        socialBenefitTab.click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        Thread.sleep(3000);
        addButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(titleTextField));
        titleTextField.sendKeys(titleSB);
        sdgIconDropdown.click();
        zeroHunger.click();
        urlTextFieldPE.sendKeys(urlSB);
        programContent.sendKeys(progContSB);
        blurbTextField.sendKeys(blurbSB);
        descriptionTextField.sendKeys(descriptionSB);
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

        Thread.sleep(5000);

        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Add detail in PartnerShip Engagement QaPostProduction", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);

        expectedImagePE=imageNameGet.getAttribute("src");
        System.out.println("expectedImage SB : "+expectedImagePE);

        applyToAllCustomerToggleEnabled.click();

        Thread.sleep(2000);
        selectClient.click();
        selectClient.sendKeys("QA_ForPostProductionOnly");
        qa_forPostProdOnly.click();


        try{
            alcDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            publishToggleTrue.isDisplayed();
            alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        }
        catch(Exception e)
        {
            publishToggleFalse.click();
            alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        }
        saveChangesButton.click();


    }

    public void addMarketingCalender() throws InterruptedException, AWTException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(marketingCalendarTab));
        marketingCalendarTab.click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        Thread.sleep(3000);
        addButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(titleTextField));
        titleTextField.sendKeys(titleMKC);
        System.out.println(titleMKC);
        urlTextField.sendKeys(urlMKC);
        Thread.sleep(2000);

        dateCalender.click();
        Thread.sleep(2000);
        currentDate.click();

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

        Thread.sleep(5000);

        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Add detail in PartnerShip Engagement QaPostProduction", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);

        expectedImageMKC=imageNameGet.getAttribute("src");
        System.out.println("expectedImage MKC : "+expectedImageMKC);

        applyToAllCustomerToggleEnabled.click();

        Thread.sleep(2000);
        selectClient.click();
        selectClient.sendKeys("QA_ForPostProductionOnly");
        qa_forPostProdOnly.click();


        try{
            alcDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            publishToggleTrue.isDisplayed();
            alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        }
        catch(Exception e)
        {
            publishToggleFalse.click();
            alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        }
        saveChangesButton.click();


    }



}
