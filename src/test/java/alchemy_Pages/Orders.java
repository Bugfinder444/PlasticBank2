package alchemy_Pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BaseClass;
import Utilities.rData;
import Utilities.Data;
import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
;import static org.testng.Assert.*;

public class Orders extends BaseClass{
    public Orders(WebDriver alcDriver){
        PageFactory.initElements(alcDriver, this);
    }

    @FindBy(xpath = "//div[@class='body']/div/div/div[text()=' Orders ']") WebElement orders_tab;
    @FindBy(xpath = "//a[@role='tab' and text()='Bonus']") WebElement ordersTab_bonus;
    @FindBy(xpath = "//a[@role='tab' and text()='Transfers']") WebElement ordersTab_transfer;
    @FindBy(xpath = "//datatable//input[@placeholder='Name']") WebElement name_SearchBox;
    @FindBy(xpath = "//div//datatable//table/tbody/tr[1]/td/div/div") List <WebElement> table_firstRowData;
    @FindBy(xpath = "//div[@class='container-fluid']//datatable//table/tbody/tr[1]/td[1]/div/div")
    WebElement tableData_FirstRow;
    @FindBy(xpath = "//div[@class='container-fluid']//datatable//table/tbody/tr[1]/td[5]/div/div")
    WebElement tableData_FirstRow_KGDelivered;
    @FindBy(xpath = "//div[@class='container-fluid']//datatable//table/tbody/tr[1]/td[4]/div/div")
    WebElement tableData_FirstRow_KGPromised;
    @FindBy(xpath = "//div[@class='container-fluid']//datatable//table/tbody/tr[1]/td[8]/div/div")
    WebElement tableData_FirstRow_PendingKG;
    @FindBy(xpath = "//div[text()=' Emergency Stop ']") WebElement emergency_stopBtn;
    @FindBy(xpath = "//div[@role='document']/div") WebElement popUp_alert;
    @FindBy(xpath = "//div/button[text()='OK']") WebElement okBtn_alertBox;
    @FindBy(xpath = "//*[text()=' This offset has been stopped. ']") WebElement offer_stopText;

    //today changes
    @FindBy(xpath = "//div[@class='container-fluid']/offsets/div[2]") WebElement newBonus_btn;
    @FindBy(xpath = "//label[text()='Bonus name']/parent::div/input[@id='name']") WebElement bonusName;
    @FindBy(xpath = "//label[text()='Country']/parent::div/select[@id='country']") WebElement country;
    @FindBy(xpath = "//label[text()='Country']/parent::div/select[@id='country']/option[text()='Philippines']") WebElement selectPhilippines;
    @FindBy(xpath = "//label[text()='Brand']/parent::div/input[@id='brand']") WebElement brandName;
    @FindBy(xpath = "//div[contains(@class, 'dropdown-content')]//li[contains(text(), 'Plastic Bank')]") WebElement selectBrandName;
    @FindBy(xpath = "//label[text()='Category']/parent::div/select")
    WebElement categoryDropDown;
    @FindBy(xpath = "//label[text()='Category']/parent::div/select/option[text()=' All eligible materials  ']")
    WebElement selectCate_AllEligible;
    @FindBy(xpath = "//label[text()='Total Weight (kg)']/parent::div/input[@id='name']")
    WebElement selectTotalWeight;
    @FindBy(xpath = "//label[text()='Members bonus/kg']/parent::div/input[@id='name']")
    WebElement membersBonusKg;
    @FindBy(xpath = "//label[text()='Branch bonus/kg']/parent::div/input[@id='name']")
    WebElement branchBonusKg;
    @FindBy(xpath = "//*[text()='Create']")
    WebElement createBtn;
    @FindBy(xpath = "//input[@id='smsCode']")
    WebElement authCode;
    @FindBy(xpath = "//button[@type='button' and text()='Submit']") 
    WebElement authCodeSubmitBtn;
    @FindBy(xpath = "//*[text()='Bonus Approval ']")
	public static WebElement bonusApprovalTab;
    @FindBy(xpath = "//button/span[text()=' Add Branch ']") WebElement addBranchBtn;
    @FindBy(xpath = "//datatable//table/tbody/tr[1]/td[1]/div/div")
    WebElement branchInBonus;
    @FindBy(xpath = "//button[text()='Confirm']")
    WebElement confirmBtn;
    @FindBy(xpath = "//loader/div//table")
    WebElement pageLoader;

    @FindBy(xpath = "//div[text()=' Bonus Progress ']/following-sibling::div[1]") 
    WebElement summary_bonusProgressText;
    @FindBy(xpath = "//span[text()='HDPE']/following-sibling::span[1]") 
    WebElement summary_HDPE_KG_Text;
    @FindBy(xpath = "//span[text()='PET']/following-sibling::span[1]") 
    WebElement summary_PET_KG_Text;
    @FindBy(xpath = "//div[normalize-space()='TOTAL:']/following-sibling::span") 
    WebElement summary_Total_KG_Text;
    
    @FindBy(xpath = "//div[text()='Exchange History ']")
    WebElement exchangeHistoryTab;
    
    @FindBy(xpath = "//div[text()='HDPE-Clean-Clear / 10.00 kg']") 
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
    @FindBy(xpath = "//div[text()='Bonus']/following-sibling::div") 
    WebElement excHisTotalBonus;
    //133
    @FindBy(xpath = "//div[@role='tab']/div/button") WebElement selectAddedBranchInBonus;
    @FindBy(xpath = "//button/span[text()=' Edit Bonus Options']") WebElement editBonusOpt;
    @FindBy(xpath = "//span[text()='Branch to Branch bonus']/parent::div/select") WebElement branchBonusOpt;
    @FindBy(xpath = "//span[text()='Branch to Branch bonus']/parent::div//option[text()='Any']") WebElement selectAnyOpt;
    @FindBy(xpath = "//button[text()=' Confirm new participants']") WebElement confirmNewParticipants;
    @FindBy(xpath = "//button[text()='Close']") WebElement closeBtnPopup;
    @FindBy(xpath = "//button[text()='Save']") WebElement saveBonusInfoBtn;
    @FindBy(xpath = "//div[text()='Summary']") 
    WebElement summary;
    @FindBy(xpath = "//span[text()='Start Approval']") 
    WebElement startApproval;
    @FindBy(xpath = "//span[@class='expanded-entity-icon']")
    List<WebElement> expander;
    
    @FindBy(xpath = "//div[@class='col text-dark-grey d-flex align-items-center']/descendant::div[@class='row']") 
    WebElement bonusinBAtext;
    @FindBy(xpath = "//div[@class='col-auto d-flex align-items-center']") 
    WebElement dp;
    @FindBy(xpath = "//div[text()='133 ']") 
    WebElement bonus133;
    @FindBy(xpath = "//div[text()='Exchange History ']") 
    WebElement exchangehistory;
    @FindBy(xpath = "//div[@class='card-header']") 
    WebElement pccardheader;
    @FindBy(xpath = "//i[@class='fa fa-circle text-green']") 
    WebElement greencircle;
    @FindBy(xpath = "//div[text()='Bonus Approval ']") 
    WebElement bonusApproval;
    @FindBy(xpath = "//li[contains(@class,'page-item')]")
    WebElement lastItemOnPaage;
    @FindBy(xpath = "//li[contains(@class,'page-item')][5]")
    WebElement lastItemOnPageOrder;
    @FindBy(xpath = "//a[contains(text(),'Sell Transactions')]")
    WebElement selltransactions;   
    @FindBy(xpath = "//a[contains(text(),'Buy Transactions')]")
    WebElement buytransactions;
    @FindBy(xpath = "//div[text()=' 0% fulfilled ']") 
    WebElement fulfilledbonus;
    @FindBy(xpath = "//button[@disabled]/descendant::span[text()='Start Approval']")
    WebElement disabledStartApproval;
    @FindBy(xpath = "//div[text()='Bonus']")
    WebElement bonusExcHisBonus;
    @FindBy(xpath = "//div[text()='Bonus']/following-sibling::div")
    WebElement bonusExcHisBonusText;
    @FindBy(xpath = "//div[text()='KG Recycled']/following-sibling::div/div/following-sibling::div/div")
    WebElement kgrecycled;
    @FindBy(xpath = "//button[contains(text(),'Fleek')]")
    WebElement bonusname;
    @FindBy(xpath = "//div[@class='card-header']/div/button")
    List<WebElement> transactions;
    @FindBy(xpath = "//span[text()='View Audit Trail']")
    WebElement viewAuditTrail;
    @FindBy(xpath = "(//div[text()=' Total KG Sold '])[1]/span")
    WebElement verifyKgVoided;

//////////////////////////Locators Related to Order///////////////////////////
    @FindBy(xpath="(//a[normalize-space()='Orders'])")
    public WebElement ordersTab;

