package smoke_Suite;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utilities.BaseClass;
import Utilities.Data;
import Utilities.ScreenshotListener;
import alchemy_Pages.AlchemyLoginPage;
import alchemy_Pages.Members;
import alchemy_Pages.Stores;
import io.qameta.allure.Description;
import io.qameta.allure.testng.AllureTestNg;
import plastic_Bank_Pages.PB_Register_Store;

@Listeners({AllureTestNg.class, ScreenshotListener.class})

public class ALC_380 extends BaseClass {
	
	@Test(priority=1, description = "Create 2 members one for cash out and second for store also Create a Store")
	@Description("Create 2 members one for cash out and second for store also Create a Store")
	public void create_Store() throws InterruptedException, IOException {
		
		PB_Register_Store store =new PB_Register_Store(pbDriver);
		Data pn =new Data();
		pn.runNewman_ALC380();
		store.createStore380();
		
		
	}
	
	@Test(priority=2, description = "Login on alchemy and edit details like | Turn On tokenActiveToggle Check canSeeTokenInWallet | Set level To PlasticBankOperated")
	@Description("Login on alchemy and edit details like | Turn On tokenActiveToggle Check canSeeTokenInWallet | Set level To PlasticBankOperated")
	public void editDetailsInAlchmey() throws InterruptedException {

		
		AlchemyLoginPage loginAlchmey=new AlchemyLoginPage(alcDriver);
		loginAlchmey.alc_adminlogin(adminphoneNumber,adminpassword);
		Stores st= new Stores(alcDriver);
		st.editStore_ALC_380(PB_Register_Store.store_name380);
		
	}
	
	@Test(priority=3, description = "Perform CashOut Transaction with a Member already having enough Cash")
	@Description("Perform CashOut Transaction with a Member already having enough Cash")
	public void cashOutTest() throws InterruptedException {
		
		PB_Register_Store storeCO = new PB_Register_Store(pbDriver);
		storeCO.cashoutStore();
	}

	@Test(priority=4, description = "Verify the Tokens deducted in App")
	@Description("Verify the Tokens deducted in App")
	public void verifyInApp() throws InterruptedException {
		PB_Register_Store storeValue = new PB_Register_Store(pbDriver);
		storeValue.compareValueInApp();
	}
	
	@Test(priority=5, description = "Verify the Tokens deducted in Alchemy")
	@Description("Verify the Tokens deducted in Alchemy")
	public void verifyInAlchemy() throws InterruptedException {
		
		Members m1 = new Members(alcDriver);
		Stores s1 =new Stores(alcDriver);
		m1.clickMembersTab();
		m1.searchAddedMemberByPhone380(Data.member1_Number380);
		m1.clickSpecificMember();
		s1.verifyTokenInAlchemy();
		
	}
	
	
}
