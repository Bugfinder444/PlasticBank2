package cms_Pages;

import Utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class login_cms extends BaseClass {

    public login_cms(WebDriver alcDriver){
        PageFactory.initElements(alcDriver,this);

    }

    @FindBy(xpath = "//input[@name='email']")
    WebElement emailTextField;
    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordTextField;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;
    @FindBy(xpath = "//button[@type='button']")
    WebElement showPasswordButton;
    @FindBy(xpath = "//input[@type=\"number\"]")
    public List<WebElement> digitVerification;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement verifyButton;
    @FindBy(xpath = "//a[text()='Return to sign in']")
    WebElement returnToSignIn;

    public void login(String email, String password){

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(emailTextField));
        emailTextField.sendKeys(email);
        passwordTextField.sendKeys(password);
        loginButton.click();

        try {
            wait.until(ExpectedConditions.elementToBeClickable(digitVerification.get(0)));
            digitVerification.get(0).sendKeys("7");
            digitVerification.get(1).sendKeys("7");
            digitVerification.get(2).sendKeys("8");
            digitVerification.get(3).sendKeys("8");
            digitVerification.get(4).sendKeys("9");
            digitVerification.get(5).sendKeys("9");
        }
        catch (Exception e){

            System.out.println("OTP is Not Required");
        }
        verifyButton.click();

    }
    public String showPassword(String email, String password) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(emailTextField));
        emailTextField.sendKeys(email);
        passwordTextField.sendKeys(password);
        Thread.sleep(3000);
        showPasswordButton.click();
        return passwordTextField.getText();

    }





}