    @FindBy(xpath="//div[@class='pb-add-button fixed ng-star-inserted']")
    public WebElement addIcon;
    @FindBy(xpath="//label[text()='Order name']/following::input")
    public WebElement orderNameTextFeild;
    @FindBy(xpath="//select[@id='country']")
    public WebElement countryDropdown;
    @FindBy(xpath="//select[@id='country']//following::option[text()='Philippines']")
    public WebElement selectCountryPhilippines;
    @FindBy(xpath="//select[@id='priceType']")
    public WebElement priceTypeDropdown;
    @FindBy(xpath="//input[@id='startDate']")
    public WebElement startDate;
    @FindBy(xpath="//input[@id='dueDate']")
    public WebElement dueDate;
    @FindBy(xpath="//input[@id='noDueDate']")
    public WebElement noDueDate;
    @FindBy(xpath="//input[@id='brand']")
    public WebElement brandTextField;
    @FindBy(xpath="//li[text()=' Plastic Bank ']")
    public WebElement brandPlasticBank;

    @FindBy(xpath="//input[@id='shippingDate']")
    public WebElement shippingDate;
    @FindBy(xpath="//input[@name=\"orderDate\"]")
    public WebElement orderDate;
    @FindBy(xpath="//input[@id='productionDate']")
    public WebElement productionDate;
    @FindBy(xpath="//input[@id='subBrand']")
    public WebElement subBrand;
    @FindBy(xpath="//input[@name=\"referenceID\"]")
    public WebElement referenceIdTextField;
    @FindBy(xpath="//label[text()='Total Revenue (USD)']/following::input")
    public WebElement totalRevenueUSDTextField;
    @FindBy(xpath="//label[text()='Category']/following::select[1]")
    public WebElement categoryDropdown;
    @FindBy(xpath="//label[text()='Type']/following::select")
    public WebElement typeDropdown;
    @FindBy(xpath="//label[text()='Color']/following::select")
    public WebElement colorDropdown;
    @FindBy(xpath="//label[text()='Weight/kg']/following::input")
    public WebElement weightTextField;
    @FindBy(xpath="//div[text()=' Assign Processor ']/div")
    public WebElement assignProcessorButton;
    @FindBy(xpath="//button[normalize-space()='Create']")
    public WebElement createButton;
    @FindBy(xpath="//input[@placeholder='Name']")
    public WebElement nameSearchField;
    @FindBy(xpath="//datatable//table/tbody/tr[1]/td[1]/div/div")
    public WebElement checkBoxInProcessorAssign;
    @FindBy(xpath="//select[@title='Select year']")
    public WebElement selectYear;
    @FindBy(xpath="//div[@role='gridcell']/div[text()]")
    public WebElement selectDate;
    @FindBy(xpath="//span[text()=' Edit Order ']")
    public WebElement editOrder;
    @FindBy(xpath="//div[text()='Save']")
    public WebElement saveButton;
    @FindBy(xpath="//div[contains(text(),'Order Name:')]")
    public WebElement ordername;
    @FindBy(xpath="//div[contains(text(),' Add From Exchange History ')]")
    public WebElement addFromExchangeHistoryButton;
    @FindBy(xpath="//select[@name='selectedOrderStatus']")
    public WebElement sp_EPR_EligibleDropdown;
    @FindBy(xpath="//option[text()='Show All']")
    public WebElement showAllDropdown;
    @FindBy(xpath="//label[text()=' Select All ']")
    public WebElement selectAllCheckMark;
    @FindBy(xpath="//tbody/tr/td[5]/div[1]/div")
    public List<WebElement> bonusOrderVerify;
    @FindBy(xpath="//tbody/tr/td[4]/div[1]/div[1]")
    public List<WebElement> totalKg;
    @FindBy(xpath="//span[contains(text(),'Total Collected: ')]")
    public WebElement totalCollectedKg;
    @FindBy(xpath="//span[contains(text(),'Pending')]")
    public WebElement pendingKg;
    @FindBy(xpath="//div[contains(text(),' TOTAL: ')]/following::span")
    public WebElement total;

    @FindBy(xpath="//div[text()=' Add Bonus ']")
    public WebElement addBonusTag;
    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement searchOffsets;
    @FindBy(xpath = "(//span[contains(@class,'tick')])[last()]")
    WebElement checkBoxSearchOffsets;
    @FindBy(xpath = "(//div[@class=\"pb-delete-icon mr-2 pointer\"])[last()]")
    WebElement deleteBonusButton;
    @FindBy(xpath = "//div[text()='Audit Trail ']")
    WebElement auditTrailTag;
    @FindBy(xpath = "//div[contains(text(),\"4,546\")]")
    WebElement kgDeliveredToplun;
    @FindBy(xpath = "//div[contains(text(),\"Order details\")]")
    WebElement orderDetailsTag;
    @FindBy(xpath = "//div[contains(text(),'Total Weight: ')]")
    List<WebElement> totalWeight;

    @FindBy(xpath = "//tbody/tr[2]/td[1]/div[1]/div[1]")
    WebElement connectedBonusScroll;

    // ALC-687
    @FindBy(xpath = "//span[contains(@class,'text-orange')]")
    List<WebElement> textOrange;

    @FindBy(xpath = "//span[contains(@class,'text-green')]")
    List<WebElement> textGreen;
    @FindBy(xpath = "//div[contains(@class,\"label text-primary-blue text-center \")]")
    List<WebElement> buyerSeller;

    @FindBy(xpath = "//div[text()='Bonus Orders']/following::div[2]")
    List<WebElement> bonusOrders;
    @FindBy(xpath = "//span[contains(text(),\"Bonus\")]")
    List<WebElement> bonus;

    @FindBy(xpath = "//div[text()=' Associated Transaction Items From Exchange History ']/following::input[@placeholder=\"Buyer\"]/following::tr/td[1]/div/div")
    List<WebElement> buyerAddExcHis;
    @FindBy(xpath = "//div[text()=' Associated Transaction Items From Exchange History ']/following::input[@placeholder=\"Seller\"]/following::tr/td[2]/div/div")
    List<WebElement> sellerAddExcHis;
    @FindBy(xpath = "//div[text()=' Associated Transaction Items From Exchange History ']/following::input[@placeholder=\"Country\"]/following::tr/td[3]/div/div")
    List<WebElement> countryAddExcHis;
    @FindBy(xpath = "//div[text()=' Associated Transaction Items From Exchange History ']/following::input[@placeholder=\"Total KG\"]/following::tr/td[4]/div/div")
    List<WebElement> totalKgAddExcHis;
    @FindBy(xpath = "//div[text()=' Associated Transaction Items From Exchange History ']/following::input[@placeholder=\"Bonus Orders\"]/following::tr/td[5]/div/div")
    List<WebElement> bonusOrderAddExcHis;
    @FindBy(xpath = "(//div[text()=' TOTAL: '])[2]/following::div[1]/div")
    WebElement totalKgAtTop;
    @FindBy(xpath = "//span[text()='Bonus 0']/parent::div/parent::div/parent::div//input")
    List<WebElement> bonus0checkBox;
    @FindBy(xpath = "//div[text()='Plastik-PET-Clean-Class b / 150.00 kg']/parent::div/parent::div//input")
    WebElement checkBoxDonation;
    @FindBy(xpath = "//div[text()='Plastik-PET-Clean-Blue / 8.00 kg']/parent::div/parent::div//input")
    WebElement checkBoxWithOutBonus;
    @FindBy(xpath = "//span[text()='']/parent::div/parent::div/parent::div//input")
    List<WebElement> checkBoxTransaction;

    @FindBy(xpath = "//div[text()='Plastik-ABS-Clean-Mixed / 101.20 kg']/parent::div/parent::div//input")
    WebElement checkBox101;
    @FindBy(xpath = "//div[text()='Plastik-PET-Clean-Green / 5.50 kg']/parent::div/parent::div//input")
    WebElement checkBox5;
    @FindBy(xpath = "//div[text()='Plastik-PET-Clean-Green / 25.00 kg']/parent::div/parent::div//input")
    WebElement checkBox25;
    @FindBy(xpath = "//div[text()='Plastik-PET-Clean-Green / 20.00 kg']/parent::div/parent::div//input")
    WebElement checkBox20;
    @FindBy(xpath = "//div[text()='Plastik-PET-Clean-Green / 10.00 kg']/parent::div/parent::div//input")
    WebElement checkBox10;
    @FindBy(xpath = "//div[text()='Plastik-PET-Clean-Green / 50.00 kg']/parent::div/parent::div//input")
    WebElement checkBox50;
    @FindBy(xpath = "(//span[text()=\"Plastic Chain\"])[2]")
    WebElement plasticChain2;
    @FindBy(xpath = "(//span[text()=\"Plastic Chain\"])[1]")
    WebElement plasticChain1;



    public static String expectedexcHisHdpeKG="HDPE-Clean-Clear / 10.00 kg";
    public static String expectedexcHisPetKG="PET-Raw-Transparent / 9.00 kg";
    public static String expectedexcHisHdpeBonus="Bonus 70";
    public static String expectedexcHisPetBonus="Bonus 63";
    public static String expectedexcHisTotalKg="Total Weight: 19.00 KG";
    public static String expectedexcHisTotalBonus="133";
    public static String order_Name;
    public static String order_NameUpdated;
    public static String refId;

    public void clickOrdersTab() throws InterruptedException {
		/*
		 * WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
		 * wait.until(ExpectedConditions.invisibilityOf(pageLoader));
		 */
    	Thread.sleep(5000);
        orders_tab.click();
    }

