package alchemy_Pages;

import Utilities.BaseClass;
import io.qameta.allure.Allure;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.List;

public class Client_Dashboards extends BaseClass {

    public Client_Dashboards(WebDriver alcDriver){
        PageFactory.initElements(alcDriver, this);
    }


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
    @FindBy(xpath = "//div[normalize-space(text())='Client Dashboards']")
    public WebElement clientDashBoards;
    @FindBy(xpath = "//div[@class='pb-add-button fixed']")
    public WebElement addButton;
    @FindBy(xpath = "//input[@id=\"dashboard-name\"]")
    public WebElement dashboardNameTextField;
    @FindBy(xpath = "//input[@id=\"dashboard-path\"]")
    public WebElement dashboardPathTextField;
    @FindBy(xpath = "//label[text()=\"Company logo*\"]/following-sibling::div")
    public WebElement companyLogo;
    @FindBy(xpath = "//label[text()='Audit Trail - Social Benefits']/parent::div/following-sibling::input")
    public WebElement auditTrailSBCheckBox;
    @FindBy(xpath = "(//div[text()='Enable / Disable Columns'])[2]")
    public WebElement enableDisableColumns;
    @FindBy(xpath = "//div[@class='pb-ballot-button small absolute inside-input']")
    public WebElement benefitOrderList;
    @FindBy(xpath = "(//div[@class='pb-ballot-button small absolute inside-input'])[2]")
    public WebElement benefitOrderList2;
    @FindBy(xpath = "//input[@placeholder='Name']")
    public WebElement nameTextField;
    @FindBy(xpath = "//input[@placeholder='Country']")
    public WebElement countryTextField;
    @FindBy(xpath = "(//span[@class='mdl-checkbox__tick-outline'])[2]")
    public WebElement checkBox;
    @FindBy(xpath = "//button[text()='Create']")
    public WebElement createButton;

    @FindBy(xpath="//label[normalize-space()='Benefit Category']/parent::div/following-sibling::input") public WebElement benefitCategory;
    @FindBy(xpath="//label[normalize-space()='Benefit Name']/parent::div/following-sibling::input") public WebElement benefitName;
    @FindBy(xpath="//label[normalize-space()='Benefit Type']/parent::div/following-sibling::input") public WebElement benefitType;
    @FindBy(xpath="//label[normalize-space()='Date Received']/parent::div/following-sibling::input") public WebElement dateReceived;
    @FindBy(xpath="//label[normalize-space()='Beneficiary Name']/parent::div/following-sibling::input") public WebElement beneficiaryName;
    @FindBy(xpath="//label[normalize-space()='Beneficiary Id']/parent::div/following-sibling::input") public WebElement beneficiaryId;
    @FindBy(xpath="//label[normalize-space()='Country']/parent::div/following-sibling::input") public WebElement country;
    @FindBy(xpath="//label[normalize-space()='Total value']/parent::div/following-sibling::input") public WebElement totalValue;
    @FindBy(xpath="//label[normalize-space()='Dependents']/parent::div/following-sibling::input") public WebElement dependents;
    @FindBy(xpath="//label[normalize-space()='Unique Claim ID']/parent::div/following-sibling::input") public WebElement uniqueClaimID;


    @FindBy(xpath = "//label[text()='Audit Trail - Plastic']/parent::div/following-sibling::input")
    public WebElement auditTrailCheckBox;
    @FindBy(xpath = "(//div[@class='pb-ballot-button small absolute inside-input'])[1]")
    public WebElement brandsList;
    @FindBy(xpath = "(//div[@class='pb-ballot-button small absolute inside-input'])[2]")
    public WebElement brandsList2;
    @FindBy(xpath = "(//div[text()='Enable / Disable Columns'])[1]")
    public WebElement enableDisableColumns1;
    @FindBy(xpath = "(//div[@class=\"ml-2 pb-add-button small\"])[1]")
    public WebElement addDataSourceButton;
    @FindBy(xpath="//label[normalize-space()='Transaction Type']/parent::div/following-sibling::input")
    public WebElement transactionType;
    @FindBy(xpath="//label[normalize-space()='Seller ID']/parent::div/following-sibling::input")
    public WebElement sellerId;
    @FindBy(xpath="//label[normalize-space()='Buyer ID']/parent::div/following-sibling::input")
    public WebElement buyerId;
    @FindBy(xpath="//label[normalize-space()='City']/parent::div/following-sibling::input")
    public WebElement city;
    @FindBy(xpath="//label[normalize-space()='Tokens']/parent::div/following-sibling::input")
    public WebElement tokens;
    @FindBy(xpath="//label[normalize-space()='Sponsor Claim']/parent::div/following-sibling::input")
    public WebElement sponsorClaim;
    @FindBy(xpath="//label[normalize-space()='Supply Chain Claim']/parent::div/following-sibling::input")
    public WebElement supplyChainClaim;
    @FindBy(xpath="//label[normalize-space()='Path']/parent::div/following-sibling::input")
    public WebElement path;
    @FindBy(xpath="//label[normalize-space()='Unique Impact Claim']/parent::div/following-sibling::input")
    public WebElement uniqueImpactClaim;
    @FindBy(xpath="//label[normalize-space()='Local Currency']/parent::div/following-sibling::input")
    public WebElement localCurrency;
    @FindBy(xpath="//label[normalize-space()='Oceanbound Verified']/parent::div/following-sibling::input")
    public WebElement oceanboundVerified;
    @FindBy(xpath="//label[normalize-space()='Bonus Claim']/parent::div/following-sibling::input")
    public WebElement bonusClaim;
    @FindBy(xpath="//label[normalize-space()='Verified Claim Status']/parent::div/following-sibling::input")
    public WebElement verifiedClaimStatus;
    @FindBy(xpath="//label[normalize-space()='Output Status']/parent::div/following-sibling::input")
    public WebElement outputStatus;
    @FindBy(xpath="//label[normalize-space()='Transaction ID']/parent::div/following-sibling::input")
    public WebElement transactionID;

