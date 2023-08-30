package smoke_Suite;

import Utilities.BaseClass;
import Utilities.ScreenshotListener;
import alchemy_Pages.AlchemyLoginPage;
import alchemy_Pages.Orders;
import io.qameta.allure.Description;
import io.qameta.allure.testng.AllureTestNg;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import plastic_Bank_Pages.PB_LoginPage;
import plastic_Bank_Pages.PB_Transaction;

//ALC-4350 = In App, Member - Create , new user login, edit, check in Alchemy to confirm new user exists , suspend account

@Listeners({AllureTestNg.class, ScreenshotListener.class})
public class ALC_4365 extends BaseClass {
    String branchPhoneNumber = "+639822222222";
    String phoneNumber = "+639811111111";
    String password = "123456a";


	@Test(priority=0, description = "Bonus order should be  stopped")
    @Description("Login on alchemy and create new bonus")
    public void createNewBonusAndSuspendedBonus() throws InterruptedException {
        AlchemyLoginPage loginAlchmey=new AlchemyLoginPage(alcDriver);
        loginAlchmey.alc_adminlogin(adminphoneNumber,adminpassword);
		PB_LoginPage pblogin = new PB_LoginPage(pbDriver);
		pblogin.permission();
		Orders alc_orders = new Orders(alcDriver);
        alc_orders.createBonus("Fleek_Bonus_22_1", "plastic", "10000", "7", "2", "778899", "seventhaugb1");
        alc_orders.changeBranchBonusDetails();
        alc_orders.checkOrderStopped("Fleek_Bonus_22_1");
    }


	@Test(priority=1, description = "New member transaction with the branch in the stopped bonus order DOES NOT generate bonus once the Bonus order is stopped")
	@Description("Signing up a member and Login Verification and Logout")
	public void verifyTransactionStoppedBonus()throws InterruptedException {
		PB_LoginPage pblogin = new PB_LoginPage(pbDriver);
		PB_Transaction pbTransaction = new PB_Transaction(pbDriver);
//		pblogin.permission();
		pblogin.login(branchPhoneNumber,password);
		Thread.sleep(5000);
		boolean bounus_text = pbTransaction.transactionBranchStopBonus(phoneNumber,"6");
		Assert.assertFalse(bounus_text);
		boolean reward_text=pbTransaction.verifyHistoryStopBonusReward();
		Assert.assertFalse(reward_text);

	}


}