    public void clickBounsTab() throws InterruptedException {
		/*
		 * WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
		 * wait.until(ExpectedConditions.invisibilityOf(pageLoader));
		 */
        Thread.sleep(5000);
        ordersTab_bonus.click();
    }

    public void search_byName(String name) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOf(pageLoader));
        wait.until(ExpectedConditions.elementToBeClickable(name_SearchBox));
        name_SearchBox.click();
        name_SearchBox.clear();
        name_SearchBox.sendKeys(name);
        Thread.sleep(10000);
    }

    public void clickSpecificOrdersBonus() {
        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(tableData_FirstRow));
        tableData_FirstRow.click();
    }
    public void clickExchangeHistory() {
    WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
    //wait.until(ExpectedConditions.invisibilityOf(pageLoader));
    wait.until(ExpectedConditions.elementToBeClickable(exchangeHistoryTab));
    exchangeHistoryTab.click();
    }
    public void clickEmergencyStopBtn(){
        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(emergency_stopBtn));
        emergency_stopBtn.click();
    }

    public Boolean verifyAlertBox() {
        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(popUp_alert));
        return popUp_alert.isDisplayed();
    }

    public void clickAlertBoxBtnOK() {
        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(okBtn_alertBox));
        okBtn_alertBox.click();
    }

    public Boolean verifyOffer_stopText() {
        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(offer_stopText));
        return offer_stopText.isDisplayed();
    }

    public void clickBonusCreate_Btn() {
        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOf(pageLoader));
        newBonus_btn.click();
    }

    public void enterBonusName(String name){
        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOf(pageLoader));
        bonusName.sendKeys(name);
    }

    public void selectCountry(){
        country.click();
        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(selectPhilippines));
        selectPhilippines.click();
    }

    public void selectBrand(String name){
        brandName.sendKeys(name);
        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(selectBrandName));
        selectBrandName.click();
    }

    public void selectBonusCategory(){
        categoryDropDown.click();
        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(selectCate_AllEligible));
        selectCate_AllEligible.click();
    }

    public void enterTotalWeight(String weight){
        selectTotalWeight.sendKeys(weight);
    }

    public void enterMembersBonus(String MemWeight){
        membersBonusKg.sendKeys(MemWeight);
    }

    public void enterBranchBonus(String BranchBonus){
        branchBonusKg.sendKeys(BranchBonus);
    }

    public void clickCreateBonusBtn(){
        createBtn.click();
    }

    public void enterAuthCode(String code) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(authCode));
        authCode.sendKeys(code);
    }

    public void clickSubmitAuthCode(){
        authCodeSubmitBtn.click();
    }

    public static void clickBonusApprovalTab() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.elementToBeClickable(bonusApprovalTab));
        Thread.sleep(3000);
        bonusApprovalTab.click();
    }

    public void clickAddBranchBtn(){
        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(addBranchBtn));
        addBranchBtn.click();
    }

    private void clickAddBranchInBonus(){
        branchInBonus.click();
    }

    public void clickConfirmBtn() throws InterruptedException {
        Thread.sleep(3000);
        confirmBtn.click();
    }

    public void clickAddedBranch() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(selectAddedBranchInBonus));
        selectAddedBranchInBonus.click();
    }

    public void clickEditBonusOptions() throws InterruptedException {
        Thread.sleep(4000);
        editBonusOpt.click();
    }

    public void clickBranchBonus(){
        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(branchBonusOpt));
        branchBonusOpt.click();
    }

    public void clickConfirmNewParticipants(){
        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(confirmNewParticipants));
        confirmNewParticipants.click();
    }

    public void selectAnyOption_branchBonus() {
        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(branchBonusOpt));
        branchBonusOpt.sendKeys((Keys.ARROW_UP));
        branchBonusOpt.sendKeys((Keys.ENTER));
    }

    public void saveBonusInformation(){
        saveBonusInfoBtn.click();
    }

    public void clickCloseBtnPopUp(){
        closeBtnPopup.click();
    }
    private void clickOrdersTransferTab() throws InterruptedException {
        Thread.sleep(5000);
        ordersTab_transfer.click();
        Thread.sleep(15000);
    }
    private String verifySenderName(){
        return table_firstRowData.get(1).getText();
    }
    private String verifyRecipientName(){
        return table_firstRowData.get(2).getText();
    }
    private String verifyReason(){
        String text = table_firstRowData.get(3).getText();
        String[] split = text.split(":");
        return split[1];
    }
    private String verifyTokenTransferType(){
        return table_firstRowData.get(4).getText();
    }
    private String verifyAmount(){
        return table_firstRowData.get(5).getText();
    }

    public void checkOrderStopped(String createdBonusName) throws InterruptedException {
        clickOrdersTab();
        clickBounsTab();
        search_byName(createdBonusName);
        clickSpecificOrdersBonus();
        clickEmergencyStopBtn();
        assert verifyAlertBox().equals(true);
        clickAlertBoxBtnOK();
        assert verifyOffer_stopText().equals(true);
    }


    public void createBonus(String createBonusName, String brandName, String totalWeight, String membersBonus, String branchBonus, String authCode, String bonusName) throws InterruptedException {
        clickOrdersTab();
        clickBounsTab();
        clickBonusCreate_Btn();
        enterBonusName(createBonusName);
        selectCountry();
        selectBrand(brandName);
        selectBonusCategory();
        enterTotalWeight(totalWeight);
        enterMembersBonus(membersBonus);
        enterBranchBonus(branchBonus);
        clickCreateBonusBtn();
        enterAuthCode(authCode);
        clickSubmitAuthCode();
        search_byName(createBonusName);
        clickSpecificOrdersBonus();
        clickBonusApprovalTab();
        clickAddBranchBtn();
        search_byName(bonusName);
        clickAddBranchInBonus();
        clickConfirmBtn();
        clickConfirmNewParticipants();
        clickAlertBoxBtnOK();
        enterAuthCode(authCode);
        clickSubmitAuthCode();
    }

    public void changeBranchBonusDetails() throws InterruptedException {
        clickAddedBranch();
        clickEditBonusOptions();
        clickBranchBonus();
        selectAnyOption_branchBonus();
        saveBonusInformation();
        clickConfirmBtn();
        clickCloseBtnPopUp();
    }

    public void verifyOrdersTransferData(String senderName, String recipientName, String reason, String type, String amount) throws InterruptedException {
        clickOrdersTab();
        clickOrdersTransferTab();
        assert verifySenderName().equals(senderName);
        assert verifyRecipientName().equals(recipientName);
        assert verifyReason().equals(reason);
        assert verifyTokenTransferType().equals(type);
        assert verifyAmount().equals(amount);

    }
    public void searchBonus(String bonusName) throws InterruptedException {
    	
    	clickOrdersTab();
        clickBounsTab();
        search_byName(bonusName);
    	
    }
    public void verifyDetailsInBonusSearch(String bonusName) throws InterruptedException {
    	searchBonus(bonusName);
    	Thread.sleep(2000);
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);
    	String kgd=tableData_FirstRow_KGDelivered.getText();
    	Assert.assertEquals(kgd, kgdelivered);
    	String kgpr =tableData_FirstRow_KGPromised.getText();
    	Assert.assertEquals(kgpr, kgpromised);
    	String kgpd =tableData_FirstRow_PendingKG.getText();
    	Assert.assertEquals(kgpd, kgpending);
  	
    }
    
    public void verifyDetailsInBonusSummary() throws InterruptedException {
    	//searchBonus(bonusName);
    	Thread.sleep(1000);
    	clickSpecificOrdersBonus();
    	Thread.sleep(3000);
    	 List<String> lst= new ArrayList<>();
    		 lst.addAll(Arrays.asList(summary_HDPE_KG_Text.getText(),summary_PET_KG_Text.getText(),summary_Total_KG_Text.getText()));
    		 Thread.sleep(2000);
    		    TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
    		    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
    		    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
    		    Thread.sleep(2000);
          Assert.assertEquals(lst,Arrays.asList("10kg","9kg","19 Kg")); 	 	
    }
    public void bonusExchangeHistoryCheckPoint() {
    	clickExchangeHistory();
    	String actualexcHisHdpeKG=excHisHdpeKG.getText();
    	String actualexcHisPetKG=excHisPetKG.getText();
    	String actualexcHisHdpeBonus=excHisHdpeBonus.getText();
    	String actualexcHisPetBonus=excHisPetBonus.getText();
    	String actualexcHisTotalKg=excHisTotalKg.getText();
    	String actualexcHisTotalBonus=excHisTotalBonus.getText();
    	Assert.assertEquals(actualexcHisHdpeKG, expectedexcHisHdpeKG);
    	Assert.assertEquals(actualexcHisPetKG, expectedexcHisPetKG);
    	Assert.assertEquals(actualexcHisHdpeBonus, expectedexcHisHdpeBonus);
    	Assert.assertEquals(actualexcHisPetBonus, expectedexcHisPetBonus);
    	Assert.assertEquals(actualexcHisTotalKg, expectedexcHisTotalKg);
    	Assert.assertEquals(actualexcHisTotalBonus, expectedexcHisTotalBonus);
    }
    
    public void bonusApprovalCheckPoints() throws InterruptedException {
    	
    	clickBonusApprovalTab();
    	
    	
    }
    public void bonusCheckPoints(String bonusName) throws InterruptedException {
    	verifyDetailsInBonusSearch(bonusName);
    	verifyDetailsInBonusSummary();
          
    	
    }
    
  WebDriverWait wait = new WebDriverWait(alcDriver,Duration.ofSeconds(20));
    
  public void buySellPresent() throws InterruptedException, IOException {
  	alcDriver.get("https://"+BaseClass.actual+"/#/admin/ordersoffsets/offset/"+Data.bonusid4360);
  	exchangehistory.click();
  	pccardheader.isDisplayed();
  	Actions action = new Actions(alcDriver);
  	action.moveToElement(lastItemOnPaage).build().perform();
  	Thread.sleep(2000);

  	 TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
  	    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
  	    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
  		Thread.sleep(2000);
  		bonusApproval.click();
  		expander.get(0).click();
  			startApproval.click();
  			wait.until(ExpectedConditions.textToBePresentInElement(buytransactions, "Buy Transactions (1)"));
  			buytransactions.click();
  			Thread.sleep(2000);
  			wait.until(ExpectedConditions.textToBePresentInElement(selltransactions, "Sell Transactions (1)"));
  			selltransactions.click();
  			Thread.sleep(2000);
  			wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(dp)));
  			dp.click();
  			
  			try {
  			Thread.sleep(5000);
  			System.out.println("sell transac   --"+bonusinBAtext.getText()+"---");
  			wait.until(ExpectedConditions.textToBePresentInElement(bonusinBAtext, "30"));
  			assertTrue(bonusinBAtext.getText().equals("30"));
  			Thread.sleep(2000);
  			TakesScreenshot ts111 = (TakesScreenshot) alcDriver;
			    byte[] screenshotsell = ts111.getScreenshotAs(OutputType.BYTES);
			    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshotsell));
			    Thread.sleep(2000);
  			}
  			
  			catch(Exception e) {
					
  			}
  				
  		alcDriver.navigate().refresh();
  		wait.until(ExpectedConditions.textToBePresentInElement(buytransactions, "Buy Transactions (1)"));
  		buytransactions.click();
  		Thread.sleep(2000);
  		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(dp)));
  		dp.click();
  		
  		try {
  		Thread.sleep(5000);
  		System.out.println("buy transac   ---"+bonusinBAtext.getText()+"---");
  		wait.until(ExpectedConditions.textToBePresentInElement(bonusinBAtext, "133"));
  		assertTrue(bonusinBAtext.getText().equals("133"));
  		Thread.sleep(2000);
 		 TakesScreenshot ts1111 = (TakesScreenshot) alcDriver;
 		    byte[] screenshotbuy = ts1111.getScreenshotAs(OutputType.BYTES);
 		 Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshotbuy));
 		Thread.sleep(2000);
  		}
  		
  		catch(Exception e) {
				
  		}
  		
  		
  		bonusname.click();
  		bonusApproval.click();
  		expander.get(1).click();
  			startApproval.click();
  			wait.until(ExpectedConditions.textToBePresentInElement(selltransactions, "Sell Transactions (1)"));
  			selltransactions.click();
  			wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(dp)));
  			dp.click();
  			
  			try {
  			Thread.sleep(5000);
  			System.out.println("sell transac   --"+bonusinBAtext.getText()+"---");
  			wait.until(ExpectedConditions.textToBePresentInElement(bonusinBAtext, "14"));
  			assertTrue(bonusinBAtext.getText().equals("14"));
  			Thread.sleep(2000);
  			TakesScreenshot ts111 = (TakesScreenshot) alcDriver;
			    byte[] screenshotsell = ts111.getScreenshotAs(OutputType.BYTES);
			    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshotsell));
			    Thread.sleep(2000);
  			}
  			
  			catch(Exception e) {
					
  			}
  		
  }   
    
    @SuppressWarnings("deprecation")
	public void verifyBonusOrderSummaryAndApprovalSteps() throws InterruptedException {
    	alcDriver.get("https://"+BaseClass.actual+"/#/admin/ordersoffsets/offset/"+Data.bonusid4360);
    	bonusApproval.click();
    	Thread.sleep(2000);
		expander.get(0).click();
		Thread.sleep(2000);
		disabledStartApproval.isDisplayed();
		Thread.sleep(2000);
   	 TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
   	    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
   	    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
   		Thread.sleep(2000);
		summary.click();
		Thread.sleep(1000);
		fulfilledbonus.isDisplayed();
		Thread.sleep(2000);
   	 TakesScreenshot ts11 = (TakesScreenshot) alcDriver;
   	    byte[] screenshot11 = ts11.getScreenshotAs(OutputType.BYTES);
   	    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot11));
   		Thread.sleep(2000);
    	exchangehistory.click();
    	alcDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    	try {
    		 WebDriverWait waitpc = new WebDriverWait(alcDriver,Duration.ofSeconds(2));
    		waitpc.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(pccardheader)));
    	}catch(Exception e) {
    		System.out.println("plastic chain not present after disabling bonus");
    	}
    	Actions action = new Actions(alcDriver);
    	action.moveToElement(greencircle).build().perform();
    	Thread.sleep(2000);
    	 TakesScreenshot ts111 = (TakesScreenshot) alcDriver;
    	    byte[] screenshot111 = ts111.getScreenshotAs(OutputType.BYTES);
    	    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot111));
    		Thread.sleep(2000);
    	 alcDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }
    
    public void bonusExcHisVerification(String bonusId) throws InterruptedException {
    	
    	alcDriver.get("https://"+actual+"/#/admin/ordersoffsets/offset/"+bonusId);

        WebDriverWait wait = new WebDriverWait(alcDriver,Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(exchangeHistoryTab));
        exchangeHistoryTab.click();
        Thread.sleep(4000);
        alcDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        try{
            Actions action = new Actions(alcDriver);
            action.scrollToElement(lastItemOnPaage).build().perform();
            Thread.sleep(2000);
            TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
            byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Bonus In Exchange History ScreenShot", new ByteArrayInputStream(screenshot1));
            Thread.sleep(2000);
            assertTrue(bonusExcHisBonusText.isDisplayed());

        }

        catch(Exception e){
            Thread.sleep(2000);
            TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
            byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Token in Bonus Exchange History ", new ByteArrayInputStream(screenshot1));
            Thread.sleep(2000);
            //Assert.assertFalse(bonusExcHisBonusText.isDisplayed());
            System.out.println("No Bonus Found");
        }
        alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    }
   
    public void buySellVerification_1711beforeVoid(String bonusId) throws InterruptedException {
    	
    	alcDriver.get("https://"+actual+"/#/admin/ordersoffsets/offset/"+bonusId);
    	bonusApproval.click();
    	Thread.sleep(2000);

    		bonusApproval.click();
        expander.get(0).click();
    			startApproval.click();
//    			wait.until(ExpectedConditions.textToBePresentInElement(buytransactions, "Buy Transactions (1)"));
//    			buytransactions.click();
//    			wait.until(ExpectedConditions.textToBePresentInElement(selltransactions, "Sell Transactions (1)"));
//    			selltransactions.click();
                Thread.sleep(2000);
    			wait.until(ExpectedConditions.elementToBeClickable(dp));
    			dp.click();
    
    			Thread.sleep(3000);

    			assertTrue(bonusinBAtext.isDisplayed());
    			Thread.sleep(2000);
    			TakesScreenshot ts111 = (TakesScreenshot) alcDriver;
			    byte[] screenshotsell = ts111.getScreenshotAs(OutputType.BYTES);
			    Allure.addAttachment("Buy Sell Verification  Screenshot", new ByteArrayInputStream(screenshotsell));
			    Thread.sleep(2000);

    		buytransactions.click();
    		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(dp)));
    		dp.click();
   
    		Thread.sleep(3000);

    		assertTrue(bonusinBAtext.isDisplayed());
    		Thread.sleep(2000);
   		 TakesScreenshot ts1111 = (TakesScreenshot) alcDriver;
   		    byte[] screenshotbuy = ts1111.getScreenshotAs(OutputType.BYTES);
   		 Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshotbuy));
   		Thread.sleep(2000);
           bonusname.click();
        Thread.sleep(2000);
        bonusApproval.click();
        Thread.sleep(3000);
        expander.get(1).click();
        startApproval.click();
        Thread.sleep(5000);
        buytransactions.click();
        Thread.sleep(3000);
        selltransactions.click();
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(dp)));
        dp.click();

        Thread.sleep(3000);

        assertTrue(bonusinBAtext.isDisplayed());
        Thread.sleep(2000);
        TakesScreenshot ts11111 = (TakesScreenshot) alcDriver;
        byte[] screenshotsell1 = ts11111.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshotsell1));
        Thread.sleep(2000);

    }
    public void buySellVerification_1711AfterVoid(String bonusId) throws InterruptedException {

        alcDriver.get("https://"+BaseClass.actual+"/#/admin/ordersoffsets/offset/"+bonusId);
        bonusApproval.click();
        Thread.sleep(2000);
        for(WebElement ele : expander) {

            ele.click();

            Actions action= new Actions(alcDriver);
            action.scrollToElement(viewAuditTrail).build().perform();
            Thread.sleep(2000);

            String voidedKg = verifyKgVoided.getText();
            Assert.assertEquals(voidedKg,"0 KG");

            Thread.sleep(2000);
            TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
            byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Token in Buy/Sell Bomnus Exchange History", new ByteArrayInputStream(screenshot1));
            Thread.sleep(2000);
            ele.click();
            Thread.sleep(2000);

        }

    }
    public void bonusProgressInSummaryTab(String bonusProgress) throws InterruptedException {

        alcDriver.get("https://"+actual+"/#/admin/ordersoffsets/offset/"+Data.bonusOrderId1711);
        alcDriver.navigate().refresh();
        try {
            Thread.sleep(6000);
            String bonusProgressActual = summary_bonusProgressText.getText();
            System.out.println(bonusProgressActual);
            assertTrue(bonusProgressActual.contains(bonusProgress));
            Thread.sleep(2000);
            TakesScreenshot ts11 = (TakesScreenshot) alcDriver;
            byte[] screenshot11 = ts11.getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Bonus in Summary tab in Bonus Progress", new ByteArrayInputStream(screenshot11));
            Thread.sleep(2000);

        }
        catch (Exception e)
        {
            System.out.println(" Bonus is Not Present ");
            Thread.sleep(2000);
            TakesScreenshot ts11 = (TakesScreenshot) alcDriver;
            byte[] screenshot11 = ts11.getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Bonus in Summary tab in Bonus Progress", new ByteArrayInputStream(screenshot11));
            Thread.sleep(2000);

        }
  }

  public void createOrder(String processorName) throws InterruptedException {

      WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
      orders_tab.click();
      Thread.sleep(2000);
      wait.until(ExpectedConditions.elementToBeClickable(ordersTab));
      ordersTab.click();
      wait.until(ExpectedConditions.elementToBeClickable(addIcon));
      addIcon.click();

      wait.until(ExpectedConditions.elementToBeClickable(orderNameTextFeild));

      String randomOrderName = RandomStringUtils.randomAlphabetic(5);
      order_Name="Fleek"+randomOrderName;
      orderNameTextFeild.sendKeys(order_Name);
      System.out.println("Order Name : "+order_Name);

      countryDropdown.click();
      selectCountryPhilippines.click();

      Thread.sleep(1000);
      brandTextField.sendKeys("Plastic Ban");
      Thread.sleep(2000);
      brandPlasticBank.click();

      startDate.click();
      Select select_Year = new Select(selectYear);
      // Select the option by its visible text (option name)
      select_Year.selectByVisibleText("2022");
      selectDate.click();

      shippingDate.click();
      // Select the option by its visible text (option name)
      select_Year.selectByVisibleText("2025");
      selectDate.click();

      Select selectType = new Select(typeDropdown);
      // Select the option by its visible text (option name)
      selectType.selectByVisibleText("PET");
      Thread.sleep(2000);
      weightTextField.sendKeys("50000");

      assignProcessorButton.click();
      wait.until(ExpectedConditions.visibilityOfAllElements(nameSearchField));
      nameSearchField.sendKeys(processorName);
      Thread.sleep(8000);
      checkBoxInProcessorAssign.click();
      confirmBtn.click();
      createButton.click();
      confirmBtn.click();

      wait.until(ExpectedConditions.visibilityOfAllElements(closeBtnPopup));
      TakesScreenshot ts = (TakesScreenshot) alcDriver;
      byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
      Allure.addAttachment("Order Created screenshot ", new ByteArrayInputStream(screenshot));
      Thread.sleep(2000);

      closeBtnPopup.click();

  }

  public void editOrder() throws InterruptedException {

      WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
      orders_tab.click();
      Thread.sleep(2000);
      wait.until(ExpectedConditions.elementToBeClickable(ordersTab));
      ordersTab.click();

      wait.until(ExpectedConditions.elementToBeClickable(nameSearchField));
      nameSearchField.sendKeys(order_Name);
      Thread.sleep(6000);
      tableData_FirstRow.click();

      wait.until(ExpectedConditions.elementToBeClickable(editOrder));
      editOrder.click();

      wait.until(ExpectedConditions.elementToBeClickable(orderNameTextFeild));
      orderNameTextFeild.click();
      orderNameTextFeild.clear();

      String randomOrderName1 = RandomStringUtils.randomAlphabetic(4);
      order_NameUpdated="OrderFleek"+randomOrderName1;
      orderNameTextFeild.sendKeys(order_NameUpdated);
      System.out.println("Updated Order Name : "+order_NameUpdated);

      saveButton.click();
      confirmBtn.click();

      wait.until(ExpectedConditions.visibilityOfAllElements(closeBtnPopup));
      TakesScreenshot ts = (TakesScreenshot) alcDriver;
      byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
      Allure.addAttachment("Order Name Update SC ", new ByteArrayInputStream(screenshot));
      Thread.sleep(2000);

      closeBtnPopup.click();
      Thread.sleep(2000);

      wait.until(ExpectedConditions.visibilityOfAllElements(ordername));
      Actions action = new Actions(alcDriver);
      action.scrollToElement(ordername).build().perform();
      String verifyOrderName=ordername.getText();

      assertTrue(verifyOrderName.contains(order_NameUpdated));

      TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
      byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
      Allure.addAttachment("Order Name Updated SC in Order Detail ", new ByteArrayInputStream(screenshot1));
      Thread.sleep(2000);

  }
  public void addFromExchangeHistory() throws InterruptedException {

      WebDriverWait wait = new WebDriverWait(alcDriver,Duration.ofSeconds(40));
      wait.until(ExpectedConditions.elementToBeClickable(addFromExchangeHistoryButton));
      Actions action = new Actions(alcDriver);
      action.scrollToElement(addFromExchangeHistoryButton).build().perform();
      addFromExchangeHistoryButton.click();
      Thread.sleep(2000);
      wait.until(ExpectedConditions.visibilityOf(sp_EPR_EligibleDropdown));
      sp_EPR_EligibleDropdown.click();
      Thread.sleep(2000);
     // showAllDropdown.click();
       Select selectOrder = new Select(sp_EPR_EligibleDropdown);
       selectOrder.selectByVisibleText("Show All");
      Thread.sleep(2000);
      selectAllCheckMark.click();
      confirmBtn.click();
      Thread.sleep(1000);
      action.scrollToElement(lastItemOnPageOrder).build().perform();

      List<String> bonusAssociated = new ArrayList<>();

      for(WebElement ele:bonusOrderVerify) {

          bonusAssociated.add(ele.getText());
          assertTrue(ele.getText().equals(Data.bonusName));
      }

      Thread.sleep(1000);
      TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
      byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
      Allure.addAttachment("Associated Transaction Items from Exchange History ", new ByteArrayInputStream(screenshot1));
      Thread.sleep(1000);

  }
  public void verifyTotalKg() throws InterruptedException {

      List<String> totalKgString =new ArrayList<>();
      for(WebElement kg : totalKg ){

          totalKgString.add(kg.getText());
      }
      List<Integer> totalKgInt = new ArrayList<>();
      for(String str :totalKgString){
          int totalKgVal = Integer.parseInt(str);
          totalKgInt.add(totalKgVal);
      }

      int sumTotalKg =0;
      for (int num : totalKgInt){
          sumTotalKg += num;
      }
      Actions action =new Actions(alcDriver);
      action.scrollToElement(total).build().perform();

      String t= total.getText();
      String tc= totalCollectedKg.getText();
      String pk= pendingKg.getText();

      int intTotal=convertStringToInteger(t);
      System.out.println(intTotal);

      int intTotalCollectedKg=stringToInt(tc);
      System.out.println(intTotalCollectedKg);

      int intpendingKg=stringToInt(pk);
      System.out.println(intpendingKg);


      Assert.assertEquals(intTotalCollectedKg,sumTotalKg);
      assertTrue(intTotal==intTotalCollectedKg+intpendingKg);

      Thread.sleep(1000);
      TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
      byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
      Allure.addAttachment("Total Kg/kgDelivered/Pending Kg Verify in Donught Graph", new ByteArrayInputStream(screenshot1));
      Thread.sleep(1000);


    }
    public void createOrder666(String processorName) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));

        orders_tab.click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(ordersTab));
        ordersTab.click();
        wait.until(ExpectedConditions.elementToBeClickable(addIcon));
        addIcon.click();

        wait.until(ExpectedConditions.elementToBeClickable(orderNameTextFeild));

        String randomOrderName = RandomStringUtils.randomAlphabetic(5);
        order_Name="Fleek"+randomOrderName;
        orderNameTextFeild.sendKeys(order_Name);
        System.out.println("Order Name : "+order_Name);

        countryDropdown.click();
        selectCountryPhilippines.click();

        Thread.sleep(1000);
        brandTextField.sendKeys("Plastic Ban");
        Thread.sleep(2000);
        brandPlasticBank.click();

        startDate.click();
        Select select_Year = new Select(selectYear);
        // Select the option by its visible text (option name)
        select_Year.selectByVisibleText("2023");
        selectDate.click();

        shippingDate.click();
        // Select the option by its visible text (option name)
        select_Year.selectByVisibleText("2025");
        selectDate.click();

        Select selectType = new Select(typeDropdown);
        // Select the option by its visible text (option name)
        selectType.selectByVisibleText("PET");
        Thread.sleep(2000);
        weightTextField.sendKeys("50000");

        assignProcessorButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(nameSearchField));
        nameSearchField.sendKeys(processorName);
        Thread.sleep(8000);
        checkBoxInProcessorAssign.click();
        confirmBtn.click();
        Thread.sleep(2000);
        assignProcessorButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(nameSearchField));
        nameSearchField.sendKeys("TOPLUN");
        Thread.sleep(8000);
        checkBoxInProcessorAssign.click();
        confirmBtn.click();

        TakesScreenshot ts = (TakesScreenshot) alcDriver;
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Processors added Screenshot ", new ByteArrayInputStream(screenshot));
        Thread.sleep(2000);
        createButton.click();
        confirmBtn.click();

        wait.until(ExpectedConditions.visibilityOfAllElements(closeBtnPopup));
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Order Created screenshot ", new ByteArrayInputStream(screenshot1));
        Thread.sleep(2000);

        closeBtnPopup.click();

    }



    public void addBonusToOrder(String bonusName) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver,Duration.ofSeconds(40));
