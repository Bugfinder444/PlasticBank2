package alchemy_Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;


import Utilities.BaseClass;

public class AlchemyLoginPage extends BaseClass{
	
public AlchemyLoginPage(WebDriver alcDriver) {
		
		PageFactory.initElements(alcDriver, this);
		}

@FindBy(xpath="//input[@id='phone']")
public WebElement email_PhoneTextFeild ;

@FindBy(xpath="//input[@id='password']")
public WebElement passwordTextFeild ;

@FindBy(xpath="//input[@type='checkbox']")
public WebElement hidePasswordCheckBox ;
@FindBy(xpath="//div[@class='cursor-pointer underline color-silver-sand']")
public WebElement forgotPasswordLink ;
@FindBy(xpath="//a[normalize-space()='View Privacy Policy']")
public WebElement viewPrivacyPolicyLink ;

@FindBy(xpath="//input-code-field/input[1]")
public WebElement one ;
@FindBy(xpath="//input-code-field/input[2]")
public WebElement two ;
@FindBy(xpath="//input-code-field/input[3]")
public WebElement three ;
@FindBy(xpath="//input-code-field/input[4]")
public WebElement four ;
@FindBy(xpath="//input-code-field/input[5]")
public WebElement five ;
@FindBy(xpath="//input-code-field/input[6]")
public WebElement six ;
@FindBy(xpath="//div[@class='ng-star-inserted']")
public WebElement resendCode ;

@FindBy(xpath="//button[normalize-space()='Log in']")
public WebElement logInButton ;
@FindBy(xpath="//div[@class='body']/div/div/div[text()=' Branches ']")
private WebElement branches_TAB;

public void enterDetails(String adminphoneNumber, String adminpassword) {
	
	email_PhoneTextFeild.sendKeys(adminphoneNumber);
	passwordTextFeild.sendKeys(adminpassword);
	logInButton.click();
	}
public void twoFactorAuth() throws InterruptedException {
	one.sendKeys("7");
	two.sendKeys("7");
	three.sendKeys("8");
	four.sendKeys("8");
	five.sendKeys("9");
	six.sendKeys("9");
	WebDriverWait wait = new WebDriverWait(pbDriver,Duration.ofSeconds(10));
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(branches_TAB)));
    branches_TAB.isDisplayed();
}
@Step("Login on app")
public void alc_adminlogin(String adminphoneNumber, String adminpassword) throws InterruptedException {
	enterDetails(adminphoneNumber, adminpassword);
	Thread.sleep(2000);
	twoFactorAuth();
	
}
}