    @FindBy(xpath = "//input[@placeholder=\"Dashboard Name\"]")
    public WebElement nameTextfield;
    @FindBy(xpath = "//div[@class='container-fluid']//datatable//table/tbody/tr[1]/td[1]/div/div")
    private WebElement tableData_FirstRow;
    @FindBy(xpath = "//h4[text()='Missing data source']")
    public WebElement missingDataPopUp;
    @FindBy(xpath = "//button[text()='Close']")
    public WebElement closeButton;



    public static String dashBoardPath = "fleek"+ RandomStringUtils.randomAlphabetic(6);
    public static String dashBoardName = "Fleek_DashBoard_"+ dashBoardPath;
    public static String email ="ashish.rawat@fleekitsolutions.com";


    WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
    Actions action =new Actions(alcDriver);
    public void checkClientDashBoard() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(clientDashBoards));
        clientDashBoards.click();

        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        addButton.click();

        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(dashboardNameTextField));

        dashboardPathTextField.sendKeys(dashBoardPath);
        dashboardNameTextField.sendKeys(dashBoardName);

        wait.until(ExpectedConditions.visibilityOf(addNewAdmin));
        addNewAdmin.click();
        wait.until(ExpectedConditions.visibilityOf(searchTextField));
        searchTextField.sendKeys(email);
        Thread.sleep(3000);
        searchIcon.click();
        Thread.sleep(3000);

        searchResultAshish.click();

        confirmButton.click();

        Actions action =new Actions(alcDriver);
        action.scrollToElement(auditTrailSBCheckBox).build().perform();

        auditTrailSBCheckBox.click();
        benefitOrderList.click();
        Thread.sleep(4000);

        nameTextField.sendKeys("Master Benefit Order Philippine");
        Thread.sleep(4000);
        //action.moveToElement(checkBox).click().build().perform();
        checkBox.click();
        confirmButton.click();

        Thread.sleep(2000);

        enableDisableColumns.click();
        Thread.sleep(1000);

        action.scrollToElement(uniqueClaimID).build().perform();

        String statusBenefitName=benefitName.getAttribute("input");
        String statusBenefitCategory=benefitCategory.getAttribute("input");
        String statusBenefitType=benefitType.getAttribute("input");
        String statusDateReceived=dateReceived.getAttribute("input");
        String statusBeneficiaryName=beneficiaryName.getAttribute("input");
        String statusBeneficiaryId=beneficiaryId.getAttribute("input");
        String statusCountry=country.getAttribute("input");
        String statusTotalValue=totalValue.getAttribute("input");
        String statusDependents=dependents.getAttribute("input");
        String statusUniqueClaimID=uniqueClaimID.getAttribute("input");

        beneficiaryId.click();
        uniqueClaimID.click();