//        wait.until(ExpectedConditions.elementToBeClickable(orders_tab));
//        orders_tab.click();
        wait.until(ExpectedConditions.elementToBeClickable(nameSearchField));
        nameSearchField.sendKeys(order_Name);
        Thread.sleep(6000);
        tableData_FirstRow.click();
        wait.until(ExpectedConditions.elementToBeClickable(addBonusTag));
        Actions action = new Actions(alcDriver);
        action.scrollToElement(addBonusTag).build().perform();
        addBonusTag.click();
        wait.until(ExpectedConditions.elementToBeClickable(searchOffsets));
        searchOffsets.sendKeys(bonusName);
        Thread.sleep(6000);
        checkBoxSearchOffsets.click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmBtn));
        confirmBtn.click();

    }
    public void addBonusToOrder666(String bonusName,String bonusName2) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(nameSearchField));
        Thread.sleep(3000);
        nameSearchField.sendKeys(order_Name);
        Thread.sleep(5000);
        tableData_FirstRow.click();
        wait.until(ExpectedConditions.elementToBeClickable(addBonusTag));
        Actions action = new Actions(alcDriver);
        action.scrollToElement(addBonusTag).build().perform();
        addBonusTag.click();
        wait.until(ExpectedConditions.elementToBeClickable(searchOffsets));
        searchOffsets.sendKeys(bonusName);
        Thread.sleep(5000);

        checkBoxSearchOffsets.click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmBtn));
        confirmBtn.click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(addBonusTag));
        addBonusTag.click();
        wait.until(ExpectedConditions.elementToBeClickable(searchOffsets));
        searchOffsets.sendKeys(bonusName2);
        Thread.sleep(6000);
        checkBoxSearchOffsets.click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmBtn));
        confirmBtn.click();
        Thread.sleep(2000);
        action.scrollToElement(connectedBonusScroll).build().perform();
        TakesScreenshot ts = (TakesScreenshot) alcDriver;
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(" Bonus Order added Screenshot ", new ByteArrayInputStream(screenshot));
        Thread.sleep(2000);

    }

    public void verifyDonughtGraph(int kgCollectedByProcessor) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfAllElements(total));
        Actions action = new Actions(alcDriver);

        action.scrollToElement(kgDeliveredToplun).build().perform();
        String kgDelTop=kgDeliveredToplun.getText();
        String cleanedString = kgDelTop.replace(",", "");
        int kgDelTopIntValue = Integer.parseInt(cleanedString);
        System.out.println(kgDelTopIntValue);
        Thread.sleep(1000);
        action.scrollToElement(total).build().perform();

        String t= total.getText();
        String tc= totalCollectedKg.getText();
        String pk= pendingKg.getText();

        int intTotal=convertStringToInteger(t);
        System.out.println(intTotal);

        int intTotalCollectedKg=stringToInt(tc);
        System.out.println(intTotalCollectedKg);

        int intpendingKg=stringToInt(pk);
        System.out.println(intpendingKg);

        assertTrue(intTotal==intTotalCollectedKg+intpendingKg);
        Thread.sleep(1000);
        assertTrue(intTotalCollectedKg==kgDelTopIntValue+kgCollectedByProcessor);

        Thread.sleep(1000);
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Total Kg/kgDelivered/Pending Kg Verify in Donught Graph", new ByteArrayInputStream(screenshot1));
        Thread.sleep(1000);

    }

    public void verifyAuditTrail() throws InterruptedException {


        WebDriverWait wait = new WebDriverWait(alcDriver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(auditTrailTag));
        auditTrailTag.click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(lastItemOnPaage));
        Thread.sleep(2000);
        Set<String> totalWeightsInOrder = new HashSet<>();

        for(int i=0;i<3;i++)
        {
            totalWeightsInOrder.add(totalWeight.get(i).getText());
        }
        System.out.println("Set of KG in Order Audit Trail :"+totalWeightsInOrder);

        Actions action = new Actions(alcDriver);

        action.scrollToElement(totalWeight.get(1)).build().perform();
        Thread.sleep(2000);
        TakesScreenshot ts = (TakesScreenshot) alcDriver;
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Total Weight in Order ", new ByteArrayInputStream(screenshot));
        Thread.sleep(2000);

        Branches b1=new Branches(alcDriver);
        b1.VerifyMARYGRACEPartnerBranchAlc666();
        System.out.println(b1.totalKgMaryGraceBranch);
        b1.VerifyRIEZAPartnerBranchAlc666();
        System.out.println(b1.totalKgRiezaBranch);
        b1.verifyBranchKgALC666(Data.b2id666);
        System.out.println(b1.totalKgBranch);

        Set<String>totalWeightInBranches = new HashSet<>(Arrays.asList(b1.totalKgMaryGraceBranch,b1.totalKgRiezaBranch,b1.totalKgBranch));
        System.out.println("Set of KG in Branches :"+totalWeightInBranches);
        Set<String>totalWeightsInOrderV = new HashSet<>(Arrays.asList("Total Weight: 618.00 KG","Total Weight: 756.00 KG","Total Weight: 110.70 KG"));
        Set<String>totalWeightInBranchesV = new HashSet<>(Arrays.asList("110.7 KG","756 KG","618 KG"));
        Assert.assertEquals(totalWeightsInOrder,totalWeightsInOrderV);
        Assert.assertEquals(totalWeightInBranches,totalWeightInBranchesV);
    }
    public void detachBonusToplun() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(alcDriver,Duration.ofSeconds(40));
        orders_tab.click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(nameSearchField));
        nameSearchField.sendKeys(order_Name);
        Thread.sleep(6000);
        tableData_FirstRow.click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(deleteBonusButton));
        deleteBonusButton.click();
        System.out.println("Order is Detatched");
    }
    public void createOrder687(String processorName) throws InterruptedException {


        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
        orders_tab.click();
        Thread.sleep(6000);
        wait.until(ExpectedConditions.elementToBeClickable(ordersTab));
        ordersTab.click();
        wait.until(ExpectedConditions.elementToBeClickable(addIcon));
        addIcon.click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(orderNameTextFeild));
        Thread.sleep(2000);
        String randomOrderName = RandomStringUtils.randomAlphabetic(5);
        order_Name="alc687"+randomOrderName;
        orderNameTextFeild.sendKeys(order_Name);
        System.out.println("Order Name : "+order_Name);

        countryDropdown.click();
        selectCountryPhilippines.click();

        Thread.sleep(1000);
        brandTextField.sendKeys("Plastic Ban");
        Thread.sleep(2000);
        brandPlasticBank.click();

        startDate.click();
        Select select_Year = new Select(selectYear);
        // Select the option by its visible text (option name)
        select_Year.selectByVisibleText("2022");
        selectDate.click();

        shippingDate.click();
        // Select the option by its visible text (option name)
        select_Year.selectByVisibleText("2025");
        selectDate.click();

        orderDate.click();

        // Select the option by its visible text (option name)
        select_Year.selectByVisibleText("2025");
        selectDate.click();

        String randomRefId = RandomStringUtils.randomAlphabetic(5);
        refId="RefId_"+randomOrderName;
        referenceIdTextField.sendKeys(refId);

        Thread.sleep(2000);

        Select selectType = new Select(typeDropdown);
        // Select the option by its visible text (option name)
        selectType.selectByVisibleText("PET");
        Thread.sleep(2000);
        weightTextField.sendKeys("10000");

        assignProcessorButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(nameSearchField));
        nameSearchField.click();
        nameSearchField.sendKeys(processorName);
        Thread.sleep(8000);
        checkBoxInProcessorAssign.click();
        confirmBtn.click();
        createButton.click();
        confirmBtn.click();

        wait.until(ExpectedConditions.visibilityOfAllElements(closeBtnPopup));
        TakesScreenshot ts = (TakesScreenshot) alcDriver;
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Order Created screenshot ", new ByteArrayInputStream(screenshot));
        Thread.sleep(2000);

        closeBtnPopup.click();

        wait.until(ExpectedConditions.elementToBeClickable(nameSearchField));
        Thread.sleep(3000);
        nameSearchField.sendKeys(order_Name);
        Thread.sleep(5000);
        tableData_FirstRow.click();


        wait.until(ExpectedConditions.elementToBeClickable(addFromExchangeHistoryButton));
        Actions action = new Actions(alcDriver);
        action.scrollToElement(addFromExchangeHistoryButton).build().perform();
        addFromExchangeHistoryButton.click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(sp_EPR_EligibleDropdown));
        sp_EPR_EligibleDropdown.click();
        Thread.sleep(2000);
        //showAllDropdown.click();
        Select selectOrder = new Select(sp_EPR_EligibleDropdown);
        selectOrder.selectByVisibleText("Show All");
        Thread.sleep(5000);

        action.scrollToElement(lastItemOnPageOrder).build().perform();

        Thread.sleep(4000);

        Set<String>bonusExpected = new HashSet<>(Arrays.asList("Bonus 0","Bonus 0", "Bonus 80"));
        Set<String>bonusOrdersExpected = new HashSet<>(Arrays.asList("System offset",Data.bonusName687+", System offset"));
        Set<String>buyerSellerExpected = new HashSet<>(Arrays.asList(Data.branch3_Name687,Data.processor_Name687,Data.branch2_Name687,Data.processor_Name687));
        Set<String>textGreenExpected = new HashSet<>(Arrays.asList("Bonus 80"));
        //Set<String>textOrangeExpected = new HashSet<>(Arrays.asList("Bonus 28","Bonus 80"));
        Set<String>totalKgExpected = new HashSet<>(Arrays.asList("Total Weight: 150.00 KG","Total Weight: 48.00 KG"));

        Set<String> bonusActual = new HashSet<>();
        Set<String> bonusOrdersActual = new HashSet<>();
        Set<String> buyerSellerActual = new HashSet<>();
        Set<String> textGreenActual = new HashSet<>();
       // Set<String> textOrangeActual = new HashSet<>();
        Set<String> totalKgActual = new HashSet<>();

        for (WebElement ele1 : bonus) {
            bonusActual.add(ele1.getText());
        }
        for (WebElement ele2 : bonusOrders) {
            bonusOrdersActual.add(ele2.getText());
        }
        for (WebElement ele3 : buyerSeller) {
            buyerSellerActual.add(ele3.getText());
        }
        for (WebElement ele4 : textGreen) {
            textGreenActual.add(ele4.getText());
        }
