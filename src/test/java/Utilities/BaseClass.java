package Utilities;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.qameta.allure.Allure;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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

import javax.mail.Session;

@SuppressWarnings("deprecation")
public class BaseClass {
		

public static String password ="123456a"; 


	public String kgdelivered = "19";///////// 76 -19
	public String kgpromised = "50,000";
	public String kgpending = "19";//////////// 76-19-0
	public String total_bonus_M_B1 = "133";

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

	public void takescreenshotofandroid(String Scrnsht_message) throws InterruptedException {
		TakesScreenshot ts1 = (TakesScreenshot) pbDriver; byte[] screenshot1 =
				ts1.getScreenshotAs(OutputType.BYTES); Allure.addAttachment(Scrnsht_message,
				new ByteArrayInputStream(screenshot1)); Thread.sleep(2000); }

	public void takescreenshotof(WebElement element, String Scrnsht_message) throws InterruptedException {
		Actions action = new Actions(alcDriver);
		action.moveToElement(element).build().perform();
		TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
		byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
		Allure.addAttachment(Scrnsht_message, new ByteArrayInputStream(screenshot1));
		Thread.sleep(2000);
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


	public boolean validateElementsAgainstCSV(List<String> elements, BufferedReader br) {
		Set<String> csvElements = new HashSet<>();

		// Read the CSV file and populate the set
		try {
			String line;
			while ((line = br.readLine()) != null) {
				// Assuming CSV file is simple and each line contains a single value
				csvElements.add(line.trim());
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;  // In case of an error, return false
		}

		// Validate elements
		for (String element : elements) {
			if (!csvElements.contains(element)) {
				return false;  // If any element is not found in the CSV, return false
			}
		}

		return true;  // All elements are found in the CSV, return true

	}
	public void csvValidate(List<String> elementsToValidate, BufferedReader br){

		try {
			boolean result = validateElementsAgainstCSV(elementsToValidate, br);

			System.out.println("Validation Result: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}


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
