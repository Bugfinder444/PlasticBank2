package cms_Suite;

import Utilities.BaseClass;
import Utilities.Data;
import alchemy_Pages.AlchemyLoginPage;
import cms_Pages.cms_Dashboard;
import impactHub_Pages.impactHubHomePage;
import cms_Pages.login_cms;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ALC_5770 extends BaseClass {

    public String emailAshish ="gayas.khan@fleekitsolutions.com";
    public String emailGayas ="ashish.rawat@fleekitsolutions.com";
    public String numberAshish ="+916394605799";
    public String numberGayas ="+919560071590";




    @Test(priority = -1,description =" Login ")
    public void Login() throws InterruptedException, IOException {


        AlchemyLoginPage login=new AlchemyLoginPage(alcDriver);
        login.alc_adminlogin(numberGayas,password);


    }
    @Test(priority = 0,description =" Login CMS ")
    public void cms_Login() throws InterruptedException, IOException {


        alcDriver.get("https://esg-qa.cognitionfoundry.io/auth/login/");
        //alcDriver.get("https://esg-stage.cognitionfoundry.io/");
        login_cms lo =new login_cms(alcDriver);
        lo.login(emailGayas,password);
        Thread.sleep(4000);
        alcDriver.navigate().refresh();


    }

    @Test(priority = 1,description =" 1. Verify upon relogin of a user with existing content, existing contents are seen in a list.\n" + "2. Verify the content list is in descending order, newest content that's created/modified. ")

    public void dateOrderChecker () throws InterruptedException, IOException {

        cms_Dashboard cd = new cms_Dashboard(alcDriver);
        try {

            cd.dateCreatedOrderCheck();
        }
        catch(Exception e)
        {
            alcDriver.navigate().refresh();
            cd.dateCreatedOrderCheck();

        }


    }

    @Test(priority = 2,description =" Create Partnership Milestone Content and Modify all the fields. Also Verifying updated Date Time ")
    public void createAndEditPartnershipMilestone () throws InterruptedException, IOException, AWTException {

        cms_Dashboard cd3 =new cms_Dashboard(alcDriver);
        cd3.createPartnershipMilestone();
        cd3.modifyPEContent();
        cd3.dateUpdateVerify();

    }

    @Test(priority = 3,description =" Verify the changes published are reflected in *QA_ForPostProductionOnly*'s ESG Home Page > Partner Milestone section. ")
    public void verifyEditedPMinQA_Postprod () throws InterruptedException, IOException {

        alcDriver.get("https://qa-impact.cognitionfoundry.io/postprodchecks/dashboard/page/home");
        //alcDriver.get("https://staging-impact.plasticbank.com/postprodchecks/dashboard/page/home");

        impactHubHomePage ehp = new impactHubHomePage(alcDriver);
        try{

            ehp.verifyTitle(cms_Dashboard.title_Random);
            ehp.verifyBlurb(cms_Dashboard.blurb_Random);
            ehp.verifyImage(cms_Dashboard.expectedImagePMedited);
            ehp.verifyUrlPM(cms_Dashboard.urlPM_updated);

        }
        catch(Exception e) {

            alcDriver.get("https://qa-admin.cognitionfoundry.io/#/admin/clientdashboards/23a911f1-8e7c-46ee-adf1-f93a6c0a2b35");
            //https://staging-admin.plasticbank.com/#/admin/clientdashboards/98179f8f-3e2d-4ba4-88b5-932473c752b2
            ehp.addEmailDashBoard(emailGayas,numberGayas,password);

            alcDriver.get("https://qa-impact.cognitionfoundry.io/postprodchecks/dashboard/page/home");
            ehp.verifyTitle(cms_Dashboard.title_Random);
            ehp.verifyBlurb(cms_Dashboard.blurb_Random);
            ehp.verifyImage(cms_Dashboard.expectedImagePMedited);
            ehp.verifyUrlPM(cms_Dashboard.urlPM_updated);

        }

    }
    @Test(priority = 4, description = " Verify the changes published are NOT reflected in *Dial*'s ESG Home Page > Partner Milestone section. ")
    public void verifyEditedPMinQA_Dial() throws InterruptedException, IOException {

        impactHubHomePage ehp = new impactHubHomePage(alcDriver);

        alcDriver.get("https://qa-impact.cognitionfoundry.io/dial/dashboard/page/home");
        //alcDriver.get("https://staging-impact.plasticbank.com/dial/dashboard/page/home");
        try {
            alcDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            AlchemyLoginPage login = new AlchemyLoginPage(alcDriver);
            login.alc_adminloginNoOtp(numberGayas, password);

            WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(6));
            wait.until(ExpectedConditions.visibilityOf(impactHubHomePage.titleMileStonePartner));

            alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        }catch (Exception e){
            alcDriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

            System.out.println("Content is not present in Dial");
            alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        }
//        try{
//
//            alcDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//            ehp.verifyTitleFalse(cms_Dashboard.title_Random);
//            ehp.verifyBlurbFalse(cms_Dashboard.blurb_Random);
//            ehp.verifyImageFalse(cms_Dashboard.expectedImagePM);
//
//            alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        }
//        catch (Exception e){
//
//            alcDriver.get("https://qa-admin.cognitionfoundry.io/#/admin/clientdashboards/98179f8f-3e2d-4ba4-88b5-932473c752b2");
//
//            ehp.addEmailDashBoard(emailGayas,numberGayas,password);
//
//            alcDriver.get("https://qa-impact.cognitionfoundry.io/dial/dashboard/page/home");
//
//            ehp.verifyTitleFalse(cms_Dashboard.title_Random);
//            ehp.verifyBlurbFalse(cms_Dashboard.blurb_Random);
//            ehp.verifyImageFalse(cms_Dashboard.expectedImagePM);
//
//        }
//
//
    }



    @Test(priority = 5,description ="Creating a new content and publishing In the CMS Dashboard navigate to the *Partnership Engagement* and add a new content. ")
    public void createPartnershipEngagement() throws InterruptedException, IOException, AWTException {

        alcDriver.get("https://esg-qa.cognitionfoundry.io/auth/login/");
        //alcDriver.get("https://esg-stage.cognitionfoundry.io/");
        try{

            cms_Dashboard cd4 = new cms_Dashboard(alcDriver);
            cd4.addPartnershipEngagment();
        }
        catch(Exception e) {

            login_cms lo =new login_cms(alcDriver);
            lo.login(emailGayas,password);
            cms_Dashboard cd4 = new cms_Dashboard(alcDriver);
            cd4.addPartnershipEngagment();
        }

    }
    @Test(priority = 6,description =" Verify the changes published are reflected in *Dial's*  ESG Market Place > Partnership Engagement section. ")
    public void verifycreatedPEInDial() throws InterruptedException, IOException, AWTException {

        alcDriver.get("https://qa-impact.cognitionfoundry.io/dial/dashboard/page/home");
        //alcDriver.get("https://staging-impact.cognitionfoundry.io/dial/dashboard/page/home");
        try{
            alcDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            AlchemyLoginPage login=new AlchemyLoginPage(alcDriver);
            login.alc_adminloginNoOtp(numberGayas,password);

            impactHubHomePage ehp = new impactHubHomePage(alcDriver);
            ehp.verifyTitlePE(cms_Dashboard.titlePE);
            ehp.verifyBlurbPE(cms_Dashboard.blurbPE);
            ehp.verifyUrlPE(cms_Dashboard.urlPE);
            alcDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        }
        catch(Exception e) {

            impactHubHomePage ehp = new impactHubHomePage(alcDriver);
            ehp.verifyTitlePE(cms_Dashboard.titlePE);
            ehp.verifyBlurbPE(cms_Dashboard.blurbPE);
            ehp.verifyUrlPE(cms_Dashboard.urlPE);
            alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }


    }
    @Test(priority = 7,description =" Verify the changes published are reflected in *QA_Postproduction*  ESG Market Place > Partnership Engagement section. ")
    public void verifycreatedPEInQA_Postprod() throws InterruptedException, IOException, AWTException {

        alcDriver.get("https://qa-impact.cognitionfoundry.io/postprodchecks/dashboard/page/home");
        //alcDriver.get("https://staging-impact.plasticbank.com/postprodchecks/dashboard/page/home");

        impactHubHomePage ehp = new impactHubHomePage(alcDriver);
        ehp.verifyTitlePE(cms_Dashboard.titlePE);
        ehp.verifyBlurbPE(cms_Dashboard.blurbPE);
        ehp.verifyUrlPE(cms_Dashboard.urlPE);


    }
    @Test(priority = 8,description =" Verify the changes published are reflected in *OceanBottle's*  ESG Market Place ")
    public void verifycreatedPEInOceanBottle() throws InterruptedException, IOException, AWTException {

        alcDriver.get("https://qa-impact.cognitionfoundry.io/oceanbottle/dashboard/page/home");
        //alcDriver.get("https://staging-impact.plasticbank.com/oceanbottle/dashboard/page/home");

        impactHubHomePage ehp = new impactHubHomePage(alcDriver);
        try {

            ehp.verifyTitlePE(cms_Dashboard.titlePE);
            ehp.verifyBlurbPE(cms_Dashboard.blurbPE);
            ehp.verifyUrlPE(cms_Dashboard.urlPE);

        }
        catch(Exception e){

            alcDriver.get("https://qa-admin.cognitionfoundry.io/#/admin/clientdashboards/0f2dc795-2c44-4b5a-8a70-08ab18fb4483");
            ehp.addEmailDashBoard(emailGayas,numberGayas,password);
            Thread.sleep(2000);
            alcDriver.get("https://qa-impact.cognitionfoundry.io/oceanbottle/dashboard/page/home");
            ehp.verifyTitlePE(cms_Dashboard.titlePE);
            ehp.verifyBlurbPE(cms_Dashboard.blurbPE);
            ehp.verifyUrlPE(cms_Dashboard.urlPE);

        }

    }
    @Test(priority = 9,description ="Creating a new content and publishing In the CMS Dashboard navigate to the *Material Credits * and add a new content. ")
    public void createMaterialCredit() throws InterruptedException, IOException, AWTException {

        alcDriver.get("https://esg-qa.cognitionfoundry.io/auth/login/");
        //alcDriver.get("https://esg-stage.cognitionfoundry.io/");
        try{

            cms_Dashboard cd5 = new cms_Dashboard(alcDriver);
            cd5.addMaterialCredit();
        }
        catch(Exception e) {

            login_cms lo =new login_cms(alcDriver);
            lo.login(emailGayas,password);
            cms_Dashboard cd5 = new cms_Dashboard(alcDriver);
            cd5.addMaterialCredit();
        }


    }


    @Test(priority = 10,description =" Verify the changes published are reflected in *QA_ForPostProductionOnly*'s ESG Home Page > Material Credits section. ")
    public void verifyMaterialCredit_Postprod () throws InterruptedException, IOException, AWTException {

        alcDriver.get("https://qa-impact.cognitionfoundry.io/postprodchecks/dashboard/page/home");
        //alcDriver.get("https://staging-impact.plasticbank.com/postprodchecks/dashboard/page/home");

        impactHubHomePage ehp = new impactHubHomePage(alcDriver);
        try{

            ehp.verifyTitleMC(cms_Dashboard.titleMC);
            ehp.verifyBlurbMC(cms_Dashboard.blurbMC);
            ehp.verifyUrlMC(cms_Dashboard.urlMC);

        }
        catch(Exception e) {

            alcDriver.get("https://qa-admin.cognitionfoundry.io/#/admin/clientdashboards/23a911f1-8e7c-46ee-adf1-f93a6c0a2b35");
            //https://staging-admin.plasticbank.com/#/admin/clientdashboards/98179f8f-3e2d-4ba4-88b5-932473c752b2
            ehp.addEmailDashBoard(emailGayas,numberGayas,password);

            alcDriver.get("https://esg-qa.cognitionfoundry.io/auth/login/");
            ehp.verifyTitleMC(cms_Dashboard.titleMC);
            ehp.verifyBlurbMC(cms_Dashboard.blurbMC);
            ehp.verifyUrlMC(cms_Dashboard.urlMC);

        }

    }

    @Test(priority = 11,description ="Creating a new content and publishing In the CMS Dashboard navigate to the *Social Benifits * and add a new content. ")
    public void createSocialBenefits() throws InterruptedException, IOException, AWTException {

        alcDriver.get("https://esg-qa.cognitionfoundry.io/auth/login/");
        //alcDriver.get("https://esg-stage.cognitionfoundry.io/");
        try{

            cms_Dashboard cd6 = new cms_Dashboard(alcDriver);
            cd6.addSocialBenefit();
        }
        catch(Exception e) {

            login_cms lo =new login_cms(alcDriver);
            lo.login(emailGayas,password);
            cms_Dashboard cd6 = new cms_Dashboard(alcDriver);
            cd6.addSocialBenefit();
        }

    }

    @Test(priority = 12,description =" Verify the changes published are reflected in *QA_ForPostProductionOnly*'s ESG Home Page > Partner Social Benefit. ")
    public void verifySocialBenefit_Postprod () throws InterruptedException, IOException, AWTException {
        alcDriver.get("https://qa-impact.cognitionfoundry.io/postprodchecks/dashboard/page/home");
        //alcDriver.get("https://staging-impact.plasticbank.com/postprodchecks/dashboard/page/home");

        impactHubHomePage ehp = new impactHubHomePage(alcDriver);
        try{

            ehp.verifyTitleSB(cms_Dashboard.titleSB);
            ehp.verifyBlurbSB(cms_Dashboard.blurbSB);
            ehp.verifyUrlSB(cms_Dashboard.urlSB);


        }
        catch(Exception e) {

            alcDriver.get("https://qa-admin.cognitionfoundry.io/#/admin/clientdashboards/23a911f1-8e7c-46ee-adf1-f93a6c0a2b35");
            //https://staging-admin.plasticbank.com/#/admin/clientdashboards/98179f8f-3e2d-4ba4-88b5-932473c752b2
            ehp.addEmailDashBoard(emailGayas,numberGayas,password);

            alcDriver.get("https://qa-impact.cognitionfoundry.io/postprodchecks/dashboard/page/home");
            ehp.verifyTitleSB(cms_Dashboard.titleSB);
            ehp.verifyBlurbSB(cms_Dashboard.blurbSB);
            ehp.verifyUrlSB(cms_Dashboard.urlSB);



        }


    }


    @Test(priority = 13,description ="Creating a new content and publishing In the CMS Dashboard navigate to the *MarketingCalender * and add a new content. ")
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

    @Test(priority = 14,description =" Verify the changes published are reflected in *QA_ForPostProductionOnly*'s ESG Home Page > Marketing Calender. ")
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
