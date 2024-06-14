package Utilities;

import alchemy_Pages.AlchemyLoginPage;
import alchemy_Pages.Benefits;
import alchemy_Pages.Client_Dashboards;
import io.qameta.allure.Allure;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class FileSearch extends BaseClass {

    @FindBy(xpath = "//span[text()=' Audit Trail Report ']")
    public static WebElement auditTrailDownloadLink;
    @FindBy(xpath = "//div[text()='Audit Trail ']")
    public static WebElement auditTrailTag;
    @FindBy(xpath = "//span[text()=' Loading... ']")
    public static WebElement loading;
    @FindBy(xpath = "//div[@class='bottom-navbar']/descendant::div[@class='navbar-item'][4]")
    public WebElement auditTrailTab;
    @FindBy(xpath = "//button[normalize-space()='Social Benefits']")
    public WebElement socialBenefitTab;
    @FindBy(xpath = "//button[normalize-space()='Export Data']")
    public WebElement exportDataButton;
    @FindBy(xpath = "//div[@class=\"loader circle-loader\"]")
    public WebElement loader;

    @FindBy(xpath = "(//div[@class='tbody-text'])[9]")
    public WebElement benefit1InTable;
    @FindBy(xpath = "(//div[@class=\"body-data\"])[1]/div/div")
    public WebElement benefit2InTable;


    public static String url = "https://qa-admin.cognitionfoundry.io/#/admin/ordersoffsets/order/bee4d7b6-71e9-488e-8c91-ca3c96ee62e3";
    // public static String fileName;
    public static String searchName = Data.processor_Name666;
    public static String downloadPath = "C:/Users/Fleek/Downloads";

    public static String fileNameContains="order-transactions_export";
    public static String fileNameContainsAT="SocialBenefitsAuditTrail";

    public FileSearch(WebDriver alcDriver) {

        PageFactory.initElements(alcDriver, this);
    }

    public static void downloadFile(String url) throws InterruptedException {


        File file = new File(downloadPath);
       // alcDriver.get(url);

        WebDriverWait wait1 = new WebDriverWait(alcDriver, Duration.ofSeconds(120));

        try{

          wait1.until(ExpectedConditions.elementToBeClickable(auditTrailTag));
        auditTrailTag.click();
        Thread.sleep(10000);
        wait1.until(ExpectedConditions.elementToBeClickable(auditTrailDownloadLink));
        auditTrailDownloadLink.click();
        Thread.sleep(1000);
        wait1.until(ExpectedConditions.invisibilityOf(loading));
        System.out.println("File is Downloaded ");
        // Thread.sleep(40000);


    }catch(NullPointerException e){


            alcDriver.navigate().refresh();
            wait1.until(ExpectedConditions.elementToBeClickable(auditTrailTag));
            auditTrailTag.click();
            Thread.sleep(10000);
            wait1.until(ExpectedConditions.elementToBeClickable(auditTrailDownloadLink));
            auditTrailDownloadLink.click();
            Thread.sleep(1000);
            wait1.until(ExpectedConditions.invisibilityOf(loading));
            // Thread.sleep(40000);
                System.out.println("file is Downloaded...");


        }catch(TimeoutException e) {
            System.out.println("file is not downloaded ");

        }
    }

    public static void findAndOpenSearch(String searchString) {

        while (true) {
            String downloadPath1 = "C:\\Users\\Fleek\\Downloads";
            File directory1 = new File(downloadPath1);
            File[] files1 = directory1.listFiles((dir, name) -> name.contains(fileNameContains));

            if (files1 != null && files1.length > 0) {
                // Open the first file that matches the criteria
               // openFile(files1[0]);
                isNamePresent(files1[0],searchString);
                break; // Exit the loop once a file is found and opened
            }

            try {
                TimeUnit.SECONDS.sleep(1); // Wait for 1 second before checking again
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void findAndOpenSearch2(String searchString,String searchString2) {

        while (true) {
            String downloadPath1 = "C:\\Users\\Fleek\\Downloads";
            File directory1 = new File(downloadPath1);
            File[] files1 = directory1.listFiles((dir, name) -> name.contains(fileNameContainsAT));

            if (files1 != null && files1.length > 0) {
                // Open the first file that matches the criteria
                // openFile(files1[0]);
                isNamePresent2(files1[0],searchString,searchString2);
                break; // Exit the loop once a file is found and opened
            }

            try {
                TimeUnit.SECONDS.sleep(1); // Wait for 1 second before checking again
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void openFile(File file) {
        try {
            // Check if the Desktop class is supported on the current platform
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
                Thread.sleep(4000);
                Desktop.getDesktop().moveToTrash(file);
            } else {
                System.out.println("Desktop is not supported on this platform.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void isNamePresent(File fileName, String searchString) {

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            Workbook workbook = new XSSFWorkbook(fileInputStream);

            // Assuming you are working with the first sheet. Change as needed.
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                for (Cell cell : row) {
                    if (cell.getCellType() == CellType.STRING) {
                        String cellValue = cell.getStringCellValue();
                        if (cellValue.contains(searchString)) {
                            System.out.println("Found '" + searchString + "' in Excel at Row: " + (row.getRowNum() + 1) + ", Column: " + (cell.getColumnIndex() + 1));
                            Allure.addAttachment(" Processor Present: "+ "  ","Found '" + searchString + "' in Excel at Row: " + (row.getRowNum() + 1) + ", Column: " + (cell.getColumnIndex() + 1));
                            break; // You can choose to continue searching or break when the first occurrence is found
                        }
                    }
                }
            }
            workbook.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void isNamePresent2(File fileName, String searchString1,String searchString2) {

        boolean searchString1Found = false;
        boolean searchString2Found = false;
        int searchString1Row = -1;
        int searchString1Column = -1;
        int searchString2Row = -1;
        int searchString2Column = -1;

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            Workbook workbook = new XSSFWorkbook(fileInputStream);

            // Assuming you are working with the first sheet. Change as needed.
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                for (Cell cell : row) {
                    if (cell.getCellType() == CellType.STRING) {
                        String cellValue = cell.getStringCellValue();
                        if (cellValue.contains(searchString1)) {
                            searchString1Found = true;
                            searchString1Row = row.getRowNum() + 1;
                            searchString1Column = cell.getColumnIndex() + 1;
                        }
                        if (cellValue.contains(searchString2)) {
                            searchString2Found = true;
                            searchString2Row = row.getRowNum() + 1;
                            searchString2Column = cell.getColumnIndex() + 1;
                        }
                        // If both search strings are found, you can exit early
                        if (searchString1Found && searchString2Found) {
                            System.out.println("Both '" + searchString1 + "' and '" + searchString2 + "' are found in Excel.");
                            System.out.println("'" + searchString1 + "' found at Row: " + searchString1Row + ", Column: " + searchString1Column);
                            System.out.println("'" + searchString2 + "' found at Row: " + searchString2Row + ", Column: " + searchString2Column);
                            workbook.close();
                            fileInputStream.close();
                            return;
                        }
                    }
                }
            }

            // After iterating through the sheet, determine which search string is present
            if (searchString1Found && !searchString2Found) {
                System.out.println("Found '" + searchString1 + "' in Excel at Row: " + searchString1Row + ", Column: " + searchString1Column + ", but did not find '" + searchString2 + "'.");
                Allure.addAttachment("Benefit Transaction Found::","Found " + searchString1 + "' in Excel at Row: " + searchString1Row + ", Column: " + searchString1Column + ", but did not find '" + searchString2 + "'.");

            } else if (!searchString1Found && searchString2Found) {
                System.out.println("Found '" + searchString2 + "' in Excel at Row: " + searchString2Row + ", Column: " + searchString2Column + ", but did not find '" + searchString1 + "'.");
                Allure.addAttachment("Benefit Transaction Found::","Found '" + searchString2 + "' in Excel at Row: " + searchString2Row + ", Column: " + searchString2Column + ", but did not find '" + searchString1 + "'.");
            } else {
                System.out.println("Neither '" + searchString1 + "' nor '" + searchString2 + "' are found in Excel.");
            }

            workbook.close();
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public static void deleteFile() {
            File directory = new File(downloadPath);

            // List all files in the directory
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    // Check if the file name contains the specified string
                    if (file.getName().contains(fileNameContains)) {
                        // Delete the file
                        boolean isDeleted = file.delete();
                        if (isDeleted) {
                            System.out.println("File deleted: " + file.getName());
                        } else {
                            System.out.println("Failed to delete file: " + file.getName());
                        }
                    }
                }
            } else {
                System.out.println("No files found in the directory.");
            }

        }
    public static void deleteFile2() {
        File directory = new File(downloadPath);

        // List all files in the directory
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                // Check if the file name contains the specified string
                if (file.getName().contains(fileNameContainsAT)) {
                    // Delete the file
                    boolean isDeleted = file.delete();
                    if (isDeleted) {
                        System.out.println("File deleted: " + file.getName());
                    } else {
                        System.out.println("Failed to delete file: " + file.getName());
                    }
                }
            }
        } else {
            System.out.println("No files found in the directory.");
        }

    }
        public void run(String searchString) throws InterruptedException {

        downloadFile(url);
        findAndOpenSearch(searchString);
        deleteFile();

    }
    public void downloadAuditTrailReport() throws InterruptedException {

        alcDriver.get("https://qa-impact.cognitionfoundry.io/"+ Client_Dashboards.dashBoardPath+"/dashboard/page/home");

        try {

            alcDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            AlchemyLoginPage login = new AlchemyLoginPage(alcDriver);
            login.alc_adminloginNoOtp("+919560071590", "123456a");
            alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
        catch(Exception e){

            alcDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println("Already Logged In");
            alcDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        }
        WebDriverWait wait = new WebDriverWait(alcDriver, Duration.ofSeconds(120));

        wait.until(ExpectedConditions.elementToBeClickable(auditTrailTab));
        auditTrailTab.click();
        wait.until(ExpectedConditions.invisibilityOf(loader));

        wait.until(ExpectedConditions.elementToBeClickable(socialBenefitTab));
        socialBenefitTab.click();
        wait.until(ExpectedConditions.invisibilityOf(loader));
        wait.until(ExpectedConditions.elementToBeClickable(exportDataButton));

        verifyAuditTrailTable();

        exportDataButton.click();

    }
    public void verifyAuditTrailTable() throws InterruptedException {

        String actualBenefit1=benefit1InTable.getText();
        String actualBenefit2=benefit2InTable.getText();

        Assert.assertEquals(actualBenefit2, Benefits.randomBenefitName2);
        Assert.assertNotEquals(actualBenefit1,Benefits.randomBenefitName);

        TakesScreenshot ts1 = (TakesScreenshot) alcDriver;
        byte[] screenshot1 = ts1.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Columns Present In Audit Trail", new ByteArrayInputStream(screenshot1));
        Thread.sleep(3000);

    }
    public void auditReport(String searchString1,String searchString2) throws InterruptedException {

        downloadAuditTrailReport();
        findAndOpenSearch2(searchString1,searchString2);
        deleteFile2();

    }
}
