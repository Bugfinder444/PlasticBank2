package cms_Pages;

import Utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class esgHomePage extends BaseClass {

    public esgHomePage(WebDriver alcDriver){
        PageFactory.initElements(alcDriver,this);

    }
    @FindBy(xpath = "//input[@name='email']")
    WebElement emailTextField;
    @FindBy(xpath = "//tbody/tr/td[3]")
    public List<WebElement> dateCreated;



}
