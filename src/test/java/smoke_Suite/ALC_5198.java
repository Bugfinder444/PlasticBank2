package smoke_Suite;

import Utilities.BaseClass;
import Utilities.Data;
import Utilities.FileSearch;
import alchemy_Pages.AlchemyLoginPage;
import alchemy_Pages.Benefits;
import alchemy_Pages.Client_Dashboards;
import impactHub_Pages.impactHubHomePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ALC_5198 extends BaseClass {

    @Test(priority = 0,description =" Login ")
    public void Login() throws InterruptedException, IOException {

        AlchemyLoginPage login=new AlchemyLoginPage(alcDriver);
        login.alc_adminlogin("+919560071590","123456a");

    }
    @Test(priority = 1,description =" Create and Edit a Benefit transactions | Create another Benefit Transaction ")
    public void createEditBenefitTransaction() throws InterruptedException, IOException {

        //alcDriver.get("https://qa-admin.cognitionfoundry.io/#/login");
        try {

            alcDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            AlchemyLoginPage login = new AlchemyLoginPage(alcDriver);
            login.alc_adminlogin("+919560071590", "123456a");
            alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
        catch(Exception e){

            alcDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println("Already Logged In");
            alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        }
        Data d = new Data();
        d.createMember();

        Benefits ben = new Benefits(alcDriver);
        ben.verifyUserDirectedToRNBForm();
        ben.fillForm(Benefits.randomBenefitName);
        System.out.println("Ben 1"+Benefits.randomBenefitName);
        //ben.checkIfBenefitIsEditable(); //Already done ALC-4864

        ben.verifyUserDirectedToRNBForm();
        ben.fillForm(Benefits.randomBenefitName2);
        System.out.println("Ben 2"+Benefits.randomBenefitName2);

    }

    @Test(priority = 3,description =" Create a new Client DashBoard and add Benefit Order with the same Benefit Transactions")
    public void createClientDashBoard() throws InterruptedException, IOException {

        Client_Dashboards cd = new Client_Dashboards(alcDriver);
        cd.createClientDashboard();

    }
    @Test(priority = 3,description =" Edit created Client DashBoard ")
    public void editClientDashBoard() throws InterruptedException, IOException {

        Client_Dashboards cd = new Client_Dashboards(alcDriver);
        cd.editClientDashboard();


    }
    @Test(priority = 4,description =" Check Impact Hub for all the Audit Trail-Social Benefits Columns present and Audit Trail - Plastic ")
    public void checkImpactHub() throws InterruptedException, IOException {

        alcDriver.get("https://qa-impact.cognitionfoundry.io/"+Client_Dashboards.dashBoardPath+"/dashboard/page/home");


        AlchemyLoginPage login = new AlchemyLoginPage(alcDriver);
        login.alc_adminloginNoOtp("+919560071590", password);

        impactHubHomePage ihp = new impactHubHomePage(alcDriver);
        ihp.verifyImpactHubAuditTrail5198();
        ihp.verifyImpactHubAuditTrailCollections(Benefits.randomBenefitName,Benefits.randomBenefitName2);

    }
    @Test(priority=5, description="Voiding the Benefit Transaction 1")
    @Description("Voiding the Benefit Transaction 1")
    public void voidBenefit() throws IOException, InterruptedException {

        alcDriver.get("https://qa-admin.cognitionfoundry.io/#/login");

        AlchemyLoginPage login=new AlchemyLoginPage(alcDriver);
        login.alc_adminlogin("+919560071590","123456a");


        Benefits ben = new Benefits(alcDriver);
        ben.confirm_and_void_benefit();
    }


    @Test(priority = 6,description =" Check Impact Hub for all the Audit Trail-Social Benefits Columns present and Audit Trail - Plastic ")
    public void checkAuditTrailExportFile() throws InterruptedException, IOException {

        FileSearch fs = new FileSearch(alcDriver);
        fs.auditReport(Benefits.randomBenefitName,Benefits.randomBenefitName2);

    }


}
