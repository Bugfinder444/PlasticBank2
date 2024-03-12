package smoke_Suite;

import Utilities.BaseClass;
import Utilities.Data;
import Utilities.auditTrailReport_2627;
import alchemy_Pages.AlchemyLoginPage;
import alchemy_Pages.Bonus;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;

public class ALC_2627 extends BaseClass {

    @Test(priority = 0,description =" Create Data and Perform Transactions 1 ")
    public void createTransaction1() throws InterruptedException, IOException {

        Data d1 = new Data();
        d1.runNewman_ALC_2627();

    }
    @Test(priority = 1,description =" `Transfer Transaction from Master Bonus`")
    public void bonusTransfer() throws InterruptedException, IOException {

        AlchemyLoginPage login=new AlchemyLoginPage(alcDriver);
        login.alc_adminlogin("+919560071590",password);

        Bonus b1 =new Bonus(alcDriver);
        b1.bonusOrdertransfer(Data.bonus1Id2627,Data.bonus2Name2627,"800 KG /50,000KG",Arrays.asList("800 KG","800 KG"),"Total Weight: 550.00 KG","600 KG /50,000KG",Arrays.asList("600 KG","600 KG"),Data.branch1_Name2627,"Plastic","PET","200");


    }
    @Test(priority = 2,description ="Transfer Transactions of a Bonus Order | Verify transaction Verified in Summary Tab and Bonus Approval Before and  after Transfer of Transaction in Master Bonus Order ")
    public void verifyBonusTransfer() throws InterruptedException, IOException {

        Bonus b2 =new Bonus(alcDriver);
        b2.verifyTransferedBonus(Data.bonus2Id2627,"1400","Total Weight: 550.00 KG","PET - 200.00KG");

    }
    @Test(priority = 3,description =" Verify the transactions Transferred are present in Branch Exchange History with Bonus Name Transferred visible ")
    public void verifyBonusTransferInBranch() throws InterruptedException, IOException {

        Bonus b3 =new Bonus(alcDriver);
        b3.branchBonustransferVerify(Data.branch1Id_2627,3);
        //Data.branch1Id_2627,3,Arrays.asList(Data.bonus1Name2627,Data.bonus1Name2627,Data.bonus1Name2627,Data.bonus2Name2627,Data.bonus1Name2627,Data.bonus2Name2627

    }
    @Test(priority = 4,description =" Verify The Transaction Transferred in Audit Trail Report of transferred Bonus")
    public void verifyImpactClaimReportInTransferredBonus() throws InterruptedException, IOException {

       auditTrailReport_2627 repo = new auditTrailReport_2627(alcDriver);
       repo.run("https://qa-admin.cognitionfoundry.io/#/admin/ordersoffsets/offset/"+Data.bonus2Id2627,"200");
    }
    @Test(priority = 5,description =" Verify The Transaction not present in Audit Trail Report of Master Bonus")
    public void verifyImpactClaimReportInBonusTransferring() throws InterruptedException, IOException {

        auditTrailReport_2627 repo = new auditTrailReport_2627(alcDriver);
        repo.run("https://qa-admin.cognitionfoundry.io/#/admin/ordersoffsets/offset/"+Data.bonus1Id2627,"50");
    }


}
