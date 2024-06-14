package smoke_Suite;

import Utilities.BaseClass;
import Utilities.Data;
import Utilities.DatabaseInsertion;
import alchemy_Pages.AlchemyLoginPage;
import alchemy_Pages.Benefits;
import alchemy_Pages.Client_Dashboards;
import impactHub_Pages.impactHubHomePage;
import org.testng.annotations.Test;

import java.io.IOException;

public class ALC_6174 extends BaseClass {

    @Test(priority = 0,enabled=true,description =" Create a ClientDashBoard ")
    public void createDashboard() throws InterruptedException, IOException {

        AlchemyLoginPage login=new AlchemyLoginPage(alcDriver);
        login.alc_adminlogin("+919560071590","123456a");

        Client_Dashboards cd =new Client_Dashboards(alcDriver);
        cd.createClientDashboard6174("Master Benefit Order Philippine");

    }
    @Test(priority = 1,enabled=true,description =" Add client dashboard to Database ")
    public void addDashboardToDatabase() throws InterruptedException, IOException {

        DatabaseInsertion d = new DatabaseInsertion();
        d.testConnection2();

    }
    @Test(priority = 2,enabled=true,description =" Verify Values in donught graph and verify with total ")
    public void openDashboardCMSAndVerify() throws InterruptedException, IOException {


        Thread.sleep(905000);
        alcDriver.get("https://qa-impact.cognitionfoundry.io/"+Client_Dashboards.dashBoardPath+"/dashboard/page/home");
        Thread.sleep(5000);

        impactHubHomePage ihp = new impactHubHomePage(alcDriver);
        ihp.socialBenefitsValueVerify();


    }
    @Test(priority = 3,enabled=true,description =" Apply Filter and then check Values")
    public void applyFilterAndVerify() throws InterruptedException, IOException {


        impactHubHomePage ihp = new impactHubHomePage(alcDriver);
        ihp.filterAuditTrail();

    }
    @Test(priority = 4,enabled=true,description =" Create new Benefit order")
    public void createNewBenefitOrderAndBenefitTransaction() throws InterruptedException, IOException {


        Benefits ben= new Benefits(alcDriver);

        ben.createMasterBenefitOrder();

        Data d = new Data();
        d.createMember();

        ben.verifyUserDirectedToRNBForm();
        ben.fillForm(Benefits.randomBenefitName);
        System.out.println("Ben 1"+Benefits.randomBenefitName);


    }
    @Test(priority = 5,enabled=true,description =" Apply Filter and then check Values")
    public void createNewDashboardAndAddBenefitOrder() throws InterruptedException, IOException {



        Client_Dashboards cd =new Client_Dashboards(alcDriver);
        cd.createClientDashboard6174(Benefits.benefitordername);

        DatabaseInsertion d = new DatabaseInsertion();
        d.testConnection2();

        Thread.sleep(990000);

    }
    @Test(priority = 6,enabled=true,description =" Verify Impact hub Audit trail summary for Newly Created single material benefit order")
    public void openNewDashboardCMSAndVerify() throws InterruptedException, IOException {



        alcDriver.get("https://qa-impact.cognitionfoundry.io/"+Client_Dashboards.dashBoardPath+"/dashboard/page/home");

        impactHubHomePage ihp = new impactHubHomePage(alcDriver);
        ihp.socialBenefitsValueVerify();


    }

}
