package io.techleadacademy._practiceTests.excel;

import java.io.*;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;


public class WriteExcelExamples {

    @Test
    public void createNewExcelFile() {
        String fileName = "Test.xlsx";

        //How to connect to the Excel file?
        String filePath = System.getProperty("user.dir") + "/src/test/resources/data/" + fileName;

        //create a new Sheet
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Students2");

        //Create a new Row
        Row firstRow = sheet.createRow(0);
        firstRow.createCell(0).setCellValue("firstName");
        firstRow.createCell(1).setCellValue("lastName");
        firstRow.createCell(2).setCellValue("phoneNumber");
        firstRow.createCell(3).setCellValue("email");
        firstRow.createCell(4).setCellValue("role");

        //saving
        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
            System.out.println("New data added successfully.");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
