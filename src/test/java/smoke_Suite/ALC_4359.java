package smoke_Suite;

import Utilities.BaseClass;
import Utilities.Data;
import Utilities.ScreenshotListener;
import alchemy_Pages.AlchemyLoginPage;
import alchemy_Pages.Members;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import plastic_Bank_Pages.PB_LoginPage;
import plastic_Bank_Pages.PB_Transaction;

import java.io.IOException;
@Listeners({AllureTestNg.class, ScreenshotListener.class})
public class ALC_4359 extends BaseClass {

    @Test(priority = 0, description = "Create a branch, adding a branch and processor in branch through endpoint")
    public void dataCreation() throws IOException {
        Data dt = new Data();
        dt.runNewman_1Branch();
    }

    @Test(priority = 1, description = "Use and existing member and Uncheck bonus eligibility in the member profile")
    public void editMemberUncheckBonus() throws InterruptedException {
        AlchemyLoginPage loginAlchmey=new AlchemyLoginPage(alcDriver);
        loginAlchmey.alc_adminlogin(adminphoneNumber,adminpassword);
        Members mb = new Members(alcDriver);
        mb.editMemberUncheckBonus(Data.member_Number4359);
    }

    @Test(priority = 3, description = "Notice that no bonus is generated in the entire transaction | Branch exchange history should show System Offset under Associated Bonus")
    public void verifyBonusPlasticBankWithBranch() throws InterruptedException {
        PB_LoginPage pblogin = new PB_LoginPage(pbDriver);
        PB_Transaction pbTransaction = new PB_Transaction(pbDriver);
        pblogin.permission();
        pblogin.login(Data.branch1_Number4359,password);
        Thread.sleep(5000);
        boolean bounus_text = pbTransaction.transactionBranchStopBonus4359(Data.member_Number4359,"6");
        Assert.assertTrue(bounus_text);
        boolean reward_text=pbTransaction.verifyHistoryStopBonusReward4359();
        Assert.assertFalse(reward_text);
        pbTransaction.logout();
    }
    @Test(priority = 4, description = "Processor exchange history should show System Offset under Associated Bonus")
    public void verifyBonusPlasticBankWithProcessor() throws InterruptedException {
        PB_LoginPage pblogin = new PB_LoginPage(pbDriver);
        PB_Transaction pbTransaction = new PB_Transaction(pbDriver);
        pblogin.login(Data.processor_Number4359,password);
        pbTransaction.clickProcessor();
        Thread.sleep(5000);
        boolean bounus_text = pbTransaction.transactionBranchStopBonus(Data.branch1_Number4359,"6");
        Assert.assertFalse(bounus_text);
        boolean reward_text=pbTransaction.verifyStopBonusProcessor4359();
        Assert.assertTrue(reward_text);
        pblogin.logout();
    }
}
