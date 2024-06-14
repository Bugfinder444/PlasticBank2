package alchemy_Pages;

import Utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Reports extends BaseClass {
    public Reports(WebDriver alcDriver){

        PageFactory.initElements(alcDriver, this);

    }


    @FindBy(xpath = "//div[text()=' Reports ']")
    public static WebElement reportsTab;
    @FindBy(xpath = "//div[@class=\"loader circle-loader\"]")
    public static WebElement loader;
    @FindBy(xpath = "//div[text()='Branch Report']")
    public static WebElement branchReport;
    @FindBy(xpath = "//div[text()='Branch Report']/following-sibling::div[text()=' EXPORT ']")
    public static WebElement branchReportExport;
    @FindBy(xpath = "//div[text()='Processor Report']")
    public static WebElement processorReport;
    @FindBy(xpath = "//div[text()='Processor Report']/following-sibling::div[text()=' EXPORT ']")
    public static WebElement processorReportExport;
    @FindBy(xpath = "//div[text()='Token Exchange History']")
    public static WebElement tokenExchangeHistory;
    @FindBy(xpath = "//div[text()='Token Exchange History']/following-sibling::div[text()=' EXPORT ']")
    public static WebElement tokenExchangeHistoryExport;

    @FindBy(xpath = "//div[text()='Branches Transaction History']")
    public static WebElement branchesTranHis;
    @FindBy(xpath = "//div[text()='Branches Transaction History']/following-sibling::div[text()=' EXPORT ']")
    public static WebElement branchesTranHisExport;
    @FindBy(xpath = "//div[text()='Loading... ']")
    public static WebElement loading;




    public static int kgByCountryValue;
    public static int kgByPhilippinesValue;
    public static List<Integer> result = new ArrayList<>();
    public static String downloadPath = "C:/Users/Fleek/Downloads";
    public static String fileNameContainsMonSnap="PB_MonthlySnapshot_";


    public void reportDownload(WebElement ele,WebElement export, String fileName) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(60));

        wait.until(ExpectedConditions.elementToBeClickable(reportsTab));
        reportsTab.click();

        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOf(ele));
        Actions action =new Actions(alcDriver);
        action.scrollToElement(ele).build().perform();

        Thread.sleep(2000);
        wait.until(ExpectedConditions.invisibilityOf(loader));
        export.click();
        Thread.sleep(10000);

        while (true) {
            String downloadPath1 = "C:\\Users\\Fleek\\Downloads";
            File directory1 = new File(downloadPath1);
            File[] files1 = directory1.listFiles((dir, name) -> name.contains(fileName));

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
//        File directory = new File(downloadPath);
//
//        // List all files in the directory
//        File[] files = directory.listFiles();
//
//        if (files != null) {
//            for (File file : files) {
//                // Check if the file name contains the specified string
//                if (file.getName().contains(fileName)) {
//                    // Delete the file
//                    boolean isDeleted = file.delete();
//                    if (isDeleted) {
//                        System.out.println("File deleted: " + file.getName());
//                    } else {
//                        System.out.println("Failed to delete file: " + file.getName());
//                    }
//                }
//            }
//        } else {
//            System.out.println("No files found in the directory.");
//        }
//
    }


}
