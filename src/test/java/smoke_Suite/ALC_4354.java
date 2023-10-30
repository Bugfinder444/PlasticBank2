package smoke_Suite;

import Utilities.ScreenshotListener;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utilities.BaseClass;
import alchemy_Pages.AlchemyLoginPage;
import alchemy_Pages.Processors;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.testng.AllureTestNg;
import plastic_Bank_Pages.PB_LoginPage;
import plastic_Bank_Pages.PB_Register_Processor;

@Listeners({AllureTestNg.class, ScreenshotListener.class})
public class ALC_4354 extends BaseClass {

	@Test(priority =0, description = "New Processor account should be successfully created")
	@Description("Create Processor with already Created Branch")
	public void createProcessor() throws InterruptedException {

		System.out.println("Create Processor with already Created Branch");
		PB_LoginPage l=new PB_LoginPage(pbDriver);
		l.permission();
		l.loginRandom(password);
		PB_Register_Processor cbp =new PB_Register_Processor(pbDriver);
		cbp.createProcessor();
	}
	@Test(priority =1, description = "New processor account is searchable in Alchemy under the 'Processor' section | -Changes are saved and can be seen in user details")
	@Description("Search and Edit Processor In Alchmey")
	public void seacrchAndEditProcessorInAlchmey() throws InterruptedException {

		System.out.println("Search and Edit Processor In Alchmey");
		AlchemyLoginPage alp = new AlchemyLoginPage(alcDriver);
		alp.alc_adminlogin(adminphoneNumber, adminpassword);
		Processors apt = new Processors(alcDriver);
		System.out.println(phoneNumber);
		apt.SearchAndEditProcessorInAlchemy(phoneNumber);
	}
	@Test(priority =2, description = "User should see the updated data")
	@Description("Login In app and Verify")
	public void VerifyInApp() throws InterruptedException {

		System.out.println("Login In app and Verify");
		Thread.sleep(2000);
		PB_LoginPage l=new PB_LoginPage(pbDriver);
//	    l.menu();
		Thread.sleep(2000);
		l.logout();
		l.loginRandom(password);
		l.menu();
		Thread.sleep(2000);
	    TakesScreenshot ts1 = (TakesScreenshot) pbDriver;
	    byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
	    Allure.addAttachment("Screenshot1", new ByteArrayInputStream(screenshot1));
		Thread.sleep(4000);
	}

}
