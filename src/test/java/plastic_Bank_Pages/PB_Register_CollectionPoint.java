package plastic_Bank_Pages;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PB_Register_CollectionPoint extends BaseClass {
	
public PB_Register_CollectionPoint(AndroidDriver pbDriver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(pbDriver), this);
	}

@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Log in\")")
public WebElement loginButton;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Logout\")")
public WebElement logoutButton;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Settings\")")
public WebElement settingsButton;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"menu\")")
public WebElement menuButton;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
public WebElement phoneNumberTextFeild;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.CheckBox\").instance(1)")
public WebElement passwordTextFeild;
@AndroidFindBy(id= "org.plasticbank.app:id/action_bar_root")
public WebElement loadedPage;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"While using the app\")")
public WebElement permission;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Allow\")")
public WebElement allow;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Finish\")")
public WebElement finishButton;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Create Business\")")
public WebElement createBusinessButton;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Recycling Business\")")
public WebElement recyclingBusinessPanel;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Collection Point\")")
public WebElement collectionPointPanel;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"CREATE BUSINESS\")")
public WebElement createBUSINESSbutton;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"camera\")")
public WebElement cameraButton;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Take a picture\")")
public WebElement takeA_PictureOption;
@AndroidFindBy(xpath= "//android.widget.ImageView[@content-desc=\"Shutter\"]")
public WebElement shutter;
@AndroidFindBy(xpath= "//android.widget.ImageButton[@content-desc=\"Done\"]")
public WebElement photoDone;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"confirm\")")
public WebElement confirmButton;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").instance(0)")
public WebElement crossButton;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
public WebElement businessNameTextField;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
public WebElement addressTextField;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.CheckBox\").instance(0)")
public WebElement mondayCheckBox;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.CheckBox\").instance(1)")
public WebElement tuesdayCheckBox;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.CheckBox\").instance(2)")
public WebElement wednesdayCheckBox;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.CheckBox\").instance(3)")
public WebElement thursdayCheckBox;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.CheckBox\").instance(4)")
public WebElement fridayCheckBox;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.CheckBox\").instance(5)")
public WebElement saturdayCheckBox;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.CheckBox\").instance(6)")
public WebElement sundayCheckBox;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Save\")")
public WebElement saveButton;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"OK\")")
public WebElement OKButton;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
public WebElement cashValuePerKgTextField;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
public WebElement currentInventoryTextField;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Add\")")
public WebElement addButton;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"DONE\")")
public WebElement doneButton;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Next\")")
public WebElement nextButton;
@AndroidFindBy(id = "tab-t1-2")
public WebElement membersTab;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").instance(2)")
public WebElement addmember;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
public WebElement branchMemberNameTextField;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
public WebElement branchMemberPhoneNumberTextField;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Gender\")")
public WebElement genderButton;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Male\")")
public WebElement maleOption;
@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Loading\")")
public WebElement loading;
@AndroidFindBy(uiAutomator="new UiSelector().text(\"search outline\")")
public WebElement searchOutline;
@AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"(?i)Track a Donation\")")
public WebElement chooseDonation;

@AndroidFindBy(uiAutomator = "new UiSelector().text(\"REGISTER MEMBER\")")
public WebElement registerUser;
@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"rocess\")")
public WebElement processor;


