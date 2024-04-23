package smoke_Suite;

import Utilities.BaseClass;
import alchemy_Pages.AlchemyLoginPage;
import alchemy_Pages.Client_Dashboards;
import impactHub_Pages.impactHubHomePage;
import org.testng.annotations.Test;

import java.io.IOException;

public class ALC_5198 extends BaseClass {

    @Test(priority = 0,description =" Login ")
    public void Login() throws InterruptedException, IOException {

        AlchemyLoginPage login=new AlchemyLoginPage(alcDriver);
        login.alc_adminlogin("+919560071590","123456a");

    }
    @Test(priority = 1,description =" Create a new Client DashBoard")
    public void createClientDashBoard() throws InterruptedException, IOException {

        Client_Dashboards cd = new Client_Dashboards(alcDriver);
        cd.createClientDashboard();

    }
    @Test(priority = 2,description =" Edit created Client DashBoard")
    public void editClientDashBoard() throws InterruptedException, IOException {

        Client_Dashboards cd = new Client_Dashboards(alcDriver);
        cd.editClientDashboard();


    }
    @Test(priority = 3,description =" Check Impact Hub for all the Audit Trail-Social Benefits Columns present and Audit Trail - Plastic ")
    public void checkImpactHub() throws InterruptedException, IOException {

        alcDriver.get("https://qa-impact.cognitionfoundry.io/"+Client_Dashboards.dashBoardPath+"/dashboard/page/home");


        AlchemyLoginPage login = new AlchemyLoginPage(alcDriver);
        login.alc_adminloginNoOtp("+919560071590", password);

        impactHubHomePage ihp = new impactHubHomePage(alcDriver);
        ihp.verifyImpactHubAuditTrail5198();
        ihp.verifyImpactHubAuditTrailCollections();

    }

}
