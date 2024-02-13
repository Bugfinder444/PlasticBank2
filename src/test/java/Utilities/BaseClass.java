package Utilities;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.qameta.allure.Allure;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;

@SuppressWarnings("deprecation")
public class BaseClass {
		

public static String password ="123456a"; 

	public String memberBonus = "7";
	public String branchBonus = "2";

	public String hdpe_M_B1 = "10";
	public String pet_M_B1 = "9";
	public String kgdelivered = "19";///////// 76 -19
	public String kgpromised = "50,000";
	public String kgpending = "19";//////////// 76-19-0

	public String hdpe_B1_B2 = "8";
	public String pet_B1_B2 = "7";

	public String hdpe_B1_B3 = "6";
	public String pet_B1_B3 = "5";

	public String hdpe_B2_P = "4";
	public String pet_B2_P = "3";

	public String hdpe_B3_P = "1";
	public String pet_B3_P = "1";

	public String total_bonus_M_B1 = "133";
	public String hdpe_bonus_M_B1 = "70";
	public String pet_bonus_M_B1 = "63";
	public String hdpe_KG_M_B1 = "10";
	public String pet_KG_M_B1 = "9";

	public String total_bonus_B1_B2 = "30";
	public String hdpe_bonus_B1_B2 = "16";
	public String pet_bonus_B1_B2 = "14";
	public String hdpe_KG_B1_B2 = "8";
	public String pet_KG_B1_B2 = "7";

	public String total_bonus_B1_B3 = "8";
	public String hdpe_bonus_B1_B3 = "4";
	public String pet_bonus_B1_B3 = "4";
	public String hdpe_KG_B1_B3 = "6";
	public String pet_KG_B1_B3 = "5";

	public String total_bonus_B2_P = "14";
	public String hdpe_bonus_B2_P = "8";
	public String pet_bonus_B2_P = "6";
	public String hdpe_KG_B2_P = "4";
	public String pet_KG_B2_P = "3";

	public String total_bonus_B3_P = "4";
	public String hdpe_bonus_B3_P = "2";
	public String pet_bonus_B3_P = "2";
	public String hdpe_KG_B3_P = "1";
	public String pet_KG_B3_P = "1";

	public String alc_B1_ExngHisBonusVerify[] = { "8", "30", "133" };// B1-B3,B1-B2,M-B1
	public String alc_B2_ExngHisBonusVerify[] = { "14", "30" };// B2-P,B2-B1
	public String alc_B3_ExngHisBonusVerify[] = { "4", "8" };// B3-P,B3-B1
	public String alc_P_ExngHisBonusVerify[] = { "4", "14" };

	// HDPE Kg, PET Kg, Total Kg
	public String alc_M_B1_ExngHisKgVerify[] = { "10 KG", "9 KG", "19 KG" };
	public String alc_B1_B2_ExngHisKgVerify[] = { "8 KG", "7 KG", "15 KG" };
	public String alc_B1_B3_ExngHisKgVerify[] = { "6 KG", "5 KG", "11 KG" };
	public String alc_B2_P_ExngHisKgVerify[] = { "4 KG", "3 KG", "7 KG" };
	public String alc_B3_P_ExngHisKgVerify[] = { "1 KG", "1 KG", "2 KG" };

	public static WebDriver alcDriver;
	public static AndroidDriver pbDriver;

	
	  protected static String randomPhoneNumber;
	  protected static String randomBusinessName; 
	  protected static String randomBranchMemberPhoneNumber;
	  protected static String randomBranchMemberName;
	  
	  protected static String randomLastName;
	  
	 
	public String memberName;
	public String branchmemberName;
	public String phoneNumber;
	public String branchMemberphoneNumber;
	public String adminphoneNumber;
	public String adminpassword;
	public String branchName;
	
	public static String temp= "upgrade-admin.cognitionfoundry.io";
	public static String actual = "qa-admin.cognitionfoundry.io";

	//@SuppressWarnings("deprecation")
	@BeforeClass