WebDriverWait wait = new WebDriverWait(pbDriver,Duration.ofSeconds(30));
public void createBranch() throws InterruptedException {
//Creating branch after member signup or login.
	WebDriverWait wait = new WebDriverWait(pbDriver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(menuButton)));
	menuButton.click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(createBusinessButton)));
	createBusinessButton.click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(recyclingBusinessPanel)));
	recyclingBusinessPanel.click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(collectionPointPanel)));
	collectionPointPanel.click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(createBUSINESSbutton)));
	createBUSINESSbutton.click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(cameraButton)));
	cameraButton.click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(takeA_PictureOption)));
	takeA_PictureOption.click();
	/*
	 * try{ wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(
	 * permission))); permission.click();
	 * wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(allow
	 * ))); allow.click(); }catch(Exception e) {
	 */
		Thread.sleep(2000);
		PointerInput fingerShutter = new PointerInput(PointerInput.Kind.TOUCH, "fingerShutter");
	    Sequence scrollShutter = new Sequence(fingerShutter, 1);
	    scrollShutter.addAction(fingerShutter.createPointerMove(Duration.ofMillis(0),
	        PointerInput.Origin.viewport(), 550, 1930));
	    scrollShutter.addAction(fingerShutter.createPointerDown(0));
	    scrollShutter.addAction(fingerShutter.createPointerMove(Duration.ofMillis(100),
	        PointerInput.Origin.viewport(), 550, 1930));
	    scrollShutter.addAction(fingerShutter.createPointerUp(0));
	    pbDriver.perform(Arrays.asList(scrollShutter));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(photoDone)));
		photoDone.click();	
		
	Thread.sleep(7000);
	PointerInput fingerconfirm = new PointerInput(PointerInput.Kind.TOUCH, "fingerconfirm");
    Sequence scrollconfirm = new Sequence(fingerconfirm, 1);
    scrollconfirm.addAction(fingerconfirm.createPointerMove(Duration.ofMillis(0),
        PointerInput.Origin.viewport(), 550, 2030));
    scrollconfirm.addAction(fingerconfirm.createPointerDown(0));
    scrollconfirm.addAction(fingerconfirm.createPointerMove(Duration.ofMillis(100),
        PointerInput.Origin.viewport(), 550, 2030));
    scrollconfirm.addAction(fingerconfirm.createPointerUp(0));
    pbDriver.perform(Arrays.asList(scrollconfirm));
	
    Thread.sleep(5000);
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(businessNameTextField)));
    System.out.println(randomBusinessName);
	//businessNameTextField.click();
	businessNameTextField.sendKeys(randomBusinessName);
	System.out.println(randomBusinessName);
	Thread.sleep(2000);
	PointerInput fingerscrolluptocheckbox = new PointerInput(PointerInput.Kind.TOUCH, "fingerscrolluptocheckbox");
    Sequence scrollscrolluptocheckbox = new Sequence(fingerscrolluptocheckbox, 1);
    scrollscrolluptocheckbox.addAction(fingerscrolluptocheckbox.createPointerMove(Duration.ofMillis(0),
        PointerInput.Origin.viewport(), 170, 1870));
    scrollscrolluptocheckbox.addAction(fingerscrolluptocheckbox.createPointerDown(0));
    scrollscrolluptocheckbox.addAction(fingerscrolluptocheckbox.createPointerMove(Duration.ofMillis(1000),
        PointerInput.Origin.viewport(), 170, 300));
    scrollscrolluptocheckbox.addAction(fingerscrolluptocheckbox.createPointerUp(0));
    pbDriver.perform(Arrays.asList(scrollscrolluptocheckbox));
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(mondayCheckBox)));
    mondayCheckBox.click();
    tuesdayCheckBox.click();
    wednesdayCheckBox.click();
    thursdayCheckBox.click();
    fridayCheckBox.click();
    saturdayCheckBox.click();
    sundayCheckBox.click();
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(saveButton)));
    saveButton.click();
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(OKButton)));
    OKButton.click();
    Thread.sleep(2000);
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(cashValuePerKgTextField)));
    cashValuePerKgTextField.click();
    cashValuePerKgTextField.sendKeys("10");
       
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(addButton)));
    addButton.click();
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(doneButton)));
    doneButton.click();
 }
public void addDonation() throws InterruptedException {
	
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(searchOutline)));
	Thread.sleep(2000);
	PointerInput fingerconfirmpassword = new PointerInput(PointerInput.Kind.TOUCH, "fingerconfirmpassword");
    Sequence scrollconfirmpassword = new Sequence(fingerconfirmpassword, 1);
    scrollconfirmpassword.addAction(fingerconfirmpassword.createPointerMove(Duration.ofMillis(0),
        PointerInput.Origin.viewport(), 950, 2060));
    scrollconfirmpassword.addAction(fingerconfirmpassword.createPointerDown(0));
    scrollconfirmpassword.addAction(fingerconfirmpassword.createPointerMove(Duration.ofMillis(100),
        PointerInput.Origin.viewport(), 950, 2060));
    scrollconfirmpassword.addAction(fingerconfirmpassword.createPointerUp(0));
    pbDriver.perform(Arrays.asList(scrollconfirmpassword));
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(addButton)));
    addButton.click();
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOf(loading)));
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(addButton)));
    addButton.click();
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(chooseDonation)));
    chooseDonation.click();
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(OKButton)));
    OKButton.click();
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOf(loading)));
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(menuButton)));
    menuButton.click();
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(logoutButton)));
    logoutButton.click();
}

