package cms_Suite;

import Utilities.BaseClass;
import Utilities.Data;
import cms_Pages.cms_Dashboard;
import cms_Pages.login_cms;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class ALC_5770 extends BaseClass {

    @Test(priority = 0,description =" Login ")
    public void cms_Login() throws InterruptedException, IOException {

        alcDriver.get("https://esg-qa.cognitionfoundry.io/auth/login/");
        login_cms lo =new login_cms(alcDriver);
        lo.login("ashish.rawat@fleekitsolutions.com","123456a");


    }
//    @Test(priority = 1,description =" Login ")
//    public void cms_DashboardContentVerify () throws InterruptedException, IOException {
//
//        alcDriver.get("https://qa-impact.cognitionfoundry.io/postprodchecks/dashboard/page/home");
//
//        cms_Dashboard cd1 =new cms_Dashboard(alcDriver);
//        cd1.verifyContentPresent();
//
//    }
    @Test(priority = 2,description =" Login ")
    public void dateOrderChecker () throws InterruptedException, IOException {

        cms_Dashboard cd =new cms_Dashboard(alcDriver);
        cd.dateCreatedOrderCheck();


    }
    @Test(priority = 3,description =" Login ")
    public void modifyEditPartnership () throws InterruptedException, IOException, AWTException {

        cms_Dashboard cd3 =new cms_Dashboard(alcDriver);
        cd3.modifyContent();


    }



}
