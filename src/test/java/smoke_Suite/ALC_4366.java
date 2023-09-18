package smoke_Suite;

import Utilities.BaseClass;
import Utilities.Data;
import Utilities.ScreenshotListener;
import alchemy_Pages.AlchemyLoginPage;
import alchemy_Pages.Members;
import alchemy_Pages.Orders;
import io.qameta.allure.Description;
import io.qameta.allure.testng.AllureTestNg;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import plastic_Bank_Pages.PB_LoginPage;
import plastic_Bank_Pages.PB_Member_Profile;
import plastic_Bank_Pages.PB_Transaction;

@Listeners({AllureTestNg.class, ScreenshotListener.class})
public class ALC_4366 extends BaseClass {
    //String branchPhoneNumber = "+18430269167";
    String phoneNumber = Data.member_NumberMB;
    //String password66 = "password1";
    @Test(priority = 0, description = "Screen will display member's details page | Screen will display a prompt page to fill out to transfer the tokens | Transferring of token was complete Current member token will be added and displayed in the App Current member token will be added and displayed in the Alchemy under 'Tokens in wallet' column")
    @Description("Login on alchemy and create new bonus")
    public void tokenTransferAndVerifyInOrdersData() throws InterruptedException, IOException {
    	
    	Data d3= new Data();
		d3.createMemberBranch();
		
        AlchemyLoginPage loginAlchmey=new AlchemyLoginPage(alcDriver);
        loginAlchmey.alc_adminlogin(adminphoneNumber,adminpassword);
        Members alc_members = new Members(alcDriver);
        Orders alc_orders = new Orders(alcDriver);
        alc_members.tokenDirectTransfer(phoneNumber, "Direct Token Transfer", "1000","778899", "Transfer Completed");
        alc_orders.verifyOrdersTransferData("Ashish Rawat", "M1 Member", " EPR Rewards", "Token transfer", "1000");
    }
    @Test(priority = 1, description = "Transaction was recorded in transfers tab with all the correct data")
    @Description("Login on mobile app and verify token transfer in history")
    public void verifyTransferTokenOnApp()throws InterruptedException {

        System.out.println("Signing up a member and Login Verification and Logout");
        PB_LoginPage pblogin = new PB_LoginPage(pbDriver);
        PB_Member_Profile pbProfile = new PB_Member_Profile(pbDriver);
        PB_Transaction pbTransaction = new PB_Transaction(pbDriver);
        pblogin.permission();
        pblogin.login(phoneNumber,password);
        Thread.sleep(5000);
        boolean tokenValue =pbProfile.tokenValueProfile();
        Assert.assertTrue(tokenValue);
        boolean tokenText = pbTransaction.verifyExchangeHistoryToken();
        Assert.assertTrue(tokenText);


    }


}