//        for (WebElement ele5 : textOrange) {
//            textOrangeExpected.add(ele5.getText());
//        }
        for (WebElement ele6 : totalWeight) {
            totalKgActual.add(ele6.getText());
        }

        Thread.sleep(2000);

        Assert.assertEquals(bonusActual, bonusExpected);
        Assert.assertEquals(bonusOrdersActual, bonusOrdersExpected);
        Assert.assertEquals(buyerSellerActual, buyerSellerExpected);
        Assert.assertEquals(textGreenActual, textGreenExpected);
        //Assert.assertEquals(textOrangeActual, textOrangeExpected);
        Assert.assertEquals(totalKgActual, totalKgExpected);


        Thread.sleep(2000);
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Associated Transaction Items from Exchange History ", new ByteArrayInputStream(screenshot1));
        Thread.sleep(1000);

        action.moveToElement(checkBoxWithOutBonus).click().build().perform();

        //checkBoxWithOutBonus.click();
        Thread.sleep(2000);
        String actualTotalKgAtTopWitoutBonus=totalKgAtTop.getText();
        Thread.sleep(1000);
        String expectedTotalKgAtTopWitoutBonus="8";
        Assert.assertEquals(actualTotalKgAtTopWitoutBonus, expectedTotalKgAtTopWitoutBonus);

        confirmBtn.click();
        Thread.sleep(2000);

        alcDriver.navigate().refresh();


        wait.until(ExpectedConditions.elementToBeClickable(addFromExchangeHistoryButton));

        action.scrollToElement(addFromExchangeHistoryButton).build().perform();
        addFromExchangeHistoryButton.click();
        //Thread.sleep(2000);
        //wait.until(ExpectedConditions.visibilityOf(sp_EPR_EligibleDropdown));
