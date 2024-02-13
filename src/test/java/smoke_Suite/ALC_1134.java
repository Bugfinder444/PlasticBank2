package smoke_Suite;

import Utilities.BaseClass;
import Utilities.Data;
import Utilities.auditTrailReport_1134;
import alchemy_Pages.AlchemyLoginPage;
import alchemy_Pages.Bonus;
import alchemy_Pages.Orders;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import java.io.IOException;


public class ALC_1134 extends BaseClass {

    public static String bonusName1134="Gayas"+ RandomStringUtils.randomAlphabetic(5);

    @Test(priority = 0, description = "Create data and do Transactions")
    public void createDataAndPerformTransaction1() throws IOException {

        Data d = new Data();
        d.runNewman_ALC_1134_1();

    }

    @Test(priority=1,description = "Transfer Transactions of a Bonus Order | Verify transaction Verified in Summary Tab and Bonus Approval Before and  after Transfer of Transaction in Master Bonus Order")
    public void transferBonusOrder() throws InterruptedException, IOException {

        AlchemyLoginPage login=new AlchemyLoginPage(alcDriver);
        login.alc_adminlogin(adminphoneNumber,adminpassword);

        Bonus b1 = new Bonus(alcDriver);
        b1.bonusTransfer(Data.bonus1Id1134,Data.bonus2Name1134,Data.processor1_Name1134);

    }

    @Test(priority=2,description = "Verifying Transactions Transfered are Present in Transferred Bonus ")
    public void verifyTransferdBonusOrder() throws InterruptedException, IOException {

        Bonus b2 = new Bonus(alcDriver);
        b2.bonusTransferVerify(Data.bonus2Id1134);

    }
    @Test(priority=3,description = "Verify the transactions Transfered are present in Branch Exchange History with Bonus Name Transfered visible")
    public void verifyBranchBonusTransfer() throws InterruptedException, IOException {

        Bonus b3 = new Bonus(alcDriver);
        b3.branchExchangeBonusTransfer(Data.branch1Id_1134,2,Data.bonus2Name1134);
        b3.branchExchangeBonusTransfer(Data.branch2Id_1134,2,Data.bonus2Name1134);

    }
    @Test(priority=4,description = "Verify the transactions Transfered are present in Processor Exchange History with Bonus Name Transfered visible ")
    public void verifyProcessorBonusTransfer() throws InterruptedException, IOException {

        Bonus b4 = new Bonus(alcDriver);
        b4.processorExchangeBonusTransfer(Data.p1id1134,2,Data.bonus2Name1134);
        b4.processorExchangeBonusTransfer(Data.p2id1134,2,Data.bonus1Name1134);

    }

    @Test(priority=5,description = "Verify The Transaction Transfered in Audit Trail Report ")
    public void verifyImpactClaimReport() throws InterruptedException, IOException {


        auditTrailReport_1134 ar = new auditTrailReport_1134(alcDriver);
        ar.run();

    }


    @Test(priority=6,description = "Perforn Another 4 set of Transactions")
    public void createDataAndPerformTransaction2() throws InterruptedException, IOException {

        Data d = new Data();
        d.runNewman_ALC_1134_2();

    }

    @Test(priority=7,description = "Verify the Transactions Transfered are present in Bonus Order Summary and Bonus Approval Section")
    public void transferBonusOrder2() throws InterruptedException, IOException {


        Bonus b5 = new Bonus(alcDriver);
        b5.bonusTransfer2(Data.bonusId1134_2,Data.processor_Name1134_2);
        b5.bonusTransferVerify2();

    }

}
