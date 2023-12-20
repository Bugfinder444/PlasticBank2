package Utilities;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.*;
import java.time.Duration;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

public class FileDownload extends BaseClass {

    @FindBy(xpath = "//span[text()=' Audit Trail Report ']")
    public static WebElement auditTrailDownloadLink;
    @FindBy(xpath = "//div[text()='Audit Trail ']")
    public static WebElement auditTrailTag;

    @FindBy(xpath = "//div[@class='card-header']")
    public static WebElement pccardheader;

    public static String url = "https://qa-admin.cognitionfoundry.io/#/admin/ordersoffsets/order/bee4d7b6-71e9-488e-8c91-ca3c96ee62e3";
    // public static String fileName;
    public String searchName = "process_Tyxs7Unq";
    public static String downloadPath = "C:/Users/Fleek/Downloads";
    public static String fileDownloaded;
    public static File latestFile;
    public static String fileNameContains="order-transactions_export";


    public FileDownload(WebDriver alcDriver) {

        PageFactory.initElements(alcDriver, this);
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
    public static File getLatestFile(String downloadPath, String fileNameContains) {

        File dir = new File(downloadPath);
        File[] files = dir.listFiles((dir1, name) -> name.contains(fileNameContains));

        if (files != null && files.length > 0) {
            Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
            return files[0];
        }

        return null;
    }
    public static void downloadFile(String url) throws InterruptedException {


        File file = new File(downloadPath);
        alcDriver.get(url);

        FluentWait<File> wait = new FluentWait<File>(file)
                .withTimeout(Duration.ofMinutes(2))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(Exception.class)
                .withMessage("File not Downloaded");


        WebDriverWait wait1 = new WebDriverWait(alcDriver, Duration.ofSeconds(120));

        wait1.until(ExpectedConditions.elementToBeClickable(auditTrailTag));
        auditTrailTag.click();
        Thread.sleep(10000);
        wait1.until(ExpectedConditions.elementToBeClickable(auditTrailDownloadLink));
        auditTrailDownloadLink.click();
        Thread.sleep(40000);


        try {

            boolean isDownloaded = wait.until(latestFile -> latestFile.exists() && latestFile.canRead());
            if (isDownloaded) {
                System.out.println("file is Downloading...");

            }
        }catch(NullPointerException e){


            alcDriver.navigate().refresh();
            wait1.until(ExpectedConditions.elementToBeClickable(auditTrailTag));
            auditTrailTag.click();
            Thread.sleep(10000);
            wait1.until(ExpectedConditions.elementToBeClickable(auditTrailDownloadLink));
            auditTrailDownloadLink.click();
            Thread.sleep(40000);
            boolean isDownloaded = wait.until(f -> f.exists() && f.canRead());
            if (isDownloaded) {
                System.out.println("file is Downloading...");

            }

        }catch(TimeoutException e) {
            System.out.println("file is not downloaded ");

        }
   }



    public void testDownloadAndSearch() throws InterruptedException {

        downloadFile(url);

        try {
            WebDriverWait fileWait = new WebDriverWait(alcDriver, Duration.ofMinutes(2));
            File latestFile = getLatestFile(downloadPath, fileNameContains);

            fileWait.until(alcDriver -> latestFile.exists() && latestFile.canRead());

            System.out.println("File is downloaded: " + latestFile.getName());

            isNamePresent(latestFile, searchName);


        } catch (TimeoutException e) {

            System.out.println("File is not downloaded within the specified time");
        }finally {

            if (latestFile != null && latestFile.exists()) {
                    latestFile.delete();
                    System.out.println("File deleted successfully");
                } else {
                    System.out.println("Failed to delete the file");
                }
            }
        }
    }