//        Assert.assertTrue(statusBenefitName.equals("disabled"));
//        Assert.assertTrue(statusDateReceived.equals("disabled"));
//        Assert.assertTrue(statusCountry.equals("disabled"));


        Thread.sleep(2000);
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Enable Disable Columns ", new ByteArrayInputStream(screenshot1));
        Thread.sleep(3000);

        action.scrollToElement(createButton).build().perform();
        createButton.click();
        Thread.sleep(5000);

    }

    public void auditTrailDashBoard() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(clientDashBoards));
        clientDashBoards.click();

        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        addButton.click();

        dashboardPathTextField.sendKeys(dashBoardPath);
        dashboardNameTextField.sendKeys(dashBoardName);

        wait.until(ExpectedConditions.visibilityOf(addNewAdmin));
        addNewAdmin.click();
        wait.until(ExpectedConditions.visibilityOf(searchTextField));
        searchTextField.sendKeys(email);
        Thread.sleep(3000);
        searchIcon.click();
        Thread.sleep(3000);

        searchResultAshish.click();
        confirmButton.click();

        Actions action =new Actions(alcDriver);
        action.scrollToElement(auditTrailCheckBox).build().perform();
        Thread.sleep(2000);
        auditTrailCheckBox.click();
        Thread.sleep(1000);
        addDataSourceButton.click();
        Thread.sleep(2000);
        brandsList.click();

        Thread.sleep(3000);
        nameTextField.sendKeys("Plastic Bank");
        Thread.sleep(5000);
        //action.moveToElement(checkBox).click().build().perform();
        checkBox.click();
        confirmButton.click();

        Thread.sleep(2000);

        enableDisableColumns1.click();

        Thread.sleep(2000);
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Enable Disable Columns ", new ByteArrayInputStream(screenshot1));
        Thread.sleep(3000);

        action.scrollToElement(createButton).build().perform();
        createButton.click();
        Thread.sleep(5000);



    }
    public void createClientDashboard() throws InterruptedException {

            wait.until(ExpectedConditions.elementToBeClickable(clientDashBoards));
            clientDashBoards.click();

            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(addButton));
            addButton.click();

            Thread.sleep(2000);
            wait.until(ExpectedConditions.visibilityOf(dashboardNameTextField));

            dashboardPathTextField.sendKeys(dashBoardPath);
            dashboardNameTextField.sendKeys(dashBoardName);

            wait.until(ExpectedConditions.visibilityOf(addNewAdmin));
            addNewAdmin.click();
            wait.until(ExpectedConditions.visibilityOf(searchTextField));
            searchTextField.sendKeys(email);
            Thread.sleep(3000);
            searchIcon.click();
            Thread.sleep(3000);

            searchResultAshish.click();

            confirmButton.click();

            Thread.sleep(3000);
            Actions action =new Actions(alcDriver);
            action.scrollToElement(auditTrailCheckBox).build().perform();
            Thread.sleep(2000);
            auditTrailCheckBox.click();
            Thread.sleep(1000);
            addDataSourceButton.click();
            Thread.sleep(2000);
            brandsList.click();

        Thread.sleep(3000);
        nameTextField.sendKeys("Plastic Bank");
        Thread.sleep(5000);
        //action.moveToElement(checkBox).click().build().perform();
        checkBox.click();
        confirmButton.click();

        Thread.sleep(2000);

        action.scrollToElement(auditTrailSBCheckBox).build().perform();

        auditTrailSBCheckBox.click();
        benefitOrderList2.click();
        Thread.sleep(4000);

        nameTextField.sendKeys("Master Benefit Order Philippine");
        Thread.sleep(4000);
        //action.moveToElement(checkBox).click().build().perform();
        checkBox.click();
        confirmButton.click();

        Thread.sleep(2000);


        action.scrollToElement(createButton).build().perform();

            action.moveToElement(esgCheckmark).click().build().perform();

            for(WebElement ele : enabledEsg4Checkmarks){
                action.moveToElement(ele).click().build().perform();
            }
            Thread.sleep(2000);

            TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
            byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Enable Disable Columns ", new ByteArrayInputStream(screenshot1));
            Thread.sleep(3000);


            createButton.click();
            Thread.sleep(5000);
            System.out.println(dashBoardPath);

    }
    public void editClientDashboard() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(nameTextfield));
        nameTextfield.sendKeys(dashBoardName);
        Thread.sleep(5000);
        tableData_FirstRow.click();
        Thread.sleep(5000);

        Actions action =new Actions(alcDriver);
        action.scrollToElement(enableDisableColumns).build().perform();
        enableDisableColumns.click();

        Thread.sleep(2000);

        beneficiaryId.click();
        uniqueClaimID.click();

        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(" Enable Disable Columns Audit Trail - Social Benefits  ", new ByteArrayInputStream(screenshot1));
        Thread.sleep(3000);

        enableDisableColumns1.click();
        action.scrollToElement(enableDisableColumns1).build().perform();

        Thread.sleep(2000);
        byte[] screenshot2 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Enable Disable Columns Audit Trail - Plastic", new ByteArrayInputStream(screenshot2));
        Thread.sleep(3000);

        updateButton.click();

        Thread.sleep(4000);

    }

}
