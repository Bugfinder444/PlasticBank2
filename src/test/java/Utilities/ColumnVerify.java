package Utilities;

import io.qameta.allure.Allure;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ColumnVerify extends BaseClass{

    public static String downloadPath = "C:/Users/Fleek/Downloads";


    public void verifyColumn(String[] searchStrings,String fileName) throws InterruptedException {

        findAndOpenSearch(searchStrings,fileName);
        deleteFile(fileName); // Implement deleteFile method if required
    }


    public static void findAndOpenSearch(String[] searchStrings,String fileName) {
        while (true) {
            File directory1 = new File(downloadPath);
            File[] files1 = directory1.listFiles((dir, name) -> name.contains(fileName));

            if (files1 != null && files1.length > 0) {
                // Check the first file that matches the criteria
                isNamePresent(files1[0], searchStrings);
                break; // Exit the loop once a file is found and checked
            }

            try {
                TimeUnit.SECONDS.sleep(1); // Wait for 1 second before checking again
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void isNamePresent(File fileName, String[] searchStrings) {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0); // Assuming the first sheet, adjust if needed

            for (String searchString : searchStrings) {
                boolean found = false;
                for (Row row : sheet) {
                    for (Cell cell : row) {
                        if (cell.getCellType() == CellType.STRING) {
                            String cellValue = cell.getStringCellValue();
                            if (cellValue.contains(searchString)) {
                                System.out.println("Found '" + searchString + "' in Excel at Row: " + (row.getRowNum() + 1) + ", Column: " + (cell.getColumnIndex() + 1));
                                Allure.addAttachment("Column Name: " + searchString + " : | ", "Found '" + searchString + "' in Excel at Row: " + (row.getRowNum() + 1) + ", Column: " + (cell.getColumnIndex() + 1));
                                found = true;
                                break; // Break inner loop to continue searching for next string
                            }
                        }
                    }
                    if (found) break; // Break outer loop if the string is found
                }
                if (!found) {
                    System.out.println("String '" + searchString + "' not found in Excel.");
                }
            }

            workbook.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void deleteFile(String fileName) {
        File directory = new File(downloadPath);

        // List all files in the directory
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                // Check if the file name contains the specified string
                if (file.getName().contains(fileName)) {
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
}

