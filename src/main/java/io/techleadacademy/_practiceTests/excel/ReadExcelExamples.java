package io.techleadacademy._practiceTests.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcelExamples {
    public static void main(String[] args) throws IOException {
        String filePath = "src/main/java/io/techleadacademy/_practiceTests/excel/Book1.xlsx";

        //Connecting to existing Excel file
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);

        //Creating an Excel Workbook
        Workbook workbook = new XSSFWorkbook(inputStream);

        //Access the Sheet
        Sheet sheet = workbook.getSheet("Sheet3");

        //Get all row count
        int rowCount = sheet.getPhysicalNumberOfRows();

        //Print out cell values of first column only
        for (int i = 0; i < rowCount; i++) {
            //Getting each row
            Row row = sheet.getRow(i);

            //Getting second cell of each row
            Cell cell = row.getCell(1);
            System.out.println(cell);
        }


    }

    public void printFirstRowAndCellData() throws IOException {
        String filePath = "src/main/java/io/techleadacademy/_practiceTests/excel/Book1.xlsx";

        //Connecting to existing Excel file
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);

        //Creating an Excel Workbook
        Workbook workbook = new XSSFWorkbook(inputStream);

        //Access the Sheet
        Sheet sheet = workbook.getSheet("Teams");

        //Access the Row
        Row firstRow = sheet.getRow(0);

        //Access the Cell
        Cell cell = firstRow.getCell(1);

        System.out.println(cell);
    }

    public void printAllCellsOfFirstRow() throws IOException {
        String filePath = "src/main/java/io/techleadacademy/_practiceTests/excel/Book1.xlsx";

        //Connecting to existing Excel file
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);

        //Creating an Excel Workbook
        Workbook workbook = new XSSFWorkbook(inputStream);

        //Access the Sheet
        Sheet sheet = workbook.getSheet("Teams");

        //Access the Row
        Row firstRow = sheet.getRow(0);

        //Find number of cells in a Row
        int cellCount = firstRow.getLastCellNum();

        for (int i = 1; i < cellCount; i++){
            //Access each Cell
            Cell cell = firstRow.getCell(i);
            System.out.println(cell);
        }
    }

    public void printCellOfEachRow() throws IOException {
        String filePath = "src/main/java/io/techleadacademy/_practiceTests/excel/Book1.xlsx";

        //Connecting to existing Excel file
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);

        //Creating an Excel Workbook
        Workbook workbook = new XSSFWorkbook(inputStream);

        //Access the Sheet
        Sheet sheet = workbook.getSheet("Sheet3");

        //Get all row count
        int rowCount = sheet.getPhysicalNumberOfRows();

        //Print out cell values of first column only
        for (int i = 0; i < rowCount; i++) {
            //Getting each row
            Row row = sheet.getRow(i);

            //Getting second cell of each row
            Cell cell = row.getCell(1);
            System.out.println(cell);
        }
    }
}
