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

public class PB_Register_Member extends BaseClass {
	

public PB_Register_Member(AndroidDriver pBriver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(pbDriver), this);
		}
//elements:-
@AndroidFindBy(uiAutomator= "new UiSelector().className(\"android.widget.EditText\").instance(0)")
public WebElement loginPagePhoneNumberTextField;
@AndroidFindBy(uiAutomator= "new UiSelector().className(\"android.widget.EditText\").instance(0)")
public WebElement loginPagePasswordTextField;
@AndroidFindBy(uiAutomator= "new UiSelector().className(\"android.widget.CheckBox\").instance(0)")
public WebElement termsAndConditionsCheckBox;
@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Password\"));")
public WebElement passwordTextField;
@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Confirm Password\"));")
public WebElement confirmPasswordTextField;
@AndroidFindBy(xpath= "//android.widget.ImageView[@content-desc=\"Shutter\"]")
public WebElement shutter;
@AndroidFindBy(xpath= "//android.widget.ImageButton[@content-desc=\"Done\"]")
public WebElement photoDone;
@AndroidFindBy(uiAutomator= "new UiSelector().className(\"android.widget.EditText\").instance(2)")
public WebElement phoneNumberTextField;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sign up\")")
public WebElement signUpButton;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Use Photo\")")
public WebElement usePhoto;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Skip for now\")")
public WebElement skipButton;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Gender\")")
public WebElement genderField;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"skip_video\")")
public WebElement skipvideoButton;
@AndroidFindBy(id= "org.plasticbank.app:id/action_bar_root")
public WebElement loadedPage;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"menu\")")
public WebElement menu;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Logout\")")
public WebElement logout;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Male\")")
public WebElement male;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Collectors\")")
public WebElement collectorsPannel;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").instance(1)")
public WebElement becomeACollectorButton;
@AndroidFindBy(uiAutomator= "new UiSelector().className(\"android.widget.EditText\").instance(0)")
public WebElement firstNameTextField;
@AndroidFindBy(uiAutomator= "new UiSelector().className(\"android.widget.EditText\").instance(1)")
public WebElement lastNameTextField;
@AndroidFindBy(uiAutomator= "new UiSelector().className(\"android.widget.Spinner\").instance(0)")
public WebElement phoneCountryCodedropdown;
//@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Philippines (+63)\")")
@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Philippines (+63)\"))")
public WebElement selectPhilipines;
@AndroidFindBy(uiAutomator= "new UiScrollable(new UiSelector().className(\"android.view.View\").instance(52))")
public WebElement countrylist;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"OK\")")
public WebElement oKButton;
@AndroidFindBy(uiAutomator= "new UiSelector().text(\"DD/MM/YYYY\")")
public WebElement dateOfBirthTextField;
@AndroidFindBy(uiAutomator= "new UiSelector().text(\"Verify Phone\")")
public WebElement  verifyPhoneText;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"CANCEL\")")
public WebElement cancel;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Qatar (+974)\")")
public WebElement selectdummycountry;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"DONE\")")
public WebElement doneButton;
@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()")
public WebElement scrollablePhilipines;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Gender\")")
public WebElement genders;
@AndroidFindBy(uiAutomator= "new UiSelector().text(\"camera\")")
public WebElement takePhoto;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"checkmark\")")
public WebElement finalconfirmation;
@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").instance(2)")
public WebElement camera;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Edit\")")
public WebElement editButton;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Your account is not verified. Click here to verify.\")")
public WebElement verifyAccount;
@AndroidFindBy(uiAutomator= "new UiSelector().className(\"android.widget.EditText\").instance(2)")
public WebElement enterSMS;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"arrow back\")")
public WebElement arrowBack;
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"While using the app\")")
public WebElement permission;

@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Allow\")")
public WebElement allow;

@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Afghanistan (+93)\")")
public WebElement selectAfghanistan;