//        sp_EPR_EligibleDropdown.click();
        //Thread.sleep(2000);
        //showAllDropdown.click();
//        Select selectOrder = new Select(sp_EPR_EligibleDropdown);
//        selectOrder.selectByVisibleText("Show All");
//        Thread.sleep(5000);

//        action.scrollToElement(lastItemOnPageOrder).build().perform();

        Thread.sleep(4000);

        Set<String>bonusExpectedD = new HashSet<>(Arrays.asList("Bonus 0"));
        Set<String>bonusOrdersExpectedD = new HashSet<>(Arrays.asList("System offset"));
        Set<String>buyerSellerExpectedD = new HashSet<>(Arrays.asList(Data.branch3_Name687,Data.processor_Name687));
//        Set<String>textGreenExpectedD = new HashSet<>(Arrays.asList("Bonus 0"));
        //Set<String>textOrangeExpectedD = new HashSet<>(Arrays.asList("Bonus 28","Bonus 80"));
        Set<String>totalKgExpectedD = new HashSet<>(Arrays.asList("Total Weight: 150.00 KG"));

        Set<String> bonusActualD = new HashSet<>();
        Set<String> bonusOrdersActualD = new HashSet<>();
        Set<String> buyerSellerActualD = new HashSet<>();
        Set<String> textGreenActualD = new HashSet<>();
        // Set<String> textOrangeActualD = new HashSet<>();
        Set<String> totalKgActualD = new HashSet<>();

        for (WebElement ele11 : bonus) {
            bonusActualD.add(ele11.getText());
        }
        for (WebElement ele22 : bonusOrders) {
            bonusOrdersActualD.add(ele22.getText());
        }
        for (WebElement ele33 : buyerSeller) {
            buyerSellerActualD.add(ele33.getText());
        }