	public void setup() throws IOException {

//		WebDriverManager.chromedriver().setup();
		alcDriver = new ChromeDriver();
		alcDriver.manage().window().maximize();
		alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		try {
			//alcDriver.get("https://staging-admin.plasticbank.com/#/login");
			alcDriver.get("https://qa-admin.cognitionfoundry.io/#/login");
		} catch (org.openqa.selenium.TimeoutException e) {
			// Handle the timeout exception here
			System.out.println("Navigation timed out. Retrying...");
			alcDriver.navigate().refresh();
		}
		
		
		//alcDriver.get("https://qa-admin.cognitionfoundry.io/#/login");
		//https://qa-admin.cognitionfoundry.io/#/login
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		caps.setCapability("newCommandTimeout", 9000);
		caps.setCapability("appPackage", "org.plasticbank.app");
		caps.setCapability("appActivity", "org.plasticbank.app.MainActivity");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		pbDriver = new AndroidDriver(url, caps);
		
		
		  memberName = "Gayas"; 
		  branchmemberName = "Gayas " + randomBranchMemberName;
		  password= "123456a"; 
		  phoneNumber = "+63" + randomPhoneNumber;
		  branchMemberphoneNumber = "+63" + randomBranchMemberPhoneNumber;
		  
		  adminphoneNumber = "+919560071590"; 
		  adminpassword = "123456a"; 
		  branchName = randomBusinessName;
		 
	}

	public static int stringToInt(String input){

		// Define a regular expression pattern to match the number
		Pattern pattern = Pattern.compile("\\d+");

		// Create a matcher that matches the pattern to the input string
		Matcher matcher = pattern.matcher(input);

		// Find the first occurrence of the pattern in the input
		if (matcher.find()) {
			// Extract and parse the matched number
			String matchedNumber = matcher.group();
			return Integer.parseInt(matchedNumber);
		}

		// Return a default value or handle the case where no number is found
		return 0; // Default value (you can change this to suit your needs)
	}
	public static int convertStringToInteger(String input) {
		// Remove non-numeric characters and commas
		String numericString = input.replaceAll("[^0-9]", "");

		// Parse the remaining string as an integer
		int convertedValue = Integer.parseInt(numericString);

		return convertedValue;
	}

	public void tap(int x, int y) throws InterruptedException {
		Thread.sleep(4000);
		PointerInput fingert = new PointerInput(PointerInput.Kind.TOUCH, "fingert");
		  Sequence scrollt = new Sequence(fingert, 1);
		  scrollt.addAction(fingert.createPointerMove(Duration.ofMillis(0),
		      PointerInput.Origin.viewport(), x, y));
		  scrollt.addAction(fingert.createPointerDown(0));
		  scrollt.addAction(fingert.createPointerMove(Duration.ofMillis(100),
		      PointerInput.Origin.viewport(), x, y));
		  scrollt.addAction(fingert.createPointerUp(0));
		  pbDriver.perform(Arrays.asList(scrollt));
	}
	
	  @BeforeSuite 
	  public void generateRandomNumber() { 
		  randomPhoneNumber =RandomStringUtils.randomNumeric(8); 
		  System.out.println("Member Number :+63" +randomPhoneNumber); }
	  
	  protected String getRandomPhoneNumber() {
		  
		  return randomPhoneNumber;
		  }
	  
	  @BeforeSuite 
	 
	
	  public void generateRandomLastName() {
		  
	  randomLastName = RandomStringUtils.randomAlphabetic(5);
	  System.out.println("Member Name : Gayas " + randomLastName); }
	  
	  protected String getRandomLastName() {
		  return randomLastName; 
		  }
	  
	  @BeforeSuite 
	  public void generateBranchMemberName() {
	  randomBranchMemberName = "Gayas " + RandomStringUtils.randomAlphabetic(5);
	  System.out.println("Branch Member Name :" + randomBranchMemberName);
	  }
	  
	  protected String getBranchMemberNumber() { 
	
		  return randomBranchMemberName; 
		  }
	  
	  @BeforeSuite public void generateRandomBranchMemberNumber() {
	  randomBranchMemberPhoneNumber = RandomStringUtils.randomNumeric(8);
	  System.out.println("Branch Member Number : +63" +
	  randomBranchMemberPhoneNumber); }
	  
	  protected String getRandomBranchMemberNumber() { 
		  return randomBranchMemberPhoneNumber; }
	  
	  @BeforeSuite 
	  public void generateBranchName() { 
		  randomBusinessName = "Gayas "+ RandomStringUtils.randomAlphabetic(5); 
		  System.out.println("Branch Name :" +randomBusinessName);
		  }
	  
	  protected String getBranchName() { 
		  return randomBusinessName; 
		  }

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			TakesScreenshot ts = (TakesScreenshot) alcDriver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));
			TakesScreenshot pb_ts = (TakesScreenshot)pbDriver;
			byte[] screenshot_pb = pb_ts.getScreenshotAs(OutputType.BYTES);
			Allure.addAttachment("Screenshot_pb", new ByteArrayInputStream(screenshot_pb));
		}
	}
	@AfterClass
	public void teardown() {

		try {
			pbDriver.quit();
			alcDriver.quit();
		}
		catch (NoSuchSessionException e){
			System.out.print("No such session exception call"+e.getMessage());
		}

	}


}
