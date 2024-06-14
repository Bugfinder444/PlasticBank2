package alchemy_Pages;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

import Utilities.ColumnVerify;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BaseClass;
import org.testng.Assert;

import static Utilities.FileDownload.latestFile;


public class Dashboard extends BaseClass{


	public Dashboard(WebDriver alcDriver){

		PageFactory.initElements(alcDriver, this);

    }

	 @FindBy(xpath = "//div[text()=' Dashboard ']")
	 public static WebElement dashBoard_tab;
	 @FindBy(xpath = "//div[text()='KG by Country']/following::span[@class='total-price']")
	 public static WebElement kgByCountry;
	 @FindBy(xpath = "//div[text()='Tokens by Country in USD']/following::span[@class='total-price']")
	 private WebElement tokensByCountry;
	 @FindBy(xpath = "//div[text()='Tokens by Country in USD']/following::span[@class='total-price'][1]")
	 private WebElement activeLocations;
	 @FindBy(xpath = "//div[text()='Members by Country']/following::span[@class='total-price'][1]")
	 private WebElement membersByCountry;
	 @FindBy(xpath = "(//div[text()=' Philippines '])[4]/following::div")
	 public static WebElement kgByPhilippines;
	 @FindBy(xpath = "//div[text()='Monthly Snapshot']")
	 public static WebElement monthlySnapshot;
	 @FindBy(xpath = "//div[text()='Monthly Snapshot']/following-sibling::div[text()=' EXPORT ']")
	 public static WebElement monthlySnapshotExport;
	 @FindBy(xpath = "//div[@class=\"loader circle-loader\"]")
	 public static WebElement loader;

	@FindBy(xpath = "//div[@title='Menu']")
	public static WebElement menuBarKgCollected;
	@FindBy(xpath = "//div[@title=\"Download CSV\"]")
	public static WebElement downloadCsv;


	public static int kgByCountryValue;
	public static int kgByPhilippinesValue;
	public static List<Integer> result = new ArrayList<>();
	public static String downloadPath = "C:/Users/Fleek/Downloads";
	public static String fileNameContainsMonSnap="PB_MonthlySnapshot_";
	public static String fileNameKgCollected="1v";


	WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));

	 public static void clickDashBoard() {
		 	WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(50));
		    wait.until(ExpectedConditions.elementToBeClickable(dashBoard_tab));
		    dashBoard_tab.click();
	 }
	public static List<Integer> checkKgByCountry() throws InterruptedException {

		 WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(50));
		 	clickDashBoard();
			 Thread.sleep(4000);
		Actions action =new Actions(alcDriver);
		action.scrollToElement(kgByCountry).build().perform();
		    wait.until(ExpectedConditions.visibilityOf(kgByCountry));
			Thread.sleep(3000);
		    String kgCountry = kgByCountry.getText();
		Thread.sleep(2000);
		TakesScreenshot ts11111 = (TakesScreenshot) alcDriver;
		byte[] screenshotsell1 = ts11111.getScreenshotAs(OutputType.BYTES);
		Allure.addAttachment("kgByCountry Screenshot", new ByteArrayInputStream(screenshotsell1));
		Thread.sleep(2000);

		action.scrollToElement(kgByPhilippines).build().perform();
		wait.until(ExpectedConditions.visibilityOf(kgByPhilippines));
		String kgPhilippines=kgByPhilippines.getText();
		Thread.sleep(2000);
		TakesScreenshot ts1111 = (TakesScreenshot) alcDriver;
		byte[] kgPhilippinesSC = ts1111.getScreenshotAs(OutputType.BYTES);
		Allure.addAttachment("kgPhilippines Screenshot", new ByteArrayInputStream(kgPhilippinesSC));
		Thread.sleep(2000);

		 String stringWithoutCommas = kgCountry.replace(",", "");
		 String stringWithoutCommasSpace = kgPhilippines.replace(",", "").replace(" ","");
		Thread.sleep(3000);
		//List<Integer> result = new ArrayList<>();

			 kgByCountryValue = Integer.parseInt(stringWithoutCommas);
			 System.out.println("!!!!"+kgByCountryValue);
			 kgByPhilippinesValue = Integer.parseInt(stringWithoutCommasSpace);
			 System.out.println("!!!!"+kgByPhilippinesValue);
		Thread.sleep(1000);
			 result.add(kgByCountryValue);
			 result.add(kgByPhilippinesValue);

		 	return result;

	 }
	public static void deleteFile() {
		File directory = new File(downloadPath);

		// List all files in the directory
		File[] files = directory.listFiles();

		if (files != null) {
				// Check if the file name contains the specified string
					// Delete the file
					File latestFile = files[0];
					boolean isDeleted = latestFile.delete();
					if (isDeleted) {
						System.out.println("File deleted: " + latestFile.getName());
					} else {
						System.out.println("Failed to delete file: " + latestFile.getName());
					}
		} else {
			System.out.println("No files found in the directory.");
		}

	}
	public void monthlySnapshotDownload() throws InterruptedException {

		String[] arr={"Month","Year","Total New Members","Total Active Members","Total KG Recycled","Total Value Received By Members(in USD$)","Active Branches","Bonus Delivered","Pending Bonus","Paid Bonus $","Paid Bonus KG"};

		WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(180));

		wait.until(ExpectedConditions.elementToBeClickable(dashBoard_tab));
		dashBoard_tab.click();

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(monthlySnapshot));
		Actions action =new Actions(alcDriver);
		action.scrollToElement(monthlySnapshot).build().perform();

		Thread.sleep(2000);
		wait.until(ExpectedConditions.invisibilityOf(loader));
		monthlySnapshotExport.click();
		Thread.sleep(4000);

		while (true) {
			String downloadPath1 = "C:\\Users\\Fleek\\Downloads";
			File directory1 = new File(downloadPath1);
			File[] files1 = directory1.listFiles((dir, name) -> name.contains(fileNameContainsMonSnap));

			if (files1 != null && files1.length > 0) {

				Assert.assertTrue(1>0);
				System.out.println("File is been Downloaded");
				// Open the first file that matches the criteria
				// openFile(files1[0]);
				//isNamePresent(files1[0],searchName);
				break; // Exit the loop once a file is found and opened
			}

			try {
				TimeUnit.SECONDS.sleep(1); // Wait for 1 second before checking again
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		ColumnVerify c= new ColumnVerify();
		c.verifyColumn(arr,fileNameContainsMonSnap);
		//deleteFile();

	}
	public void kgCollectedReport() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(180));

		wait.until(ExpectedConditions.elementToBeClickable(dashBoard_tab));
		dashBoard_tab.click();

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(menuBarKgCollected));
		Actions action =new Actions(alcDriver);

		Thread.sleep(2000);
		//action.moveToElement(menuBarKgCollected).click().build().perform();
		menuBarKgCollected.click();

		Thread.sleep(4000);

		downloadCsv.click();


			String downloadPath1 = "C:\\Users\\Fleek\\Downloads";
			File directory1 = new File(downloadPath1);

			Set<String> initialFiles = new HashSet<>();
			for (File file : directory1.listFiles()) {
				initialFiles.add(file.getName());
			}

		boolean newFileDownloaded = false;

		while (!newFileDownloaded) {
			File[] currentFiles = directory1.listFiles();

			if (currentFiles != null) {
				for (File file : currentFiles) {
					if (!initialFiles.contains(file.getName())) {
						Assert.assertTrue(true); // File is downloaded
						System.out.println("A new file has been downloaded: " + file.getName());

						// Open the new file if needed
						// openFile(file);
						// isNamePresent(file, searchName);

						newFileDownloaded = true; // Set the flag to true to break the loop
						break;
					}
				}
			}


			try {
				TimeUnit.SECONDS.sleep(1); // Wait for 1 second before checking again
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}


}
