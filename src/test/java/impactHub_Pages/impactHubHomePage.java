package impactHub_Pages;

import Utilities.BaseClass;
import alchemy_Pages.AlchemyLoginPage;
import cms_Pages.cms_Dashboard;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v117.network.Network;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class impactHubHomePage extends BaseClass {

    public impactHubHomePage(WebDriver alcDriver) {
        PageFactory.initElements(alcDriver, this);

    }

    @FindBy(xpath = "//div[text()=' Partnership Milestones ']/following::div[7]/div")
    public static WebElement titleMileStonePartner;
    @FindBy(xpath = "//div[text()=' Partnership Milestones ']/following::div[9]")
    public WebElement blurbMileStonePartner;
    @FindBy(xpath = "(//div[text()=' Partnership Milestones ']/following::div/div/div/div/div)[1]")
    public WebElement imageMileStonePartner;

    @FindBy(xpath = "//label[text()='Add New Admin']/parent::div/button")
    public WebElement addNewAdmin;
    @FindBy(xpath = "//button[text()='Update']")
    public WebElement updateButton;
    @FindBy(xpath = "//label[text()='ESG']/following::span[@class=\"checkmark\"]/following::input[@disabled]")
    public List<WebElement> disabledEsg4Checkmarks;
    @FindBy(xpath = "//label[text()='ESG']/following::span[@class=\"checkmark\"]/following::input[position() < last()]")
    public List<WebElement> enabledEsg4Checkmarks;
    @FindBy(xpath = "//label[text()='ESG']/following::span[@class=\"checkmark\"]")
    public WebElement esgCheckmark;
    @FindBy(xpath = "(//div[@class=\"navbar-item\"])[1]")
    public WebElement marketPlaceButton;
    //div[contains(@class,"marketplace")]
    @FindBy(xpath = "(//h4[text()=' Partnership Engagement ']/following::div[text()])[1]")
    public WebElement titlePE;
    @FindBy(xpath = "(//h4[text()=' Partnership Engagement ']/following::div[text()])[1]")
    public WebElement titlePE1;
    @FindBy(xpath = "(//h4[text()=' Partnership Engagement ']/following::div[text()]/following::div)[1]")
    public WebElement blurbePE;
    @FindBy(xpath = "(//h4[text()=' Partnership Engagement ']/following::div[contains(@class,'card-image')])[1]")
    public WebElement imagePE;


    @FindBy(xpath = "(//h4[text()=' Material Credits ']/following::div[text()])[1]")
    public WebElement titleMC;
    @FindBy(xpath = "(//h4[text()=' Material Credits ']/following::div[text()]/following::div)[1]")
    public WebElement titleMC1;
    @FindBy(xpath = "(//h4[text()=' Material Credits ']/following::div[text()]/following-sibling::div[1])[1]")
    public WebElement blurbeMC;
    @FindBy(xpath = "(//h4[text()=' Material Credits ']/following::div[contains(@class,'card-image')])[1]")
    public WebElement imageMC;

    @FindBy(xpath = "(//h4[text()=' Social Benefits ']/following::div[text()])[1]")
    public WebElement titleSB;
    @FindBy(xpath = "(//h4[text()=' Social Benefits ']/following::div[text()])[1]")
    public WebElement titleSB1;
    @FindBy(xpath = "(//h4[text()=' Social Benefits ']/following::div[text()]/following-sibling::div[1])[1]")
    public WebElement blurbeSB;
    @FindBy(xpath = "(//h4[text()=' Social Benefits ']/following::div[contains(@class,'card-image')])[1]")
    public WebElement imageSB;
    @FindBy(xpath = "//h4[text()=' Social Benefits ']")
    public WebElement socialBenifits;
    @FindBy(xpath = "//h4[text()=' Partnership Engagement ']")
    public WebElement partnershipEngagement;
    @FindBy(xpath = "//h4[text()=' Partnership Engagement ']")
    public WebElement partnershipEng;


    @FindBy(xpath = "//input[@placeholder=\"Search\"]")
    public WebElement searchTextField;
    @FindBy(xpath = "//div[@class=\"search-icon\"]")
    public WebElement searchIcon;
    @FindBy(xpath = "//div[text()='gayas.khan@fleekitsolutions.com']")
    public WebElement searchResultGayas;
    @FindBy(xpath = "//div[text()='ashish.rawat@fleekitsolutions.com']")
    public WebElement searchResultAshish;
    @FindBy(xpath = "//button[text()='Confirm']")
    public WebElement confirmButton;
    @FindBy(xpath = "//h4[text()='Error']")
    public WebElement errorPopUp;
    @FindBy(xpath = "//button[text()='Close']")
    public WebElement closeButton;


    @FindBy(xpath = "//div[@class=\"loader circle-loader\"]")
    public WebElement loader;

    @FindBy(xpath = "//div[@class=\"calendar-component\"]/div/p")
    public List<WebElement> titleMarketingCalender;
    @FindBy(xpath = "(//div[@class=\"calendar-component\"])[1]/img")
    public WebElement imageMarketingCalender;
    @FindBy(xpath = "(//div[contains(@class,\"navbar-item\")])[7]")
    public WebElement marketingCalenderTab;
    @FindBy(xpath = "//h4[text()=' Partnership Engagement ']/following::button[text()=' Program Details ']")
    public WebElement programDetails;
    @FindBy(xpath = "//button[text()=' Contact your Sales Rep ']")
    public WebElement contactYourSalesRep;
    @FindBy(xpath = "//h4[text()=' Material Credits ']/following::div[text()=' Program Details ']")
    public WebElement programDetailsMC;
    @FindBy(xpath = "//h4[text()=' Social Benefits ']/following::button[text()=' Program Details ']")
    public WebElement programDetailsSB;
    @FindBy(xpath = "(//div[contains(@class,\"navbar-item\")])[11]")
    public WebElement locationButton;
    @FindBy(xpath = "//img")
    public WebElement img;
    @FindBy(xpath = "(//div[contains(@class,\"navbar-item\")])[15]")
    public WebElement mediaKit;

    @FindBy(xpath = "//div[@class='bottom-navbar']/descendant::div[@class='navbar-item'][4]")
    public WebElement auditTrailTab;
    //div[@class='navbar-item bottom-item-selected']
    //div[@class='navbar-item bottom-item-selected']//*[name()='svg']
    @FindBy(xpath = "//button[normalize-space()='Social Benefits']")
    public WebElement socialBenefitTab;
    @FindBy(xpath = "//div[@class='thead']/div/div/div/div[contains(@class,'thead-top-label')]")
    public List<WebElement> tableHeaderName;

    @FindBy(xpath = "(//div[@class=\"body-data\"])[1]/div/div")
    public WebElement benefit2InTable;
    @FindBy(xpath = "(//div[@class='tbody-text'])[9]")
    public WebElement benefit1InTable;
    @FindBy(xpath = "//button[text()=' Collections ']")
    public WebElement collectionsButtons;
    @FindBy(xpath = "//button[text()=' Summary ']")
    public WebElement summaryButton;

    @FindBy(xpath = "//div[text()=' Social benefits ']/following::div[@class=\"data-container\"]/p")
    public List<WebElement> socialBenefitChartValues;
    @FindBy(xpath = "//div[text()='Social Benefits']/preceding-sibling::div")
    public WebElement socialBenefitsTotalTop;
    @FindBy(xpath = "//span[text()='All countries']/parent::button")
    public WebElement allCountriesDropdown;
    @FindBy(xpath = "//span[text()='Philippines']/preceding-sibling::div")
    public WebElement philippinesCheckBox;
    @FindBy(xpath = "//span[text()='All year']/parent::button")
    public WebElement allYearDropdown;
    @FindBy(xpath = "//span[text()='2024']/preceding-sibling::div")
    public WebElement year2024;
    @FindBy(xpath = "(//button[text()=' Apply filter '])[1]")
    public WebElement applyFilterButtonCountry;
    @FindBy(xpath = "(//button[text()=' Apply filter '])[2]")
    public WebElement applyFilterButtonYear;


    public static String actualUrl;

    public static int totalSocialBenefits;
    public static List<String> socialBenefitsString=new ArrayList<>();
    public static List<String> socialBenefitsString2=new ArrayList<>();
    public static List<Integer> socialBenefitsInt;
    public static int totalSocialBenefitsCalculated;

    //https://qa-impact.cognitionfoundry.io/postprodchecks/dashboard/page/home
    //https://qa-impact.cognitionfoundry.io/oceanbottle/dashboard/page/home
    //https://qa-impact.cognitionfoundry.io/dial/dashboard/page/home

    // dial::  https://qa-admin.cognitionfoundry.io/#/admin/clientdashboards/98179f8f-3e2d-4ba4-88b5-932473c752b2
    // qa_post :: https://qa-admin.cognitionfoundry.io/#/admin/clientdashboards/23a911f1-8e7c-46ee-adf1-f93a6c0a2b35
    // oceanBottle :: https://qa-admin.cognitionfoundry.io/#/admin/clientdashboards/0f2dc795-2c44-4b5a-8a70-08ab18fb4483


    public void verifyTitle(String expectedTitle) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(titleMileStonePartner));
        String actualTitle = titleMileStonePartner.getText();
        Thread.sleep(2000);
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Verify Title in PartnerShip Milestone ", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);
        Assert.assertEquals(actualTitle, expectedTitle);

    }

    public void verifyBlurb(String expectedBlurb) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(blurbMileStonePartner));
        String actualBlurb = blurbMileStonePartner.getText();
        Thread.sleep(2000);
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Verify Blurb in PartnerShip Milestone ", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);
        Assert.assertEquals(actualBlurb, expectedBlurb);

    }

    public void verifyImage(String expectedImage) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(imageMileStonePartner));
        String actualImage = imageMileStonePartner.getAttribute("style");
        Thread.sleep(2000);
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Verify Image in PartnerShip Milestone ", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);
        Assert.assertTrue(actualImage.contains(expectedImage));


    }

    public void verifyUrlPM(String expectedUrl) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));

        wait.until(ExpectedConditions.elementToBeClickable(imageMileStonePartner));

        String initialTab = alcDriver.getWindowHandle();

        imageMileStonePartner.click();

        Thread.sleep(3000);

        Set<String> handles = alcDriver.getWindowHandles();

        for (String handle : handles) {
            if (!handle.equals(initialTab)) {
                alcDriver.switchTo().window(handle);
                actualUrl = alcDriver.getCurrentUrl();
                break;
            }
        }

        if (alcDriver.getCurrentUrl().equals(expectedUrl)) {

            System.out.println("URL matched!");
            System.out.println("expectedUrl:" + expectedUrl);
            System.out.println("actualUrl:" + actualUrl);
            Thread.sleep(2000);
            TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
            byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Verify Link is working ", new ByteArrayInputStream(screenshot1));
            Thread.sleep(2000);

            Assert.assertEquals(expectedUrl, actualUrl);
            // Close the new tab
            alcDriver.close();
        } else {
            System.out.println("URL didn't match!");
            // Close the new tab
            alcDriver.close();
        }

        // Switch back to the initial tab
        alcDriver.switchTo().window(initialTab);

    }

    public void verifyUrlPE(String expectedUrl) throws InterruptedException, AWTException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));


        Thread.sleep(4000);

        JavascriptExecutor js = (JavascriptExecutor) alcDriver;

        Actions action = new Actions(alcDriver);
        //action.scrollToElement(programDetails).click().build().perform();
        Thread.sleep(3000);

        js.executeScript("arguments[0].click();", programDetails);

        wait.until(ExpectedConditions.elementToBeClickable(contactYourSalesRep));

        String initialTab = alcDriver.getWindowHandle();
        Thread.sleep(2000);
        js.executeScript("arguments[0].click();", contactYourSalesRep);

        Thread.sleep(3000);

        Set<String> handles = alcDriver.getWindowHandles();

        for (String handle : handles) {
            if (!handle.equals(initialTab)) {
                alcDriver.switchTo().window(handle);
                actualUrl = alcDriver.getCurrentUrl();
                break;
            }
        }

        if (alcDriver.getCurrentUrl().equals(expectedUrl)) {

            System.out.println("URL matched!");
            System.out.println("expectedUrl:" + expectedUrl);
            System.out.println("actualUrl:" + actualUrl);
            Thread.sleep(2000);
            TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
            byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Verify Link is working ", new ByteArrayInputStream(screenshot1));
            Thread.sleep(2000);

            Assert.assertEquals(expectedUrl, actualUrl);
            // Close the new tab
            alcDriver.close();
        } else {
            System.out.println("URL didn't match!");
            // Close the new tab
            alcDriver.close();
        }

        // Switch back to the initial tab
        alcDriver.switchTo().window(initialTab);

    }

    public void verifyTitleFalse(String expectedTitle) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));

        try {
            wait.until(ExpectedConditions.elementToBeClickable(titleMileStonePartner));
            String actualTitle = titleMileStonePartner.getText();
            Thread.sleep(2000);
            TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
            byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Verify changed title in PartnerShip Milestone QaPostProduction not present in Dial", new ByteArrayInputStream(screenshot1));
            Thread.sleep(2000);
            Assert.assertNotEquals(actualTitle, expectedTitle);
        } catch (Exception e) {
            alcDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);


        }


    }

    public void verifyBlurbFalse(String expectedBlurb) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(blurbMileStonePartner));
        String actualBlurb = blurbMileStonePartner.getText();
        Thread.sleep(2000);
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Verify changed Blurb in PartnerShip Milestone QaPostProduction not present in Dial", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);
        Assert.assertNotEquals(expectedBlurb, actualBlurb);


    }

    public void verifyImageFalse(String expectedImage) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(imageMileStonePartner));
        String actualImage = imageMileStonePartner.getAttribute("style");
        Thread.sleep(2000);
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Verify changed Image in PartnerShip Milestone QaPostProduction not present in Dial", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);
        Assert.assertFalse(actualImage.contains(expectedImage));


    }


    public void verifyTitlePE(String expectedTitle) throws InterruptedException, AWTException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.elementToBeClickable(marketPlaceButton));
        marketPlaceButton.click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(partnershipEngagement));
        Actions action = new Actions(alcDriver);
        action.scrollToElement(partnershipEngagement).build().perform();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) alcDriver;
        js.executeScript("window.scrollBy(0, 380)");

        Thread.sleep(2000);

        Robot robot = new Robot();
        robot.mouseMove(320, 440);

        Thread.sleep(3000);
        String actualTitle = titlePE.getText();
        Thread.sleep(2000);
        Assert.assertEquals(actualTitle, expectedTitle);
        Thread.sleep(2000);
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Verify detail in PartnerShip Engagement ", new ByteArrayInputStream(screenshot1));
        robot.mouseMove(322, 442);


    }

    public void verifyBlurbPE(String expectedBlurb) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(blurbePE));
        Thread.sleep(2000);
        String actualBlurb = blurbePE.getText();
        Thread.sleep(2000);
        Assert.assertEquals(actualBlurb, expectedBlurb);

    }

    public void verifyImagePE(String expectedImage) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(imagePE));
        Thread.sleep(3000);
        String actualImage = imagePE.getAttribute("style");
        Thread.sleep(2000);
        Assert.assertTrue(actualImage.contains(expectedImage));


    }

    public void addEmailDashBoard(String email, String number, String password) throws InterruptedException {

        try {
            alcDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            AlchemyLoginPage login = new AlchemyLoginPage(alcDriver);
            login.alc_adminlogin(number, password);
            alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        } catch (Exception e) {

            System.out.println("Already Logged In");
        }

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(addNewAdmin));
        addNewAdmin.click();
        wait.until(ExpectedConditions.visibilityOf(searchTextField));
        searchTextField.sendKeys(email);
        Thread.sleep(3000);
        searchIcon.click();
        Thread.sleep(3000);

        searchResultAshish.click();

        confirmButton.click();
        Actions action = new Actions(alcDriver);
        action.scrollToElement(updateButton).build().perform();
        try {
            wait.until(ExpectedConditions.visibilityOf(disabledEsg4Checkmarks.get(1)));
            esgCheckmark.click();
            for (WebElement ele : disabledEsg4Checkmarks) {
                ele.click();
            }
        } catch (Exception e) {

            System.out.println("ESG is  Checked");
        } finally {

            updateButton.click();
        }

    }

    public void verifyTitleMC(String expectedTitle) throws InterruptedException, AWTException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.elementToBeClickable(marketPlaceButton));
        marketPlaceButton.click();
        wait.until(ExpectedConditions.visibilityOf(titleMC));
        Thread.sleep(3000);

        Robot robot = new Robot();
        robot.mouseMove(320, 400);

        Thread.sleep(4000);
        String actualTitle = titleMC.getText();
        Thread.sleep(2000);
        Assert.assertEquals(actualTitle, expectedTitle);

        Thread.sleep(2000);
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Verify detail in Material Credits ", new ByteArrayInputStream(screenshot1));


    }

    public void verifyBlurbMC(String expectedBlurb) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(blurbeMC));
        String actualBlurb = blurbeMC.getText();
        Thread.sleep(2000);
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Verify Blurb in Material Credits ", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);
        Assert.assertEquals(actualBlurb, expectedBlurb);


    }

    public void verifyImageMC(String expectedImage) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(imageMC));
        Thread.sleep(2000);
        String actualImage = imageMC.getAttribute("style");
        Thread.sleep(2000);
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Verify Image in Material Credits ", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);
        Assert.assertTrue(actualImage.contains(expectedImage));


    }

    public void verifyTitleSB(String expectedTitle) throws InterruptedException, AWTException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.elementToBeClickable(marketPlaceButton));
        marketPlaceButton.click();
        wait.until(ExpectedConditions.visibilityOf(titleSB));
        Thread.sleep(3000);

        Actions action = new Actions(alcDriver);
        action.scrollToElement(socialBenifits).build().perform();

        JavascriptExecutor js = (JavascriptExecutor) alcDriver;
        js.executeScript("window.scrollBy(0, 320)");

        Thread.sleep(2000);

        Robot robot = new Robot();
        robot.mouseMove(320, 400);

        Thread.sleep(4000);
        String actualTitle = titleSB.getText();
        Thread.sleep(2000);
        Assert.assertEquals(actualTitle, expectedTitle);

        Thread.sleep(2000);
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Verify detail in Social Benefits ", new ByteArrayInputStream(screenshot1));
        robot.mouseMove(322, 442);


    }

    public void verifyBlurbSB(String expectedBlurb) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(blurbeSB));
        String actualBlurb = blurbeSB.getText();
        Thread.sleep(2000);
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Verify Blurb in Social Benefit ", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);
        Assert.assertEquals(actualBlurb, expectedBlurb);


    }

    public void verifyImageSB(String expectedImage) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(imageSB));
        Thread.sleep(2000);
        String actualImage = imageSB.getAttribute("style");
        Thread.sleep(2000);
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Verify Image in Social Benefit ", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);
        Assert.assertTrue(actualImage.contains(expectedImage));


    }


    public void verifyTitleMKC(String expectedTitle) throws InterruptedException, AWTException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));

        List<String> actualTitleMKC = new ArrayList<>();

        wait.until(ExpectedConditions.elementToBeClickable(marketingCalenderTab));
        marketingCalenderTab.click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(titleMarketingCalender.get(0)));
        for (WebElement ele : titleMarketingCalender) {
            actualTitleMKC.add(ele.getText());
        }
        Thread.sleep(2000);
        System.out.println(actualTitleMKC);
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Verify Title in Marketing Calender ", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);

        boolean isTitleFound = false;
        for (String title : actualTitleMKC) {
            if (title.contains(expectedTitle)) {
                isTitleFound = true;
                break;
            }
        }

        Assert.assertTrue(isTitleFound);

    }


    public void verifyImageMKC(String expectedImageMKC) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(imageMarketingCalender));
        Thread.sleep(2000);
        String actualImage = imageMarketingCalender.getAttribute("style");
        Thread.sleep(2000);
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Verify Image in Marketing Calender ", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);
        System.out.println();
        Assert.assertTrue(actualImage.contains(expectedImageMKC));


    }

    public void verifyUrlMC(String expectedUrl) throws InterruptedException, AWTException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));


        Thread.sleep(4000);

        JavascriptExecutor js = (JavascriptExecutor) alcDriver;

        Actions action = new Actions(alcDriver);
        //action.scrollToElement(programDetails).click().build().perform();

        js.executeScript("arguments[0].click();", programDetailsMC);

        wait.until(ExpectedConditions.elementToBeClickable(contactYourSalesRep));

        String initialTab = alcDriver.getWindowHandle();
        Thread.sleep(2000);
        js.executeScript("arguments[0].click();", contactYourSalesRep);

        Thread.sleep(3000);

        Set<String> handles = alcDriver.getWindowHandles();

        for (String handle : handles) {
            if (!handle.equals(initialTab)) {
                alcDriver.switchTo().window(handle);
                actualUrl = alcDriver.getCurrentUrl();
                break;
            }
        }

        if (alcDriver.getCurrentUrl().equals(expectedUrl)) {

            System.out.println("URL matched!");
            System.out.println("expectedUrl:" + expectedUrl);
            System.out.println("actualUrl:" + actualUrl);
            Thread.sleep(2000);
            TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
            byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Verify Link is working ", new ByteArrayInputStream(screenshot1));
            Thread.sleep(2000);

            Assert.assertEquals(expectedUrl, actualUrl);
            // Close the new tab
            alcDriver.close();
        } else {
            System.out.println("URL didn't match!");
            // Close the new tab
            alcDriver.close();
        }

        // Switch back to the initial tab
        alcDriver.switchTo().window(initialTab);

    }

    public void verifyUrlSB(String expectedUrl) throws InterruptedException, AWTException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));


        Thread.sleep(4000);

        JavascriptExecutor js = (JavascriptExecutor) alcDriver;

        Actions action = new Actions(alcDriver);
        //action.scrollToElement(programDetails).click().build().perform();

        js.executeScript("arguments[0].click();", programDetailsSB);

        wait.until(ExpectedConditions.elementToBeClickable(contactYourSalesRep));

        String initialTab = alcDriver.getWindowHandle();
        Thread.sleep(2000);
        js.executeScript("arguments[0].click();", contactYourSalesRep);

        Thread.sleep(3000);

        Set<String> handles = alcDriver.getWindowHandles();

        for (String handle : handles) {
            if (!handle.equals(initialTab)) {
                alcDriver.switchTo().window(handle);
                actualUrl = alcDriver.getCurrentUrl();
                break;
            }
        }

        if (alcDriver.getCurrentUrl().equals(expectedUrl)) {

            System.out.println("URL matched!");
            System.out.println("expectedUrl:" + expectedUrl);
            System.out.println("actualUrl:" + actualUrl);
            Thread.sleep(2000);
            TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
            byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Verify Link is working ", new ByteArrayInputStream(screenshot1));
            Thread.sleep(2000);

            Assert.assertEquals(expectedUrl, actualUrl);
            // Close the new tab
            alcDriver.close();
        } else {
            System.out.println("URL didn't match!");
            // Close the new tab
            alcDriver.close();
        }

        // Switch back to the initial tab
        alcDriver.switchTo().window(initialTab);

    }

    public void verifyUrlMKC(String expectedUrl) throws InterruptedException, AWTException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
        String initialTab = alcDriver.getWindowHandle();
        Thread.sleep(2000);
        WebElement mkcContent = alcDriver.findElement(By.xpath("//p[text()=' " + cms_Dashboard.titleMKC + " ']"));
        JavascriptExecutor js = (JavascriptExecutor) alcDriver;
        js.executeScript("arguments[0].click();", mkcContent);


        // mkcContent.click();
        // """"
        //p[text()=' Fleek Marketing Calender : KlFou ']

        Thread.sleep(4000);

        Set<String> handles = alcDriver.getWindowHandles();

        for (String handle : handles) {
            if (!handle.equals(initialTab)) {
                alcDriver.switchTo().window(handle);
                actualUrl = alcDriver.getCurrentUrl();
                break;
            }
        }

        if (alcDriver.getCurrentUrl().equals(expectedUrl)) {

            System.out.println("URL matched!");
            System.out.println("expectedUrl:" + expectedUrl);
            System.out.println("actualUrl:" + actualUrl);
            Thread.sleep(2000);
            TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
            byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Verify Link is working ", new ByteArrayInputStream(screenshot1));
            Thread.sleep(2000);

            Assert.assertEquals(expectedUrl, actualUrl);
            // Close the new tab
            alcDriver.close();
        } else {
            System.out.println("URL didn't match!");
            // Close the new tab
            alcDriver.close();
        }

        // Switch back to the initial tab
        alcDriver.switchTo().window(initialTab);

    }

    public void verifyLocation() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.elementToBeClickable(locationButton));
        locationButton.click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOf(img));

        Assert.assertTrue(img.isDisplayed());

        Thread.sleep(2000);
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Location is available ", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);



    }
    public void verifyMediaKit(String expectedUrl) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.elementToBeClickable(mediaKit));

        String initialTab = alcDriver.getWindowHandle();
        Thread.sleep(2000);

        mediaKit.click();
        Thread.sleep(2000);

        Set<String> handles = alcDriver.getWindowHandles();

        for (String handle : handles) {
            if (!handle.equals(initialTab)) {
                alcDriver.switchTo().window(handle);
                actualUrl = alcDriver.getCurrentUrl();
                break;
            }
        }

        String redirectedTab = alcDriver.getCurrentUrl();

        Thread.sleep(2000);

        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Redirected to Brand Folder ", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);

        Assert.assertEquals(redirectedTab,expectedUrl);

        // Switch back to the initial tab
        alcDriver.switchTo().window(initialTab);


    }

    public void verifyImpactHubAuditTrailSB() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.elementToBeClickable(auditTrailTab));
        auditTrailTab.click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(socialBenefitTab));
        socialBenefitTab.click();

        wait.until(ExpectedConditions.visibilityOf(tableHeaderName.get(0)));

        Set<String> actualTableContents = new HashSet<>();

        Thread.sleep(2000);

        Set<String>expectedTableContents = new HashSet<>(Arrays.asList("Benefit Name","Benefit Category","Benefit Type","Date Received","Beneficiary Name","Beneficiary Id","Country","Total value","Dependents","Unique Claim ID"));

        for(WebElement ele : tableHeaderName){

            actualTableContents.add(ele.getText());
        }

        Thread.sleep(3000);

        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Columns Present In Social Benefit Audit Trail", new ByteArrayInputStream(screenshot1));
        Thread.sleep(3000);

        Assert.assertEquals(actualTableContents,expectedTableContents);


    }

    public void verifyImpactHubAuditTrail5952() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(180));
        Actions action = new Actions(alcDriver);

        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(auditTrailTab));
        auditTrailTab.click();

        wait.until(ExpectedConditions.invisibilityOf(loader));
        Thread.sleep(1000);

        wait.until(ExpectedConditions.elementToBeClickable(collectionsButtons));
        collectionsButtons.click();
        Thread.sleep(2000);

        try {

            wait.until(ExpectedConditions.visibilityOf(tableHeaderName.get(0)));

            Set<String> actualTableContents = new HashSet<>();

            Thread.sleep(2000);

            Set<String> expectedTableContents = new HashSet<>(Arrays.asList("Transaction Type", "Seller Name", "Buyer Name", "Collection Date", "Order Date", "Country", "Material", "Color", "Weight", "Total Value", "Material Value", "Bonus Value", "Output", "Seller ID","Buyer ID", "City", "Tokens","Sponsor Claim", "Supply Chain Claim", "Path", "Unique Impact Claim", "Local Currency", "Oceanbound Verified", "Bonus Claim", "Verified Claim Status", "Output Status", "Transaction ID"));

            for(WebElement ele : tableHeaderName){

                actualTableContents.add(ele.getText());
            }

            Thread.sleep(3000);

            TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
            byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Columns Present In Audit Trail", new ByteArrayInputStream(screenshot1));
            Thread.sleep(3000);

            Assert.assertEquals(actualTableContents, expectedTableContents);

            Thread.sleep(2000);

        }
        catch (Exception e){

            summaryButton.click();
            wait.until(ExpectedConditions.invisibilityOf(loader));
            collectionsButtons.click();

            wait.until(ExpectedConditions.visibilityOf(tableHeaderName.get(0)));

            Set<String> actualTableContents = new HashSet<>();

            Thread.sleep(2000);


            Set<String> expectedTableContents = new HashSet<>(Arrays.asList("Transaction Type", "Seller Name", "Buyer Name", "Collection Date", "Order Date", "Country", "Material", "Color", "Weight", "Total Value", "Material Value", "Bonus Value", "Output", "Seller ID","Buyer ID", "City", "Tokens","Sponsor Claim", "Supply Chain Claim", "Path", "Unique Impact Claim", "Local Currency", "Oceanbound Verified", "Bonus Claim", "Verified Claim Status", "Output Status", "Transaction ID"));

            for(WebElement ele : tableHeaderName){

                actualTableContents.add(ele.getText());
            }

            Thread.sleep(3000);

            TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
            byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Columns Present In Audit Trail", new ByteArrayInputStream(screenshot1));
            Thread.sleep(3000);

            Assert.assertEquals(actualTableContents, expectedTableContents);

            Thread.sleep(2000);

        }

    }
    public void verifyImpactHubAuditTrail5198() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(120));
        Actions action = new Actions(alcDriver);

        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(auditTrailTab));
        //action.moveToElement(auditTrailTab).click().build().perform();
        auditTrailTab.click();

        wait.until(ExpectedConditions.invisibilityOf(loader));
        Thread.sleep(1000);

        wait.until(ExpectedConditions.elementToBeClickable(socialBenefitTab));
        socialBenefitTab.click();

        wait.until(ExpectedConditions.invisibilityOf(loader));

        wait.until(ExpectedConditions.visibilityOf(tableHeaderName.get(0)));

        Set<String> actualTableContents = new HashSet<>();

        Thread.sleep(2000);

        Set<String>expectedTableContents = new HashSet<>(Arrays.asList("Benefit Name","Benefit Category","Benefit Type","Date Received","Beneficiary Name","Beneficiary Id","Country","Total value","Dependents","Unique Claim ID"));

        for(WebElement ele : tableHeaderName){

            actualTableContents.add(ele.getText());
        }

        Thread.sleep(3000);

        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Columns Present In Social Benefit Audit Trail", new ByteArrayInputStream(screenshot1));
        Thread.sleep(3000);

        Assert.assertEquals(actualTableContents,expectedTableContents);

        Thread.sleep(2000);



    }
    public void verifyImpactHubAuditTrailCollections(String expectedBenefit1, String expectedBenefit2) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.elementToBeClickable(collectionsButtons));
        collectionsButtons.click();
        Thread.sleep(2000);

        try {

            wait.until(ExpectedConditions.visibilityOf(tableHeaderName.get(0)));

            Set<String> actualTableContents = new HashSet<>();

            Thread.sleep(2000);

            Set<String> expectedTableContents = new HashSet<>(Arrays.asList("Transaction Type", "Seller Name", "Buyer Name", "Collection Date", "Order Date", "Country", "Material", "Color", "Weight", "Total Value", "Material Value", "Bonus Value", "Output"));

            for (WebElement ele : tableHeaderName) {

                actualTableContents.add(ele.getText());
            }

            Thread.sleep(3000);

            TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
            byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Columns Present In Audit Trail", new ByteArrayInputStream(screenshot1));
            Thread.sleep(3000);

            Assert.assertEquals(actualTableContents, expectedTableContents);

            Thread.sleep(2000);

        }
        catch (Exception e){

            summaryButton.click();
            wait.until(ExpectedConditions.invisibilityOf(loader));
            collectionsButtons.click();

            wait.until(ExpectedConditions.visibilityOf(tableHeaderName.get(0)));

            Set<String> actualTableContents = new HashSet<>();

            Thread.sleep(2000);

            Set<String> expectedTableContents = new HashSet<>(Arrays.asList("Transaction Type", "Seller Name", "Buyer Name", "Collection Date", "Order Date", "Country", "Material", "Color", "Weight", "Total Value", "Material Value", "Bonus Value", "Output"));

            for (WebElement ele : tableHeaderName) {

                actualTableContents.add(ele.getText());
            }

            Thread.sleep(3000);

            String actualBenefit1=benefit1InTable.getText();
            String actualBenefit2=benefit2InTable.getText();

            Assert.assertEquals(actualBenefit1,expectedBenefit1);
            Assert.assertEquals(actualBenefit2,expectedBenefit2);

            TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
            byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Columns Present In Audit Trail", new ByteArrayInputStream(screenshot1));
            Thread.sleep(3000);

            Assert.assertEquals(actualTableContents, expectedTableContents);

            Thread.sleep(2000);

        }

    }
    public void socialBenefitsValueVerify() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(120));
        Actions action = new Actions(alcDriver);
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;

        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(auditTrailTab));
        auditTrailTab.click();

        wait.until(ExpectedConditions.invisibilityOf(loader));
        Thread.sleep(1000);

        action.scrollToElement(socialBenefitChartValues.get(0)).build().perform();

        byte[] screenshot2 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Social Benefits dashboard ", new ByteArrayInputStream(screenshot2));
        Thread.sleep(3000);

        for(WebElement ele:socialBenefitChartValues){

            socialBenefitsString.add(ele.getText());
            Thread.sleep(2000);

        }
        System.out.println(socialBenefitsString);

        int totalSum = 0;

        for (String socBenSt : socialBenefitsString) {

            int number  = Integer.parseInt(socBenSt.replace(",", ""));
            totalSum += number;

        }

        totalSocialBenefitsCalculated=totalSum;

        System.out.println(totalSocialBenefitsCalculated);

        action.scrollToElement(socialBenefitsTotalTop).build().perform();

        byte[] screenshot3 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Social Benefits Total at Top ", new ByteArrayInputStream(screenshot3));
        Thread.sleep(3000);

        String totalSocialBenefitsSt=socialBenefitsTotalTop.getText();
        String totalSocBenSt=totalSocialBenefitsSt.replace(",","").replace(" ","");
        totalSocialBenefits=Integer.parseInt(totalSocBenSt);

        Assert.assertEquals(totalSocialBenefitsCalculated,totalSocialBenefits);

        System.out.println(totalSocialBenefits);



    }
    public void filterAuditTrail() throws InterruptedException {


        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(120));
        allCountriesDropdown.click();
        Thread.sleep(2000);
        philippinesCheckBox.click();
        Thread.sleep(2000);
        applyFilterButtonCountry.click();
        Thread.sleep(4000);

        allYearDropdown.click();
        Thread.sleep(2000);
        year2024.click();
        Thread.sleep(2000);
        applyFilterButtonYear.click();
        Thread.sleep(4000);

        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Filter Applied ", new ByteArrayInputStream(screenshot1));
        Thread.sleep(3000);

        Actions action =new Actions(alcDriver);
        action.scrollToElement(socialBenefitChartValues.get(0)).build().perform();

        byte[] screenshot2 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Social Benefits dashboard ", new ByteArrayInputStream(screenshot2));
        Thread.sleep(3000);


        for(WebElement ele:socialBenefitChartValues){

            socialBenefitsString2.add(ele.getText());
            Thread.sleep(2000);

        }
        System.out.println(socialBenefitsString2);

        int totalSum = 0;

        for (String socBenSt : socialBenefitsString2) {

            int number  = Integer.parseInt(socBenSt.replace(",", ""));
            totalSum += number;

        }

        totalSocialBenefitsCalculated=totalSum;

        System.out.println(totalSocialBenefitsCalculated);

        action.scrollToElement(socialBenefitsTotalTop).build().perform();

        byte[] screenshot3 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Social Benefits Total at Top ", new ByteArrayInputStream(screenshot3));
        Thread.sleep(3000);

        String totalSocialBenefitsSt=socialBenefitsTotalTop.getText();
        String totalSocBenSt=totalSocialBenefitsSt.replace(",","").replace(" ","");
        totalSocialBenefits=Integer.parseInt(totalSocBenSt);

        Assert.assertEquals(totalSocialBenefitsCalculated,totalSocialBenefits);

        System.out.println(totalSocialBenefits);



    }

    public static int convertToInt(String numberString) {

        // Remove leading and trailing whitespaces
        String trimmedNumber = numberString.trim();

        // Remove commas from the number string
        String numberWithNoCommas = trimmedNumber.replace(",", "").replace(" ","");

        // Parse the string into an integer
        int intValue = Integer.parseInt(numberWithNoCommas);

        return intValue;
    }

    public static List<Integer> convertToIntList(List<String> numberStrings) {

        List<Integer> intList = new ArrayList<>();
        int totalSum = 0;
        for (String numberString : numberStrings) {

            int number  = Integer.parseInt(numberString.replace(",", ""));
            totalSum += number;

        }
        return intList;

    }




}