public void addMemberToCreatedBranch() throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(pbDriver,Duration.ofSeconds(40));
	Thread.sleep(1000);
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(registerUser)));
	registerUser.click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(branchMemberNameTextField)));
	System.out.println("branch adding member name "+randomBranchMemberName);
	branchMemberNameTextField.sendKeys("Gayas "+randomBranchMemberName);
	
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(branchMemberPhoneNumberTextField)));
	
	branchMemberPhoneNumberTextField.sendKeys(randomBranchMemberPhoneNumber);
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(nextButton)));
	nextButton.click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(genderButton)));
	genderButton.click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(maleOption)));
	maleOption.click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(OKButton)));
	OKButton.click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(nextButton)));
	nextButton.click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(OKButton)));
	OKButton.click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(nextButton)));
	nextButton.click();
	Thread.sleep(2000);
	PointerInput fingercameraicon = new PointerInput(PointerInput.Kind.TOUCH, "fingercameraicon");
    Sequence scrollcameraicon = new Sequence(fingercameraicon, 1);
    scrollcameraicon.addAction(fingercameraicon.createPointerMove(Duration.ofMillis(0),
        PointerInput.Origin.viewport(), 700, 900));
    scrollcameraicon.addAction(fingercameraicon.createPointerDown(0));
    scrollcameraicon.addAction(fingercameraicon.createPointerMove(Duration.ofMillis(100),
        PointerInput.Origin.viewport(), 700, 900));
    scrollcameraicon.addAction(fingercameraicon.createPointerUp(0));
    pbDriver.perform(Arrays.asList(scrollcameraicon));
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(takeA_PictureOption)));
	takeA_PictureOption.click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(shutter)));
	shutter.click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(photoDone)));
	photoDone.click();
	Thread.sleep(4000);
	PointerInput fingerConfirm = new PointerInput(PointerInput.Kind.TOUCH, "fingerConfirm");
    Sequence scrollConfirm = new Sequence(fingerConfirm, 1);
    scrollConfirm.addAction(fingerConfirm.createPointerMove(Duration.ofMillis(0),
        PointerInput.Origin.viewport(), 550, 2030));
    scrollConfirm.addAction(fingerConfirm.createPointerDown(0));
    scrollConfirm.addAction(fingerConfirm.createPointerMove(Duration.ofMillis(100),
        PointerInput.Origin.viewport(), 550, 2030));
    scrollConfirm.addAction(fingerConfirm.createPointerUp(0));
    pbDriver.perform(Arrays.asList(scrollConfirm));
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(nextButton)));
	nextButton.click();


	Thread.sleep(2000);
	PointerInput fingerpassword = new PointerInput(PointerInput.Kind.TOUCH, "fingerpassword");
    Sequence scrollpassword = new Sequence(fingerpassword, 1);
    scrollpassword.addAction(fingerpassword.createPointerMove(Duration.ofMillis(0),
        PointerInput.Origin.viewport(), 320, 620));
    scrollpassword.addAction(fingerpassword.createPointerDown(0));
    scrollpassword.addAction(fingerpassword.createPointerMove(Duration.ofMillis(1000),
        PointerInput.Origin.viewport(), 320, 620));
    scrollpassword.addAction(fingerpassword.createPointerUp(0));
    pbDriver.perform(Arrays.asList(scrollpassword));
    Thread.sleep(2000);
    pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
    pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
    pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_3));
    pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_4));
    pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_5));
    pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_6));
    pbDriver.pressKey(new KeyEvent(AndroidKey.A));
//    pbDriver.pressKey(new KeyEvent(AndroidKey.D));
//    pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
   
   
    PointerInput fingerconfirmpassword = new PointerInput(PointerInput.Kind.TOUCH, "fingerconfirmpassword");
    Sequence scrollconfirmpassword = new Sequence(fingerconfirmpassword, 1);
    scrollconfirmpassword.addAction(fingerconfirmpassword.createPointerMove(Duration.ofMillis(0),
        PointerInput.Origin.viewport(), 320, 770));
    scrollconfirmpassword.addAction(fingerconfirmpassword.createPointerDown(0));
    scrollconfirmpassword.addAction(fingerconfirmpassword.createPointerMove(Duration.ofMillis(1000),
        PointerInput.Origin.viewport(), 320, 770));
    scrollconfirmpassword.addAction(fingerconfirmpassword.createPointerUp(0));
    pbDriver.perform(Arrays.asList(scrollconfirmpassword));
    pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
    pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
    pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_3));
    pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_4));
    pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_5));
    pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_6));
    pbDriver.pressKey(new KeyEvent(AndroidKey.A));
//    pbDriver.pressKey(new KeyEvent(AndroidKey.D));
//    pbDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
    Thread.sleep(5000);
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(finishButton)));
    finishButton.click();
    Thread.sleep(5000);
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(crossButton)));
    tap(crossButton.getLocation().getX()+10,crossButton.getLocation().getY()+10);
    
    
}
public void goToProcessor(){
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOf(loading)));
	 wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(menuButton)));
	    menuButton.click();
	    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(processor)));
	    processor.click();
}

}