@AndroidFindBy(xpath ="//android.view.View/android.view.View[4]/android.view.View/android.view.View[1]/android.widget.EditText")
public WebElement verify1;
@AndroidFindBy(xpath ="//android.view.View/android.view.View[4]/android.view.View/android.view.View[2]/android.widget.EditText")
public WebElement verify2;
@AndroidFindBy(xpath ="//android.view.View/android.view.View[4]/android.view.View/android.view.View[3]/android.widget.EditText")
public WebElement verify3;
@AndroidFindBy(xpath ="//android.view.View/android.view.View[4]/android.view.View/android.view.View[4]/android.widget.EditText")
public WebElement verify4;
@AndroidFindBy(xpath ="//android.view.View/android.view.View[4]/android.view.View/android.view.View[5]/android.widget.EditText")
public WebElement verify5;
@AndroidFindBy(xpath ="//android.view.View/android.view.View[4]/android.view.View/android.view.View[6]/android.widget.EditText")
public WebElement verify6;


//functions:-

public void clickSignUpButton() {
	WebDriverWait wait = new WebDriverWait(pbDriver,Duration.ofSeconds(50));
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(permission)));
	permission.click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(signUpButton)));
	signUpButton.click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(skipvideoButton)));
	skipvideoButton.click();
	
}

public void chooseCollectorsPannel() throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(pbDriver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(collectorsPannel)));
	Thread.sleep(2000);
	collectorsPannel.click();
}

public void clickBecomeAColectorButton() {
	WebDriverWait wait = new WebDriverWait(pbDriver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(becomeACollectorButton)));
	becomeACollectorButton.click();
}
public void uploadphoto() throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(pbDriver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(takePhoto)));
	takePhoto.click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(camera)));
	Thread.sleep(2000);
	PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
  Sequence scrolla = new Sequence(finger1, 1);
  scrolla.addAction(finger1.createPointerMove(Duration.ofMillis(0),
      PointerInput.Origin.viewport(), camera.getLocation().getX() + 400, camera.getLocation().getY() + 50));
  scrolla.addAction(finger1.createPointerDown(0));
  scrolla.addAction(finger1.createPointerMove(Duration.ofMillis(100),
      PointerInput.Origin.viewport(), camera.getLocation().getX() + 400, camera.getLocation().getY() + 50));
  scrolla.addAction(finger1.createPointerUp(0));
  pbDriver.perform(Arrays.asList(scrolla));
  wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(permission)));
	permission.click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(allow)));
  allow.click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(shutter)));
	shutter.click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(photoDone)));
	photoDone.click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(usePhoto)));
	usePhoto.click();
	
}

public void enterFirstName(String name) {
	WebDriverWait wait = new WebDriverWait(pbDriver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(firstNameTextField)));
	firstNameTextField.sendKeys(name);
}
public void enterLastName(String lastname) {
	WebDriverWait wait = new WebDriverWait(pbDriver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(lastNameTextField)));
	lastNameTextField.sendKeys(lastname);
	System.out.println(lastname);
}
public void random_enterLastName() {
	WebDriverWait wait = new WebDriverWait(pbDriver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(lastNameTextField)));
	lastNameTextField.sendKeys(randomLastName);
	System.out.println(randomLastName);
}

public void enterPhoneNumberRandom() {
	WebDriverWait wait = new WebDriverWait(pbDriver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(phoneNumberTextField)));
	phoneNumberTextField.click();
	phoneNumberTextField.sendKeys(randomPhoneNumber);
	pbDriver.pressKey(new KeyEvent(AndroidKey.BACK));
  
}
public void enterPhoneNumber(String phoneNumber) {
	WebDriverWait wait = new WebDriverWait(pbDriver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(phoneNumberTextField)));
	phoneNumberTextField.click();
	phoneNumberTextField.sendKeys(phoneNumber);
  
}

public void chosenCountryCode() throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(pbDriver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(phoneCountryCodedropdown)));
	phoneCountryCodedropdown.click();
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(countrylist)));
	selectAfghanistan.click();
	for (int i = 0; i < 178; i++) {
		pbDriver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
	}
	selectPhilipines.click();  
	oKButton.click();
}

