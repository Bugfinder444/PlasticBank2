package cms_Suite;

import Utilities.BaseClass;
import alchemy_Pages.AlchemyLoginPage;
import alchemy_Pages.Users;
import impactHub_Pages.impactHubHomePage;
import org.testng.annotations.Test;

import java.io.IOException;

public class ALC_5507 extends BaseClass {

    @Test(priority = 0,description =" Login ")
    public void Login() throws InterruptedException, IOException {


        AlchemyLoginPage login=new AlchemyLoginPage(alcDriver);
        login.alc_adminlogin("+17783844311","778778");

    }
    @Test(priority = 1,description =" Verify If Location Is visible  ")
    public void verifyLocation() throws InterruptedException, IOException {

        alcDriver.get("https://qa-impact.cognitionfoundry.io/postprodchecks/dashboard/page/home");

        impactHubHomePage ihp =new impactHubHomePage(alcDriver);
        ihp.verifyLocation();

    }

//    @Test(priority = 2,description =" Check If the Media Kit is redirected to brandfolder ")
//    public void verifyMediaKit() throws InterruptedException, IOException {
//
//        alcDriver.get("https://qa-impact.cognitionfoundry.io/postprodchecks/dashboard/page/home");
//
//        impactHubHomePage ihp =new impactHubHomePage(alcDriver);
//        ihp.verifyMediaKit("https://brandfolder.com/plasticbank/partner");
//
//    }




}
