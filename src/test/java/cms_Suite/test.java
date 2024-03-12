package cms_Suite;

import Utilities.BaseClass;
import alchemy_Pages.AlchemyLoginPage;
import cms_Pages.cms_Dashboard;
import cms_Pages.login_cms;
import impactHub_Pages.impactHubHomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class test extends BaseClass {

    public String emailAshish = "gayas.khan@fleekitsolutions.com";
    public String emailGayas = "ashish.rawat@fleekitsolutions.com";
    public String numberAshish = "+916394605799";
    public String numberGayas = "+919560071590";

    @Test(priority = -1, description = " Login ")
    public void Login() throws InterruptedException, IOException {


        AlchemyLoginPage login = new AlchemyLoginPage(alcDriver);
        login.alc_adminlogin(numberGayas, password);
        Thread.sleep(4000);


    }

    @Test(priority = 0, description = " Login CMS ")
    public void cms_Login() throws InterruptedException, IOException {


        alcDriver.get("https://esg-qa.cognitionfoundry.io/auth/login/");
        //alcDriver.get("https://esg-stage.cognitionfoundry.io/");
        login_cms lo = new login_cms(alcDriver);
        lo.login(emailGayas, password);
        Thread.sleep(4000);
        alcDriver.navigate().refresh();

    }

    @Test(priority = 1,description ="Creating a new content and publishing In the CMS Dashboard navigate to the *MarketingCalender * and add a new content. ")
    public void createMarketingCalender() throws InterruptedException, IOException, AWTException {

        alcDriver.get("https://esg-qa.cognitionfoundry.io/auth/login/");
        //alcDriver.get("https://esg-stage.cognitionfoundry.io/");
        try{

            cms_Dashboard cd7 = new cms_Dashboard(alcDriver);
            cd7.addMarketingCalender();
        }
        catch(Exception e) {

            login_cms lo =new login_cms(alcDriver);
            lo.login(emailGayas,password);
            cms_Dashboard cd7 = new cms_Dashboard(alcDriver);
            cd7.addMarketingCalender();
        }

    }

    @Test(priority = 2,description =" Verify the changes published are reflected in *QA_ForPostProductionOnly*'s ESG Home Page > Marketing Calender. ")
    public void verifyMarketingCalender_Postprod() throws InterruptedException, IOException, AWTException {
        alcDriver.get("https://qa-impact.cognitionfoundry.io/postprodchecks/dashboard/page/home");
        //alcDriver.get("https://staging-impact.plasticbank.com/postprodchecks/dashboard/page/home");

        impactHubHomePage ehp = new impactHubHomePage(alcDriver);
      try{

            ehp.verifyTitleMKC(cms_Dashboard.titleMKC);
            ehp.verifyUrlMKC(cms_Dashboard.urlMKC);

        }
        catch(Exception e) {

            alcDriver.get("https://qa-admin.cognitionfoundry.io/#/admin/clientdashboards/23a911f1-8e7c-46ee-adf1-f93a6c0a2b35");
            //https://staging-admin.plasticbank.com/#/admin/clientdashboards/98179f8f-3e2d-4ba4-88b5-932473c752b2
            ehp.addEmailDashBoard(emailGayas,numberGayas,password);

            alcDriver.get("https://qa-impact.cognitionfoundry.io/postprodchecks/dashboard/page/home");
            ehp.verifyTitleMKC(cms_Dashboard.titleMKC);
            ehp.verifyUrlMKC(cms_Dashboard.urlMKC);

        }

    }
}
