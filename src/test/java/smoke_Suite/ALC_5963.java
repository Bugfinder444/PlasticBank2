package smoke_Suite;

import Utilities.BaseClass;
import alchemy_Pages.AlchemyLoginPage;
import alchemy_Pages.Client_Dashboards;
import impactHub_Pages.impactHubHomePage;
import org.testng.annotations.Test;

import java.io.IOException;

public class ALC_5963 extends BaseClass {

    @Test(priority = 0,description =" Login ")
    public void Login() throws InterruptedException, IOException {

        AlchemyLoginPage login=new AlchemyLoginPage(alcDriver);
        login.alc_adminlogin("+919560071590","123456a");

    }
    @Test(priority = 1,description =" Check Client DashBoard and Create a new DashBoard with all the Audit Trail-Social Benefits Columns Enabled")
    public void checkAndCreateClientDashBoard() throws InterruptedException, IOException {

        Client_Dashboards cd = new Client_Dashboards(alcDriver);
        cd.checkClientDashBoard();

    }

    @Test(priority = 2,description =" Check Impact Hub for all the Audit Trail-Social Benefits Columns present ")
    public void checkImpactHub() throws InterruptedException, IOException {

        alcDriver.get("https://qa-impact.cognitionfoundry.io/"+Client_Dashboards.dashBoardPath+"/dashboard/page/home");


        AlchemyLoginPage login = new AlchemyLoginPage(alcDriver);
        login.alc_adminloginNoOtp("+919560071590", password);

        impactHubHomePage ihp = new impactHubHomePage(alcDriver);
        ihp.verifyImpactHubAuditTrailSB();

    }


}