public void enterDOB() throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(pbDriver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(dateOfBirthTextField)));
	dateOfBirthTextField.click();
	
	
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(cancel)));
	PointerInput fingerYears = new PointerInput(PointerInput.Kind.TOUCH, "fingerYears");
    Sequence scrollYears = new Sequence(fingerYears, 1);
    scrollYears.addAction(fingerYears.createPointerMove(Duration.ofMillis(0),
        PointerInput.Origin.viewport(), cancel.getLocation().getX()+100, cancel.getLocation().getY() + 500));
    scrollYears.addAction(fingerYears.createPointerDown(0));
    scrollYears.addAction(fingerYears.createPointerMove(Duration.ofMillis(100),
        PointerInput.Origin.viewport(), cancel.getLocation().getX()+100, cancel.getLocation().getY() + 100));
    scrollYears.addAction(fingerYears.createPointerUp(0));
    pbDriver.perform(Arrays.asList(scrollYears));
Thread.sleep(1000);
    doneButton.click();
	}

public void selectGender() throws InterruptedException {
	Thread.sleep(1000);
	PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
  Sequence scrolla = new Sequence(finger1, 1);
  scrolla.addAction(finger1.createPointerMove(Duration.ofMillis(0),
      PointerInput.Origin.viewport(), 1000, 1700));
  scrolla.addAction(finger1.createPointerDown(0));
  scrolla.addAction(finger1.createPointerMove(Duration.ofMillis(1000),
      PointerInput.Origin.viewport(), 1000, 200));
  scrolla.addAction(finger1.createPointerUp(0));
  pbDriver.perform(Arrays.asList(scrolla));
  WebDriverWait wait = new WebDriverWait(pbDriver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(genderField)));
	genderField.click();
	
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(genders)));
	male.click();
	oKButton.click();
}
public void enterpassword(String password) {
	WebDriverWait wait = new WebDriverWait(pbDriver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(passwordTextField)));
	passwordTextField.sendKeys(password);
	confirmPasswordTextField.sendKeys(password);
}
public void clicktermsandconditions() {
	WebDriverWait wait = new WebDriverWait(pbDriver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(termsAndConditionsCheckBox)));
	termsAndConditionsCheckBox.click();
}
public void finalconfirm() {
	WebDriverWait wait = new WebDriverWait(pbDriver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(finalconfirmation)));
	finalconfirmation.click();
	}

public void verifyAccount() throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(pbDriver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(editButton)));
	editButton.click();
	
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(verifyAccount)));
	verifyAccount.click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(enterSMS)));
	enterSMS.sendKeys("778899");
	Thread.sleep(1000);
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(oKButton)));
    oKButton.click();
    Thread.sleep(2000);
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(oKButton)));
    oKButton.click();
	
}

public void clickmenu() {
	WebDriverWait wait = new WebDriverWait(pbDriver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(menu)));
	menu.click();
}
public void clickbackarrow() {
	WebDriverWait wait = new WebDriverWait(pbDriver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(arrowBack)));
	arrowBack.click();
}
public void clicklogout() {
	WebDriverWait wait = new WebDriverWait(pbDriver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(logout)));
	logout.click();
}
public void skipForNow() {
	WebDriverWait wait = new WebDriverWait(pbDriver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(skipButton)));
   skipButton.click();
}
public void fillDetailsRandom(String name,String password) throws InterruptedException {
	uploadphoto();
	enterFirstName(name);
	random_enterLastName();
	chosenCountryCode();
	enterPhoneNumberRandom();
	enterDOB();
	selectGender();
	enterpassword(password);
	clicktermsandconditions();
	finalconfirm();
	skipForNow();
}
public void fillDetails(String name,String lastname,String password,String phoneNumber) throws InterruptedException {
	uploadphoto();
	enterFirstName(name);
	enterLastName(lastname);
	chosenCountryCode();
	enterPhoneNumber(phoneNumber);
	enterDOB();
	selectGender();
	enterpassword(password);
	clicktermsandconditions();
	finalconfirm();
	skipForNow();
}


public void signUpRandom(String name,String password) throws InterruptedException {
	clickSignUpButton();
	chooseCollectorsPannel();
	clickBecomeAColectorButton();
	fillDetailsRandom(name, password);
	verifyAccount();
	
}
public void logout(){
	clickmenu();
	clicklogout();
}
public void signUp(String name,String lastname,String password,String phoneNumber) throws InterruptedException {
	clickSignUpButton();
	chooseCollectorsPannel();
	clickBecomeAColectorButton();
	fillDetails(name,lastname,password,phoneNumber);
	verifyAccount();
	clickmenu();
	clicklogout();
}
}