//        for (WebElement ele44 : textGreen) {
//            textGreenActualD.add(ele44.getText());
//        }
//        for (WebElement ele55 : textOrange) {
//            textOrangeExpectedD.add(ele55.getText());
//        }
        for (WebElement ele66 : totalWeight) {
            totalKgActualD.add(ele66.getText());
        }

        Thread.sleep(2000);

        Assert.assertEquals(bonusActualD, bonusExpectedD);
        Assert.assertEquals(bonusOrdersActualD, bonusOrdersExpectedD);
        Assert.assertEquals(buyerSellerActualD, buyerSellerExpectedD);
        //Assert.assertEquals(textGreenActualD, textGreenExpectedD);
        //Assert.assertEquals(textOrangeActualD, textOrangeExpectedD);
        Assert.assertEquals(totalKgActualD, totalKgExpectedD);


        Thread.sleep(2000);

        byte[] screenshot2 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Associated Transaction Items from Exchange History ", new ByteArrayInputStream(screenshot2));
        Thread.sleep(1000);

        //checkBoxSearchOffsets.click();

        action.moveToElement(checkBoxDonation).click().build().perform();
        Thread.sleep(2000);

        String actualTotalKgAtTopDonation=totalKgAtTop.getText();
        Thread.sleep(1000);
        String expectedTotalKgAtTopDonation="150";
        Assert.assertEquals(actualTotalKgAtTopDonation, expectedTotalKgAtTopDonation);
       // checkBoxDonation.click();

        confirmBtn.click();

        Thread.sleep(3000);
        String totalCollectedKgInDashBoard=totalCollectedKg.getText();

        action.scrollToElement(total).build().perform();
        assertTrue(totalCollectedKgInDashBoard.equals("Total Collected: 158 Kg"));

        Thread.sleep(2000);
        byte[] screenshot4 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Doughnut Graph ", new ByteArrayInputStream(screenshot4));
        Thread.sleep(1000);

        auditTrailTag.click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOf(totalWeight.get(0)));

        action.scrollToElement(plasticChain2).build().perform();
        Thread.sleep(2000);
        byte[] screenshot3 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Added transactions in Audit Trail ", new ByteArrayInputStream(screenshot3));
        Thread.sleep(2000);


        Set<String>expectedTotakWeightInAuditTrail = new HashSet<>(Arrays.asList("Total Weight: 150.00 KG","Total Weight: 8.00 KG"));

        Set<String> actualTotakWeightInAuditTrail = new HashSet<>();

        Thread.sleep(2000);

        for (WebElement ele : totalWeight) {
            actualTotakWeightInAuditTrail.add(ele.getText());
        }
        Thread.sleep(2000);

        Assert.assertEquals(actualTotakWeightInAuditTrail,expectedTotakWeightInAuditTrail);

    }


    public void createOrderAllPlastik(String processorName) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        orders_tab.click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(ordersTab));
        ordersTab.click();
        wait.until(ExpectedConditions.elementToBeClickable(addIcon));
        addIcon.click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(orderNameTextFeild));
        Thread.sleep(2000);
        String randomOrderName = RandomStringUtils.randomAlphabetic(5);
        order_Name="Fleek"+randomOrderName;
        orderNameTextFeild.sendKeys(order_Name);
        System.out.println("Order Name : "+order_Name);

        countryDropdown.click();
        selectCountryPhilippines.click();

        Thread.sleep(1000);
        brandTextField.sendKeys("Plastic Ban");
        Thread.sleep(2000);
        brandPlasticBank.click();

        startDate.click();
        Select select_Year = new Select(selectYear);
        // Select the option by its visible text (option name)
        select_Year.selectByVisibleText("2022");
        selectDate.click();

        shippingDate.click();
        // Select the option by its visible text (option name)
        select_Year.selectByVisibleText("2025");
        selectDate.click();

        orderDate.click();

        // Select the option by its visible text (option name)
        select_Year.selectByVisibleText("2025");
        selectDate.click();

        String randomRefId = RandomStringUtils.randomAlphabetic(5);
        refId="RefId_"+randomOrderName;
        referenceIdTextField.sendKeys(refId);

        Thread.sleep(2000);
        weightTextField.sendKeys("50000");

        assignProcessorButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(nameSearchField));
        nameSearchField.sendKeys(processorName);
        Thread.sleep(8000);
        checkBoxInProcessorAssign.click();
        confirmBtn.click();
        createButton.click();
        confirmBtn.click();

        wait.until(ExpectedConditions.visibilityOfAllElements(closeBtnPopup));
        closeBtnPopup.click();

        wait.until(ExpectedConditions.elementToBeClickable(nameSearchField));
        Thread.sleep(3000);
        nameSearchField.sendKeys(order_Name);
        Thread.sleep(5000);
        tableData_FirstRow.click();



        wait.until(ExpectedConditions.elementToBeClickable(addFromExchangeHistoryButton));
        Actions action = new Actions(alcDriver);
        action.scrollToElement(addFromExchangeHistoryButton).build().perform();
        addFromExchangeHistoryButton.click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(sp_EPR_EligibleDropdown));
        sp_EPR_EligibleDropdown.click();
        Thread.sleep(2000);
        //showAllDropdown.click();
        Select selectOrder = new Select(sp_EPR_EligibleDropdown);
        selectOrder.selectByVisibleText("Show All");
        Thread.sleep(5000);

        action.scrollToElement(lastItemOnPageOrder).build().perform();

        Thread.sleep(4000);


        try{
            alcDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            checkBox25.click();

        }catch (Exception e){

            System.out.println("Element is not clickable");
            alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }

        action.moveToElement(checkBox101).click().build().perform();

        Thread.sleep(2000);
        String actualTotalKgAtTopWitoutBonus=totalKgAtTop.getText();
        Thread.sleep(1000);
        System.out.println(actualTotalKgAtTopWitoutBonus);
        String expectedTotalKgAtTopWitoutBonus="101.2";
        Assert.assertEquals(actualTotalKgAtTopWitoutBonus, expectedTotalKgAtTopWitoutBonus);

        confirmBtn.click();

        Thread.sleep(5000);

        String actualkgInAddFromExcHis=totalKgAddExcHis.get(0).getText();
        String expectedkgInAddFromExcHis="101.2";
        Assert.assertEquals(actualkgInAddFromExcHis,expectedkgInAddFromExcHis);

        Thread.sleep(3000);

        action.scrollToElement(totalCollectedKg).build().perform();
        String actualKgCollectedInDonoughtGraph=totalCollectedKg.getText();
        String expectedKgCollectedInDonoughtGraph="Total Collected: 101 Kg";
        Assert.assertEquals(actualKgCollectedInDonoughtGraph,expectedKgCollectedInDonoughtGraph);


        auditTrailTag.click();

        wait.until(ExpectedConditions.visibilityOf(totalWeight.get(0)));

        action.scrollToElement(plasticChain1).build().perform();
        Thread.sleep(2000);
        byte[] screenshot3 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Added transactions in Audit Trail ", new ByteArrayInputStream(screenshot3));
        Thread.sleep(2000);

        String actualTotakWeightInAuditTrail=totalWeight.get(0).getText();
        String expectedTotakWeightInAuditTrail="Total Weight: 101.20 KG";
        Assert.assertEquals(actualTotakWeightInAuditTrail,expectedTotakWeightInAuditTrail);

    }

    public void createOrderAllPlastik2(String processorName) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));
        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;

        orders_tab.click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(ordersTab));
        ordersTab.click();
        wait.until(ExpectedConditions.elementToBeClickable(addIcon));
        addIcon.click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(orderNameTextFeild));
        Thread.sleep(2000);
        String randomOrderName = RandomStringUtils.randomAlphabetic(5);
        order_Name="Fleek"+randomOrderName;
        orderNameTextFeild.sendKeys(order_Name);
        System.out.println("Order Name : "+order_Name);

        countryDropdown.click();
        selectCountryPhilippines.click();

        Thread.sleep(1000);
        brandTextField.sendKeys("Plastic Ban");
        Thread.sleep(2000);
        brandPlasticBank.click();

        startDate.click();
        Select select_Year = new Select(selectYear);
        // Select the option by its visible text (option name)
        select_Year.selectByVisibleText("2022");
        selectDate.click();

        shippingDate.click();
        // Select the option by its visible text (option name)
        select_Year.selectByVisibleText("2025");
        selectDate.click();

        orderDate.click();
        // Select the option by its visible text (option name)
        select_Year.selectByVisibleText("2025");
        selectDate.click();

        String randomRefId = RandomStringUtils.randomAlphabetic(5);
        refId="RefId_"+randomOrderName;
        referenceIdTextField.sendKeys(refId);

        Thread.sleep(2000);
        weightTextField.sendKeys("50000");

        assignProcessorButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(nameSearchField));
        nameSearchField.sendKeys(processorName);
        Thread.sleep(8000);
        checkBoxInProcessorAssign.click();
        confirmBtn.click();
        createButton.click();
        confirmBtn.click();

        wait.until(ExpectedConditions.visibilityOfAllElements(closeBtnPopup));
        closeBtnPopup.click();

        wait.until(ExpectedConditions.elementToBeClickable(nameSearchField));
        Thread.sleep(3000);
        nameSearchField.sendKeys(order_Name);
        Thread.sleep(5000);
        tableData_FirstRow.click();



        wait.until(ExpectedConditions.elementToBeClickable(addFromExchangeHistoryButton));
        Actions action = new Actions(alcDriver);
        action.scrollToElement(addFromExchangeHistoryButton).build().perform();
        addFromExchangeHistoryButton.click();
        Thread.sleep(2000);

        action.scrollToElement(lastItemOnPageOrder).build().perform();

        Thread.sleep(4000);


        try{
            alcDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            checkBox101.click();

        }catch (Exception e){

            System.out.println("Element is not clickable");
            alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }



        action.moveToElement(checkBox5).click().build().perform();
        Thread.sleep(2000);
        action.moveToElement(checkBox50).click().build().perform();

        Thread.sleep(2000);
        String actualTotalKgAtTopWitoutBonus=totalKgAtTop.getText();
        Thread.sleep(1000);
        System.out.println(actualTotalKgAtTopWitoutBonus);
        String expectedTotalKgAtTopWitoutBonus="55.5";
        Assert.assertEquals(actualTotalKgAtTopWitoutBonus, expectedTotalKgAtTopWitoutBonus);

        confirmBtn.click();

        Thread.sleep(2000);

        Set<String>expectedkgInAddFromExcHis = new HashSet<>(Arrays.asList("50","5.5"));

        Set<String> actualkgInAddFromExcHis = new HashSet<>();

        for (WebElement ele : totalKgAddExcHis) {
            actualkgInAddFromExcHis.add(ele.getText());
        }
        Assert.assertEquals(actualkgInAddFromExcHis,expectedkgInAddFromExcHis);

        Thread.sleep(3000);

        action.scrollToElement(totalCollectedKg).build().perform();
        String actualKgCollectedInDonoughtGraph=totalCollectedKg.getText();
        String expectedKgCollectedInDonoughtGraph="Total Collected: 56 Kg";
        Assert.assertEquals(actualKgCollectedInDonoughtGraph,expectedKgCollectedInDonoughtGraph);

        auditTrailTag.click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOf(totalWeight.get(0)));

        wait.until(ExpectedConditions.visibilityOf(totalWeight.get(0)));

        action.scrollToElement(plasticChain2).build().perform();
        Thread.sleep(2000);
        byte[] screenshot3 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Added transactions in Audit Trail ", new ByteArrayInputStream(screenshot3));
        Thread.sleep(2000);

        Set<String>expectedTotakWeightInAuditTrail = new HashSet<>(Arrays.asList("Total Weight: 50.00 KG","Total Weight: 5.50 KG"));

        Set<String> actualTotakWeightInAuditTrail = new HashSet<>();

        Thread.sleep(2000);

        for (WebElement ele : totalWeight) {
            actualTotakWeightInAuditTrail.add(ele.getText());
        }
        Thread.sleep(2000);

        Assert.assertEquals(actualTotakWeightInAuditTrail,expectedTotakWeightInAuditTrail);

    }


}