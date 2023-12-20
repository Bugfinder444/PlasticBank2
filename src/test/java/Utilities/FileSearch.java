package Utilities;

import io.qameta.allure.Allure;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FileSearch extends BaseClass {

    @FindBy(xpath = "//span[text()=' Audit Trail Report ']")
    public static WebElement auditTrailDownloadLink;
    @FindBy(xpath = "//div[text()='Audit Trail ']")
    public static WebElement auditTrailTag;
    @FindBy(xpath = "//span[text()=' Loading... ']")
    public static WebElement loading;

    public static String url = "https://qa-admin.cognitionfoundry.io/#/admin/ordersoffsets/order/bee4d7b6-71e9-488e-8c91-ca3c96ee62e3";
    // public static String fileName;
    public static String searchName = Data.processor_Name666;
    public static String downloadPath = "C:/Users/Fleek/Downloads";

    public static String fileNameContains="order-transactions_export";

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

    public static void findAndOpenSearch() {

        while (true) {
            String downloadPath1 = "C:\\Users\\Fleek\\Downloads";
            File directory1 = new File(downloadPath1);
            File[] files1 = directory1.listFiles((dir, name) -> name.contains(fileNameContains));

            if (files1 != null && files1.length > 0) {
                // Open the first file that matches the criteria
               // openFile(files1[0]);
                isNamePresent(files1[0],searchName);
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
                            Allure.addAttachment(" processor that is doing Transaction: "+Data.processor_Name666+ "  || Processor found in Report : | ","Found '" + searchString + "' in Excel at Row: " + (row.getRowNum() + 1) + ", Column: " + (cell.getColumnIndex() + 1));
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
        public void run() throws InterruptedException {

        downloadFile(url);
        findAndOpenSearch();
        deleteFile();

    }
}
